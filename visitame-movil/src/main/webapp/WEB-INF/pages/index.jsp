<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes">

    <title>visitame</title>
    <meta name="description" content="App Visitame">

    <!-- See https://goo.gl/OOhYW5 -->
    <link rel="manifest" href="/manifest.json">

    <script src="<%=request.getContextPath()%>/static/bower_components/webcomponentsjs/webcomponents-loader.js"></script>

    <link rel="import" href="<%=request.getContextPath()%>/static/componentes/visitame-app/visitame-app.html">
  </head>
  <body>
    <visitame-app></visitame-app>
  </body>
</html>
