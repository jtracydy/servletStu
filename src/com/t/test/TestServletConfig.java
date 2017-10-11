package com.t.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
		// super.init(config);
		String userName = config.getInitParameter("userName");
		System.out.println(userName);
		System.out.println("调用 init()方法带参数的方法 ");

		/**
		 * 获取web.xml中配置的参数
		 */
		System.out.println("获取web.xml中配置的参数....");
		ServletContext context = config.getServletContext();
		String nameA = context.getInitParameter("A");
		System.out.println("nameA:" + nameA);
		String nameB = context.getInitParameter("A");
		System.out.println("nameB:" + nameB);
		/**
		 * 获取properties文件内容
		 */
		System.out.println("获取properties文件内容....");
		try {
			URL url = context.getResource("/WEB-INF/config/jdbc.properties");// 得到URL
			InputStream in_url = url.openStream();// 直接得到流
			// getProperties(in_url);// 获取资源文件
			/**
			 * 读取配置文件是通过流
			 */
			getProperties(context.getResourceAsStream("/WEB-INF/config/jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

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

	private void getProperties(InputStream in) throws IOException {
		Properties props = new Properties();
		props.load(in);

		String url = props.getProperty("url");
		System.out.println("url:" + url);
		String username = props.getProperty("username");
		System.out.println("username:" + username);
		String pwd = props.getProperty("password");
		System.out.println("pwd:" + pwd);
	}
}
