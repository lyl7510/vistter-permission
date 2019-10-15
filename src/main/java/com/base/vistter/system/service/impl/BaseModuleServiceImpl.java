package com.base.vistter.system.service.impl;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;
import com.base.vistter.system.mapper.BaseModuleMapper;
import com.base.vistter.system.mapper.BaseRoleModuleMapper;
import com.base.vistter.system.service.BaseModuleService;
import com.base.vistter.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("baseModuleServiceImpl")
@Transactional
public class BaseModuleServiceImpl extends BaseServiceImpl implements BaseModuleService {

    @Resource(name = "baseModuleMapperImpl")
    private BaseModuleMapper baseModuleMapper;

    @Resource(name = "baseRoleModuleMapperImpl")
    private BaseRoleModuleMapper baseRoleModuleMapper;

    @Override
    protected BaseMapper getBaseMapper() {
        return this.baseModuleMapper;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List getModuleListByRoleId(Map paramMap) throws PlatformException{
        return baseModuleMapper.getModuleListByRoleId(paramMap);
    }

    @Transactional(readOnly = true)
    public List getProjectModuleList(Map paramMap) throws PlatformException{
        return baseModuleMapper.getProjectModuleList(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(String id) throws PlatformException {
        baseRoleModuleMapper.deleteByModuleId(id);
        super.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List list) throws PlatformException {
        baseRoleModuleMapper.deleteByModuleIds(list);
        super.delete(list);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void start(String id) throws PlatformException{
        baseModuleMapper.start(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void stop(String id) throws PlatformException{
        baseModuleMapper.stop(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List findProjectModuleList(Map paramMap) throws PlatformException{
        return baseModuleMapper.findList(paramMap);
    }
}
