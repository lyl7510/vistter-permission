package com.base.vistter.system.service.impl;

import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.mapper.BaseMapper;
import com.base.vistter.common.service.impl.BaseServiceImpl;
import com.base.vistter.system.bean.ErrorCode;
import com.base.vistter.system.mapper.BaseDepartMapper;
import com.base.vistter.system.mapper.BaseUserMapper;
import com.base.vistter.system.service.BaseDepartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("baseDepartServiceImpl")
@Transactional
public class BaseDepartServiceImpl extends BaseServiceImpl implements BaseDepartService {

    @Resource(name = "baseDepartMapperImpl")
    private BaseDepartMapper baseDepartMapper;

    @Resource(name = "baseUserMapperImpl")
    private BaseUserMapper baseUserMapper;

    @Transactional(readOnly = true)
    public List findList(Map paramMap) throws PlatformException {
        return baseDepartMapper.findList(paramMap);
    }

    @Override
    protected BaseMapper getBaseMapper() {
        return this.baseDepartMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(String id) throws PlatformException {
        long count = baseUserMapper.countByDepartId(id);
        if(count > 0){
            throw  new PlatformException(ErrorCode.DEPART_HAS_USERNAME);
        }
        super.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List list) throws PlatformException {
        long count = baseUserMapper.countByDepartIds(list);
        if(count > 0){
            throw  new PlatformException(ErrorCode.DEPART_HAS_USERNAME);
        }
        super.delete(list);
    }
}
