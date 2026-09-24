package com.example.InterceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                            HttpServletResponse response,
                            Object handler){

//        if(handler instanceof HandlerMethod handlerMethod){
//            String controllerName  = handlerMethod.getBeanType().getName();
//            String methodName = handlerMethod.getMethod().getName();
//
//            System.out.println("Pre handle call");
//            System.out.println("Controller name"+controllerName);
//            System.out.println("Method name : "+methodName);
//        }


        System.out.println("Token : "+request.getHeader("token"));
        System.out.println("Method : "+request.getMethod());
        System.out.println("Query String : "+request.getQueryString());
        System.out.println("IP Address : "+request.getRemoteAddr());
        System.out.println("URI : "+request.getRequestURI());
//        System.out.println("Secret : "+request.getHeader("secret"));
//        System.out.println("x-user-role : "+request.getHeader("x-user-role"));

        if(handler instanceof HandlerMethod handlerMethod){
            System.out.println("Controller : "+ handlerMethod.getBeanType().getName());
            System.out.println("Controller Method : "+handlerMethod.getMethod().getName());
        }

        return true;  // True if you have to go next otherwise back
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView){
        System.out.println("Post handle call");


    }



    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex){
        System.out.println("After Completion called");

        if(ex != null){
            System.out.println(ex.getMessage());
        }
    }

}
