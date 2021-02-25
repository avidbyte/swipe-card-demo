package com.example.swipecard.entity;

import lombok.Data;

/**
 * 韦根板 短报文格式类型
 * @author aaron
 * @since 2021-02-24
 */
@Data
public class ResponseMsgType {


    /**
     * 控制器
     */
    public static final byte CONTROLLER = (byte)0x20;



    public static final byte REMOTE_OPEN_DOOR = (byte)0x40;

}
