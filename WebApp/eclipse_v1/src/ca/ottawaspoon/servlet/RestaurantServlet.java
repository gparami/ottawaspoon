package ca.ottawaspoon.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import ca.ottawaspoon.beans.Restaurant;
import ca.ottawaspoon.utils.*;

/**
 * Servlet implementation class RestaurantServlet
 */
@WebServlet(urlPatterns = { "/restaurant" })
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ServerUtils.getStoredConnection(request);
		 
        String strID = (String) request.getParameter("id");
        
        int id = 0;
        try {
            id = Integer.parseInt(strID);
        } catch (Exception e) {
        }
 
        Restaurant restaurant = null;
        String errorString = null;
 
        try {
        	restaurant = DatabaseUtils.getRestaurant(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null && restaurant == null) {
            response.sendRedirect(request.getServletPath() + "/restaurants");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("restaurant", restaurant);
 
        //test sop remove later
        System.out.println("=======================================>" + restaurant.getName());
        
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/restaurantView.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ServerUtils.getStoredConnection(request);
		
		
		String strID = (String) request.getParameter("id");
        String name = (String) request.getParameter("name");
        String type = (String) request.getParameter("type");
        String url = (String) request.getParameter("url");
        int id = 0;
        try {
            id = Integer.parseInt(strID);
        } catch (Exception e) {
        }
        Restaurant restaurant = new Restaurant(id, name, type, url);
        String errorString = null;
 
        //TODO change this
        try {
            DatabaseUtils.getRestaurant(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("restaurant", restaurant);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/restaurantView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/restaurant");
        }
	}

}
