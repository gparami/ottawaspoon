# ottawaspoon

A Java web application that works as Urbanspoon for the city of Ottawa with added machine learning features. 

## Getting Started

The peoject was developed in [Eclipse IDE for Java EE Developers](https://eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygen3) environment using an [Apache Tomcat 9.x](https://tomcat.apache.org/download-90.cgi) server and [PostgreSQL](https://www.postgresql.org/) as the database of the project. We recommend you use the same environment for running on your local machine for development or testing purposes.

## Built With

- [Eclipse IDE for Java EE Developers](https://eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygen3) - The development environment
- [Apache Tomcat 9.x](https://tomcat.apache.org/download-90.cgi) - The server server
- [PostgreSQL](https://www.postgresql.org/) - The database management system
- `javax.servlet.jsp.jstl-1.2.5-b03` -  Java Servlet and JavaServer Pages library
- `taglibs-standard-impl-1.2.5` - Tag Libraries for use with Java Server Pages (JSPs)
- `taglibs-standard-jstlel-1.2.5` - Tag Libraries for use with Java Server Pages (JSPs)
- `taglibs-standard-spec-1.2.5` - Tag Libraries for use with Java Server Pages (JSPs)
- `postgresql-42.2.1` - JDBC driver for postgreSQL
- `jython-standalone-2.7.0` - Jython library to run python on Java platform

## Authors

* **Parami Gunasekara** - [@paramigunasekara](https://github.com/paramigunasekara)
* **Artem Tarasov** - [@artemtar](https://github.com/artemtar)
* **Aleksandr Shumarov** - [@Aleks048](https://github.com/Aleks048)

## Screenshots

* Home View
![home view](https://github.com/paramigunasekara/ottawaspoon/raw/master/screens/home.png)

* Restaurant View
![restaurant view](https://github.com/paramigunasekara/ottawaspoon/raw/master/screens/restaurant.png)

* Login View
![login view](https://github.com/paramigunasekara/ottawaspoon/raw/master/screens/login.png)

## jdbc code
```
public static void  main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=ottawaspoon", "postgres", "postgres");
            Statement st = db.createStatement();
            st.close();
        } catch (Exception e){}
```