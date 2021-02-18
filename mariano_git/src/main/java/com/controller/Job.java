package com.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Alineacion;
import com.Conexion;
import com.ConocerLluvia;
import com.GuardarDB;
import com.Lluvia;
import com.Planetas;
import com.PresionTemperatura;
@RestController
@RequestMapping("/")


public class Job {

	@RequestMapping(value="calcularPronostico", method=RequestMethod.GET)	
		
			public  ResponseEntity<Object> calcularPronostico(@PathParam("dia") Integer dia) throws SQLException {
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
	       guardarDB.limpiarPronostico(con);
	          guardarDB.completarPronostico(con);
	        //calculo de Sequia
	        Alineacion sequia = new Alineacion ();
	        sequia.Alineacion(2);
	        Scanner sna = new Scanner(System.in);
	  //          System.out.println("Por favor escriba la cantidad de dias del periodo a evaluar");
	          int cantDiasT= 3670; 
	              
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
	                + "periodos de optima temperatura y presion .");
				Integer diaConsultado=dia;
				
				//return new ResponseEntity<>(EstadoConsultado,  HttpStatus.OK);
	        return new ResponseEntity<>("OK",  HttpStatus.OK);
	}
			
		
		// TODO Auto-generated method stub

	}


