
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Resultado encontrado</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="Resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  <link rel="stylesheet" href="Resources/Styles.css"> 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="Resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="background-color:#D8D8D8">

<div class="container" style="padding:5% 20%;">
    
    <div class="panel panel-default">
        <div class="panel-heading" style="text-align: center">
            <legend><h1>Resultado</h1></legend>
            <h1 style="color:#3D77E3"><%=(String)request.getAttribute("Resultado")%></h1>
        </div>    
    </div>
    <a class="btn  btn-danger col-md-offset-5 col-md-2" href="index.jsp">Regresar</a>
    </div>
</div>
</body>
</html>
