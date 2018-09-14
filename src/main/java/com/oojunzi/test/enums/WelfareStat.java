package com.oojunzi.test.enums;

/**
 * 删除状态
 *
 * @author CBC
 */
public enum WelfareStat {

    /**
     * 未使用
     */
	UNUSE(0),
    /**
     * 已使用
     */
    USED(1),
	/**
	 * 已过期
	 */
	OVERDUE(2);

    private int stat;

    /**
     * 构造方法
     *
     * @param status 用户状态码
     */
    WelfareStat(int stat) {
        this.stat = stat;
    }

    /**
     * 获取用户状态码
     *
     * @return 用户状态码
     */
    public int val() {
        return stat;
    }
}
