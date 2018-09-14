package com.oojunzi.test.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.oojunzi.test.dao.UserDao;
import com.oojunzi.test.dao1.VipUserMapper;
import com.oojunzi.test.enums.UserStatus;
import com.oojunzi.test.model.User;
import com.oojunzi.test.model1.VipUser;
import com.oojunzi.test.service.UserService;
import com.oojunzi.test.util.Pager;

/**
 * UserServiceImpl实现UserService定义的接口
 *
 * @author CBC
 */
@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	VipUserMapper vipUserMapper;

	public List<Map> getTenUser() {
		return userDao.getTenUser();
	}

	public Pager<User> getUserListByUserType(UserStatus userStatus, int page, int pageSize) {
		Pager<User> userPager = new Pager<User>(page, pageSize);

		int count = userDao.countUser(userStatus);
		if (count > 0) {
			List<User> userList = userDao.selectUserList(userStatus, userPager.getOffset(), pageSize);
			userPager.setTotalCount(count);
			userPager.setData(userList);
		}

		return userPager;
	}

	public Pager<User> getUserListByUserType(int userType, int page, int pageSize) {
		Pager<User> userPager = new Pager<User>(page, pageSize);
		userPager.setTotalCount(countByUserType(userType));
		userPager.setData(userDao.selectUserListByUserType(userType, userPager.getOffset(), pageSize));
		return userPager;
	}

	public int countByUserType(int userType) {
		return userDao.countByUserType(userType);
	}

	// @Caching(evict = {
	// @CacheEvict(value = CacheConfig.DEFAULT_CACHE, key = "'user.' + #user.id"),
	// @CacheEvict(value = CacheConfig.DEFAULT_CACHE, key = "'user.openid.' +
	// #user.openId"),
	// @CacheEvict(value = CacheConfig.DEFAULT_CACHE, key = "'user.mobile.' +
	// #user.mobile")
	// })
	public boolean updateByUid(User user) {
		LOGGER.info("##### update user.{}", user);
		return userDao.updateByUid(user);
	}

	public boolean updateUserStatus(int uid, UserStatus userStatus) {
		User user = findByUid(uid);
		user.setStatus(userStatus.getStatus());
		// 只有已加入会员才更新 更新时间
		if (UserStatus.MEMBERSHIP.getStatus() == userStatus.getStatus()) {
			user.setUpdateTime(new Date());
		}
		return updateByUid(user);
	}

	public boolean updateUserSubscribe(int uid, int subscribe) {
		User user = findByUid(uid);
		user.setSubscribe(subscribe);
		return updateByUid(user);
	}

	// @Caching(evict = {
	// @CacheEvict(value = CacheConfig.DEFAULT_CACHE, key = "'user.' + #user.id"),
	// @CacheEvict(value = CacheConfig.DEFAULT_CACHE, key = "'user.openid.' +
	// #user.openId"),
	// @CacheEvict(value = CacheConfig.DEFAULT_CACHE, key = "'user.mobile.' +
	// #user.mobile")
	// })
	public int createUser(User user) {
		if (user == null) {
			return 0;
		}
		LOGGER.info("##### create user. {}", user);
		return userDao.insert(user);
	}

	// @Cacheable(value = CacheConfig.DEFAULT_CACHE, key = "'user.' + #uid")
	public User findByUid(int uid) {
		if (uid < 1) {
			return null;
		}
		User user = userDao.findByUid(uid);
		LOGGER.info("##### findByUid({}), user:{}", uid, user);
		return user;
	}

	public List<User> findByUidList(List<Integer> uidList) {
		return userDao.findByUidList(uidList);
		// List<User> userList = new ArrayList<>();
		// uidList.forEach(uid -> {
		// User user = findByUid(uid);
		// if (user != null) {
		// userList.add(user);
		// }
		// });
		// return userList;
	}

	// @Cacheable(value = CacheConfig.DEFAULT_CACHE, key = "'user.openid.' +
	// #openId")
	public User findByOpenId(String openId) {
		if (StringUtils.isEmpty(openId)) {
			LOGGER.warn("##### openid is empty.");
			return null;
		}
		return userDao.findByOpenId(openId);
	}

	// @Cacheable(value = CacheConfig.DEFAULT_CACHE, key = "'user.mobile.' +
	// #mobile")
	public User findByMobile(String mobile) {
		if (StringUtils.isEmpty(mobile)) {
			return null;
		}
		return userDao.findByMobile(mobile);
	}

	public Pager<User> getUserListByWithdrawStatus(int withdrawStatus, int page, int pageSize) {
		Pager<User> userPager = new Pager<User>(page, pageSize);
		userPager.setTotalCount(countByPresidentWithdrawStatus(withdrawStatus));
		userPager.setData(userDao.getUserListByWithdrawStatus(withdrawStatus, userPager.getOffset(), pageSize));
		return userPager;
	}

	private int countByPresidentWithdrawStatus(int withdrawStatus) {
		return userDao.countByPresidentWithdrawStatus(withdrawStatus);
	}

	public List<Map> findLikeDataByMobile(String mobile) {
		if (StringUtils.isEmpty(mobile)) {
			return null;
		}
		return userDao.findLikeDataByMobile(mobile);
	}

	public int countRegUsersByDate(String beginDate) {
		if (StringUtils.isEmpty(beginDate)) {
			return 0;
		}
		return userDao.countRegUsersByDate(beginDate);
	}

	public Pager<User> findByInviterUid(int uid, int page, int pageSize) {
		Pager<User> userPager = new Pager<User>(page, pageSize);
		userPager.setTotalCount(userDao.countByInviterUid(uid));
		int offset = userPager.getOffset();
		userPager.setData(userDao.findByInviterUid(uid, offset, pageSize));
		return userPager;
	}

	public int countByInviterUid(int uid) {
		return userDao.countByInviterUid(uid);
	}


	public VipUser getVipUserByParas(VipUser vipUser) throws Exception {
		return vipUserMapper.getVipUserByParas(vipUser);
	}

	public void saveVipUser(VipUser vipUser) throws Exception {
		vipUserMapper.save(vipUser);
	}


}
