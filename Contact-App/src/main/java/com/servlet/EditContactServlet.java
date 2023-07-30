package com.servlet;

import java.io.IOException;

import com.connection.DatabaseConnect;
import com.dao.ContactDao;
import com.entity.Contact;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class EditContactServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cid = Integer.parseInt(request.getParameter("cid"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		
		RequestDispatcher dispatcher = null;
		
		if(name == null || name == "") {
			request.setAttribute("status", "Empty");
			dispatcher = request.getRequestDispatcher("AddContact.jsp");
			dispatcher.forward(request, response);
		}
		else if(phone == null || phone == "") {
			request.setAttribute("status", "EmptyPhone");
			dispatcher = request.getRequestDispatcher("AddContact.jsp");
			dispatcher.forward(request, response);
		}
		else if((phone.length()>10 || phone.length()<10)) {
			request.setAttribute("status", "Invalid");
			dispatcher = request.getRequestDispatcher("AddContact.jsp");
			dispatcher.forward(request, response);
		}
		else {
			Contact c = new Contact();
			c.setId(cid);
			c.setName(name);
			c.setEmail(email);
			c.setPhone(phone);
			
			ContactDao dao = new ContactDao(DatabaseConnect.getConnection());
			
			boolean f = dao.updateContact(c);
			
			dispatcher = request.getRequestDispatcher("EditContact.jsp");
			if(f) {
				request.setAttribute("status", "update");
			}
			else {
				request.setAttribute("status", "failed");
			}
			
			dispatcher.forward(request, response);
		}
	}
}
