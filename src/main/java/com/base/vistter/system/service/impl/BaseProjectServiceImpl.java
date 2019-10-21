package com.base.vistter.system.service.impl;

import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.mapper.BaseMapper;
import com.base.vistter.common.service.impl.BaseServiceImpl;
import com.base.vistter.system.bean.ErrorCode;
import com.base.vistter.system.mapper.*;
import com.base.vistter.system.service.BaseProjectService;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("baseProjectServiceImpl")
@Transactional
public class BaseProjectServiceImpl extends BaseServiceImpl implements BaseProjectService {

    @Resource(name = "baseProjectMapperImpl")
    private BaseProjectMapper baseProjectMapper;

    @Resource(name = "baseDepartMapperImpl")
    private BaseDepartMapper baseDepartMapper;

    @Resource(name = "baseDictMapperImpl")
    private BaseDictMapper baseDictMapper;

    @Resource(name = "baseUserMapperImpl")
    private BaseUserMapper baseUserMapper;

    @Resource(name = "baseRoleModuleMapperImpl")
    private BaseRoleModuleMapper baseRoleModuleMapper;

    @Resource(name = "baseRoleMapperImpl")
    private BaseRoleMapper baseRoleMapper;

    @Resource(name = "baseModuleMapperImpl")
    private BaseModuleMapper baseModuleMapper;

    protected BaseMapper getBaseMapper() {
        return this.baseProjectMapper;
    }

    @Transactional(readOnly = true)
    public Map findProjectSettingByCode(String projectCode) throws PlatformException {
        return baseProjectMapper.findProjectSettingByCode(projectCode);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Map paramMap) throws PlatformException {
        long projectCount = baseProjectMapper.verifyProjectCode(MapUtils.getString(paramMap, "PROJECT_CODE"));
        if (projectCount > 0) {
            throw new PlatformException(ErrorCode.PROJECT_CODE_ISEXIT);
        }
        baseProjectMapper.save(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(String id) throws PlatformException {
        baseDictMapper.deleteByProjectId(id);
        baseUserMapper.deleteByProjectId(id);
        baseDepartMapper.deleteByProjectId(id);
        baseRoleModuleMapper.deleteByRoleId(id);
        baseRoleMapper.deleteByProjectId(id);
        baseModuleMapper.deleteByProjectId(id);
        baseProjectMapper.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List list) throws PlatformException {
        baseDictMapper.deleteByProjectIds(list);
        baseUserMapper.deleteByProjectIds(list);
        baseDepartMapper.deleteByProjectIds(list);
        baseRoleModuleMapper.deleteByProjectIds(list);
        baseRoleMapper.deleteByProjectIds(list);
        baseModuleMapper.deleteByProjectIds(list);
        baseProjectMapper.delete(list);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void start(Map paramMap) throws PlatformException{
        baseProjectMapper.start(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void stop(Map paramMap) throws PlatformException{
        baseProjectMapper.stop(paramMap);
    }
}
