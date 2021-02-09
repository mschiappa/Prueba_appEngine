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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Usuario
 */
public class Lluvia {
    
   
    
    
    
    public ConocerLluvia Lluvia(int cantDiasT) throws SQLException{
      
      int t0;
      int cantDias= cantDiasT, cantLluvia=0,diaMayorLluvia=0;
      int distB=2000,distF=500,distV=1000;
      double coordXB=0, coordYB = 0,coordXV=0, coordYV = 0,coordXF=0, coordYF = 0,distTotal2=0;
      ConocerLluvia PeriodoLluvia= new ConocerLluvia();
   
    
      int i;
      int PB,PF,PV=0,P3P=0;
     
      
      for(i=1; i<=cantDias;i++){
          
        PB=360-(i*3);
        PF=360-(i*1);
        PV=i*5;
        P3P=P3P-PV;
     
         
       //calculo coordenadas planeta Betasoides
       coordYB=  (Math.round(distB*Math.sin(Math.toRadians(PB))*10.0)/10.0);
       coordXB=  (Math.round(distB*Math.cos(Math.toRadians(PB))*10.0)/10.0);

       //calculo de coordenadas planeta Vulcano
       coordYV=  Math.round(distV*Math.sin(Math.toRadians(PV)*10.0)/10.0);
       coordXV=  (Math.round(distV*Math.cos(Math.toRadians(PV))*10.0)/10.0);
     
       //calculo de coordenadas planeta Ferengis 
       coordYF=  (Math.round(distF*Math.sin(Math.toRadians(PF))*10.0)/10.0);
       coordXF=  (Math.round(distF*Math.cos(Math.toRadians(PF))*10.0)/10.0);
        
    
       double a1,b1;
       a1=(((0*coordXV)+(0*coordYV))-((coordXB*coordXV)*(coordYB*coordYV)))/((coordXF*coordXV)+(coordYF*coordYV));
       b1=(((0*coordXV)+(0*coordYF))-((coordXB*coordXF)*(coordYB*coordYF)))/((coordXF*coordXV)+(coordYF*coordYV));
       
             
             Conexion conexion =new Conexion();
           Connection con = null;
            try {
                con = conexion.obtener();
            } catch (SQLException ex) {
                Logger.getLogger(Lluvia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Lluvia.class.getName()).log(Level.SEVERE, null, ex);
            }
                         GuardarDB guardarDB=new GuardarDB();

       //calculo de vectores paralelos
    if(a1>0 & b1>0){
       cantLluvia=cantLluvia+1;
       //Math.
           try {
                guardarDB.guardarPronostico(con, i, "Lluvia");
            } catch (SQLException ex) {
                Logger.getLogger(Lluvia.class.getName()).log(Level.SEVERE, null, ex);
            }
    }   
    
       double dist1,dist2,dist3,distTotal;
    
       dist1=Math.sqrt(Math.pow((coordXB-coordXV),2)+Math.pow((coordYB-coordYV),2));
       dist2=Math.sqrt(Math.pow((coordXB-coordXF),2)+Math.pow((coordYB-coordYF),2));
       dist3=Math.sqrt(Math.pow((coordXV-coordXF),2)+Math.pow((coordYV-coordYF),2));
       distTotal=dist1+dist2+dist3;
         
         
       if(distTotal>distTotal2){
             distTotal2=distTotal;
             diaMayorLluvia=i;
             PeriodoLluvia.setDiaLluvia( diaMayorLluvia);
       
             
           
            
       }
        
             
          PeriodoLluvia.setLluvia(cantLluvia);
         
      
         
        
    }
       Conexion conexion =new Conexion();
           Connection con = null;
            try {
                con = conexion.obtener();
            } catch (SQLException ex) {
                Logger.getLogger(Lluvia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Lluvia.class.getName()).log(Level.SEVERE, null, ex);
            }
       GuardarDB guardarDB=new GuardarDB();
       guardarDB.actualizarPronostico(con, diaMayorLluvia, "Pico maximo de lluvia");
       return PeriodoLluvia;
    }
}
     
    

