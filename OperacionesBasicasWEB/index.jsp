<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Inicio</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="Resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="Resources/font-awesome-4.7.0/css/font-awesome.css">   
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  <link rel="stylesheet" href="Resources/Styles.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="Resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body style="background-color:#D8D8D8">

<div class="container"  style="padding:6% 0% 0% 0%;">
       <div class="panel panel-default" >
            
            <div class="panel-body">
                <div class="container" style="padding:0% 0% 2% 27%">
           
                
                <div style="float: left; padding-left: 10%">
                    <legend><h1>Operaciones básicas</h1></legend>
                    
                    <h4 style="padding-bottom:10%;">Selecciona una operación a realizar:</h4>
                    
                    <form action="CargaServlet" method="post" id="registro">
                        <div class="row">
                            <label class="form">Número 1</label>
                            <input type="text" class="form-control" name="x" id="x" required></input>
                        </div>
                        <div class="row">
                            <label class="form">Número 2</label>
                            <input type="text" class="form-control" name="y" id="y" required></input>
                        </div>
                        <div class="row">
                        <label for="sel1">Seleccionar operación:</label>
                        <select class="form-control" id="ope" name="ope">
                            <option>Suma</option>
                            <option>Resta</option>
                            <option>Division</option>
                            <option>Multiplicacion</option>
                            
                        </select>
                        </div>
                        <div class="row">
                            <label style="color:white">__</label>
                            <button form="registro" type="submit" class="btn btn-primary col-md-4 form-control" style="margin: 0 auto;">Realizar</button>  
                        </div>
                    </div>
                </div>
                </div>
            </div>
       </div>
</body>
</html>

