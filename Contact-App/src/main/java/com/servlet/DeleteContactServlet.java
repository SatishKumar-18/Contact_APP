package com.servlet;

import java.io.IOException;

import com.connection.DatabaseConnect;
import com.dao.ContactDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteContactServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		RequestDispatcher dispatcher = null;
		
		ContactDao dao = new ContactDao(DatabaseConnect.getConnection());
		
		boolean f = dao.deleteContact(cid);
		
		dispatcher = request.getRequestDispatcher("ViewContact.jsp");
		if(f) {
			request.setAttribute("status", "delete");
		}
		else {
			request.setAttribute("status", "failed");
		}
		
		dispatcher.forward(request, response);
	}
}
