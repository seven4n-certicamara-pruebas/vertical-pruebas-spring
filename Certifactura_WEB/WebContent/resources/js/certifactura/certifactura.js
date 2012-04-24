function Certifactura(){
	/**
	 * Muestra un mensaje al usuario mediante blockui o alert dependiendo de la compatibilidad del usuario. 
	 */
	this.mostrarMensaje = function(mensaje){
		if(jQuery.blockUI){
			jQuery.blockUI({
				message: mensaje,
				css: { 
					border:'none', padding:'15px', size:'12.0pt',
					backgroundColor:'#05d', color:'#fff',
					opacity:'.8','-webkit-border-radius': '10px','-moz-border-radius': '10px'
				}
			});
			window.setTimeout(jQuery.unblockUI, 2000);
		}else
			alert(mensaje);
	};
	
	
	this.mostrarMensajeCallBack = function(idComponente){
		jQuery("#"+idComponente ).dialog({
			modal: true,
			buttons: {
				Aceptar: function() {
					jQuery( this ).dialog( "close" );
				}
			}
		});
	};
	
	this.getMensajeEstado = function(estadoSys){
		if(estadoSys=="activo")
			return "Activa";
		if(estadoSys=="inactivo")
			return "Inactiva";
		if(estadoSys=="enProcesoDeSolucion")
			return "En proceso de solución";
		if(estadoSys=="Solucionado")
			return "Solucionada";
		if(estadoSys=="consideradoEnSolucion")
			return "Considerada en solucion";
	};
	
	/**
	 * Verifica si un campo NO se encuentra nulo, vacio o sólo con espacios en blanco. 
	 */
	this.validarNoNulo = function(valor){
		if( valor == null || valor.length == 0 || /^\s+$/.test(valor) ) {
			  return false;
		}
		return true;
	};
	
	/**
	 * Verifica si un campo SI se encuentra nulo, vacio o sólo con espacios en blanco. 
	 */
	this.validarNulo = function(valor){
		if( valor == null || valor.length == 0 || /^\s+$/.test(valor) ) {
			  return true;
		}
		return false;
	};
	
	this.show_msg_box = function(nombreClass) {
		jQuery('.'+nombreClass).focus(function (){
			jQuery(this).parents('ol li').find('.msgBox').css({visibility: "visible",display: "block"}).fadeIn("slow");
		}).blur(function(){  
			jQuery(this).parents('ol li').find('.msgBox').css({visibility: "hidden"});
			jQuery(this).parents('ol li').find('.msgBox').toggle("400");
		});
	};
	
	this.paginador = function( desde, hasta, resultadosTotales, campoOrdenamiento, portletns, funcionBusqueda, idPaginador, resultadosPorPagina){
		var _funcionBusqueda = "buscar";
		var _resultadosPorPagina = 10;
		var _idPaginador = "paginador";
		
		if(this.validarNoNulo(funcionBusqueda))
			_funcionBusqueda = funcionBusqueda;
		if(this.validarNoNulo(idPaginador))
			_idPaginador = idPaginador;
		if(this.validarNoNulo(resultadosPorPagina))
			_resultadosPorPagina = resultadosPorPagina;
		
			
		var paginadorHTML = "";
		if (resultadosTotales > _resultadosPorPagina){
			
			var mod = Math.floor(resultadosTotales % _resultadosPorPagina);
			var div = Math.floor(resultadosTotales / _resultadosPorPagina);

			var paginaActual =  Math.floor((desde / _resultadosPorPagina) + 1);
			var numTotalPaginas = (mod != 0) ? div+1 : div;
			
			// Paginas Primera y Anterior
			if (paginaActual > 1 ) {
				paginadorHTML += "<span>&nbsp;<a href=\"javascript:"+_funcionBusqueda+"("+portletns+", '"+campoOrdenamiento+"', 1)\" >&nbsp;Primera</a>&nbsp;</span>" +
					 "<span>&nbsp;<a href=\"javascript:"+_funcionBusqueda+"("+portletns+", '"+campoOrdenamiento+"', " + (paginaActual-1) + ")\" >&nbsp;« Anterior</a>&nbsp;</span>";
			} else {
				paginadorHTML += "<span>&nbsp;Primera&nbsp;</span>" +
			 "<span>&nbsp;« Anterior&nbsp;</span>";
			}
			
			// Paginas intermedias 
			
			var limitePaginas = 10;
			var paginasValidas = 8;
			var cotaInferior = paginaActual;
			var cotaSuperior = numTotalPaginas;
			var suspensivosInicial = false;
			var suspensivosFinal = false;
			var suspensivosAmbos = false;
			var suspensivosAmbosRestante = false;
			
			// Si el numero de paginas totales a visualizar excede la cota máxina de paginación, se hace necesario simplificar (uso de puntos suspensivos)
			// el listado.
			if (numTotalPaginas > limitePaginas){
			
				cotaSuperior = paginaActual + paginasValidas;
				
				if (cotaInferior + paginasValidas > numTotalPaginas)
					cotaInferior = numTotalPaginas - paginasValidas;
				
				if (cotaSuperior > numTotalPaginas)
					cotaSuperior = numTotalPaginas;
				
				// Caso en donde sólo se requiere puntos suspensivos al principio de la lista
				if (paginaActual > 1 && cotaSuperior >= numTotalPaginas)
					suspensivosInicial = true;
				
				// Caso en donde sólo se requiere puntos suspensivos al final de la lista
				if (paginaActual == 1 && cotaSuperior <= numTotalPaginas)
					suspensivosFinal = true;
						
				// Caso en donde sólo se requiere puntos suspensivos tanto al principio como al final de la lista
				if (paginaActual > 1 && cotaSuperior < numTotalPaginas) {
					suspensivosAmbos = true;
					cotaSuperior--;
				}
			} else{
					cotaInferior = 1;
			} 
		
			if (suspensivosInicial) {
				paginadorHTML += "<span>&nbsp;...&nbsp;</span>";
				suspensivosInicial = false;
			}
				
			if (suspensivosAmbos){
				paginadorHTML += "<span>&nbsp;...&nbsp;</span>";
				suspensivosAmbos = false;
				suspensivosAmbosRestante = true;
			}
		
			for (i=cotaInferior; i <= cotaSuperior; i++){
			
				if (paginaActual == i ) {	
					paginadorHTML += "<span>&nbsp;"+ i +"&nbsp;</span>";
				} else {
					paginadorHTML += "<span>&nbsp;<a href=\"javascript:"+_funcionBusqueda+"("+portletns+", '"+campoOrdenamiento+"', " + i + ")\" >"+ i +"</a>&nbsp;</span>";
				}
			}

			if (suspensivosAmbosRestante){
				paginadorHTML += "<span>&nbsp;...&nbsp;</span>";
			}
			
			if (suspensivosFinal){
				paginadorHTML += "<span>&nbsp;...&nbsp;</span>";
			}

			// Paginas Siguiente y Última
			if (paginaActual < numTotalPaginas ) {
				
				paginadorHTML += "<span>&nbsp;<a href=\"javascript:"+_funcionBusqueda+"("+portletns+", '"+campoOrdenamiento+"', " + (paginaActual+1) + ")\" >Siguiente »</a>&nbsp;</span>" +
			 					 "<span>&nbsp;<a href=\"javascript:"+_funcionBusqueda+"("+portletns+", '"+campoOrdenamiento+"', " + numTotalPaginas + ")\" >Última</a>&nbsp;</span>";
			} else {
				paginadorHTML += "<span>&nbsp;Siguiente »&nbsp;</span>" + "<span>&nbsp;Última&nbsp;</span>";
			}
		}

		jQuery('#'+_idPaginador).html(paginadorHTML);
	};
}