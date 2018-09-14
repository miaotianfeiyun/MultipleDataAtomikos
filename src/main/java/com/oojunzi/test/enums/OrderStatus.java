package com.oojunzi.test.enums;

/**
 * 订单状态
 *
 * @author CBC
 */
public enum OrderStatus {
    /*
     * 待支付
     */
    PREPAY(0),
    /*
     * 支付成功
     */
    SUCCESS(1),
    /*
     * 支付失败
     */
    FAIL(2);
    int status;

    OrderStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
