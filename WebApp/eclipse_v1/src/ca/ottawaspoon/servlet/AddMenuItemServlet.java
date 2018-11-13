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

import ca.ottawaspoon.beans.MenuItem;
import ca.ottawaspoon.beans.Restaurant;
import ca.ottawaspoon.utils.DatabaseUtils;
import ca.ottawaspoon.utils.ServerUtils;

/**
 * Servlet implementation class AddMenuItemServlet
 */
@WebServlet(urlPatterns = { "/addmenuitem"})
public class AddMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMenuItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ServerUtils.getStoredConnection(request);
		 
        String strID = (String) request.getParameter("rid");
        
        int rid = 0;
        try {
            rid = Integer.parseInt(strID);
        } catch (Exception e) {
        }
 
        Restaurant restaurant = null;
        String errorString = null;
 
        try {
        	restaurant = DatabaseUtils.getRestaurant(conn, rid);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null || restaurant == null) {
            response.sendRedirect(request.getServletPath() + "/restaurants");
            return;
        }
 
        System.out.println("===================================> " + restaurant.getRestaurantID());
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("restaurant", restaurant);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/newMenuItemView.jsp");
        dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = ServerUtils.getStoredConnection(request);

		String strrID = (String) request.getParameter("rid");
		String striID = (String) request.getParameter("iid");
        String name = (String) request.getParameter("name");
        String description = (String) request.getParameter("description");
        String strPrice = (String) request.getParameter("price");
        String type = (String) request.getParameter("type");
        String category = (String) request.getParameter("category");
        
        int iid = 0;
        int price = 0;
        int rid = 0;
        
        try {
            iid = Integer.parseInt(striID);
            rid = Integer.parseInt(strrID);
            price = Integer.parseInt(strPrice);
        } catch (Exception e) {
        }
        
        MenuItem menuitem = new MenuItem(iid,name,type,category,description,price,rid);
 
        Restaurant restaurant = null;
        String errorString = null;
 
//        if (striID == null || strrID == null || name == null || description == null || type == null || strPrice == null || category == null) {
//        	errorString = "strrID is:" + strrID;
////        	errorString = "Required fields missing!";
//        }
//        
        if (strrID == null) {
        	errorString = "Restaurant ID not found!";
        }
 
        if (errorString == null) {
            try {
            	restaurant = DatabaseUtils.getRestaurant(conn, rid);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        if (errorString == null) {
            try {
                DatabaseUtils.addMenuItem(conn, menuitem);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
        
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("menuitem", menuitem);
        request.setAttribute("restaurant", restaurant);
        
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/newMenuItemView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/restaurant?id=" + rid);
        }
	}

}
