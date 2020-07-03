package com.keduw.jpa.dao;

import com.keduw.jpa.common.LXCoreDao;
import com.keduw.entity.UserEntity;

/**
 * @author hongshengfeng
 * @date 2020.07.03
 * @version 1.0.1
 */
public interface UserDao extends LXCoreDao<UserEntity, Integer> {

    UserEntity getById(int id);

}
