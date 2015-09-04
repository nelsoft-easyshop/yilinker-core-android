package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Bryan on 9/1/2015.
 */
public class CustomizedCategory {

    private String categoryName;
    private int parentId;
    private List<String> productsAdd;
    private int categoryId;
    private String name;
    private List<SubCategoryUpload> subcategories;
    private List<CategoryProducts> products;

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
                jsonSubCategory.put("categoryId", subCategoryUploadUpload.getCategoryId());
                jsonSubCategory.put("categoryName", subCategoryUploadUpload.getCategoryName());
                //jsonProductProperty.put("parentId", subCategoryUploadUpload.getCategoryId());
                jsonSubCategory.put("products", subCategoryUploadUpload.getProducts());


                arraySubCategoryList.put(jsonSubCategory);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return arraySubCategoryList;
    }



    public static class CustomizedCategoryInstance implements InstanceCreator<CustomizedCategory> {

        @Override
        public CustomizedCategory createInstance(Type type) {

            return new CustomizedCategory();
        }
    }

}
