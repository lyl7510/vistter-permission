package com.base.vistter.domain;

import com.base.vistter.domain.model.ReadModel;
import com.base.vistter.domain.model.WriteModel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ModelComponent {

    /**
     * 只读的model
     */
    public Map<String , ReadModel>  readModelMap = new HashMap<String, ReadModel>();

    /**
     * 可写的model
     */
    public Map<String , WriteModel> writeModelMap = new HashMap<String , WriteModel>();

    public void addReadModel(String key , ReadModel model){
        readModelMap.put(key , model);
    }

    public ReadModel getReadModel(String key){
        return readModelMap.get(key);
    }

    public void addWriteModel(String key , WriteModel model){
        writeModelMap.put(key , model);
    }

    public WriteModel getWriteModel(String key){
        return writeModelMap.get(key);
    }
}
