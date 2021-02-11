/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Usuario
 */
public class GuardarDB {
    
    
     public void limpiarPronostico(Connection conexion ) throws SQLException{
      try{
        // PreparedStatement consulta;
        Statement st = conexion.createStatement();
        String sql ="DELETE FROM galaxia.PRONOSTICO";
           // st = conexion.prepareStatement("INSERT INTO galaxia.PRONOSTICOS" + "(id_dia, estado) VALUES("+dia+","+estado+")");
         /*   st.setInt(1,dia);
         
            st.setString(2, estado);*/
           
         st.executeUpdate(sql);

      }catch(SQLException ex){
         throw new SQLException(ex);
      }
     }
     public void guardarPronostico(Connection conexion, int dia , String estado ) throws SQLException{
      try{
        // PreparedStatement consulta;
        Statement st = conexion.createStatement();
       // String sql ="INSERT INTO galaxia.PRONOSTICO" + "(id_dia, estado) VALUES("+dia+","+"'"+estado+"'"+")";
            String sql ="UPDATE  galaxia.PRONOSTICO SET estado="+"'"+estado+"'"+ "where id_dia="+dia;
           // st = conexion.prepareStatement("INSERT INTO galaxia.PRONOSTICOS" + "(id_dia, estado) VALUES("+dia+","+estado+")");
         /*   st.setInt(1,dia);
         
            st.setString(2, estado);*/
           
         st.executeUpdate(sql);

      }catch(SQLException ex){
         throw new SQLException(ex);
      }
     }
      public void actualizarPronostico(Connection conexion, int dia , String estado ) throws SQLException{
      try{
        // PreparedStatement consulta;
        Statement st = conexion.createStatement();
        String sql ="UPDATE  galaxia.PRONOSTICO SET estado="+"'"+estado+"'"+ "where id_dia="+dia;
           // st = conexion.prepareStatement("INSERT INTO galaxia.PRONOSTICOS" + "(id_dia, estado) VALUES("+dia+","+estado+")");
         /*   st.setInt(1,dia);
         
            st.setString(2, estado);*/
           
         st.executeUpdate(sql);

      }catch(SQLException ex){
         throw new SQLException(ex);
      }
     }
        public String consultarPronostico(Connection conexion, int dia  ) throws SQLException{
      try{
        // PreparedStatement consulta;
          Statement st = conexion.createStatement();
          String sql = "SELECT estado FROM galaxia.PRONOSTICO " + "WHERE id_dia=" + dia;
         
     
           
          String resultado="";
          ResultSet rs = st.executeQuery(sql);
          while(rs.next()) {
         resultado= rs.getString("estado");
          }
          return resultado;
      }catch(SQLException ex){
         throw new SQLException(ex);
      
   }
    
    
}
              public void completarPronostico(Connection conexion  ) throws SQLException{
      try{
        // PreparedStatement consulta;
        Statement st = conexion.createStatement();
        int i=1;
        int cantDias=3670;
        for(i=1; i<=cantDias;i++){
            
        String sql ="INSERT INTO galaxia.PRONOSTICO (ID_DIA,ESTADO) VALUES("+i+",'NORMAL')";
           // st = conexion.prepareStatement("INSERT INTO MSCHIAPPA.PRONOSTICOS" + "(id_dia, estado) VALUES("+dia+","+estado+")");
         /*   st.setInt(1,dia);
         
            st.setString(2, estado);*/
           
         st.executeUpdate(sql);
        }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
     }

}
