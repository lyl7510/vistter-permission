package com.base.vistter.system.mapper.impl;

import com.base.vistter.common.mapper.impl.BaseMapperImpl;
import com.base.vistter.system.mapper.BaseAttachmentMapper;
import org.springframework.stereotype.Repository;

@Repository("baseAttachmentMapperImpl")
public class BaseAttachmentMapperImpl extends BaseMapperImpl implements BaseAttachmentMapper {

    protected String getNameSpace(){
        return "BaseAttachment";
    }

}
