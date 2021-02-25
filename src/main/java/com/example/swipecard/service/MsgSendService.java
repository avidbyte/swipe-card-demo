package com.example.swipecard.service;

import com.example.swipecard.config.UdpConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author aaron
 * @since 2021-02-25
 */
@Service
public class MsgSendService {

    @Resource
    private UdpConfig udpConfig;

    InetAddress inetAddress = InetAddress.getLocalHost();

    public MsgSendService() throws UnknownHostException {
    }


}
