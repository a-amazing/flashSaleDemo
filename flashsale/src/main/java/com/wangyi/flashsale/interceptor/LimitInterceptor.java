package com.wangyi.flashsale.interceptor;

import com.wangyi.flashsale.common.limiter.Limiter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangyi
 * @date 2020/04/07
 */
public class LimitInterceptor implements HandlerInterceptor {

    private Limiter limiter;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            return false;
        }
        HandlerMethod method = (HandlerMethod)handler;
        //由限流器判断是否可以进入方法
        return limiter.pass();
    }

    public Limiter getLimiter() {
        return limiter;
    }

    public void setLimiter(Limiter limiter) {
        this.limiter = limiter;
    }
}
