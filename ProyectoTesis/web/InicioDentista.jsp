
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
    <style type="text/css">
 //   @import url(http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css);
body{margin-top:20px;}
.fa-fw {width: 2em;}
   .jumbotron {
background: #358CCE;
color: #FFF;
border-radius: 0px;
}
.jumbotron-sm { padding-top: 24px;
padding-bottom: 24px; }
.jumbotron small {
color: #FFF;
}
.h1 small {
font-size: 24px;
}


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
                   Clinica dental <small> Pagina de Dentistas</small></h1>
            </div>
        </div>
    </div>
</div>
    
    
    
    
	<div class="container">
    <div class="row">
        <div class="col-md-3">
            <ul class="nav nav-pills nav-stacked admin-menu">
                <li class="active"><a href="#" data-target-id="home"><i class="fa fa-home fa-fw"></i>Home</a></li>
                <li><a href="http://www.jquery2dotnet.com" data-target-id="Profile"><i class="fa fa-list-alt fa-fw"></i>Mensajes Enviados</a></li>
                <li><a href="http://www.jquery2dotnet.com" data-target-id="IngresarTer"><i class="fa fa-list-alt fa-fw"></i>Ingresar Termino Nuevo</a></li>

                <li><a href="http://www.jquery2dotnet.com" data-target-id="Salir"><i class="fa fa-list-alt fa-fw"></i>Salir</a></li>
            
            </ul>
        </div>
        
        <form action="MirarMensajesDentistaServelt" method="GET">
        <div class="col-md-9 well admin-content" id="home">
            <p>
                Bienvenido    ${usuario.nombre}   <br>
               Alguna consulta!
            </p>
            <p>
                Presione aqui para mirar los mensajes del consultorio  <a href="MirarMensajesDentista.jsp" >Mirar mensajes</a>
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
             <td class="view-message ">${mensaje.nombrePaciente}</td>
          
             <td class="view-message ">${mensaje.termino}</td>
            
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
      
    
                 <form method="POST" action="InsertarTerminoServlet"> 
                     <div class="col-md-9 well admin-content" id="IngresarTer">
                        
                         <div class="form-group">
                        <input type="text" name="termino" id="codigo" class="form-control input-lg" placeholder="Ingrese el termino dental"> 
                         </div>
                        <div class="form-group">
                        <input type="text" name="significado" id="password" class="form-control input-lg" placeholder="Ingrese los Sintomas">
                        </div>
                         <div class="form-group">
                       <label for="dolor">
                                Seleccione el nivel de dolor el paciente siente </label>
                             <select id="subject" name="dolor" class="form-control" required="required">
                                                
                                <option value="na" selected="">nivel de gravedad</option>
                                <option value="mucho">Fuerte</option>
                                <option value="medio">mediano</option>
                                <option value="leve">debil</option>
                            </select>
                             
                             
                         </div>
                        <div class="form-group">
                          <label for="tiempo">
                                Seleccione el tiempo que el paciente puede tener con el dolor</label>
                            <select id="subject" name="tiempo" class="form-control" required="required">
                                <option value="na" selected="">tiempo de dolor</option>
                                <option value="leve">Poco tiempo</option>
                                <option value="medio">medio tiempo</option>
                                <option value="mucho">Mucho tiempo</option>
                            </select>
                            
                        </div>
                         <div class="col-xs-6 col-sm-6 col-md-6">
                                 <input type="submit"  class="btn btn-lg btn-success btn-block"  value="Insertar Termino">
			</div>
                         
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
