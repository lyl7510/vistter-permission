package com.base.vistter.system.service.impl;

import com.base.vistter.mapper.BaseMapper;
import com.base.vistter.system.mapper.BaseRoleMapper;
import com.base.vistter.system.service.BaseRoleService;
import com.base.vistter.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("baseRoleServiceImpl")
@Transactional
public class BaseRoleServiceImpl extends BaseServiceImpl implements BaseRoleService {

    @Resource(name = "baseRoleMapperImpl")
    private BaseRoleMapper baseRoleMapper;

    @Override
    protected BaseMapper getBaseMapper() {
        return this.baseRoleMapper;
    }

}
