
<%@page import="Principal.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Principal.Mensaje"%>
<%@page import="java.util.List"%>
<a href="../src/java/Servlets/LoginServlet.java"></a>
<%@page contentType="text/html" pageEncoding="UTF-8"%>





<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">

    <title>Account Management - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="css/Incio.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">



    </style>
    <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        $( document ).ready(function() {
          var iframe_height = parseInt($('html').height()); 
          window.parent.postMessage( iframe_height, 'https://bootsnipp.com');
        });
    </script>
</head>
<body>
    
    <div class="jumbotron jumbotron-sm">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <h1 class="h1">
                   Clinica dental <small>Estamos para Usted!</small></h1>
            </div>
        </div>
    </div>
    </div>
    <div class="row">  
 
    

  
	<div class="container">
<form action="MirarMensajesPacienteServlet" method="GET">   
        <div class="col-md-3">
            <ul class="nav nav-pills nav-stacked admin-menu">
                <li class="active"><a href="#" data-target-id="home"><i class="fa fa-home fa-fw"></i>Home</a></li>
                <li><a href="http://www.jquery2dotnet.com" data-target-id="Profile"><i class="fa fa-list-alt fa-fw"></i>Mensajes Enviados</a></li>
                <li><a href="http://www.jquery2dotnet.com" data-target-id="Historia"><i class="fa fa-list-alt fa-fw"></i>Imprimir Historia Clinica</a></li>
                <li><a href="http://www.jquery2dotnet.com" data-target-id="Salir"><i class="fa fa-list-alt fa-fw"></i>Salir</a></li>
            
            </ul>
        </div>
        <div class="col-md-9 well admin-content" id="home">
            <p>
                Bienvenido  ${usuario.nombre}     <br>
               Alguna consulta!
            </p>
            <p>
                Presione aqui para enviar un mensaje al consultorio <a href="EnviarMensajePaciente.jsp" >Enviar mensaje</a>
                <br>
                Gracias por su preferencia!
            </p>
        </div>
       
        <div class="col-md-9 well admin-content" id="Profile">
            <table class="table table-inbox table-hover">
            
            <tbody>
            <c:forEach var="mensaje" items="${listaMensaje}">
                 <tr class="unread">
            <td class="inbox-small-cells"><i class="fa fa-star"></i></td>
         
            <td class="view-message ">${mensaje.termino}</td>
            <td class="view-message ">${mensaje.mensaje}</td>
            <td class="view-message  text-right">${mensaje.tiempo}</td>
                 </tr>
             </c:forEach>   
            </tbody>     
            
                
            
       
      </table>
            
    </div>
               
       <div class="col-md-9 well admin-content" id="Salir">
                    
          <a href="Login.jsp" class="btn btn-lg btn-primary btn-block">Salir</a>
               
               
       </div>        

</form>
     
               <form action="ImprimirHistorialPacienteServlet" method="post">  
               <div class="col-md-9 well admin-content" id="Historia">     
             <button type="submit" class="btn btn-primary pull-right" >
                            Imprimir Historia Clinica</button>
                </div>
                
             
          </form> 
               
               
       </div>
               
             
               
</div>               
               
               

	<script type="text/javascript">
	$(document).ready(function()
{
    var navItems = $('.admin-menu li > a');
    var navListItems = $('.admin-menu li');
    var allWells = $('.admin-content');
    var allWellsExceptFirst = $('.admin-content:not(:first)');
    
    allWellsExceptFirst.hide();
    navItems.click(function(e)
    {
        e.preventDefault();
        navListItems.removeClass('active');
        $(this).closest('li').addClass('active');
        
        allWells.hide();
        var target = $(this).attr('data-target-id');
        $('#' + target).show();
    });
});
	</script>
        
</body>
</html>
