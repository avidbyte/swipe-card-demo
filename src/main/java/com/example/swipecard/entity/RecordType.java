package com.example.swipecard.entity;

import lombok.Data;

/**
 * 记录类型
 *
 * @author aaron
 * @since 2021-02-24
 */
@Data
public class RecordType {

    /**
     * 无记录
     */
    public static final byte ZERO = 0;

    /**
     * 刷卡记录
     */
    public static final byte ONE = 1;

    /**
     * 门磁,按钮, 设备启动, 远程开门记录
     */
    public static final byte TWO = 2;

    /**
     * 报警记录
     */
    public static final byte THREE = 3;

}
