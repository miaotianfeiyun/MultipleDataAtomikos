package com.oojunzi.test.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Dao基类
 */
@Component
abstract class BaseDao {
    @Autowired
    @Qualifier("test1SqlSessionTemplate")
    private SqlSession sqlSession;

    /**
     * get SqlSession
     *
     * @return SqlSession
     */
    public SqlSession getSqlSession() {
        return sqlSession;
    }

    /**
     * set SqlSession
     *
     * @param sqlSession SqlSession
     */
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
}
