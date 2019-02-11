package com.shuiyujie.controller;

import com.shuiyujie.service.IMessageService;
import com.shuiyujie.service.impl.IMessageServiceImpl;
import com.shuiyujie.util.AbstractBaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shui
 * @create 2019-02-11
 **/
@RestController
public class MessageController extends AbstractBaseController {

    @Resource
    private IMessageService messageService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return messageService.info();
    }

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String echo(String mid) {
        System.out.println("【*** 访问地址 ***】" + super.getMessage("member.add.action"));
        return super.getMessage("welcome.msg", mid);
    }
}
