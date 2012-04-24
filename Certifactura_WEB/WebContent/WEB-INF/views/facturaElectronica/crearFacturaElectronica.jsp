<%
/**
 * CertiFactura
 * Certicámara S.A.
 * NotaDebitoElectronicaDominio
 * @author Seven4N Ltda.
 * Apr 23, 2012
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="../init.jsp" 
%>
<form id="facturaElectronicaDominio" action="${contextPath}/factura/electronica/crear" method="post">

	<input name="idConsecutivo" id="idConsecutivo" type="text" maxlength="20" />
	
	<input name="fecha" id="fecha" type="text" maxlength="20" />
	
	<input name="idEmisor" id="idEmisor" type="text" maxlength="20" />
	
	<input name="idReceptor" id="idReceptor" type="text" maxlength="20" />
	
	<input name="estado" id="estado" type="text" maxlength="20" />

 	
  	<input type="submit" id="publicar-tag-problematica" name="publicar-tag-problematica"
  		   value="<fmt:message key="button.crear"/>" />
 	

</form>

<script type="text/javascript">

var certifactura = null;
jQuery(document).ready(function() {
	crearDatePicker();
	certifactura = new Certifactura();

});



//Crea el objeto datePicker al cargar la pagina
function crearDatePicker(){
	
	jQuery.datepicker.setDefaults({dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
		dayNames: ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado'],
		monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre']});
	jQuery('#fecha').datepicker( "option", "dateFormat", 'yy-mm-dd');
	jQuery('#fecha').datepicker({
			onSelect: function(dateText, inst) { 
				validarFecha();
			}
	});
}



//Validador de la fecha limite de publicación
function validarFecha(){
	var fecha = jQuery('#fecha').val();
	var fechaActual = "${fechaActual}";	
	if(fecha < fechaActual && fecha != ''){
		certifactura.mostrarMensaje("La fecha seleccionada es menor a la fecha actual");
		//alert("La fecha seleccionada es menor a la fecha actual");
		jQuery('#fecha').val('');
		return false;
	}
}

</script>