package ca.ottawaspoon.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.ottawaspoon.beans.Rater;
import ca.ottawaspoon.utils.DatabaseUtils;
import ca.ottawaspoon.utils.ServerUtils;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet(urlPatterns = { "/signup"})
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        String email = request.getParameter("email");
		String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        Date join_date = new Date(System.currentTimeMillis());
        int reputation = 5;
 
        Rater user = null;
        boolean hasError = false;
        String errorString = null;
 
        if (userName == null || password == null || userName.length() == 0 || password.length() == 0 || name.length() == 0 || email.length() == 0 || type == "Type") {
            hasError = true;
            errorString = "All Fields are Required!";
        } else {
            Connection conn = ServerUtils.getStoredConnection(request);
            try {
                // Find the user in the DB.
                user = DatabaseUtils.findUser(conn, userName, password);
 
                if (user != null) {
                    hasError = true;
                    errorString = "Username already in use!";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        // If error, forward to /WEB-INF/views/login.jsp
        if (hasError) {
            user = new Rater();
            user.setUserName(userName);
            user.setPassword(password);
            user.setName(name);
            user.setEmail(email);
            user.setType(type);
 
            // Store information in request attribute, before forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
 
            // Forward to /WEB-INF/views/signupView.jsp
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
            dispatcher.forward(request, response);
        }
        
        // If no error create new user, login, and redirect to userInfo page.
        else {
        	Connection conn = ServerUtils.getStoredConnection(request);
        	Rater newRater = new Rater();
        	newRater.setUserName(userName);
        	newRater.setPassword(password);
        	newRater.setEmail(email);
        	newRater.setName(name);
        	newRater.setJoin_date(join_date);
        	newRater.setType(type);
        	newRater.setReputation(reputation);
        	
        	try {
                // Find the user in the DB.
        		DatabaseUtils.addRater(conn, newRater);
        		errorString = "Username Added!";
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        	
        	// Store information in request attribute, before forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", newRater);
            
            // Forward to /WEB-INF/views/signupView.jsp
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
            dispatcher.forward(request, response);
        }
	}

}
