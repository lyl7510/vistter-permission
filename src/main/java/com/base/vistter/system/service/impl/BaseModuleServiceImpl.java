package com.base.vistter.system.service.impl;

import com.base.vistter.mapper.BaseMapper;
import com.base.vistter.system.mapper.BaseModuleMapper;
import com.base.vistter.system.service.BaseModuleService;
import com.base.vistter.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("baseModuleServiceImpl")
@Transactional
public class BaseModuleServiceImpl extends BaseServiceImpl implements BaseModuleService {

    @Resource(name = "baseModuleMapperImpl")
    private BaseModuleMapper baseModuleMapper;

    @Override
    protected BaseMapper getBaseMapper() {
        return this.baseModuleMapper;
    }

}
