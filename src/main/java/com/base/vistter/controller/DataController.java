package com.base.vistter.controller;

import com.base.vistter.domain.ModelComponent;
import com.base.vistter.domain.ParamModel;
import com.base.vistter.domain.Result;
import com.base.vistter.domain.model.ReadModel;
import com.base.vistter.domain.model.WriteModel;
import com.base.vistter.service.DataReadService;
import com.base.vistter.service.DataWriteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DataController {

    @Autowired
    private ModelComponent modelComponent;

    @Resource(name = "dataReadServiceImpl")
    private DataReadService dataReadService;
    @Resource(name = "dataWriteServiceImpl")
    private DataWriteService dataWriteService;

    @PostMapping("/data")
    public Result read(@RequestBody ParamModel paramModel) {
        Result result = new Result();
        if (StringUtils.isEmpty(paramModel.getModelId())) {
            return new Result(400);
        }
        ReadModel readModel = modelComponent.getReadModel(paramModel.getModelId());
        if (readModel != null) {
            return dataReadService.getResult(result, readModel, paramModel);
        }
        WriteModel writeModel = modelComponent.getWriteModel(paramModel.getModelId());
        if (writeModel != null) {
            return dataWriteService.getResult(result , writeModel , paramModel);
        }
        return new Result(400);
    }


}
