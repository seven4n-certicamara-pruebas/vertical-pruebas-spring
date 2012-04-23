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


jQuery(document).ready(function() {
	alert("jQuery");

});

</script>