package com.shuiyujie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shui
 * @create 2019-02-11
 **/
@SpringBootApplication    // 启动SpringBoot程序，而后自带子包扫描
public class StartSpringBootMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(StartSpringBootMain.class, args);
    }
}
