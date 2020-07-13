package com.keduw.repo;

import com.keduw.entity.KdUrlAccessEntity;
import com.keduw.entity.QKdUrlAccessEntity;
import com.keduw.jpa.QuerydslBaseRepo;
import com.keduw.model.UrlAccess;
import com.keduw.service.UrlService;
import com.keduw.util.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hongshengfeng
 * @date 2020/07/03
 */
@Component
public class UrlAccessRepo extends QuerydslBaseRepo<KdUrlAccessEntity, QKdUrlAccessEntity>{

    public List<UrlAccess> findAuthUrl(){
        List<UrlAccess> infoList = queryFactory.select(e).from(e)
                .where(bitAnd(e.flag, UrlAccess.Flag.IS_AUTH).eq(UrlAccess.Flag.IS_AUTH))
                .fetch().stream().map(info -> {
            UrlAccess data = BeanUtils.copyProperties(info, UrlAccess.class);
            return data;
        }).collect(Collectors.toList());
        return infoList;
    }

    public List<UrlAccess> findAccessUrl(){
        List<UrlAccess> infoList = queryFactory.select(e).from(e)
                .where(bitAnd(e.flag, UrlAccess.Flag.IS_AUTH).ne(UrlAccess.Flag.IS_AUTH))
                .fetch().stream().map(info -> {
                    UrlAccess data = BeanUtils.copyProperties(info, UrlAccess.class);
                    return data;
                }).collect(Collectors.toList());
        return infoList;
    }

    private QKdUrlAccessEntity e = QKdUrlAccessEntity.kdUrlAccessEntity;

    @Override
    public QKdUrlAccessEntity getEntityPath() {
        return e;
    }
}
