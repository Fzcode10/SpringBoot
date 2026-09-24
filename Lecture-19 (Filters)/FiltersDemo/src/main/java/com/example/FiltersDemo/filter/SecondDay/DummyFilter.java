package com.example.FiltersDemo.filter.SecondDay;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class DummyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest =
                (HttpServletRequest) servletRequest;

        HttpServletResponse httpServletResponse =
                (HttpServletResponse) servletResponse;

        String uri = ((HttpServletRequest) servletRequest).getRequestURI();

//        if(!uri.startsWith("/api/")){
//            System.out.println("Path not start with /api/");
//            chain.doFilter(servletRequest, servletResponse);
//        }

        System.out.println("Dummy filer called");

        chain.doFilter(servletRequest, servletResponse);

    }
}
