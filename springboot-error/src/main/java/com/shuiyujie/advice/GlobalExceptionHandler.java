package com.shuiyujie.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shui
 * @create 2019-02-12
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 定义错误显示页，error.html
    public static final String DEFAULT_ERROR_VIEW = "error";

    // 所有的异常都是Exception子类
    @ExceptionHandler(Exception.class)
    public Object defaultErrorHandler(HttpServletRequest request, Exception e) {
        class ErrorInfo {
            private Integer code;
            private String message;
            private String url;

            public Integer getCode() {
                return code;
            }

            public void setCode(Integer code) {
                this.code = code;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
        ErrorInfo info = new ErrorInfo();
        // 标记一个错误信息类型
        info.setCode(100);
        info.setMessage(e.getMessage());
        info.setUrl(request.getRequestURL().toString());
        return info;
    }
//	public ModelAndView defaultErrorHandler(HttpServletRequest request,
//			Exception e) { // 出现异常之后会跳转到此方法
//		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW); // 设置跳转路径
//		mav.addObject("exception", e); // 将异常对象传递过去
//		mav.addObject("url", request.getRequestURL()); // 获得请求的路径
//		return mav;
//	}
}