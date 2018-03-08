# ottawaspoon
Urbanspoon for the city of Ottawa.

## jdbc code
```
public static void  main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection db = DriverManager.getConnection("jdbc:postgres://tpjdrpaw:ojYNNlKphTrospph3Evc9gS4OMv9N9RZ@stampy.db.elephantsql.com:5432/tpjdrpaw", "tpjdrpaw", "ojYNNlKphTrospph3Evc9gS4OMv9N9RZ");
            Statement st = db.createStatement();
            st.close();
        } catch (Exception e){}
```