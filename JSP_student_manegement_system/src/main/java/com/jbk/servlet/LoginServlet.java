package com.jbk.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.connection.DbConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get data
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println(username + "..." + password);
//process data
		try {
		 Connection connection=	DbConnection.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM student WHERE username=? and password=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()) {
			//nevigate 
		HttpSession session=	request.getSession();
		session.setAttribute("username", username);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("msg", "Invalid Credientials");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
