package com.base.vistter.service.impl;

import com.base.vistter.dao.WriteDataDao;
import com.base.vistter.domain.ParamModel;
import com.base.vistter.domain.Result;
import com.base.vistter.domain.model.InterceptorModel;
import com.base.vistter.domain.model.VerifyModel;
import com.base.vistter.domain.model.WriteModel;
import com.base.vistter.service.DataWriteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Transactional
@Service("dataWriteServiceImpl")
public class DataWriteServiceImpl implements DataWriteService {

    @Resource(name = "writeDataDaoImpl")
    private WriteDataDao writeDataDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Result getResult(Result result, WriteModel model , ParamModel paramModel){
        List<InterceptorModel> interceptors = model.getInterceptors();
        if(interceptors != null && !interceptors.isEmpty()){
            for(InterceptorModel interceptorModel : interceptors){
                long count = this.executeInterceptor(interceptorModel.getModelId() , paramModel.getParamMap());
                if(count > 0l){
                    result.setCode(interceptorModel.getCode());
                    return result;
                }
            }
        }
        List<WriteModel> childrens = model.getChildren();
        if(childrens != null && !childrens.isEmpty()){
            for(WriteModel children : childrens){
                if(verify(children.getVerifications() , paramModel.getParamMap())){
                    this.executeWriteModel(children , paramModel);
                }
            }
        }
        if(verify(model.getVerifications() , paramModel.getParamMap())){
            this.executeWriteModel(model , paramModel);
        }
        return result;
    }

    private boolean verify(List<VerifyModel> verifyList , Map<String , Object> paramMap){
        for(int i = 0 ; i < verifyList.size() ; i++){
            if(verifyList.get(i).getType().equals("list")){
                List<Object> list = (List<Object>) paramMap.get(verifyList.get(i).getName());
                if(list == null || list.isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }

    private void executeWriteModel(WriteModel model ,ParamModel paramModel){
        if(model.getType().equals(WriteModel.SAVE)){
            writeDataDao.insert(model.getModelId() , paramModel.getParamMap());
        }else if(model.getType().equals(WriteModel.UPDATE)){
            writeDataDao.update(model.getModelId(),  paramModel.getParamMap());
        }else if(model.getType().equals(WriteModel.DELETE)){
            writeDataDao.delete(model.getModelId() , paramModel.getParamMap());
        }
    }

    private long executeInterceptor(String modelId , Map<String , Object> paramMap){
        return writeDataDao.count(modelId ,paramMap);
    }

}
