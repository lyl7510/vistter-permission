package com.base.vistter.service.impl;

import com.base.vistter.dao.ReadDataDao;
import com.base.vistter.domain.ParamModel;
import com.base.vistter.domain.Result;
import com.base.vistter.domain.model.ReadModel;
import com.base.vistter.service.DataReadService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Transactional
@Service("dataReadServiceImpl")
public class DataReadServiceImpl implements DataReadService {

    @Resource(name = "readDataDaoImpl")
    private ReadDataDao readDataDao;

    public Result getResult(Result result, ReadModel model , ParamModel paramModel) {
        if(model.isCount()){
            long count = readDataDao.count(paramModel.getModelId() , paramModel.getParamMap());
            result.setTotal(count);
        }
        if(model.isSingle()){
            Map<String , Object> single = readDataDao.single(paramModel.getModelId() , paramModel.getParamMap());
            result.setData(single);
            this.serializeModel(result , model.getChildren() ,  paramModel.getParamMap());
        }
        if(!model.isSingle() && model.isData()){
            List<Map<String , Object>> list = readDataDao.data(paramModel.getModelId() , paramModel.getParamMap());
            result.setData(list);
            this.serializeModel(result , model.getChildren() ,  paramModel.getParamMap());
        }
        return result;
    }
    @SuppressWarnings("unchecked")
    private void serializeModel(Result result , List<ReadModel> list , Map<String , Object> paramMap){
        if(!list.isEmpty()){
            for(ReadModel model : list){
                if(model.isCount()){
                    Result rt = new Result();
                    long count = readDataDao.count(model.getModelId() , paramMap);
                    rt.setTotal(count);
                }
                if(model.isSingle()){
                    if(result.getData() instanceof Map){
                        Map<String ,Object> dataMap = (Map<String ,Object>) result.getData();
                        Result rt = this.setChildrenModel(dataMap , model ,  paramMap , true);
                        this.serializeModel(rt , model.getChildren() , paramMap);
                    }else{
                        List<Map<String ,Object>> results = (List<Map<String ,Object>>) result.getData();
                        for(Map<String ,Object> dataMap : results){
                            Result rt = this.setChildrenModel(dataMap , model ,  paramMap , true);
                            this.serializeModel(rt , model.getChildren() , paramMap);
                        }
                    }

                }
                if(!model.isSingle() && model.isData()){
                    if(result.getData() instanceof Map){
                        Map<String ,Object> dataMap = (Map<String ,Object>) result.getData();
                        Result rt = this.setChildrenModel(dataMap , model , paramMap , false);
                        this.serializeModel(rt , model.getChildren() , paramMap);
                    }else{
                        List<Map<String ,Object>> results = (List<Map<String ,Object>>) result.getData();
                        for(Map<String ,Object> dataMap : results){
                            Result rt = this.setChildrenModel(dataMap , model , paramMap , false);
                            this.serializeModel(rt , model.getChildren() , paramMap);
                        }
                    }

                }
            }
        }
    }

    private Result setChildrenModel(Map<String, Object> dataMap , ReadModel model , Map<String ,Object> paramMap , boolean isSingle){
        Result result = new Result();
        paramMap.put("_pid" , MapUtils.getString(dataMap , "ID"));
        if(isSingle){
            Map<String , Object> single = readDataDao.single(model.getModelId() , paramMap);
            result.setData(single);
        }else{
            List<Map<String , Object>> list = readDataDao.data(model.getModelId() , paramMap);
            result.setData(list);
        }
        dataMap.put(generKey(model.getModelId() , model.getRef()) , result);
        return result;
    }

    private String generKey(String modelId , String ref){
        return StringUtils.isEmpty(ref) ? modelId : ref;
    }
}
