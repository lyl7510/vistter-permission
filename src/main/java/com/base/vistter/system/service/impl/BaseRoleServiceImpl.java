package com.base.vistter.system.service.impl;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;
import com.base.vistter.system.bean.ErrorCode;
import com.base.vistter.system.mapper.BaseRoleMapper;
import com.base.vistter.system.mapper.BaseRoleModuleMapper;
import com.base.vistter.system.mapper.BaseUserMapper;
import com.base.vistter.system.service.BaseRoleService;
import com.base.vistter.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("baseRoleServiceImpl")
@Transactional
public class BaseRoleServiceImpl extends BaseServiceImpl implements BaseRoleService {

    @Resource(name = "baseRoleMapperImpl")
    private BaseRoleMapper baseRoleMapper;

    @Resource(name = "baseUserMapperImpl")
    private BaseUserMapper baseUserMapper;

    @Resource(name = "baseRoleModuleMapperImpl")
    private BaseRoleModuleMapper baseRoleModuleMapper;

    @Override
    protected BaseMapper getBaseMapper() {
        return this.baseRoleMapper;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void start(Map paramMap) throws PlatformException {
        baseRoleMapper.start(paramMap);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void stop(Map paramMap) throws PlatformException {
        baseRoleMapper.stop(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(String id) throws PlatformException {
        long count = baseUserMapper.countByRoleId(id);
        if(count > 0){
            throw new PlatformException(ErrorCode.ROLE_EXIST_USERS);
        }
        baseRoleModuleMapper.deleteByRoleId(id);
        super.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List list) throws PlatformException {
        long count = baseUserMapper.countByRoleIds(list);
        if(count > 0){
            throw new PlatformException(ErrorCode.ROLE_EXIST_USERS);
        }
        baseRoleModuleMapper.deleteByRoleIds(list);
        super.delete(list);
    }

    @Override
    @Transactional(readOnly = true)
    public List findList(Map paramMap) throws PlatformException{
        return baseRoleMapper.findList(paramMap);
    }
}
