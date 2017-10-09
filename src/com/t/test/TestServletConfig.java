package com.t.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletConfig extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public TestServletConfig() {
		System.out.println("调用 构造方法 ");
	}

	public void init() throws ServletException {
		System.out.println("调用 init()方法 ");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String userName = config.getInitParameter("userName");
		System.out.println(userName);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("调用 doGet()方法 ");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("调用 doPost()方法 ");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("调用 service()方法 ");
		super.service(req, res);
	}

	public void destroy() {
		System.out.println("调用 destroy()方法 ");
		super.destroy();
	}
}
