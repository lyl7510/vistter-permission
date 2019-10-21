package com.base.vistter.system.service.impl;

import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.mapper.BaseMapper;
import com.base.vistter.common.service.impl.BaseServiceImpl;
import com.base.vistter.system.bean.ErrorCode;
import com.base.vistter.system.mapper.BaseDictMapper;
import com.base.vistter.system.service.BaseDictService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("baseDictServiceImpl")
@Transactional
public class BaseDictServiceImpl extends BaseServiceImpl implements BaseDictService {

    @Resource(name = "baseDictMapperImpl")
    private BaseDictMapper baseDictMapper;

    @Transactional(readOnly = true)
    public List findList(Map paramMap) throws PlatformException {
        return baseDictMapper.findList(paramMap);
    }

    @Override
    protected BaseMapper getBaseMapper() {
        return this.baseDictMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Map paramMap) throws PlatformException {
        long count = baseDictMapper.isExist(paramMap);
        if(count > 0){
            throw new PlatformException(ErrorCode.DICT_VALUE_ISEXIST);
        }
        super.save(paramMap);
    }

}
