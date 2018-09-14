package com.oojunzi.test.dao;

import java.util.List;
import java.util.Map;

import com.oojunzi.test.enums.UserStatus;
import com.oojunzi.test.model.User;

/**
 * UserDao interface
 *
 * @author CBC
 */
public interface UserDao {

    /**
     * 插入用户基本信息
     *
     * @param user com.oojunzi.wechat.model.User
     * @return 用户ID
     */
    int insert(User user);

    /**
     * 更新用户基本信息
     *
     * @param user com.oojunzi.wechat.model.User
     * @return 受影响的行数
     */
    boolean updateByUid(User user);

    /**
     * 根据用户ID获取用户基本信息
     *
     * @param uid 用户ID
     * @return com.oojunzi.wechat.model.User
     */
    User findByUid(int uid);

    /**
     * 根据openId获取用户基本信息
     *
     * @param openId 微信openId
     * @return com.oojunzi.wechat.model.User
     */
    User findByOpenId(String openId);

    /**
     * 统计全部用户数量
     *
     * @param userStatus com.oojunzi.wechat.enums.UserStatus
     * @return 用户数量
     */
    int countUser(UserStatus userStatus);

    /**
     * 分页获取用户基本信息
     *
     * @param userStatus com.oojunzi.wechat.enums.UserStatus
     * @param offset     偏移量
     * @param limit      返回结果条数
     * @return 用户列表
     */
    List<User> selectUserList(UserStatus userStatus, int offset, int limit);

    /**
     * 根据类型获取用户总数
     *
     * @param userType 用户类型
     * @return 数量
     */
    int countByUserType(int userType);

    /**
     * 分页获取用户基本信息
     *
     * @param userType 用户类型
     * @param offset   偏移量
     * @param limit    返回结果条数
     * @return 用户列表
     */
    List<User> selectUserListByUserType(int userType, int offset, int limit);

    /**
     * 根据手机号获取用户基本信息
     *
     * @param mobile 手机号
     * @return com.oojunzi.wechat.model.User
     */
    User findByMobile(String mobile);

    /**
     * 批量获取用户
     *
     * @param uidList 用户id list
     * @return 用户列表
     */
    List<User> findByUidList(List<Integer> uidList);

	/** 
	 * @Description: 根据会长提现状态获取用户列表
	 * @param  withdrawStatus
	 * @param  offset
	 * @param  pageSize
	 * @return List<User>
	 * @author liujq-2018年4月4日
	 */
	List<User> getUserListByWithdrawStatus(int withdrawStatus, int offset, int pageSize);
	/** 
	 * @Description: 根据会长提现状态获取用户总数
	 * @param  withdrawStatus
	 * @param  offset
	 * @param  pageSize
	 * @return List<User>
	 * @author liujq-2018年4月4日
	 */
	int countByPresidentWithdrawStatus(int withdrawStatus);
    /**
     * 根据手机号模糊查询用户名
     *
     * @param mobile 手机号
     * @return com.oojunzi.wechat.model.User
     */
	List<Map> findLikeDataByMobile(String mobile);
	/**
     * 取得最新10条用户
     */
	List<Map> getTenUser();
	/**
	 * 查询距离指定日期注册人数 
	 * @param date
	 * @return
	 */
	int countRegUsersByDate(String beginDate);
	
	
    /**
     * 根据UID获取被邀请的用户列表
     *
     * @param uid    邀请人uid
     * @param offset 页码
     * @param limit  每页记录数
     * @return 会员列表
     */
    List<User> findByInviterUid(int uid, int offset, int limit);

    /**
     * 根据UID获取被邀请的用户总数
     *
     * @param uid 邀请人uid
     * @return 被邀请的用户总数
     */
    int countByInviterUid(int uid);
}
