package com.example.swipecard.entity;

import lombok.Data;

/**
 * 查询控制器状态 返回报文 demo
 * @author aaron
 * @since 2021-02-24
 */
@Data
public class ControllerReceiveMsg {

    /**
     * 报文数据
     */
    private byte[] message;

    public ControllerReceiveMsg() {
        /**
         * 构造初始开门报文数据
         */
        byte[] message = new byte[1024];
        /**
         * 类型 固定
         */
        message[0] = (byte) 0x17;
        /**
         * 功能号 固定
         */
        message[1] = (byte) 0x20;
        /**
         * 保留 固定
         */
        message[2] = (byte) 0x00;
        /**
         * 保留 固定
         */
        message[3] = (byte) 0x00;

        /**
         *  4-7 设备序列号  从高到低  顺序是7654
         */
        message[4] = (byte) 0xBB;
        message[5] = (byte) 0x4E;
        message[6] = (byte) 0x69;
        message[7] = (byte) 0x0D;

        /**
         * 8-11 最后一条记录的索引号 (=0表示没有记录)
         */
        message[8] = (byte) 0x00;
        message[9] = (byte) 0x00;
        message[10] = (byte) 0x00;
        message[11] = (byte) 0x00;

        /**
         * 记录类型
         * 0=无记录
         * 1=刷卡记录
         * 2=门磁,按钮, 设备启动, 远程开门记录
         * 3=报警记录
         */
        message[12] = (byte) 0x01;

        /**
         * 有效性(0 表示不通过, 1表示通过)
         */
        message[13] = (byte) 0x01;

        /**
         * 门号(1,2,3,4)
         */
        message[14] = (byte) 0x01;

        /**
         * 进门/出门(1表示进门, 2表示出门)
         */
        message[15] = (byte) 0x01;

        /**
         * 卡号(类型是刷卡记录时)
         * 或编号(其他类型记录)
         */
        message[16] = (byte) 0x00;
        message[17] = (byte) 0x00;
        message[18] = (byte) 0x00;
        message[19] = (byte) 0x00;
        /**
         * 20-26
         * 刷卡时间:
         * 年月日时分秒 (采用BCD码)见设置时间部分的说明
         * 2021.02.24 10:28:47
         */
        message[20] = (byte) 0x20;
        message[21] = (byte) 0x21;
        message[22] = (byte) 0x02;
        message[23] = (byte) 0x24;
        message[24] = (byte) 0x10;
        message[25] = (byte) 0x28;
        message[26] = (byte) 0x47;



        this.message = message;
    }

}
