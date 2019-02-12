package com.shuiyujie.controller;

import com.shuiyujie.VO.Member;
import com.shuiyujie.util.AbstractBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Iterator;

/**
 * @author shui
 * @create 2019-02-11
 **/
@Controller
public class MessageController extends AbstractBaseController {

    /**
     * 路由到表单页面
     *
     * @return
     */
    @RequestMapping(value = "/addPre", method = RequestMethod.GET)
    public String addPre() {
        return "member_add";
    }

    /**
     * 演示表单提交时产生的数据校验错误
     *
     * @param vo
     * @param result
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(@Valid Member vo, BindingResult result) {
        if (result.hasErrors()) {
            Iterator<ObjectError> iterator = result.getAllErrors().iterator();
            while (iterator.hasNext()) {
                ObjectError error = iterator.next();
                System.out.println("【错误信息】code = " + error.getCode() + "，message = " + error.getDefaultMessage());
            }
            return result.getAllErrors();
        } else {
            return vo;
        }
    }

    /**
     * 演示 500 错误
     *
     * @return
     */
    @RequestMapping(value="/get")
    @ResponseBody
    public String get() {
        System.out.println("除法计算：" + (10 / 0));
        return "hello world" ;
    }
}
