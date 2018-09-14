package com.oojunzi.test.enums;

/**
 * 按钮类型
 * 
 * @author 肖祥龙
 *
 */
public enum ButtonType {

	/**
	 * 渠道来源 A
	 */
	A("A"),
	/**
	 * 渠道来源 B
	 */
	B("B"),

	/**
	 * 扫码 scan
	 */
	SCAN("scan"),
	/**
	 * 关注 subscribe
	 */
	SUBSCRIBE("subscribe"),
	/**
	 * 领取 receive
	 */
	RECEIVE("receive"),
	/**
	 * 支付
	 */
	PAY("pay");

	private String butType;

	private ButtonType(String butType) {
		this.butType = butType;
	}

	public String val() {
		return butType;
	}
}
