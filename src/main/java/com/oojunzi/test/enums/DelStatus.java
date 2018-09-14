package com.oojunzi.test.enums;

/**
 * 删除状态
 *
 * @author CBC
 */
public enum DelStatus {

    /**
     * 正常
     */
	NORMAL(0),

    /**
     * 删除
     */
    DEL(1);

    private int status;

    /**
     * 构造方法
     *
     * @param status 用户状态码
     */
    DelStatus(int status) {
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
