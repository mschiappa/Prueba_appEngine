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
        	 Class.forName("com.mysql.cj.jdbc.Driver");
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