package com.base.vistter.system.service.impl;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;
import com.base.vistter.system.mapper.BaseDepartMapper;
import com.base.vistter.system.service.BaseDepartService;
import com.base.vistter.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("baseDepartServiceImpl")
@Transactional
public class BaseDepartServiceImpl extends BaseServiceImpl implements BaseDepartService {

    @Resource(name = "baseDepartMapperImpl")
    private BaseDepartMapper baseDepartMapper;

    @Transactional(readOnly = true)
    public List findList(Map paramMap) throws PlatformException{
        return baseDepartMapper.findList(paramMap);
    }

    @Override
    protected BaseMapper getBaseMapper() {
        return this.baseDepartMapper;
    }
}
