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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		String password = request.getParameter("confirmPassword");
		
		RequestDispatcher dispatcher = null;
		
		
		
		if(name == null || name == "") {
			request.setAttribute("status", "invalidName");
			dispatcher = request.getRequestDispatcher("Register.jsp");
			dispatcher.forward(request, response);
		}
		else if(email == null || email == "") {
			request.setAttribute("status", "invalidEmail");
			dispatcher = request.getRequestDispatcher("Register.jsp");
			dispatcher.forward(request, response);
		}
		else if(!pwd.equals(password)) {
			request.setAttribute("status", "noMatch");
			dispatcher = request.getRequestDispatcher("Register.jsp");
			dispatcher.forward(request, response);
		}
		else {
			User u = new User(name, email, password);
			
			UserDao dao = new UserDao(DatabaseConnect.getConnection());
			boolean f = dao.userRegister(u);
			
			dispatcher = request.getRequestDispatcher("Register.jsp");
			if(f) {
				request.setAttribute("status", "success");
			}
			
			dispatcher.forward(request, response);
		}
		
	}
}
