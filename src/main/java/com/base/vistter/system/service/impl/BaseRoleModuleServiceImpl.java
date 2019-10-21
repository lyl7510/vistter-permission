package com.base.vistter.system.service.impl;

import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.mapper.BaseMapper;
import com.base.vistter.common.service.impl.BaseServiceImpl;
import com.base.vistter.system.mapper.BaseRoleModuleMapper;
import com.base.vistter.system.service.BaseRoleModuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("baseRoleModuleServiceImpl")
@Transactional
public class BaseRoleModuleServiceImpl extends BaseServiceImpl implements BaseRoleModuleService {

    @Resource(name = "baseRoleModuleMapperImpl")
    private BaseRoleModuleMapper baseRoleModuleMapper;

    @Override
    protected BaseMapper getBaseMapper() {
        return this.baseRoleModuleMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Map paramMap) throws PlatformException {
        baseRoleModuleMapper.deleteByProjectRoleId(paramMap);
        List list = (List) paramMap.get("MODULE_IDS");
        if (list != null && !list.isEmpty()) {
            baseRoleModuleMapper.save(paramMap);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List getListByRoleId(Map paramMap) throws PlatformException{
        return baseRoleModuleMapper.getListByRoleId(paramMap);
    }

}
