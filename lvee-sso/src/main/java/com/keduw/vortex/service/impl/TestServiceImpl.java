package com.keduw.vortex.service.impl;

import com.keduw.vortex.annotation.DataSource;
import com.keduw.vortex.datasources.DataSourceDef;
import com.keduw.vortex.vo.Test;
import com.keduw.vortex.dao.TestDao;
import com.keduw.vortex.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public Test getTestInfo(int id) {
        return testDao.selectByPrimaryKey(id);
    }

    @Override
    @DataSource(name = DataSourceDef.SECOND)
    public Test getTestInfo2(int id) {
        return testDao.selectByPrimaryKey(id);
    }
}
