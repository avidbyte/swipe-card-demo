package com.example.swipecard.entity;

import lombok.Data;

/**
 * 报文
 *
 * @author aaron
 * @since 2021-01-28
 */
@Data
public class DoorSendMsg {
    /**
     * 报文数据
     */
    private byte[] message;

    public DoorSendMsg() {
        /**
         * 构造初始开门报文数据
         */
        byte[] message = new byte[1024];
        message[0] = (byte) 0x17;
        message[1] = (byte) 0x40;
        message[2] = (byte) 0x00;
        message[3] = (byte) 0x00;
        message[4] = (byte) 0xBB;
        message[5] = (byte) 0x4E;
        message[6] = (byte) 0x69;
        message[7] = (byte) 0x0D;
        message[8] = (byte) 0x01;
        this.message = message;
    }
}
