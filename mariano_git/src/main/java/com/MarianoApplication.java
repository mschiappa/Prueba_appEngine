package com;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class MarianoApplication {

	public static void main(String[] args) throws SQLException {
		 int diasSequia;
	        Planetas Vulcano = new Planetas (-5,1000, "Vulcano");
	        Planetas Ferengis  = new Planetas (1,500, "Ferengis");
	        Planetas Betasoides = new Planetas (3,1000, "Betasoides");
	        Conexion conexion =new Conexion();
	           Connection con = null;
	            try {
	                con = conexion.obtener();
	            } catch (SQLException ex) {
	               
	            } catch (ClassNotFoundException ex) {
	               
	            }
	         GuardarDB guardarDB=new GuardarDB();
	        guardarDB.consultarPronostico(con, 109);
	      /*  guardarDB.limpiarPronostico(con);
	          guardarDB.completarPronostico(con);
	        //calculo de Sequia
	        Alineacion sequia = new Alineacion ();
	        sequia.Alineacion(2);
	        Scanner sna = new Scanner(System.in);
	            System.out.println("Por favor escriba la cantidad de dias del periodo a evaluar");
	          int cantDiasT= Integer.parseInt((sna.next()));
	              
	        diasSequia=sequia.Sequia(cantDiasT);
	        System.out.println("Se pronostica "+ diasSequia +" días de sequia en el periodo evaluado" + " en el periodo evaluado de "
	        + cantDiasT+ " días.");
	        
	//calculo de lluvia
	        int CantLluvia;
	        
	 
	         Lluvia lluvia = new Lluvia ();
	      //  lluvia.Lluvia(cantDiasT);
	        ConocerLluvia infoLLuvia= new ConocerLluvia();
	        infoLLuvia=lluvia.Lluvia(cantDiasT);
	        System.out.println("Se pronostica que lloverá "+ infoLLuvia.cantLluvia+ " "
	                + "días en el periodo y el día con el pico de intensidad será "+ infoLLuvia.diaLLuvia+ " en el periodo evaluado de "
	        + cantDiasT+ " días.");
	        
	        
	        //calculo de presion y temperatura
	          int PresionYTemp;
	 
	         PresionTemperatura PresyT = new PresionTemperatura();
	       // lluvia.Lluvia(cantDiasT);
	      //  ConocerLluvia infoLLuvia= new ConocerLluvia();
	        PresionYTemp=PresyT.presionTemperatura(cantDiasT);
	        System.out.println("Se pronostica existiran "+ PresionYTemp+ " "
	                + "periodos de optima temperatura y presion .");*/
	
	        SpringApplication.run(MarianoApplication.class, args);
	}
	    
		
	}


