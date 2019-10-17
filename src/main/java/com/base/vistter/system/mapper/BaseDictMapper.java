package com.base.vistter.system.mapper;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;

import java.util.Map;

public interface BaseDictMapper extends BaseMapper {

    long isExist(Map paramMap) throws PlatformException;
}
