package com.oojunzi.test.enums;

/**
 * 场景使用状态  0未使用 ，1已使用
 * 
 * @author 肖祥龙
 *
 */
public enum SceneUseStatus {
	/**
	 * 未使用 0
	 */
	UNUSED(0),
	/**
	 * 已使用 1
	 */
	USED(1);
	

	private Integer useStatus;

	private SceneUseStatus(Integer sceneType) {
		this.useStatus = sceneType;
	}

	public Integer val() {
		return useStatus;
	}
}
