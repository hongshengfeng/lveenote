package com.keduw.service.impl;

import com.keduw.repo.UrlAccessRepo;
import com.keduw.model.UrlAccess;
import com.keduw.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hongshengfeng
 * @date 2020/07/03
 */
@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlAccessRepo urlAccessRepo;

    @Override
    public List<UrlAccess> getAccessUrl() {
        return urlAccessRepo.findAccessUrl();
    }

    @Override
    public List<UrlAccess> getAuthUrl() {
        return urlAccessRepo.findAuthUrl();
    }

}
