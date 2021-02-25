package com.example.swipecard.service;

/**
 * IC卡权限验证
 *
 * @author aaron
 * @since 2021-02-23
 */
public interface CardValidationService {

    /**
     * 验证设备 对应的项目与人员对应的项目是否是同一个
     *
     * @param deviceIp     设备ip
     * @param icCardNumber ic卡号
     * @return boolean
     */
    boolean cardCheck(String deviceIp, String icCardNumber);




}
