package com.base.vistter.dao;

import java.util.List;
import java.util.Map;

/**
* @ClassName: ReadDataMapper
* @Description: TODO(这里用一句话描述这个类的作用)
* @author liyanlei
* @date 2018年9月12日 下午1:32:03
*
*/
public interface ReadDataDao {

    /**
     * 统计数据
     * @param model
     * @param paramMap
     * @return
     */
    public long count(String model, Map<String, Object> paramMap);

    /**
     * 单条数据
     * @param model
     * @param paramMap
     * @return
     */
    public Map<String ,Object> single(String model, Map<String, Object> paramMap);

    /**
     * 列表数据
     * @param model
     * @param paramMap
     * @return
     */
    public List<Map<String ,Object>> data(String model, Map<String, Object> paramMap);

}
