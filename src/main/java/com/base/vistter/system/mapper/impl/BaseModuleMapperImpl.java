package com.base.vistter.system.mapper.impl;

import com.base.vistter.mapper.impl.BaseMapperImpl;
import com.base.vistter.system.mapper.BaseModuleMapper;
import org.springframework.stereotype.Repository;

@Repository("baseModuleMapperImpl")
public class BaseModuleMapperImpl extends BaseMapperImpl implements BaseModuleMapper {

    protected String getNameSpace(){
        return "BaseModule";
    }

}
