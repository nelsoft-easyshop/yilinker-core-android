package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by J.Bautista
 */
public class ProblemDetail {

    private String problemType;
    private String csrName;
    private String problemRemarks;
    private List<String> images;

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getCsrName() {
        return csrName;
    }

    public void setCsrName(String csrName) {
        this.csrName = csrName;
    }

    public String getProblemRemarks() {
        return problemRemarks;
    }

    public void setProblemRemarks(String problemRemarks) {
        this.problemRemarks = problemRemarks;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public static class ProblemDetailInstance implements InstanceCreator<ProblemDetail> {

        @Override
        public ProblemDetail createInstance(Type type) {

            return new ProblemDetail();
        }
    }
}
