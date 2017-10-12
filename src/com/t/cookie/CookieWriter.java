package com.t.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author dan.wang
 */
public class CookieWriter extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/**
		 * 创建session
		 */
		Cookie accountCookie = new Cookie("account", "account---lucasCookieGoogle");// 中文需要编码
		accountCookie.setMaxAge(0);

		// 把加密结果保存到Cookie中 并控制有效期
		Cookie ssidCookie = new Cookie("ssid", "ssid---lucasCookieGoogle");
		ssidCookie.setMaxAge(Integer.MAX_VALUE);

		res.addCookie(accountCookie);// 账户Cookie
		res.addCookie(ssidCookie);// 加密后账户的Cookie
		System.out.println(accountCookie.getName() + "++++++++" + accountCookie.getValue());
		System.out.println(ssidCookie.getName() + "+++++++" + ssidCookie.getValue());
		System.out.println("调用 doGet()方法 ");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("调用 doPost()方法 ");
		doGet(req, res);
	}
}
