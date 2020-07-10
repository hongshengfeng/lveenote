package com.keduw.service.impl;

import com.keduw.jpa.repo.UserRepo;
import com.keduw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户数据处理
 *
 * @author hongshengfeng
 * @date 2020/07/03
 */

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
