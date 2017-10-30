<%-- 
    Document   : MirarMensajesDentista
    Created on : Sep 20, 2017, 1:49:36 PM
    Author     : USER
--%>
<%@page import="Principal.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Principal.Mensaje"%>
<%@page import="java.util.List"%>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <form acction="ImprimirHistoriaPacienteServlet" method="Post">
                
        <div class="row ">
       <div class="form-group col-md-3">
                            <label for="subject">
                                Seleccione al paciente a revisar</label>
                            <select id="paciente" name="paciente" class="form-control" required="required">
                               <option value="na" selected="">Lista de Pacientes</option>
                               <c:forEach var="lista" items="${listaUsuario}">
                              <option value="${lista.nombre}"> ${lista.nombre}</option>
                               </c:forEach>
                               
                            </select>
           
        </div> 
             
              <div class="col-md-3">
                        <button type="submit" class="btn btn-primary pull-right" id="btnContactUs">
                           Imprimir Historial clinico</button>
              </div>
             
        </div> 
            
        </form>    
            </div>
        
        
    </body>
</html>
