package com.keduw.lvee.service.impl;

import com.keduw.lvee.annotation.DataSource;
import com.keduw.lvee.datasources.DataSourceDef;
import com.keduw.lvee.vo.Test;
import com.keduw.lvee.dao.TestDao;
import com.keduw.lvee.service.TestService;
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
