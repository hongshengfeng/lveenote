package com.keduw.lvee.dao;

import com.keduw.lvee.vo.Test;
import org.apache.ibatis.annotations.Mapper;

/**
 * 测试接口
 * @author 柏渡人
 * @date 2020.01.29
 */
@Mapper
public interface TestDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}