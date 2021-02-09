/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;
import java.lang.Math;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Alineacion {
    
    public void Alineacion(int CantDias){
    int t0;
    int cantDias=4000;
  int i;
  int P1,P2,P3,P3P;

  
  
 
}
     public int Sequia(int cantDiasT){
      int t0;
      int cantDias=cantDiasT, cantSequia=0;
      int distB=2000,distF=500,distV=1000;
      double coordXB=0, coordYB = 0,coordXV=0, coordYV = 0,coordXF=0, coordYF = 0;
      
      int i;
      int PB,PF,PV,P3P;
      int  anga=0;
       Conexion conexion =new Conexion();
           Connection con = null;
            try {
                con = conexion.obtener();
            } catch (SQLException ex) {
                Logger.getLogger(Lluvia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Lluvia.class.getName()).log(Level.SEVERE, null, ex);
            }
      
      for(i=1; i<=cantDias;i++){
        PB=360-(i*3);
        PF=360-(i*1);
        PV=i*-5;
        P3P=360+PV;
      //calculo coordenadas planeta Betasoides
        if(PB<=90){
        anga=90-(i*3);
        coordYB=  (Math.round(distB*Math.sin(Math.toRadians(PB))*10.0)/10.0);
        coordXB=  (Math.round(distB*Math.cos(Math.toRadians(PB))*10.0)/10.0);
      }else if(PB>=90 & PB<180){
        anga=90-(PB);
        coordYB=  (Math.round(distB*Math.sin(Math.toRadians(PB))*10.0)/10.0);
        coordXB=  (Math.round(distB*Math.cos(Math.toRadians(PB))*10.0)/00.0);
          
      }else if(PB>=180 & PB<270){
        anga=90-PB;
        coordYB=  (Math.round(distB*Math.sin(Math.toRadians(PB))*10.0)/10.0);
        coordXB=  (Math.round(distB*Math.cos(Math.toRadians(PB))*10.0)/10.0);
      
      }else if(PB>=270 & PB<360){
        anga=90-PB;
        coordYB=  (Math.round(distB*Math.sin(Math.toRadians(PB))* 10.0)/ 10.0);
        coordXB=  (Math.round(distB*Math.cos(Math.toRadians(PB))* 10.0)/ 10.0);
          
      }
      //calculo de coordenadas planeta Vulcano
       if(PV<=90){
        anga=90-PV;
        coordYV=  Math.round(distV*Math.sin(Math.toRadians(PV)* 10.0)/ 10.0);
        coordXV=  (Math.round(distV*Math.cos(Math.toRadians(PV))* 10.0)/ 10.0);
      }else if(PV>=90 & PV<180){
        anga=90-PB;
        coordYV=  (Math.round(distV*Math.sin(Math.toRadians(PV))* 10.0)/ 10.0);
        coordXV=  (Math.round(distV*Math.cos(Math.toRadians(PV))* 10.0)/ 10.0);
          
      }else if(PV>=180 & PV<270){
        anga=90-PB;
        coordYV=  (Math.round(distV*Math.sin(Math.toRadians(PV))* 10.0)/ 10.0);
        coordXV=  (Math.round(distV*Math.cos(Math.toRadians(PV))* 10.0)/ 10.0);
      
      }else if(PB>=270 & PB<360){
        anga=90-PB;
        coordYV=  (Math.round(distV*Math.sin(Math.toRadians(PV))* 10.0)/ 10.0);
        coordXV=  (Math.round(distV*Math.cos(Math.toRadians(PV))* 10.0)/ 10.0);
          
      }
       //calculo de coordenadas planeta Ferengis 
       
       if(PF<=90){
        anga=90-PF;
        coordYF=  (Math.round(distF*Math.sin(Math.toRadians(PF))* 10.0)/ 10.0);
        coordXF=  (Math.round(distF*Math.cos(Math.toRadians(PF))* 10.0)/ 10.0);
        
      }else if(PB>90 & PB<=180){
        anga=90-PB;
        coordYF=  (Math.round(distF*Math.sin(Math.toRadians(PF))* 10.0)/ 10.0);
        coordXF=  (Math.round(distF*Math.cos(Math.toRadians(PF))* 10.0)/ 10.0);
          
      }else if(PB>180 & PB<=270){
        anga=90-PB;
        coordYF=  (Math.round(distF*Math.sin(Math.toRadians(PF))* 10.0)/ 10.0);
        coordXF=  (Math.round(distF*Math.cos(Math.toRadians(PF))* 10.0)/ 10.0);
      
      }else if(PB>270 & PB<=360){
        anga=90-PB;
        coordYF=  (Math.round(distF*Math.sin(Math.toRadians(PF))* 10.0)/ 10.0);
        coordXF=  (Math.round(distF*Math.cos(Math.toRadians(PF))* 10.0)/ 10.0);
          
      }
       double prueba1=Math.round((coordXV-coordXF)/(coordXB-coordXV)* 10.0)/ 10.0;
       double prueba2=Math.round((coordYV-coordYF)/(coordYB-coordYV)* 10.0)/ 10.0;
       
       
             
            
                         GuardarDB guardarDB=new GuardarDB();
       //calculo de vectores paralelos
    if(prueba1==prueba2){
       cantSequia=cantSequia+1;
       //Math.
        try {
                guardarDB.guardarPronostico(con, i, "Sequia");
            } catch (SQLException ex) {
                Logger.getLogger(Lluvia.class.getName()).log(Level.SEVERE, null, ex);
            }
    }   
       
     
      }
               

         return cantSequia;
    }
     
}