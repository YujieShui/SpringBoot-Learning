package com.shuiyujie.service.impl;

import com.shuiyujie.service.IMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shui
 * @create 2019-02-11
 **/
//@Service
public class IMessageServiceImpl implements IMessageService {
    @Override
    public String info() {
        return "imessageservice information";
    }
}
