package com.certicamara.certifactura.dto;


/**
 * CertiFactura
 * Certicámara S.A.
 * FacturaElectronicaParticularDTO
 * @author Seven4N Ltda.
 * Apr 30, 2012
 */
public class FacturaElectronicaParticularDTO
{
	
	private String atributo;
	
	private Object valor;

	public String getAtributo( )
	{
		return atributo;
	}

	public void setAtributo( String atributo )
	{
		this.atributo = atributo;
	}

	public Object getValor( )
	{
		return valor;
	}

	public void setValor( Object valor )
	{
		this.valor = valor;
	}
	

}
