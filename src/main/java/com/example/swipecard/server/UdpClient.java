package com.example.swipecard.server;


import lombok.extern.slf4j.Slf4j;
import com.example.swipecard.util.HexConvert;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * @author aaron
 * @since 2021-01-27
 */
@Slf4j
public class UdpClient {

    public static void send(String ip, int port, byte[] content) {
        try {
            DatagramSocket socket = new DatagramSocket(8082);
            SocketAddress socketAddress = new InetSocketAddress(ip, port);
            //参数1.数据 2.数据长度
            DatagramPacket packet = new DatagramPacket(content, content.length, socketAddress);
            String str = HexConvert.BinaryToHexString(content);
            log.info("目标IP:" + ip + ",目标端口:" + port + ",发送的报文:" + str);
            socket.send(packet);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
