package com.base.vistter.system.mapper;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;

import java.util.Map;

public interface BaseUserMapper extends BaseMapper {

    Map findByUserName(Map paramMap) throws PlatformException;

}
