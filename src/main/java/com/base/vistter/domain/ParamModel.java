package com.base.vistter.domain;

import java.io.Serializable;
import java.util.Map;

public class ParamModel
    implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 模型
     */
    private String modelId;

    /**
     * 参数
     */
    private Map<String, Object> paramMap;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }


    @Override
    public String toString() {
        return "ParamModel [modelId=" + modelId + ", paramMap=" + paramMap +  "]";
    }

}
