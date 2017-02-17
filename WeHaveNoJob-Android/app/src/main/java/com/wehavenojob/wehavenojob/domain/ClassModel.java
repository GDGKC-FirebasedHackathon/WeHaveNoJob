package com.wehavenojob.wehavenojob.domain;

/**
 * Created by judepark on 2017. 2. 17..
 */

public class ClassModel {
    private String date;
    private String className;
    private String classContent;

    public ClassModel(String date, String className, String classContent) {
        this.date = date;
        this.className = className;
        this.classContent = classContent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassContent() {
        return classContent;
    }

    public void setClassContent(String classContent) {
        this.classContent = classContent;
    }
}