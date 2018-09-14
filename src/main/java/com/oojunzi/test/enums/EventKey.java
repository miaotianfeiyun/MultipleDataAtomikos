package com.oojunzi.test.enums;

public enum EventKey {
	WELCOME("welcome"), RAINBOWCARD("rainbowcard");

	private String key;

	EventKey(String key) {
		this.key = key;
	}

	public String val() {
		return key;
	}
}
