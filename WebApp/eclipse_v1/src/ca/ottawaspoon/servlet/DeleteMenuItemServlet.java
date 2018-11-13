package ca.ottawaspoon.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.ottawaspoon.beans.Restaurant;
import ca.ottawaspoon.utils.DatabaseUtils;
import ca.ottawaspoon.utils.ServerUtils;

/**
 * Servlet implementation class DeleteMenuItemServlet
 */
@WebServlet(urlPatterns = { "/deletemenuitem"})
public class DeleteMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMenuItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ServerUtils.getStoredConnection(request);
		 
		String striID = (String) request.getParameter("iid");
		String strrID = (String) request.getParameter("rid");
        
		int iid = 0;
        int rid = 0;
        
        try {
            iid = Integer.parseInt(striID);
            rid = Integer.parseInt(strrID);
        } catch (Exception e) {
        }
 
        String errorString = null;
        Restaurant restaurant = null;
 
        try {
        	restaurant = DatabaseUtils.getRestaurant(conn, rid);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
        
        try {
            DatabaseUtils.deleteMenuItem(conn, iid);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
         
        // If has an error, redirected to the error page.
        if (errorString != null) {
            // Shorten the error string
        	errorString = errorString.substring(0, Math.min(errorString.length(), 25));
        	response.getOutputStream().println("<script type=\"text/javascript\"> swal({type:\"warning\",title:\"Oops...\",text:\"Something went wrong!\",footer:\"<a href>" + errorString + "...</a>\"}); </script>");
        }
        
        // If everything nice.
        // Redirect to the product listing page.        
        else {
            response.sendRedirect(request.getContextPath() + "/restaurant?id=" + restaurant.getRestaurantID());
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
