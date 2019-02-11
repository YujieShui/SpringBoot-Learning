package com.shuiyujie.controller;

import com.shuiyujie.util.AbstractBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author shui
 * @create 2019-02-11
 **/
@Controller
public class MessageController extends AbstractBaseController {

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(String mid, Model model) {
        // request属性传递包装
        model.addAttribute("url", "www.shuiyujie.com");
        // request属性传递包装
        model.addAttribute("mid", mid);
        // 此处只返回一个路径， 该路径没有设置后缀，后缀默认是*.html
        return "message/message_show";
    }
}
