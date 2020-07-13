package com.keduw.service;

import com.keduw.model.UrlAccess;

import java.util.List;

/**
 * @author hongshengfeng
 * @date 2020/07/03
 */
public interface UrlService {

    List<UrlAccess> getAccessUrl();

    List<UrlAccess> getAuthUrl();

}
