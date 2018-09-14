package com.oojunzi.test.enums;

public enum WelfareType {
	/**
	 * 99元会员费代金卷
	 */
	COUPON_100("coupon_100"),
	/**
	 * 100互助金
	 */
	COIN_100("coin_100");

	String welfareType;

	WelfareType(String welfareType) {
		this.welfareType = welfareType;
	}

	public String val() {
		return welfareType;
	}
}
