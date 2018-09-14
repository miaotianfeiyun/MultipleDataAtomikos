package com.oojunzi.test.enums;

/**
 * 提现类型
 * 
 * @author 肖祥龙
 *
 */
public enum WithdrawType {
	/**
	 * 人人推
	 */
	RENRENTUI(1),
	/**
	 * 渠道
	 */
	CHANNEL(2);

	private int type;

	private WithdrawType(int type) {
		this.type = type;
	}

	public int val() {
		return type;
	}
}
