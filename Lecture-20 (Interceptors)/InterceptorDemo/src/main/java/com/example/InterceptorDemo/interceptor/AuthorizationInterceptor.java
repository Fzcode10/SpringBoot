package com.example.InterceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        String secret = request.getHeader("x-user-role");

        if(secret == null || !secret.equals("admin")){
            System.out.println("Unauthorized");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.getWriter().write(
                    "\n" +
                            "{\n" +
                            "\t\"message\" : \"You are not authorized to perform this work\"\n" +
                            "}"
            );
            return false;
        }

        return true;  // True if you have to go next otherwise back
    }
}
