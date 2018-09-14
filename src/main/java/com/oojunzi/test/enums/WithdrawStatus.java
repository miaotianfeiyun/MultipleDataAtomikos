package com.oojunzi.test.enums;

/**
 * 提现状态
 */
public enum WithdrawStatus {

    /**
     * 提交申请
     */
    SUBMITTED(0),

    /**
     * 通过审核并完成提现
     */
    APPROVED(1),

    /**
     * 已拒绝
     */
    REJECTED(2);

    private int status;

    WithdrawStatus(int status) {
        this.status = status;
    }

    /**
     * 提现状态
     *
     * @return 提现状态code
     */
    public int getStatus() {
        return status;
    }
}
