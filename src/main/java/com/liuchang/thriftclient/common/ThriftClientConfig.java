package com.liuchang.thriftclient.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:03 2020/2/14
 * @ Description：
 * @ Modified By：
 */
@Configuration
public class ThriftClientConfig {
    @Value("${thrift.server.host}")
    private String host;
    @Value("${thrift.server.port}")
    private int port;

    @Bean(initMethod = "init")
    public ThriftClient thriftClient() {
        ThriftClient thriftClient = new ThriftClient();
        thriftClient.setHost(host);
        thriftClient.setPort(port);
        return thriftClient;
    }
}
