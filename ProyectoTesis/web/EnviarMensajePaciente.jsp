
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Contact us page - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
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
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
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
  
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div class="well well-sm">
                  <form action="EnviarMensajeServlet" method="POST">
                      
                                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="text">
                                Nombre del usuario</label>
                            <text for="name" id="nombre" name="nombre"  value = "${usuario.nombre}">  ${usuario.nombre}
                            
                            
                            </text>
                         
                        </div>
                        <div class="form-group">
                            <label for="email">
                                Correo Electronico</label>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                                </span>
                                <input type="email" class="form-control" id="email" placeholder="Enter email" required="required" /></div>
                        </div>
                        <div class="form-group">
                            <label for="dolor">
                                Seleccione el nivel de dolor que usted siente</label>
                            <select id="subject" name="dolor" class="form-control" required="required">
                                <option value="na" selected="">nivel de gravedad</option>
                                <option value="mucho">Fuerte</option>
                                <option value="medio">mediano</option>
                                <option value="leve">debil</option>
                            </select>
                              <label for="tiempo">
                                Seleccione el tiempo que tiene usted con el dolor</label>
                            <select id="subject" name="tiempo" class="form-control" required="required">
                                <option value="na" selected="">tiempo de dolor</option>
                                <option value="leve">Poco tiempo</option>
                                <option value="medio">medio tiempo</option>
                                <option value="mucho">Mucho tiempo</option>
                            </select>
                            
                            
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name"> Ingrese su mensaje</label>
                               
                            <textarea name="message" id="message" class="form-control" rows="9" cols="25" required="required"
                                placeholder=""></textarea>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary pull-right" id="btnContactUs">
                            Send Message</button>
                    </div>
                </div>
                </form>
            </div>
        </div>
        <div class="col-md-4">
            <form>
            <legend><span class="glyphicon glyphicon-globe"></span> Our office</legend>
            <address>
                <strong>Twitter, Inc.</strong><br>
                795 Folsom Ave, Suite 600<br>
                Lima Peru, CA 94107<br>
                <abbr title="Phone">
                    P:</abbr>
                (051)456-7890
            </address>
            <address>
                <strong>Clinica Dental Velasquez</strong><br>
                <a href="mailto:#">first.last@example.com</a>
            </address>
            </form>
        </div>
    </div>
</div>
    
<script type="text/javascript">

</script>
</body>
</html>
