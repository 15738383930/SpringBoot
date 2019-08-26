package com.example.demo.interceptor;

import com.example.demo.utils.CommUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 错误页面拦截器
 * @Author zhou
 * @Date 2019/8/14 11:34
 */
//@Component
public class ErrorPageInterceptor extends HandlerInterceptorAdapter {

    private List<Integer> errorCodeList = Arrays.asList(404, 403, 500, 501);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        if (errorCodeList.contains(response.getStatus())) {
            response.sendRedirect("/error" + CommUtil.Property.ERROR_PATH);
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
