package com.base.vistter.dao;

import java.util.Map;

public interface WriteDataDao {

    public void insert(String model, Map<String, Object> paramMap);

    public void update(String model, Map<String, Object> paramMap);

    public void delete(String model, Map<String, Object> paramMap);

    public long count(String model, Map<String, Object> paramMap);

}
