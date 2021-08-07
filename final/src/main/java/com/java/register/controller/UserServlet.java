package com.java.register.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.register.dao.UserDao;
import com.java.register.model.User;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
       
	private UserDao userDao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/userRegister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String regDate = request.getParameter("regDate");
		
		User user = new User();
		
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		user.setAddress(address);
		user.setRegDate(regDate);
		
		try {
			userDao.registerUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		response.sendRedirect("");
		
	}

}
