package com.yilinker.core.model;

/**
 * Created by Patrick on 8/17/2015.
 */
public class Category {

    private int categoryId;
    private String name;
    private boolean hasChild;

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

    public boolean isHasChild(){
        return hasChild;
    }

    public void setHasChild(boolean hasChild){
        this.hasChild = hasChild;
    }
}
