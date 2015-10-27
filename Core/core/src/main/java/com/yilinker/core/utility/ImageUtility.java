package com.yilinker.core.utility;

import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.LruCache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaybr_000 on 8/7/2015.
 */
public class ImageUtility {

    public static final String TEMP_IMAGE_FOLDER = "temp_image_folder";

    private static Bitmap bitmap = null;
    private static LruCache<String, Bitmap> mMemoryCache;
    public final static String chartDirectory = String.format("%s/%s", Environment.getExternalStorageDirectory().toString(),"Online Seller Chart");
    public final static String uploadDirectory = String.format("%s/%s", Environment.getExternalStorageDirectory().toString(), "Online Seller Temp");
    public static int uploadFileName;


    /**
     * converts recently captured photo from camera to bitmap object
     * @return bitmap
     */
    public final static String getFilePath(final String tempName) {

        File file = new File(Environment.getExternalStorageDirectory().toString());
        for (File temp : file.listFiles()) {
            if (temp.getName().equals(tempName)) {
                file = temp;
                break;
            }
        }

        try {
            bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            file.delete();

            String path = String.format("%s/%s",Environment.getExternalStorageDirectory().toString(),"Online Seller");
            if(!new File(path).exists()){
                new File(path).mkdirs();
            }

            OutputStream outputFile = null;
            File newfile = new File(path, String.valueOf(System.currentTimeMillis()) + ".JPEG");
            /***saving to gallery*/
            try {

                outputFile = new FileOutputStream(newfile);

                //Resize the image
                double width = bitmap.getWidth();
                double height = bitmap.getHeight();
                double ratio = 400 / width;
                int newheight = (int) (ratio * height);

                bitmap = Bitmap.createScaledBitmap(bitmap, 400, newheight, true);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outputFile);
                outputFile.flush();
                outputFile.close();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return newfile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Resizes camera bitmap and returns new file path
     * @param filePath
     * @return
     */
    public final static String compressCameraFileBitmap(final String filePath) {

            File compressedFile = null;
            File file = new File(filePath);

            File cacheFolder = new File(Environment.getExternalStorageDirectory().toString(), TEMP_IMAGE_FOLDER);

            if(!cacheFolder.exists()){
                cacheFolder.mkdir();
            }

            try {

                Bitmap bitmap = BitmapFactory.decodeFile(filePath);

                compressedFile = new File(String.format("%s/%s/compressed%s.jpeg", Environment.getExternalStorageDirectory().toString(), TEMP_IMAGE_FOLDER,file.getName()));
                FileOutputStream out = new FileOutputStream(compressedFile);
                bitmap.compress(Bitmap.CompressFormat.JPEG,70,out);
                out.flush();
                out.close();


                return compressedFile.getPath();

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
    }

    public static void clearCache(){

        File file = new File(String.format("%s/%s", Environment.getExternalStorageDirectory().toString(), TEMP_IMAGE_FOLDER));

        if(file.exists()){

            file.delete();

        }

    }


    /**
     * @param bitmap
     * @return converting bitmap and return a string
     */
    public static String convertBitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }


    public static String convertFileToString(String filePath) {

        Bitmap bitmap = BitmapFactory.decodeFile(filePath);

        if (bitmap != null) {

            return  convertBitMapToString(bitmap);

        }

        return null;

    }

    public static Bitmap convertFileToBitmap(String filePath) {

        Bitmap bm = BitmapFactory.decodeFile(filePath);

        if (bm != null) {

//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            bm.compress(Bitmap.CompressFormat.PNG, 100, out);
//            Bitmap decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));

            //Resize the image
            double width = bm.getWidth();
            double height = bm.getHeight();
            double ratio = 400 / width;
            int newheight = (int) (ratio * height);

            return Bitmap.createScaledBitmap(bm, 400, newheight, true);
        }


        return null;
    }

    /**
     * @param encodedString
     * @return bitmap (from given string)
     */
    public static Bitmap convertStringToBitMap(final String encodedString){

        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        // Use 1/8th of the available memory for this memory cache.
        final int cacheSize = maxMemory / 8;

        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                // The cache size will be measured in kilobytes rather than
                // number of items.
                return bitmap.getByteCount() / 1;
            }
        };

        bitmap = getBitmapFromMemCache(encodedString);

        if (bitmap != null) {
            return bitmap;
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{

                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = 10;

                    byte [] encodeByte=Base64.decode(encodedString, Base64.DEFAULT);
                    bitmap=BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length, options);
                }catch(Exception e){
                    e.getMessage();
                }
            }
        });

        thread.run();

        addBitmapToMemoryCache(encodedString, bitmap);

        return bitmap;
    }


    /**
     * calculates bitmap's sample size
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    /**
     * puts bitmap to memory cache
     * @param key
     * @param bitmap
     */
    public static void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    /**
     * gets key from memory cache
     * @param key
     * @return
     */
    public static Bitmap getBitmapFromMemCache(String key) {
        return mMemoryCache.get(key);
    }


    public static String getRealPathFromURI(Context context, Uri contentURI) {
        String result = null;
        String[] projection = {MediaStore.Images.Media.DATA};

        try {
            Cursor cursor = context.getContentResolver().query(contentURI, projection, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(projection[0]);
            result = cursor.getString(columnIndex);
            cursor.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    public static final List<String> encodeImageList(List<String> images) {

        final List<String> encodedImages = new ArrayList<>();

        for (final String string: images) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    encodedImages.add(convertFileToString(string));
                }
            }).run();
        }
        return encodedImages;

    }

    public static final List<String> getUploadFilenames(List<String> images) {

        List<String> filenames = new ArrayList<>();

        File folder = new File(uploadDirectory);
        if(!folder.exists()) folder.mkdirs();

        String path = folder.getPath();

        for(int i=0; i<images.size();i++) {

            Bitmap bm = BitmapFactory.decodeFile(images.get(i));

            File newFile = new File(path,String.valueOf(++uploadFileName)+".JPEG");

            try {
                FileOutputStream outputStream = new FileOutputStream(newFile);

                double width = bm.getWidth();
                double height = bm.getHeight();
                double ratio = 400 / width;
                int newheight = (int) (ratio * height);

                bm = Bitmap.createScaledBitmap(bm, 400, newheight, true);
                bm.compress(Bitmap.CompressFormat.JPEG, 85, outputStream);
                outputStream.flush();
                outputStream.close();

                filenames.add(String.valueOf(uploadFileName)+".JPEG");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return filenames;
    }

    public static final void deleteUploadFolder(File file){
        if(file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory())
                    deleteUploadFolder(file2);
                else
                    file2.delete();
            }
            file.delete();
        }
    }

    public static final boolean saveChart(Bitmap bitmap){
        File file = new File(chartDirectory);
        if(!file.exists()){
            file.mkdirs();
        }

        File newFile = new File(chartDirectory,"chart.JPEG");

        try {
            FileOutputStream outputStream = new FileOutputStream(newFile);

            double width = bitmap.getWidth();
            double height = bitmap.getHeight();
            double ratio = 400 / width;
            int newheight = (int) (ratio * height);

            bitmap = Bitmap.createScaledBitmap(bitmap, 400, newheight, true);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outputStream);
            outputStream.flush();
            outputStream.close();

            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }






}
