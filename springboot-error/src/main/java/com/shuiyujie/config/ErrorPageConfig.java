package com.shuiyujie.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author shui
 * @create 2019-02-12
 **/
@Component
public class ErrorPageConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage[] errorPages = new ErrorPage[3];
        errorPages[0] = new ErrorPage(HttpStatus.NOT_FOUND, "/error-400.html");
        errorPages[1] = new ErrorPage(HttpStatus.NOT_FOUND, "/error-404.html");
        errorPages[2] = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-500.html");
        registry.addErrorPages(errorPages);
    }
}