package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Patrick on 8/26/2015.
 */
public class Search {


    private String keyword;
    private String  searchUrl;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }



    public static class SearchInstance implements InstanceCreator<Search> {

        @Override
        public Search createInstance(Type type) {

            return new Search();
        }
    }
}
