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

import ca.ottawaspoon.beans.MBean;
import ca.ottawaspoon.beans.Restaurant;
import ca.ottawaspoon.utils.DatabaseUtils;
import ca.ottawaspoon.utils.ServerUtils;

/**
 * Servlet implementation class MQueryServlet
 */
@WebServlet(urlPatterns = { "/mquery"})
public class MQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = ServerUtils.getStoredConnection(request);
		 
        String name = (String) request.getParameter("id");
        
        String errorString = null;
        ArrayList<MBean> mbeans = null;
        Restaurant restaurant = null;
 
        try {
        	mbeans = DatabaseUtils.mQuery(conn, name);
        	restaurant = DatabaseUtils.getRestaurant(conn, name);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
     // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("restaurant", restaurant);
        request.setAttribute("mbeans", mbeans);
         
        // Forward to /WEB-INF/views/productListView.jsp
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/mQueryView.jsp");
	    dispatcher.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
