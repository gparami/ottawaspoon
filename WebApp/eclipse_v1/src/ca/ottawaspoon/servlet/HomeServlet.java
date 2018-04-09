package ca.ottawaspoon.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.ottawaspoon.utils.DatabaseUtils;
import ca.ottawaspoon.utils.ServerUtils;
import ca.ottawaspoon.beans.Restaurant;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(urlPatterns = { "/home"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = ServerUtils.getStoredConnection(request);
		
		ArrayList<String> restaurantNames = null;
		String errorString = null;
		
		try {
            // Find the user in the DB.
			restaurantNames = DatabaseUtils.getRestaurantNames(conn);

            if (restaurantNames == null) {
                errorString = "Database Connection Issues!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
		
		if (errorString != null || restaurantNames == null) {
			boolean hasNames = false;
			request.setAttribute("hasNames", hasNames);
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
            dispatcher.forward(request, response);
		} else {
			request.setAttribute("restaurantNames", restaurantNames);
			// Forward to /WEB-INF/views/homeView.jsp	
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
		    dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String restaurantName = request.getParameter("restaurantName");
		
		String errorString = null;
		Restaurant restaurant = null;
		Connection conn = ServerUtils.getStoredConnection(request);
		
		try {
            // Find the user in the DB.
			restaurant= DatabaseUtils.getRestaurant(conn, restaurantName);

            if (restaurant == null) {
                errorString = "Restaurant name not found!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
		
		if (errorString != null || restaurant == null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
            dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/restaurant?id=" + restaurant.getRestaurantID());
		}
	}

}
