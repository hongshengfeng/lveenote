package com.keduw.jpa.repo;

import com.keduw.entity.KdUrlAccessEntity;
import com.keduw.entity.QKdUrlAccessEntity;
import com.keduw.jpa.common.QuerydslBaseRepo;
import com.keduw.model.Note;
import com.keduw.model.UrlAccess;
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

    public List<UrlAccess> findAllInfo(){
        List<UrlAccess> infoList = queryFactory.select().from(e).fetch().stream().map(info -> {
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
