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

import ca.ottawaspoon.beans.IBean;
import ca.ottawaspoon.utils.DatabaseUtils;
import ca.ottawaspoon.utils.ServerUtils;

/**
 * Servlet implementation class IQueryServlet
 */
@WebServlet(urlPatterns = { "/iquery"})
public class IQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = ServerUtils.getStoredConnection(request);
		 
        String cat = (String) request.getParameter("id");
        
        String errorString = null;
        ArrayList<IBean> cats = null;
 
        cats = DatabaseUtils.iQuery(conn, cat);
        
        if (cats== null) {
        	errorString = "Something Went Wrong!";
        }
        
        
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null) {
            response.sendRedirect(request.getServletPath() + "/categories");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("cats", cats);
        
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/iQueryView.jsp");
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
