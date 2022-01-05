package com.jbk.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.connection.DbConnection;

@WebServlet("/deleteServlet")
public class DeleteServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		Connection connection = DbConnection.getConnection();

		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id=?");
			preparedStatement.setString(1, id);

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {

				RequestDispatcher rd = request.getRequestDispatcher("listOfStudent");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("listOfStudent");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
