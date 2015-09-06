package com.yilinker.core.model.seller;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.InstanceCreator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryan on 9/1/2015.
 */
public class CustomizedCategory implements Parcelable {

    private String categoryName;
    private int parentId;
    private List<String> productsAdd;
    private int categoryId;
    private String name;
    private List<SubCategoryUpload> subcategories;
    private List<CategoryProducts> products;
    private List<CustomizedCategory> categories;
    private List<SubCategoryUpload> subcategoriesAdd;

    public List<CustomizedCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<CustomizedCategory> categories) {
        this.categories = categories;
    }

    public List<CategoryProducts> getProducts() {
        return products;
    }

    public void setProducts(List<CategoryProducts> products) {
        this.products = products;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getProductsAdd() {
        return productsAdd;
    }

    public void setProductsAdd(List<String> productsAdd) {
        this.productsAdd = productsAdd;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<SubCategoryUpload> getSubCategoryList() {
        return subcategories;
    }

    public void setSubCategoryList(List<SubCategoryUpload> subCategories) {
        this.subcategories = subCategories;
    }

    public JSONArray getSubCategoryArrayList(){
        final JSONArray arraySubCategoryList = new JSONArray();

        try {
            for (int i = 0; i < subcategories.size(); i++) {

                SubCategoryUpload subCategoryUploadUpload = subcategories.get(i);

                JSONObject jsonSubCategory = new JSONObject();
                JSONArray arrayAttributes = new JSONArray();
                //jsonSubCategory.put("categoryId", subCategoryUploadUpload.getCategoryId());
                jsonSubCategory.put("categoryName", subCategoryUploadUpload.getCategoryName());
                //jsonProductProperty.put("parentId", subCategoryUploadUpload.getCategoryId());
                if(subCategoryUploadUpload.getProducts() != null) {
                    JSONArray intList = new JSONArray();
                    for (int ctr = 0; ctr < subCategoryUploadUpload.getProducts().size(); ctr++) {
                        intList.put(Integer.parseInt(subCategoryUploadUpload.getProducts().get(ctr)));
                    }
                    jsonSubCategory.put("products", intList);
                }else {
                    jsonSubCategory.put("products", subCategoryUploadUpload.getProducts());
                }

                arraySubCategoryList.put(jsonSubCategory);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return arraySubCategoryList;
    }

    public JSONArray getCategoryArrayList(){

        final JSONArray categoryList = new JSONArray();

        try {

            for(int y = 0; y < categories.size(); y++ ) {
                CustomizedCategory customizedCategory = categories.get(y);
                JSONObject jsonCategory = new JSONObject();


                jsonCategory.put("categoryId", customizedCategory.getCategoryId());
                jsonCategory.put("categoryName", customizedCategory.getCategoryName());
                jsonCategory.put("parentId", customizedCategory.getParentId());
                if(customizedCategory.getProductsAdd() != null) {
                    JSONArray intList = new JSONArray();
                    for (int ctr = 0; ctr < customizedCategory.getProductsAdd().size(); ctr++) {
                       intList.put(Integer.parseInt(customizedCategory.getProductsAdd().get(ctr)));
                    }
                    jsonCategory.put("products", intList);
                }else{
                    JSONArray intList2 = new JSONArray();
                    jsonCategory.put("products", intList2);
                }
                JSONArray arraySubCategoryList = new JSONArray();
                if(!customizedCategory.getSubCategoryList().isEmpty()) {
                    for (int i = 0; i < customizedCategory.getSubCategoryList().size(); i++) {

                        SubCategoryUpload subCategoryUploadUpload = customizedCategory.getSubCategoryList().get(i);

                        JSONObject jsonSubCategory = new JSONObject();
                        jsonSubCategory.put("categoryId", subCategoryUploadUpload.getCategoryId());
                        jsonSubCategory.put("categoryName", subCategoryUploadUpload.getCategoryName());
                        //jsonProductProperty.put("parentId", subCategoryUploadUpload.getCategoryId());
                        if(subCategoryUploadUpload.getProducts() != null){
                            JSONArray intList3 = new JSONArray();
                            for (int ctr = 0; ctr < subCategoryUploadUpload.getProducts().size(); ctr++) {
                                intList3.put(Integer.parseInt(subCategoryUploadUpload.getProducts().get(ctr)));
                            }
                            jsonSubCategory.put("products", intList3);
                        }else{
                            JSONArray intList4 = new JSONArray();
                            jsonCategory.put("products", intList4);
                        }



                        arraySubCategoryList.put(jsonSubCategory);
                    }
                    jsonCategory.put("subcategories",arraySubCategoryList);
                }else{
                    List<SubCategoryUpload> subCategoryUploadList = new ArrayList<>();
                    jsonCategory.put("subcategories",subCategoryUploadList);
                }

                categoryList.put(jsonCategory);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return categoryList;
    }

    public List<SubCategoryUpload> getSubcategoriesAdd() {
        return subcategoriesAdd;
    }

    public void setSubcategoriesAdd(List<SubCategoryUpload> subcategoriesAdd) {
        this.subcategoriesAdd = subcategoriesAdd;
    }

    public static class CustomizedCategoryInstance implements InstanceCreator<CustomizedCategory> {

        @Override
        public CustomizedCategory createInstance(Type type) {

            return new CustomizedCategory();
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.categoryName);
        dest.writeInt(this.parentId);
        dest.writeStringList(this.productsAdd);
        dest.writeInt(this.categoryId);
        dest.writeString(this.name);
        dest.writeTypedList(subcategories);
        dest.writeList(this.products);
        dest.writeTypedList(categories);
    }

    public CustomizedCategory() {
    }

    protected CustomizedCategory(Parcel in) {
        this.categoryName = in.readString();
        this.parentId = in.readInt();
        this.productsAdd = in.createStringArrayList();
        this.categoryId = in.readInt();
        this.name = in.readString();
        this.subcategories = in.createTypedArrayList(SubCategoryUpload.CREATOR);
        this.products = new ArrayList<CategoryProducts>();
        in.readList(this.products, List.class.getClassLoader());
        this.categories = in.createTypedArrayList(CustomizedCategory.CREATOR);
    }

    public static final Creator<CustomizedCategory> CREATOR = new Creator<CustomizedCategory>() {
        public CustomizedCategory createFromParcel(Parcel source) {
            return new CustomizedCategory(source);
        }

        public CustomizedCategory[] newArray(int size) {
            return new CustomizedCategory[size];
        }
    };
}
