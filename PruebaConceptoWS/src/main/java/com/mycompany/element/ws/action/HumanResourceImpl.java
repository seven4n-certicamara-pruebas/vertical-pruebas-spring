package com.mycompany.element.ws.action;

import java.util.Date;

public class HumanResourceImpl implements HumanResourceService {

	@Override
	public void bookHoliday(Date fechaInicio, Date fechaFin, String nombre) {
		System.out.println(fechaInicio);
		System.out.println(fechaFin);
		System.out.println(nombre);
	}

}
