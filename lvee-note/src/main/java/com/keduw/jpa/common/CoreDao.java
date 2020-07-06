package com.keduw.jpa.common;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author hongshengfeng
 * @date 2020/07/03
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface CoreDao<T, ID extends Serializable> extends JpaRepositoryImplementation<T, ID> {
}
