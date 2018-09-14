package com.oojunzi.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户基本信息
 *
 * @author CBC
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -5051993822874155962L;

    /**
     * 自增id
     */
    private Integer id = 0;
    /**
     * 用户名
     */
    private String name = "";

    /**
     * 注册手机号
     */
    private String mobile = "";

    /**
     * 用户类型 0普通会员 1会长
     */
    private Integer userType = 0;

    /**
     * 邀请用户uid
     */
    private Integer inviterUid = 0;

    /**
     * 注册IP
     */
    private String regIp = "";

    /**
     * 状态
     */
    private Integer status = 0;


    /**
     * 头像
     */
    private String avatar = "";


    /**
     * unionId
     */
    private String unionId = "";

    /**
     * openId
     */
    private String openId = "";

    /**
     * nickname
     */
    private String nickname = "";

    /**
     * sex
     */
    private Integer sex = 0;

    /**
     * 是否关注
     */
    private Integer subscribe = 0;

    /**
     * 关注时间
     */
    private Date subscribeTime = new Date();

    /**
     * 语言
     */
    private String language = "";

    /**
     * 城市
     */
    private String city = "";

    /**
     * 省份
     */
    private String province = "";

    /**
     * 国家
     */
    private String country = "";

    /**
     * remark
     */
    private String remark = "";

    /**
     * groupid
     */
    private Integer groupId = 0;

    /**
     * tagIds
     */
    private String tagIds = "";
    
    /**
     * 渠道
     */
    private String channel = "";

    /**
     * accessToken
     */
    private String accessToken = "";

    /**
     * refreshToken
     */
    private String refreshToken = "";

    /**
     * lastRefreshTime
     */
    private Date lastRefreshTime = new Date();

    /**
     * 创建时间
     */
    private Date createTime = new Date();

    /**
     * 最后更新时间
     */
    private Date updateTime = new Date();

    /**
     * 是否会长
     *
     * @return 是否会长
     */
    public boolean isPresident() {
        return userType == 1;
    }
}
