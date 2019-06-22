package com.base.vistter.service;

import com.base.vistter.domain.ParamModel;
import com.base.vistter.domain.Result;
import com.base.vistter.domain.model.WriteModel;

public interface DataWriteService {

    Result getResult(Result result, WriteModel model, ParamModel paramModel);

}
