package ottawaspoon;

import java.sql.*;

public class OttawaSpoon {

	public static void main(String[] args) {
		System.out.println("You suck!!! Thank you.");
		try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgres://tpjdrpaw:ojYNNlKphTrospph3Evc9gS4OMv9N9RZ@stampy.db.elephantsql.com:5432/tpjdrpaw";
            String userid = "tpjdrpaw";
            String password = "ojYNNlKphTrospph3Evc9gS4OMv9N9RZ";
            Connection db = DriverManager.getConnection(url, userid, password);
            Statement st = db.createStatement();
            st.close();
        } catch (Exception e){System.out.println("Error - erorr@!!!!2211!@!@!@!!"); System.out.println(e);}
		
	}
}
