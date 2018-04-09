package ca.ottawaspoon.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.ottawaspoon.utils.*;

/**
 * Servlet implementation class DeleteRestaurantServlet
 */
@WebServlet("/deleterestaurant")
public class DeleteRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRestaurantServlet() {
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
 
        String errorString = null;
 
        try {
            DatabaseUtils.deleteRestaurant(conn, id);
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
            response.sendRedirect(request.getContextPath() + "/resturants");
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
