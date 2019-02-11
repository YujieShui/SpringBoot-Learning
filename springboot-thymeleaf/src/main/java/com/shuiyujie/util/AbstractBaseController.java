package com.shuiyujie.util;


import org.springframework.context.MessageSource;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * @author shui
 * @create 2019-02-11
 **/
public abstract class AbstractBaseController {


    @Resource
    /**
     * 自动注入配置文件 MessageSource 对象
     */
    private MessageSource messageSource;

    public String getMessage(String key, String... args) {
        return this.messageSource.getMessage(key, args, Locale.getDefault());
    }
}