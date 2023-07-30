package com.servlet;

import java.io.IOException;

import com.connection.DatabaseConnect;
import com.dao.UserDao;
import com.entity.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		RequestDispatcher dispatcher= null;
		HttpSession session = null;
		
		if(email == null || email == "") {
			request.setAttribute("status", "invalid");
			dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}
		else if(password == null || password == "") {
			request.setAttribute("status", "invalid");
			dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}
		else {
			UserDao dao = new UserDao(DatabaseConnect.getConnection());
			User user = dao.loginUser(email, password);
			
			
			session = request.getSession();
			if(user != null) {
				session.setAttribute("email", user.getEmail());
				session.setAttribute("id", user.getId());
				response.sendRedirect("AddContact.jsp");
			}
			else {
				request.setAttribute("status", "invalid");
				dispatcher = request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
