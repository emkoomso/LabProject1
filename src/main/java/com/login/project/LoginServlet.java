package com.login.project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home" })
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("uname");
		String password = req.getParameter("credentials");
		if ("ekoomson".equalsIgnoreCase(username) && "visa".equals(password)) {
			req.setAttribute("uname", username);
			Cookie objCookie = new Cookie("username_Cookie", username);
			objCookie.setPath("/LabProject1");
			objCookie.setSecure(true);
			objCookie.setMaxAge(300);
			resp.addCookie(objCookie);
			req.getRequestDispatcher("welcome.jsp").forward(req, resp);
		} else  {
			resp.sendRedirect("error.jsp");
			
		}

	}
}
