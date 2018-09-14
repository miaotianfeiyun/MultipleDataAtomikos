package com.oojunzi.test.service;

import java.util.List;
import java.util.Map;

import com.oojunzi.test.enums.UserStatus;
import com.oojunzi.test.model.User;
import com.oojunzi.test.model1.VipUser;
import com.oojunzi.test.util.Pager;

/**
 * UserService 定义用户基本信息操作
 *
 * @author CBC
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param user User
     * @return 用户ID
     */
    int createUser(User user);

    /**
     * 根据UID查找用户
     *
     * @param uid 用户ID
     * @return User
     */
    User findByUid(int uid);

    /**
     * 根据UID批量查找用户
     *
     * @param uidList 用户ID列表
     * @return 用户列表
     */
    List<User> findByUidList(List<Integer> uidList);

    /**
     * 根据openId获取用户基本信息
     *
     * @param openId 微信openId
     * @return com.oojunzi.wechat.model.User
     */
    User findByOpenId(String openId);

    /**
     * 根据手机号查找用户
     *
     * @param mobile 手机号
     * @return User
     */
    User findByMobile(String mobile);

    /**
     * 获取用户列表
     *
     * @param userStatus UserStatus
     * @param page       页码
     * @param pageSize   每页展示的用户数量
     * @return 分页信息
     */
    Pager<User> getUserListByUserType(UserStatus userStatus, int page, int pageSize);

    /**
     * 根据用户类型获取用户列表
     *
     * @param userType 0会员 1会长
     * @param page     页码
     * @param pageSize 每页数量
     * @return 分页
     */
    Pager<User> getUserListByUserType(int userType, int page, int pageSize);
    
    /**
     * 根据会长提现状态获取用户列表
     *
     * @param withdrawStatus 0会员 1会长
     * @param page     页码
     * @param pageSize 每页数量
     * @return 分页
     */
    Pager<User> getUserListByWithdrawStatus(int withdrawStatus, int page, int pageSize);

    /**
     * 根据类型获取用户总数
     *
     * @param userType 用户类型
     * @return 数量
     */
    int countByUserType(int userType);

    /**
     * 更新用户基本信息
     *
     * @param user com.oojunzi.wechat.model.User
     * @return 受影响的行数
     */
    boolean updateByUid(User user);

    /**
     * 修改用户状态
     *
     * @param uid        uid
     * @param userStatus 用户状态
     * @return 成功标识
     */
    boolean updateUserStatus(int uid, UserStatus userStatus);


    /**
     * 修改用户是否关注
     *
     * @param uid        uid
     * @param subscribe 是否关注
     * @return 成功标识
     */
    boolean updateUserSubscribe(int uid, int subscribe);
    
    /**
     * 根据手机号模糊查询用户名
     *
     * @param mobile 手机号
     * @return com.oojunzi.wechat.model.User
     */
    List<Map> findLikeDataByMobile(String mobile);

    /**
     * 获取最新加入的十个会员
     * @return
     */
	List<Map> getTenUser();
	 /**
     *  查询距离指定日期注册人数 -
     * @return
     */
	int countRegUsersByDate(String beginDate);
	
	 /**
     * 根据UID获取被要求的用户列表
     *
     * @param uid      邀请人uid
     * @param page     页码
     * @param pageSize 每页记录数
     * @return 分页信息
     */
    Pager<User> findByInviterUid(int uid, int page, int pageSize);

    /**
     * 根据UID获取被邀请的用户总数
     *
     * @param uid 邀请人uid
     * @return 会员总数
     */
    int countByInviterUid(int uid);
    VipUser getVipUserByParas(VipUser vipUser) throws Exception ;
    
    void saveVipUser(VipUser vipUser)  throws Exception ;
	
}
