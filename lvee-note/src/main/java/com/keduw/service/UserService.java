package com.keduw.service;

import com.keduw.model.User;

/**
 * 用户相关数据处理接口
 *
 * @author hongshengfeng
 * @date 2020.07.03
 * @version 1.0.1
 */
public interface UserService {

    User getInfo(int id);

    User getInfoByDsl(int id);

}
