package com.base.vistter.service;

import com.base.vistter.domain.ParamModel;
import com.base.vistter.domain.Result;
import com.base.vistter.domain.model.ReadModel;

public interface DataReadService {

    Result getResult(Result result, ReadModel model, ParamModel paramModel);

}
