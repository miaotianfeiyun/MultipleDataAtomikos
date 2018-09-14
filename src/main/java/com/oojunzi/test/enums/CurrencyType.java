package com.oojunzi.test.enums;

/**
 * 货币类型
 *
 * @author CBC
 */
public enum CurrencyType {
    /**
     * 现金
     */
    MONEY(1, "现金", "元"),

    /**
     * 圈币
     */
    QUAN_COIN(2, "圈币", "圈币");

    /**
     * 类型
     */
    private int type;

    /**
     * 名称
     */
    private String name;

    /**
     * 单位
     */
    private String unit;

    /**
     * 构造函数
     *
     * @param type 类型
     * @param name 名称
     */
    CurrencyType(int type, String name, String unit) {
        this.type = type;
        this.name = name;
        this.unit = unit;
    }

    /**
     * 类型
     *
     * @return 类型
     */
    public int getType() {
        return type;
    }

    /**
     * 名称
     *
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 单位
     *
     * @return 单位
     */
    public String getUnit() {
        return unit;
    }
}
