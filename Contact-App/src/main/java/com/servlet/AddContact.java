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

@WebServlet("/addContact")
public class AddContact extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
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
			Contact contact = new Contact(name, email, phone, userId);
			ContactDao dao = new ContactDao(DatabaseConnect.getConnection());
			
			boolean f = dao.saveContact(contact);
			
			dispatcher = request.getRequestDispatcher("AddContact.jsp");
			if(f) {
				request.setAttribute("status", "save");
			}
			else {
				request.setAttribute("status", "failed");
			}
			
			dispatcher.forward(request, response);
		}
		
	}
}
