<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes">

    <title>visitame</title>
    <meta name="description" content="App de Visitas BBVA">

    <base href="<%=request.getContextPath()%>/">

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
      const baseUrl = document.querySelector('base').href;
      // Load and register pre-caching Service Worker
      if ('serviceWorker' in navigator) {
        window.addEventListener('load', function() {
          navigator.serviceWorker.register('<%=request.getContextPath()%>/static/service-worker.js');
        });
      }
    </script>

    <script src="<%=request.getContextPath()%>/static/bower_components/webcomponentsjs/webcomponents-loader.js"></script>

    <link rel="import" href="<%=request.getContextPath()%>/static/src/visitame-app/visitame-app.html">

    <style>
      body {
        margin: 0;
        font-family: 'Roboto', 'Noto', sans-serif;
        line-height: 1.5;
        min-height: 100vh;
        background-color: #fff;
      }
    </style>
  </head>
  <body>
    <visitame-app></visitame-app>
  </body>
</html>
