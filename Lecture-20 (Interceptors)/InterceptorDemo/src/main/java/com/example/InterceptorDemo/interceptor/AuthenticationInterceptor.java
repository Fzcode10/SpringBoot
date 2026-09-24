package com.example.InterceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        String secret = request.getHeader("secret");

        if(secret == null || !secret.equals("fzad")){
            System.out.println("Authentication Failed!");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setContentType("application/json");
            response.getWriter().write(
                    "\n" +
                            "{\n" +
                            "\t\"message\" : \"Sorry Authentication failed\"\n" +
                            "}"
            );
            return false;
        }

        return true;  // True if you have to go next otherwise back
    }
}
