package ca.ottawaspoon.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ca.ottawaspoon.beans.HBean;
import ca.ottawaspoon.beans.Rater;
import ca.ottawaspoon.utils.DatabaseUtils;
import ca.ottawaspoon.utils.ServerUtils;

/**
 * Servlet implementation class HQueryServlet
 */
@WebServlet(urlPatterns = { "/hquery"})
public class HQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = ServerUtils.getStoredConnection(request);
        String id = (String) request.getParameter("id");
        
        String errorString = null;
		ArrayList <HBean> hBeans = null;
		Rater user = null;
		
		try {
			hBeans = DatabaseUtils.HQuery(conn, id);
			user = DatabaseUtils.findUser(conn, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		if (hBeans == null || user == null) {
			response.sendRedirect(request.getServletPath() + "/home");
			return;
		} else {
			
			// If no error.
	        // The product does not exist to edit.
	 
	        // Store errorString in request attribute, before forward to views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("user", user);
	        request.setAttribute("hBeans", hBeans);
	        
	        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/hQueryView.jsp");
	        dispatcher.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
