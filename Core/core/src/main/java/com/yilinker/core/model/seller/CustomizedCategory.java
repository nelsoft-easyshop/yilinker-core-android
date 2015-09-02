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
    private List<String> products;
    private int categoryId;
    private String name;
    private List<SubCategory> subCategoryList;

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

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
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

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<SubCategory> subCategories) {
        this.subCategoryList = subCategories;
    }

    public JSONArray getSubCategoryArrayList(){
        final JSONArray arraySubCategoryList = new JSONArray();

        try {
            for (int i = 0; i < subCategoryList.size(); i++) {

                SubCategory subCategory = subCategoryList.get(i);

                JSONObject jsonSubCategory = new JSONObject();
                JSONArray arrayAttributes = new JSONArray();
                jsonSubCategory.put("categoryId", subCategory.getCategoryId());
                jsonSubCategory.put("categoryName", subCategory.getCategoryName());
                //jsonProductProperty.put("parentId", subCategory.getCategoryId());
                jsonSubCategory.put("products",subCategory.getProducts());


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
