package com.oojunzi.test.enums;

/**
 * 文件上传类型
 * 
 * @author 肖祥龙
 *
 */
public enum FileType {
	/**
	 * 展位
	 */
	STAND("stand"),
	/**
	 * 案件展示
	 */
	CASESHOW("caseShow"),
	/**
	 * 名人堂
	 */
	USERFAME("userFame"),
	/**
	 * 场景二维码
	 */
	SCENE("scene");

	private String fileType;

	private FileType(String fileType) {
		this.fileType = fileType;
	}

	public String val() {
		return fileType;
	}

}
