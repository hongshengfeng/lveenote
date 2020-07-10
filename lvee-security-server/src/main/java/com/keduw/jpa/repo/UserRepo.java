package com.keduw.jpa.repo;

import com.keduw.entity.KdUserEntity;
import com.keduw.entity.QKdUserEntity;
import com.keduw.jpa.common.QuerydslBaseRepo;
import org.springframework.stereotype.Component;

/**
 * @author hongshengfeng
 * @date 2020/07/10
 */

@Component
public class UserRepo extends QuerydslBaseRepo<KdUserEntity, QKdUserEntity>{

    public KdUserEntity findByName(String userName){
        KdUserEntity e = queryFactory.select(u).from(u).where(u.userName.eq(userName)).fetchOne();
        return null;
    }

    private QKdUserEntity u = QKdUserEntity.kdUserEntity;

    @Override
    public QKdUserEntity getEntityPath() {
        return u;
    }
}
