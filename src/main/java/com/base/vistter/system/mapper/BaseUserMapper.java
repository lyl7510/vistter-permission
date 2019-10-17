package com.base.vistter.system.mapper;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface BaseUserMapper extends BaseMapper {

    Map findByUserName(Map paramMap) throws PlatformException;

    void resetPwd(Map paramMap) throws PlatformException;

    long countByRoleId(String roleId) throws PlatformException;

    long countByRoleIds(List roleIds) throws PlatformException;

    void start(Map paramMap) throws PlatformException;

    void stop(Map paramMap) throws PlatformException;

    long usernameIsExit(Map paramMap) throws PlatformException;
}
