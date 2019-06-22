package com.base.vistter.dao.impl;

import com.base.vistter.dao.WriteDataDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("writeDataDaoImpl")
public class WriteDataDaoImpl implements WriteDataDao {

    @Autowired
    private SqlSession session;

    public void insert(String model, Map<String, Object> paramMap){
        session.insert(model , paramMap);
    }

    public void update(String model, Map<String, Object> paramMap){
        session.update(model , paramMap);
    }

    public void delete(String model, Map<String, Object> paramMap){
        session.delete(model , paramMap);
    }

    public long count(String model, Map<String, Object> paramMap){
        return session.selectOne(model , paramMap);
    }
}
