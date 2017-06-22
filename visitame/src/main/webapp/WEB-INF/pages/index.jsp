<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes">

    <title>visitame</title>
    <meta name="description" content="App de Visitas BBVA">

    <base id = "baseUrl" href="<%=request.getContextPath()%>/">
    
    <base id = "baseRest"  href="http://<%=request.getServerName()%>:<%=request.getServerPort()%>/VISITAMEREST/api/">

    <link rel="icon" href="<%=request.getContextPath()%>/static/images/favicon.ico">

    <!-- See https://goo.gl/OOhYW5 -->
    <link rel="manifest" href="<%=request.getContextPath()%>/static/manifest.json">

    <!-- See https://goo.gl/qRE0vM -->
    <meta name="theme-color" content="#3f51b5">

    <!-- Add to homescreen for Chrome on Android. Fallback for manifest.json -->
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="application-name" content="Visitame App">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
    <meta name="apple-mobile-web-app-title" content="Visitame App">

    <script>
    // Register the base URL
    const baseUrl = document.querySelector('#baseUrl').href;
    const baseRest = document.querySelector('#baseRest').href;
    // Load and register pre-caching Service Worker
    if ('serviceWorker' in navigator) {
      window.addEventListener('load', function() {
        navigator.serviceWorker.register('<%=request.getContextPath()%>/static/service-worker.js');
      });
    }
    </script>

    <script src="<%=request.getContextPath()%>/static/bower_components/webcomponentsjs/webcomponents-loader.js"></script>

    <link rel="import" href="<%=request.getContextPath()%>/static/src/visitame-app/visitame-app.html">
    <link rel="import" href="<%=request.getContextPath()%>/static/src/visitame-app-views/view-error-dialog.html">
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDqyFz0Q9ZZLMmgqJhck4soRfa0V1s71jQ&libraries=places"></script>
   
   	<script src="<%=request.getContextPath()%>/static/bower_components/sweetalert2/dist/sweetalert2.min.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bower_components/sweetalert2/dist/sweetalert2.min.css">

	<!-- Include a polyfill for ES6 Promises (optional) for IE11 and Android browser -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
   
    <style>
      body {
        margin: 0;
        font-family: 'Roboto', 'Noto', sans-serif;
        line-height: 1.5;
        min-height: 100vh;
        background-color: #fff;
        position: relative;
      }
    </style>
  </head>
  <body>
    <visitame-app></visitame-app>
    <view-error-dialog id="dialog-error"></view-error-dialog>	
  </body>
  <script>

  	function SyncObjects(callback){
  		var verify = setInterval(() => { 
				try{
					callback();
					clearInterval(verify);
				}catch(e){}
		  }, 100);
  	}
  
  	function mostrarError(mapaMensaje) {
		var SEVERIDAD_ALTA 	= "ALTA";
		var SEVERIDAD_MEDIA = "MEDIA";
		
		var ventaMensaje = document.getElementById('mensaje-error');
		var dialogError = document.getElementById('dialog-error');
		document.getElementById('mensaje_texto').innerHTML = mapaMensaje.mensajeError;
		dialogError.severidad = mensaje.severidad;
		
		var tipoSeveridad = mapaMensaje.severidad;
		if(tipoSeveridad == SEVERIDAD_ALTA){
			dialogError.estiloAlerta = "alerta-alta";
			dialogError.iconoAlerta = "icons:cancel"
		}else if(tipoSeveridad == SEVERIDAD_MEDIA){
			dialogError.estiloAlerta = "alerta-media";
			dialogError.iconoAlerta = "icons:report-problem";
		}else{
			dialogError.estiloAlerta = "alerta-baja";
			dialogError.iconoAlerta = "icons:report";
		}
		ventaMensaje.open();
	}
  </script>
</html>
