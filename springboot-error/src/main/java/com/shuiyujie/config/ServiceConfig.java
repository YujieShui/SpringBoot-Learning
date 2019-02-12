package com.shuiyujie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.shuiyujie.service.impl.IMessageServiceImpl;

/**
 * @author shui
 * @create 2019-02-11
 **/
@Configuration    // 此处为配置项
public class ServiceConfig {
    @Bean(name = "configService")       // 此处返回的是一个Spring的配置Bean，与xml的“<bean>”等价
    public IMessageServiceImpl getMessageService() {    // 方法名称随便写
        return new IMessageServiceImpl();
    }
}
