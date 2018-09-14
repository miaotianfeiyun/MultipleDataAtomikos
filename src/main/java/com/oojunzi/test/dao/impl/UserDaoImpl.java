package com.oojunzi.test.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.oojunzi.test.dao.UserDao;
import com.oojunzi.test.enums.UserStatus;
import com.oojunzi.test.model.User;

/**
 * 实现UserDao
 *
 * @author CBC
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private static final String NAME_SPACE = "com.oojunzi.test.dao.UserDao.";

    public List<Map> getTenUser() {
    	
    	return getSqlSession().selectList(NAME_SPACE + "getTenUser");
    }
    
    public int insert(User user) {
        return getSqlSession().insert(NAME_SPACE + "insert", user);
    }

    
    public boolean updateByUid(User user) {
        return getSqlSession().update(NAME_SPACE + "updateByUid", user) > 0;
    }

    
    public User findByUid(int uid) {
        return getSqlSession().selectOne(NAME_SPACE + "findByUid", uid);
    }

    
    public User findByOpenId(String openId) {
        return getSqlSession().selectOne(NAME_SPACE + "findByOpenId", openId);
    }

    
    public User findByMobile(String mobile) {
        return getSqlSession().selectOne(NAME_SPACE + "findByMobile", mobile);
    }

    
    public List<User> findByUidList(List<Integer> uidList) {
        if (CollectionUtils.isEmpty(uidList)) {
            return new ArrayList<User>();
        }
        return getSqlSession().selectList(NAME_SPACE + "findByUidList", uidList);
    }

    
    public int countUser(UserStatus userStatus) {
        Integer cnt = getSqlSession().selectOne(NAME_SPACE + "countUser", userStatus.getStatus());
        return cnt == null ? 0 : cnt;
    }

    
    public List<User> selectUserList(UserStatus userStatus, int offset, int limit) {
        Map<String, Object> paramMap = new HashMap<String, Object>(3);
        paramMap.put("status", userStatus.getStatus());
        paramMap.put("offset", offset);
        paramMap.put("limit", limit);
        LOGGER.debug("##### selectUserList paramMap:{}", paramMap);
        return getSqlSession().selectList(NAME_SPACE + "selectUserList", paramMap);
    }

    
    public int countByUserType(int userType) {
        Integer cnt = getSqlSession().selectOne(NAME_SPACE + "countByUserType", userType);
        return cnt == null ? 0 : cnt;
    }

    
    public List<User> selectUserListByUserType(int userType, int offset, int limit) {
        Map<String, Object> paramMap = new HashMap<String, Object>(3);
        paramMap.put("userType", userType);
        paramMap.put("offset", offset);
        paramMap.put("limit", limit);
        return getSqlSession().selectList(NAME_SPACE + "selectUserListByUserType", paramMap);
    }

	
	public List<User> getUserListByWithdrawStatus(int withdrawStatus, int offset, int pageSize) {
		 Map<String, Object> paramMap = new HashMap<String, Object>(3);
	        paramMap.put("withdrawStatus", withdrawStatus);
	        paramMap.put("offset", offset);
	        paramMap.put("limit", pageSize);
	        return getSqlSession().selectList(NAME_SPACE + "getUserListByWithdrawStatus", paramMap);
	}

	
	public int countByPresidentWithdrawStatus(int withdrawStatus) {
		 Integer cnt = getSqlSession().selectOne(NAME_SPACE + "countByPresidentWithdrawStatus", withdrawStatus);
	     return cnt == null ? 0 : cnt;
	}

    
    public List<Map> findLikeDataByMobile(String mobile) {
    	if(StringUtils.isEmpty(mobile)) {
    		return null;
    	}
        Map<String, Object> paramMap = new HashMap<String, Object>(1);
        paramMap.put("mobile", mobile);
        LOGGER.debug("##### findLikeDataByMobile paramMap:{}", paramMap);
        return getSqlSession().selectList(NAME_SPACE + "findLikeDataByMobile", paramMap);
    }
    
    public int countRegUsersByDate(String beginDate) {
    	if(StringUtils.isEmpty(beginDate)) {
    		return 0;
    	}
        Integer cnt =  getSqlSession().selectOne(NAME_SPACE + "countRegUsersByDate", beginDate);
        return cnt == null ? 0 : cnt;
    }
    
    
    public int countByInviterUid(int uid) {
        Integer cnt = getSqlSession().selectOne(NAME_SPACE + "countByInviterUid", uid);
        return cnt == null ? 0 : cnt;
    }

    
    public List<User> findByInviterUid(int uid, int offset, int limit) {
        Map<String, Object> paramMap = new HashMap<String, Object>(3);
        paramMap.put("uid", uid);
        paramMap.put("offset", offset);
        paramMap.put("limit", limit);
        return getSqlSession().selectList(NAME_SPACE + "findByInviterUid", paramMap);
    }
    
}
