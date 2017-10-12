package com.t.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionReader extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		String sessionId = session.getId();
		System.out.println("sessionId:" + sessionId);
		session.setMaxInactiveInterval(1000 * 5);
		int time = session.getMaxInactiveInterval();
		System.out.println("time:" + time);
		session.setAttribute("sesionDemo", "sessionAttribute");
		String userName = (String) session.getAttribute("sesionDemo");
		System.out.println(userName);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("调用 doPost()方法 ");
		doGet(req, res);
	}
}
