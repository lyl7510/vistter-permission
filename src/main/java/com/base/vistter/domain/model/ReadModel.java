package com.base.vistter.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReadModel implements Serializable {

    private String modelId;

    private boolean count = false;

    private boolean single = false;

    private boolean data = false;

    private String ref;

    private List<ReadModel> children = new ArrayList<ReadModel>();

    public ReadModel() {

    }

    public void add(ReadModel model) {
        this.children.add(model);
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public boolean isCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }

    public List<ReadModel> getChildren() {
        return children;
    }

    public void setChildren(List<ReadModel> children) {
        this.children = children;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
