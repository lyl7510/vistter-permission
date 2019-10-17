package com.base.vistter.system.mapper.impl;

import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.impl.BaseMapperImpl;
import com.base.vistter.system.mapper.BaseDepartMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("baseDepartMapperImpl")
public class BaseDepartMapperImpl extends BaseMapperImpl implements BaseDepartMapper {

    protected String getNameSpace() {
        return "BaseDepart";
    }


    public void deleteByProjectId(String projectId) throws PlatformException{
        try {
            super.delete("deleteByProjectId" , projectId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    public void deleteByProjectIds(List projectIds) throws PlatformException{
        try {
            super.delete("deleteByProjectIds" , projectIds);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }
}
