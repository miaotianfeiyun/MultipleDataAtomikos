package com.oojunzi.test.enums;

/**
 * 用户状态
 *
 * @author CBC
 */
public enum UserStatus {

    /**
     * 新注册
     */
    REG(1),

    /**
     * 已绑定手机号
     */
    BIND_PHONE(2),

    /**
     * 已加入会员
     */
    MEMBERSHIP(3);

    private int status;

    /**
     * 构造方法
     *
     * @param status 用户状态码
     */
    UserStatus(int status) {
        this.status = status;
    }

    /**
     * 获取用户状态码
     *
     * @return 用户状态码
     */
    public int getStatus() {
        return status;
    }
}
