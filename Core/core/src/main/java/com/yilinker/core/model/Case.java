package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Patrick on 9/14/2015.
 */
public class Case {

    private String caseId;
    private String status,date;
    private String filedTo;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFiledTo() {
        return filedTo;
    }

    public void setFiledTo(String filedTo) {
        this.filedTo = filedTo;
    }

    public static class CaseInstance implements InstanceCreator<Case> {

        @Override
        public Case createInstance(Type type) {
            return new Case();
        }
    }
}
