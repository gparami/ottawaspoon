package ca.ottawaspoon.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ca.ottawaspoon.beans.*;

/**
 * This class uses SQL queries and return java elements.
 * @author Parami
 *
 */
public class DatabaseUtils {

	/**
	 * This method is to find the user by username and password.
	 * @param conn Connection to the database.
	 * @param userName User entered Username.
	 * @param password User entered password.
	 * @return Rater object with user if exists, otherwise null.
	 * @throws SQLException If database errors exist.
	 */
	public static Rater findUser(Connection conn, String userName, String password) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " //
                + " where a.User_Name = ? and a.password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String gender = rs.getString("Gender");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(gender);
            return user;
        }
        return null;
    }
	
}
