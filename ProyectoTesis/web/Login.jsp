
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Mix &amp; Match Login - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="js/login.js" type="text/javascript"></script>
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

<div class="row" style="margin-top:20px">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
        <form action="LoginServlet" method="POST" form="post">
			<fieldset>
				<h2>Logeate Clinica dental</h2>
				<hr class="colorgraph">
				<div class="form-group">
                    <input type="text" name="codigo" id="codigo" class="form-control input-lg" placeholder="Usuario">
				</div>
				<div class="form-group">
                    <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password">
				</div>
				
				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
                                 <input type="submit"  class="btn btn-lg btn-success btn-block"  value="Entrar">
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
                                            <a href="Registro.jsp" class="btn btn-lg btn-primary btn-block">Registrate</a>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</div>

</div>

</body>
</html>
