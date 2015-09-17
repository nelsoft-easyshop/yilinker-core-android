package com.yilinker.core.helper;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Patrick on 8/9/2015.
 */
public class FileHelper {
    // Read file
    public static String readFileFromAssets(Context context, String fileName)
            throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(context
                .getAssets().open(fileName)));

        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = bf.readLine()) != null) {

            builder.append(line);
        }

        bf.close();

        return builder.toString();
    }

    public static String readFile(Context context, String filePath)
            throws IOException {

        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = br.readLine()) != null) {

            builder.append(line);
        }


        br.close();


        return builder.toString();
    }

    // Write file
    public static void writeFile(Context context, String filePath, String content) throws IOException {

        FileWriter writer = new FileWriter(filePath, false);
        writer.write(content);

        writer.close();

    }

    //Checks if a file exist in the directory
    public static boolean containsFile(String filePath){

        File file = new File(filePath);

        return file.exists();
    }

}
