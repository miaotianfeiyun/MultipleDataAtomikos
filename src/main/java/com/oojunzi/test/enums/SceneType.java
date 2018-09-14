package com.oojunzi.test.enums;

/**
 * 场景类型
 * 
 * @author 肖祥龙
 *
 */
public enum SceneType {
	/**
	 * 加油站
	 */
	JYZ("JYZ"),
	/**
	 * 洗车店
	 */
	XCD("XCD"),
	/**
	 * 活动
	 */
	ACTIVITY("ACTIVITY");
	

	private String sceneType;

	private SceneType(String sceneType) {
		this.sceneType = sceneType;
	}

	public String val() {
		return sceneType;
	}
}
