package com.yilinker.core.model.request;

/**
 * Created by J.Bautista on 7/15/16.
 */
public class FollowedSeller {

    private int page;
    private int limit;
    private String keyword;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
