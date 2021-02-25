package com.example.swipecard.server;



import com.example.swipecard.config.UdpConfig;
import com.example.swipecard.entity.DoorSendMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.example.swipecard.service.CardValidationService;
import com.example.swipecard.util.CardUtil;
import com.example.swipecard.util.HexConvert;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author aaron
 * @since 2021-01-28
 */

@Slf4j
@WebListener
public class UdpListener implements ServletContextListener {

    private UdpConfig udpConfig;

    @Resource
    private CardValidationService cardValidationService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UdpConfig udpConfig = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(UdpConfig.class);
        this.udpConfig=udpConfig;
        CardValidationService cardValidationService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(CardValidationService.class);
        this.cardValidationService=cardValidationService;
        try {
            executeUdpMsg();
        } catch (SocketException e) {
            log.error(e.getMessage());
        }
    }

    private void executeUdpMsg() throws SocketException {
        log.info("========>监听UDP数据包，监听端口 {} <======== ", udpConfig.getPort());
        int port = udpConfig.getPort();
        //创建服务器端DatagramSocket，指定端口
        DatagramSocket socket = new DatagramSocket(port);
        log.info("=======创建数据报，用于接收客户端发送的数据======");
        int a = 0;
        while (true) {
            byte[] buffer = new byte[udpConfig.getMaxUdpDataSize()];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                log.info("=======端口 {} 等待接收消息 ======", udpConfig.getPort());
                socket.receive(packet);
                // 接收到的UDP信息，然后解码
                buffer = packet.getData();
                InetAddress address = packet.getAddress();
                String targetIp = address.getHostAddress();
                int targetPort = packet.getPort();
                log.info("=========接收到来自" + targetIp + ":" + targetPort + "的消息:" + HexConvert.BinaryToHexString(buffer));
                if (CardUtil.judgeController(buffer)) {
                    if (CardUtil.judgeRecordType(buffer)) {
                        UdpClient.send(targetIp, targetPort, new DoorSendMsg().getMessage());
                    }
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("========> 关闭监听UDP数据包，监听端口 {} <======== ", udpConfig.getPort());
    }

}
