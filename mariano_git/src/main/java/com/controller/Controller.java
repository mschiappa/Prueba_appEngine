package com.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Conexion;
import com.GuardarDB;
import com.Lluvia;

@RestController
@RequestMapping("/")
public class Controller {
	@RequestMapping(value="obtenerclima", method=RequestMethod.GET)	
	public ResponseEntity<Object> obtenerClima(/*@PathParam("dia") Integer dia*/) throws SQLException {
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
                     String EstadoConsultado=guardarDB.consultarPronostico(con, 109);
		
		
		return new ResponseEntity<>(EstadoConsultado,  HttpStatus.OK);
	}
	
}
