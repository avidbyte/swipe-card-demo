package com.example.swipecard.util;


import com.example.swipecard.entity.RecordType;
import com.example.swipecard.entity.ResponseMsgType;

/**
 * @author aaron
 * @since 2021-01-28
 */
public class CardUtil {
    /**
     * 信息位 1代表成功
     */
    private static final byte dataStatus = 1;
    private static final byte zero = 0;

    public static boolean checkDoorSendStatus(byte[] arr) {
        byte msg = arr[72];
        return msg == dataStatus;
    }


    public static String getIcCardNumber(byte[] arr) {
        return "";
    }


    /**
     *  判断短报文是否是 查询控制器状态返回报文
     * @param arr 返回报文
     * @return boolean
     */
    public static boolean judgeController(byte[] arr){
        return ResponseMsgType.CONTROLLER==arr[1];
    }

    /**
     *  判断短报文是否是远程开门返回报文
     * @param arr 返回报文
     * @return boolean
     */
    public static boolean judgeRemoteOpenDoor(byte[] arr){
        return ResponseMsgType.REMOTE_OPEN_DOOR==arr[1];
    }


    /**
     * 查询控制器状态返回报文 判断记录类型
     *
     * @param arr 查询控制器状态返回报文
     * @return boolean
     */
    public static boolean judgeRecordType(byte[] arr) {
        return  RecordType.ONE ==arr[12];
    }
}
