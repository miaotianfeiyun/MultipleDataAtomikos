package com.oojunzi.test.dao1;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oojunzi.test.model1.VipUser;

/**
 * <p>
 * Title: VipUserMapper.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:www.oojunzi.com
 * </p>
 * 
 * @author liujq
 * @date :2015年7月1日
 * @version :1.0
 */
@Repository
public interface VipUserMapper {
	/**
	 * @Description: 分页获取内容
	 * @param vipUser
	 * @param pageBounds
	 * @return List<VipUser>
	 */
//	public List<VipUser> getVipUserByParas(VipUser vipUser, PageBounds pageBounds) throws Exception;

	/**
	 * @Description: 根据条件获取内容
	 * @param vipUser
	 * @return
	 * @throws Exception
	 * @return VipUser
	 */
	public VipUser getVipUserByParas(VipUser vipUser) throws Exception;

	/**
	 * @Description: 添加
	 * @param vipUser
	 * @throws Exception
	 * @return void
	 */
	public void save(VipUser vipUser) throws Exception;

	/**
	 * @Description: 更新
	 * @param vipUser
	 * @throws Exception
	 * @return void
	 */
	public void update(VipUser vipUser) throws Exception;

	/**
	 * @Description: 删除
	 * @param vipUser
	 * @throws Exception
	 * @return void
	 */
	public void delete(VipUser vipUser) throws Exception;

	/**
	 * @Description: 获取用户信息 不带分页
	 * @param vipUser
	 * @return
	 * @throws Exception
	 * @return List<VipUser>
	 */
	public List<VipUser> getVipUsersByParasNoPage(VipUser vipUser) throws Exception;

	/**
	 * 关联获取用户和车辆信息
	 * 
	 * @param vipUser
	 * @return
	 * @throws Exception
	 */
	public VipUser getVipUserById(int id) throws Exception;

	/**
	 * 条件查询列表
	 * 
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<VipUser> getVipCarListByRelevance(VipUser vipUser) throws Exception;

	/**
	 * 根据id获取用户
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
//	public VipCar findUSerByUserId(int userId) throws Exception;
}
