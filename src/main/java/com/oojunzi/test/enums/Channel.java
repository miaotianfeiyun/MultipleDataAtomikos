package com.oojunzi.test.enums;

public enum Channel {

	/**
	 * 彩虹卡
	 */
	RAINBOWCARD("rainbow_card");

	private String channel;

	private Channel(String channel) {
		this.channel = channel;
	}
	public String val() {
		return channel;
	}
}
