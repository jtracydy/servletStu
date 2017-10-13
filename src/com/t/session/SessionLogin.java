package com.t.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userName = (String) session.getAttribute("username");
		if (("").equals(userName) || null == userName) {
			session.setAttribute("username", "lucas");
			session.setAttribute("password", "123");
			System.out.println(session.getId());
		}
		else{
			System.out.println("userName=" + session.getAttribute("username"));
			System.out.println("password="+session.getAttribute("password"));
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("调用 doPost()方法 ");
		doGet(req, res);
	}
}
