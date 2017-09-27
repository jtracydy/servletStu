package com.t.test;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestServlet implements Servlet {

	public TestServlet() {
		System.out.println("TestServlet");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet初始化");
		String useName1 = config.getInitParameter("TestServlet");
		// String userName2 =
		// getServletConfig().getInitParameter("LifeCycleServlet");
		System.out.println("TestServlet+" + useName1);
		// System.out.println("LifeCycleServlet+" + userName2);

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}