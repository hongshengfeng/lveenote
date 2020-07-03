package com.keduw.jpa.repo;

import com.keduw.entity.QUserEntity;
import com.keduw.entity.UserEntity;
import com.keduw.jpa.common.QuerydslBaseRepo;
import com.keduw.jpa.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepo extends QuerydslBaseRepo<UserEntity, QUserEntity> {

    @Autowired
    private UserDao userDao;

    public UserEntity findById(int id){
        return userDao.getById(id);
    }

    public UserEntity findByDsl(int id){
        UserEntity info = queryFactory.select(u).from(u).where(u.id.eq(id)).fetchOne();
        return info;
    }

    private QUserEntity u = QUserEntity.userEntity;

    @Override
    public QUserEntity getEntityPath() {
        return u;
    }
}
