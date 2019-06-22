package com.base.vistter.domain.model;

public class InterceptorModel{

    private String modelId;

    private int code;

    public InterceptorModel(String modelId , int code){
        this.modelId = modelId;
        this.code = code;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
