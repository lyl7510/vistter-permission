package com.base.vistter.system.mapper;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public interface BaseProjectMapper extends BaseMapper {

    Map findProjectSettingByCode(String projectCode) throws PlatformException;

    long verifyProjectCode(String projectCode) throws PlatformException;

    void start(Map paramMap) throws PlatformException;

    void stop(Map paramMap) throws PlatformException;
}
