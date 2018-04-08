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
		 
        String code = (String) request.getParameter("id");
 
        Restaurant restaurant = null;
        String errorString = null;
 
        try {
            product = DBUtils.findProduct(conn, code);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null && product == null) {
            response.sendRedirect(request.getServletPath() + "/productList");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
 
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
        dispatcher.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
