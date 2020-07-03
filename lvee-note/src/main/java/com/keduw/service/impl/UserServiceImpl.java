package com.keduw.service.impl;

import com.keduw.jpa.dao.UserDao;
import com.keduw.entity.UserEntity;
import com.keduw.jpa.repo.UserRepo;
import com.keduw.model.User;
import com.keduw.service.UserService;
import com.keduw.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户数据处理
 *
 * @author hongshengfeng
 * @date 2020.07.03
 * @version 1.0.1
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public User getInfo(int id) {
        UserEntity e = userRepo.findById(id);
        return BeanUtils.copyProperties(e, User.class);
    }

    @Override
    public User getInfoByDsl(int id) {
        UserEntity e = userRepo.findByDsl(id);
        return BeanUtils.copyProperties(e, User.class);
    }

}
