package com.t.cookieAndSession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * username pwd
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("调用 doGet()方法 ");
		boolean b = judeCookieStatus(req);
		System.out.println("cookie中是否存在用户的信息:"+b);
		if(!b) {
			System.out.println("添加用户的信息到cookie中");
			Cookie cookieUser = new Cookie("username",req.getParameter("username"));
			Cookie cookiePwd = new Cookie("pwd",req.getParameter("pwd"));
			resp.addCookie(cookieUser);
			resp.addCookie(cookiePwd);
			System.out.println("添加用户的信息到cookie中已经完成");
		}
		
		HttpSession session = req.getSession(true);
		if (session == null) {
           System.out.println("session为空");
		}else {
			 System.out.println("session不为空");
		}
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("调用 doPost()方法 ");
		doGet(req, res);
	}

	private boolean judeCookieStatus(HttpServletRequest req) {
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		Cookie[] cookies = req.getCookies();

		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals(username) && cookies[i].getValue().equals(pwd)) {
				System.out.println("username:"+cookies[i].getName().equals(username) +"pwd:"+cookies[i].getValue().equals(pwd)+"......");
				return true;
			}
		}
		return false;
	}
}
