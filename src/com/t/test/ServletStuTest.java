package com.t.test;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletStuTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletStuTest() {
		System.out.println("调用 构造方法 ");

	}

	public void destroy() {
		System.out.println("调用 destroy()方法 ");
		super.destroy();

	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("调用 doGet()方法 ");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("调用 doPost()方法 ");
	}

	public void init() throws ServletException {
		System.out.println("调用 init()方法 ");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("调用 Http  service()方法 ");
		super.service(req, resp);

	}

	// 只有以get方式调用该servlet的时候才会调用getLastModified
	// 返回-1 表示永远是最近的，不使用缓存
	@Override
	protected long getLastModified(HttpServletRequest req) {
		System.out.println("调用 getLastModified()方法 ");
		return super.getLastModified(req);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("调用 service()方法 ");
		super.service(req, res);
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("调用 preDestroy()方法 ");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("调用 postConstruct()方法");
	}
}