package com.base.vistter.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WriteModel implements Serializable {

    public static final String SAVE = "save";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";

    private String modelId;

    private String type;

    private List<InterceptorModel> interceptors
            = new ArrayList<InterceptorModel>();

    private List<WriteModel> children = new ArrayList<WriteModel>();

    private List<VerifyModel> verifications = new ArrayList<VerifyModel>();

    public WriteModel(String modelId ,String type){
        this.modelId = modelId;
        this.type = type;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<InterceptorModel> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<InterceptorModel> interceptors) {
        this.interceptors = interceptors;
    }

    public List<WriteModel> getChildren() {
        return children;
    }

    public void setChildren(List<WriteModel> children) {
        this.children = children;
    }

    public List<VerifyModel> getVerifications() {
        return verifications;
    }

    public void setVerifications(List<VerifyModel> verifications) {
        this.verifications = verifications;
    }
}
