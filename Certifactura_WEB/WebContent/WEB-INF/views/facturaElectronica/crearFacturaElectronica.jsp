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


<!--  CONTENEDOR DE ERRORES -->
 <div class="oculto" id="nameErrors">
       <ul id="moreErrors">
       </ul>
 </div>



<form id="facturaElectronicaDominio" action="${contextPath}/factura/electronica/crear" method="post">
	<fieldset>
		<ol>
			<li>
				<strong id="idConsecutivo-form-crearfactura"><em>*</em> <fmt:message key="crearfacturaElectronica.formulario.idConsecutivo"/></strong>
	 			<div>
	 			<label>
	 				<!--<a href="#" class="masInformacion" title='<liferay-ui:message key="crearProblematica.tooltip.titulo"/>'><liferay-ui:message key="mas.informacion.simbolo"/></a>-->
	 				<input name="consecutivoIdentificador" id="idConsecutivo" type="text" maxlength="20" />
	 			</label>
	 			</div> 
 			</li>
 			
			<li>
				<strong id="fecha-form-crearfactura"><em>*</em> <fmt:message key="crearfacturaElectronica.formulario.fecha"/></strong>
	 			<div>
	 			<label>
	 				<!--<a href="#" class="masInformacion" title='<liferay-ui:message key="crearProblematica.tooltip.titulo"/>'><liferay-ui:message key="mas.informacion.simbolo"/></a>-->
	 				<input name="fecha" id="fechaFactura" class="datepick" type="text" maxlength="20" />
	 			</label>
	 			</div> 
 			</li>
 			
			<li>
				<strong id="idEmisor-form-crearfactura"><em>*</em> <fmt:message key="crearfacturaElectronica.formulario.idEmisor"/></strong>
	 			<div>
	 			<label>
	 				<!--<a href="#" class="masInformacion" title='<liferay-ui:message key="crearProblematica.tooltip.titulo"/>'><liferay-ui:message key="mas.informacion.simbolo"/></a>-->
	 				<input name="identificacionEmisor" id="idEmisor" type="text" maxlength="20" />
	 			</label>
	 			</div> 
 			</li>
 			
			<li>
				<strong id="idReceptor-form-crearfactura"><em>*</em> <fmt:message key="crearfacturaElectronica.formulario.idReceptor"/></strong>
	 			<div>
	 			<label>
	 				<!--<a href="#" class="masInformacion" title='<liferay-ui:message key="crearProblematica.tooltip.titulo"/>'><liferay-ui:message key="mas.informacion.simbolo"/></a>-->
	 				<input name="identificacionReceptor" id="idReceptor" type="text" maxlength="20" />
	 			</label>
	 			</div> 
 			</li>			
 			
 		</ol>
 			
		<!--  BOTON DE ENVIAR PROBLEMATICA -->
	    <strong>&nbsp;</strong>
	    <div id="enviar">
		<input type="submit" id="publicar-tag-problematica" name="publicar-tag-problematica" class="botonEnviar"
			   			value="<fmt:message key="crearfacturaElectronica.formulario.boton.crearFactura"/>" />
	    </div>
	    
	</fieldset>
</form>

<script type="text/javascript">

var certifactura = null;
jQuery(document).ready(function() {
	crearDatePicker();
	certifactura = new Certifactura();	
	validate('<fmt:message key="erros-one-problematica"/>', '<fmt:message key="erros-more-part1-problematica"/>', '<fmt:message key="erros-more-part2-problematica"/>');
	
	
	
	
	

});


//Validador de campos en el formulario crearProblematica
function validate(msj1, msj2, msj3){	
	var container = jQuery('#nameErrors');
	var subContainer = jQuery('#moreErrors');
	var claseError = "error";
	var claseErrorCampos = "errorCampos";
	var claseOculto = "oculto";
	var validator = jQuery('#facturaElectronicaDominio').validate({		
		 rules: {
			 consecutivoIdentificador:{
				 required:true
				 /*maxlength: 2*/
			}
			,			 
			fecha:{
			 	required: true
		 		/*minlength: 2,
		 		maxlength: 256,
		 		SpecialCharsValidatorTitles:true*/
		 	}
			,
			identificacionEmisor:{
			 	required: true
		 		/*minlength: 2,
		 		maxlength: 4000*/
		  	}
			,
			identificacionReceptor:  {
				required:true
				/*
		 		required: function(element) {
		 			var documentTypeSelected = jQuery("input:checked[name=<portlet:namespace />fechaLimiteCheckbox]").val();
		 			return (documentTypeSelected == 'on');
		 		},
		 		date: true*/
		 	}			
		 },
		 messages: {
			consecutivoIdentificador: '' ,
			fecha: '',
			identificacionEmisor: '',
			identificacionReceptor: ''
		 },
		 highlight: function(element, errorClass) {
		     	jQuery( element ).addClass( claseErrorCampos );
		  },
		unhighlight: function(element, errorClass) {
				     jQuery( element ).removeClass( claseErrorCampos );
		},  
	 	invalidHandler: function(e, validator) {
	 		/*jQuery.unblockUI();
	 		jQuery.fn.MultiFile.reEnableEmpty();
				var errors = validator.numberOfInvalids();
				if (errors) {
					var message = errors == 1
						? msj1
						: msj2 +" "+ errors + " "+ msj3;
					subContainer.html('<li>'+message+'</li>');
					container.addClass(claseError);
					container.removeClass(claseOculto);
				} else {
					container.removeClass(claseError);
					container.addClass(claseOculto);
				}*/
			},
		 errorClass: "errorOculto",
//		 errorElement: "div",
		 errorLabelContainer: '#moreErrors',
		 errorContainer: '#nameErrors'
		});
}





//Crea el objeto datePicker al cargar la pagina
function crearDatePicker(){
	
	jQuery.datepicker.setDefaults({dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
		dayNames: ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado'],
		monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre']});
	jQuery('#fechaFactura').datepicker( "option", "dateFormat", 'yy-mm-dd');
	jQuery('#fechaFactura').datepicker({
			onSelect: function(dateText, inst) { 
				validarFecha();
			}
	});
}



//Validador de la fecha limite de publicación
function validarFecha(){
	var fecha = jQuery('#fechaFactura').val();
	var fechaActual = "${fechaActual}";	
	if(fecha < fechaActual && fecha != ''){
		certifactura.mostrarMensaje("La fecha seleccionada es menor a la fecha actual");
		//alert("La fecha seleccionada es menor a la fecha actual");
		jQuery('#fechaFactura').val('');
		return false;
	}
}

</script>