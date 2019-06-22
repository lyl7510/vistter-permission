package com.base.vistter.dao.impl;

import com.base.vistter.dao.ReadDataDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ReadDataDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liyanlei
 * @date 2018年9月14日 上午11:22:29
 */
@Repository("readDataDaoImpl")
public class ReadDataDaoImpl implements ReadDataDao {

    @Autowired
    private SqlSession session;

    public long count(String model , Map<String, Object> paramMap){
       return session.selectOne(model+"Count" , paramMap);
    }

    public Map<String ,Object> single(String model ,Map<String, Object> paramMap){
        return session.selectOne(model+"Single" , paramMap);
    }

    public List<Map<String ,Object>> data(String model ,Map<String, Object> paramMap){
        return session.selectList(model+"Data" , paramMap);
    }

}
