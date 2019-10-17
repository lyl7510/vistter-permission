package com.base.vistter.system.service.impl;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;
import com.base.vistter.system.bean.ErrorCode;
import com.base.vistter.system.mapper.BaseUserMapper;
import com.base.vistter.system.service.BaseUserService;
import com.base.vistter.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Transactional
@Service("baseUserServiceImpl")
public class BaseUserServiceImpl extends BaseServiceImpl implements BaseUserService {

    @Resource(name = "baseUserMapperImpl")
    private BaseUserMapper baseUserMapper;

    protected BaseMapper getBaseMapper() {
        return baseUserMapper;
    }

    @Transactional(readOnly = true)
    public Map findByUserName(Map paramMap) throws PlatformException {
        return baseUserMapper.findByUserName(paramMap);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void resetPwd(Map paramMap) throws PlatformException {
        baseUserMapper.resetPwd(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void start(Map paramMap) throws PlatformException{
        baseUserMapper.start(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void stop(Map paramMap) throws PlatformException{
        baseUserMapper.stop(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Map paramMap) throws PlatformException {
        long count = baseUserMapper.usernameIsExit(paramMap);
        if(count > 0){
            throw new PlatformException(ErrorCode.USERNAME_IS_EXIT);
        }
        super.save(paramMap);
    }

}
