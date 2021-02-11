package com;

//package galaxia;
import java.sql.*;

import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
   private static Connection cnx = null;
   public static Connection obtener() throws SQLException, ClassNotFoundException {
      if (cnx == null) {
         try {
        	/* String instanceConnectionName = "galaxiarest:us-central1:galaxia";
        	 String databaseName = "galaxia";


        	 String IP_of_instance = "34.72.218.208";
        	 String username ="root";
        	 String password = "Misofsan18";

        	 String jdbcUrl = String.format(
        	     "jdbc:mysql://%s/%s?cloudSqlInstance=%s"
        	         + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
        	 IP_of_instance,
        	     databaseName,
        	     instanceConnectionName);

        	 Class.forName("com.mysql.cj.jdbc.Driver");
        	 cnx = DriverManager.getConnection(jdbcUrl, username, password);

        	 */
        	 Class.forName("com.mysql.cj.jdbc.Driver");	 
        // Class.forName("com.mysql.jdbc.GoogleDriver");
        
           cnx = DriverManager.getConnection("jdbc:mysql://34.72.218.208:3306/galaxia","root", "Misofsan18");
         } catch (SQLException ex) {
            throw new SQLException(ex);
         }
      }
      return cnx;
   }
   public static void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }
}