package com.t.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * MyFilter.java
 * 
 * @title 过滤器
 * @description
 * @author SAM-SHO
 * @Date 2014-9-25
 */
public class MyFilter1 implements Filter {


	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;

		String contextPath = request.getContextPath();// 上下文路径
		String servletPath = request.getServletPath();// 得到访问的servlet或者jsp的路径
//
//		System.out.println("上下文路径:" + contextPath);
//		System.out.println("访问的servlet或者jsp的路径 ： " + servletPath);
		
		System.out.println("MyFilter1 pre.............");
		chain.doFilter(req, resp);
		System.out.println("MyFilter1 after.............");
	}

	public void init(FilterConfig filterConfig) throws ServletException {

		String name = filterConfig.getInitParameter("name");
		System.out.println("获取过滤器的初始化参数： " + name);
	}

}