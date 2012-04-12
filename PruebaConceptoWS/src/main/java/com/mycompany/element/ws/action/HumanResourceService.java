package com.mycompany.element.ws.action;

import java.util.Date;

/**
 * Firmas de negocio para el ejemplo de prueba 
 * @author jose
 *
 */
public interface HumanResourceService {

    
    /**
     * Se crea un registro de dia festivo para un empleado 
     * @param fechaInicio
     * @param fechaFin
     * @param nombre
     */
	public void bookHoliday(Date fechaInicio, Date fechaFin, String nombre);

}
