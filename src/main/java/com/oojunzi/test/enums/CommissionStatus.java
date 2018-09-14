package com.oojunzi.test.enums;

public enum CommissionStatus {
	 /**
     * 是否收到提成：0未收到
     */
	RECEIVE_NO(0),
    /**
     * 是否收到提成：1已收到
     */
    RECEIVE_YES(1);

    int isCommission;

	CommissionStatus(int isCommission) {
		 this.isCommission = isCommission;
	}

	public int getIsCommission() {
		return isCommission;
	}
}
