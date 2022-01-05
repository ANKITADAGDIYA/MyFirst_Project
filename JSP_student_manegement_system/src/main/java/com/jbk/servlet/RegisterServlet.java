package com.jbk.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.connection.DbConnection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String id=timestamp.replace(".", "");


		Connection connection = DbConnection.getConnection();

		try {
			String sql = "INSERT INTO student (id,username,password,email,phone) values(?,?,?,?,?)";
		PreparedStatement preparedStatement=	connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		preparedStatement.setString(2, username);
		preparedStatement.setString(3, password);
		preparedStatement.setString(4, email);
		preparedStatement.setString(5, phone);
		
	int rows=	preparedStatement.executeUpdate();

	if(rows>0) {
		request.setAttribute("msg", "Register Successfully Completed");
		RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}
	else {
		request.setAttribute("msg", "Registration Failed");
		RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);	}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
