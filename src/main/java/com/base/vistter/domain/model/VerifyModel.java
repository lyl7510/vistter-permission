package com.base.vistter.domain.model;

public class VerifyModel {

    private String type;

    private String name;

    public VerifyModel(){

    }

    public VerifyModel(String type , String name){
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
