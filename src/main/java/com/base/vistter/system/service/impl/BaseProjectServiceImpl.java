package com.base.vistter.system.service.impl;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;
import com.base.vistter.system.bean.ErrorCode;
import com.base.vistter.system.mapper.BaseProjectMapper;
import com.base.vistter.system.service.BaseProjectService;
import com.base.vistter.service.impl.BaseServiceImpl;
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
        baseProjectMapper.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List list) throws PlatformException {
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
