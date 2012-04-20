package com.certicamara.certifactura.aplicacion;

import com.certicamara.certifactura.aplicacion.FacturaElectronica.ComandoCrearFacturaElectronica;



public class GestorComandos {
		
	public void recibirComando(Comando comando){
		
		if(comando instanceof ComandoCrearFacturaElectronica){
			comando.ejecutar();
		}
	}

}
