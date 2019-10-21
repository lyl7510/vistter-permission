package com.base.vistter.system.service.impl;

import com.base.vistter.common.mapper.BaseMapper;
import com.base.vistter.common.service.impl.BaseServiceImpl;
import com.base.vistter.system.mapper.BaseAttachmentMapper;
import com.base.vistter.system.service.BaseAttachmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("baseAttachmentServiceImpl")
@Transactional
public class BaseAttachmentServiceImpl extends BaseServiceImpl implements BaseAttachmentService {

    @Resource(name = "baseAttachmentMapperImpl")
    private BaseAttachmentMapper baseAttachmentMapper;

    @Override
    protected BaseMapper getBaseMapper() {
        return this.baseAttachmentMapper;
    }
}
