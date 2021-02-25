package com.example.swipecard.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaron
 * @since 2021-02-25
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties("udp")
public class UdpConfig {

    private int port;

    private int maxUdpDataSize;
}
