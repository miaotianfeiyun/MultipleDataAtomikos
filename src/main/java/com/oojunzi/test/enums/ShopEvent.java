package com.oojunzi.test.enums;

/**
 * 店铺事件
 * 
 * @author 肖祥龙
 *
 */
public enum ShopEvent {
	/**
	 * 支付
	 */
	PAY("pay"),
	/**
	 * 扫码
	 */
	SCAN("scan"),
	/**
	 * 添加车辆
	 */
	CAR("car"),
	/**
	 * 参与互助
	 */
	HELP("help");

	private String type;

	private ShopEvent(String type) {
		this.type = type;
	}

	public String val() {
		return type;
	}
}
