package com.example.FiltersDemo.filter.SecondDay;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

//@Component
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest =
                (HttpServletRequest) servletRequest;

        HttpServletResponse httpServletResponse =
                (HttpServletResponse) servletResponse;


//        String token = httpServletRequest.getHeader("token");

        System.out.println(httpServletRequest.getHeader("token"));
        System.out.println(httpServletRequest.getHeader("X-api-key"));
        System.out.println(httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getMethod());
//        System.out.println(httpServletRequest.getInputStream());
//        System.out.println(httpServletRequest.getReader());

        BufferedReader reader =
                httpServletRequest.getReader();

        StringBuilder body = new StringBuilder();
        String line = reader.readLine();

        while( line != null){
            body.append(line);
            line = reader.readLine();
        }

        System.out.println(body);

        chain.doFilter(servletRequest, servletResponse);

    }
}
