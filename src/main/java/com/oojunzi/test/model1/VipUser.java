package com.oojunzi.test.model1;

import java.util.Date;

/**
 * @author 肖祥龙
 *
 */
public class VipUser implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	/*
	 * 主键id
	 */
	private int u_id;
	/*
	 * 会员编号
	 */
	private String noid;
	/*
	 * 邮箱
	 */
	private String email;
	/*
	 * 住址
	 */
	private String address;
	/*
	 * 身份证
	 */
	private String id_card;
	/*
	 * 职业
	 */
	private String jobs;
	/*
	 * 教育程度
	 */
	private String education;
	/*
	 * 婚姻状况
	 */
	private String marriage;
	/*
	 * 手机号
	 */
	private String phone;
	/*
	 * 孩子数量
	 */
	private Integer children;
	/*
	 * 微信号
	 */
	private String wxid;
	/*
	 * 微信唯一标识id
	 */
	private String openid;
	/*
	 * 微信昵称
	 */
	private String nick_name;
	/*
	 * 真实姓名
	 */
	private String real_name;
	/*
	 * 	
	 */
	private String sex = "1";
	/*
	 * 审核状态：10:未审核 20:已审核
	 */
	private String ischek = "10";
	/*
	 * 信誉
	 */
	private Integer credit = 100;
	/*
	 * 密码
	 */
	private String password;
	/*
	 * 余额
	 */
	private Double balance = 0.0;
	/*
	 * 奖励
	 */
	private Double award = 0.0;
	/*
	 * 创建时间
	 */
	private Date createdate;
	/*
	 * 更新时间
	 */
	private Date updatedate;

	private Double minMoney;

	private Double maxMoney;

	private Date joinBeginDate;

	private Date joinEndDate;

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public void setNoid(String noid) {
		this.noid = noid;
	}

	public String getNoid() {
		return this.noid;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getId_card() {
		return this.id_card;
	}

	public void setJobs(String jobs) {
		this.jobs = jobs;
	}

	public String getJobs() {
		return this.jobs;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEducation() {
		return this.education;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public Integer getChildren() {
		return this.children;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid;
	}

	public String getWxid() {
		return this.wxid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getNick_name() {
		return this.nick_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getReal_name() {
		return this.real_name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return this.sex;
	}

	public void setIschek(String ischek) {
		this.ischek = ischek;
	}

	public String getIschek() {
		return this.ischek;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Integer getCredit() {
		return this.credit;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setAward(Double award) {
		this.award = award;
	}

	public Double getAward() {
		return this.award;
	}

	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}

	public java.util.Date getCreatedate() {
		return this.createdate;
	}

	public java.util.Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(java.util.Date updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "VipUser [u_id=" + u_id + ", noid=" + noid + ", email=" + email + ", address=" + address + ", id_card="
				+ id_card + ", jobs=" + jobs + ", education=" + education + ", marriage=" + marriage + ", phone="
				+ phone + ", children=" + children + ", wxid=" + wxid + ", openid=" + openid + ", nick_name="
				+ nick_name + ", real_name=" + real_name + ", sex=" + sex + ", ischek=" + ischek + ", credit=" + credit
				+ ", password=" + password + ", balance=" + balance + ", award=" + award + ", createdate=" + createdate
				+ ", updatedate=" + updatedate + ",]";
	}

	public Double getMinMoney() {
		return minMoney;
	}

	public void setMinMoney(Double minMoney) {
		this.minMoney = minMoney;
	}

	public Double getMaxMoney() {
		return maxMoney;
	}

	public void setMaxMoney(Double maxMoney) {
		this.maxMoney = maxMoney;
	}

	public Date getJoinBeginDate() {
		return joinBeginDate;
	}

	public void setJoinBeginDate(Date joinBeginDate) {
		this.joinBeginDate = joinBeginDate;
	}

	public Date getJoinEndDate() {
		return joinEndDate;
	}

	public void setJoinEndDate(Date joinEndDate) {
		this.joinEndDate = joinEndDate;
	}

}
