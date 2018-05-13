<!DOCTYPE html>
<html style="height: 100%">
<head>
	
	<title>Login</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>	
	<style>
	footer {
    position: absolute;
    bottom: 0;
	}
	body {
  	min-height: 100%;
  	margin: 0;
  	padding: 0;
  	position: relative;
	}
	</style>
</head>
<body style="background:url('architect.jpg') fixed no-repeat">
			  <%

// Récupération du message d'erreur

String erreur = (String) request.getAttribute("erreur");

// Affichage du message s'il existe

if (erreur != null) { %>

<strong>Erreur, les identifiants ne sont pas corrects </strong>

<%
} %>
<nav class="navbar navbar-default">   
		<div class="container">
			<div class="navbar-header">   
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">BIENVENUE</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li> <a href="#">Qui somme-nous?</a> </li>
					<li> <a href="#">Nous contacter</a> </li>
					<li> <a href="#">Paramètre</a> </li>
					<li> <a href="#">Partenaires</a> </li>
				</ul>
				<!--<form class="navbar-form navbar-right inline-form">
					<div class="form-group">
						<button type="button" class="btn btn-primary center-block">Recherche
						</button>
					</div>
				</form>-->
			</div>
		</div>
	</nav>
	<div class="container" style="min-height: 40vh;">
			<div class="col-sm-offset-2 col-sm-8 col-sm-offset-2" style="border:solid black 2px;border-radius:4px;min-height: 40vh;background-color:white;margin-top:10%;">
				<div style="display: flex;flex-direction: column;justify-content: center;min-height:40vh">
					<div class="col-sm-offset-1 col-sm-10 col-sm-offset-1" style="margin-top:5px;border-radius:3px;background-color:white;margin-bottom:10px;min-height:80px;cursor:pointer;">
						<p style="text-align:center;margin:0"><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2" style="min-height:80px;padding:10px 55px;backgroung-color:grey;min-width:100%;">SIGN IN</button>
						</p>
					</div>
					<div class="col-sm-offset-1 col-sm-10 col-sm-offset-1" style="margin-top:5px;border-radius:3px;background-color:white;margin-bottom:10px;min-height:80px;cursor:pointer;">
						<p style="text-align:center;margin:0"><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="min-height:80px;padding:10px 55px;backgroung-color:grey;min-width:100%;">SIGN UP</button>
						</p>
					</div>
				</div>
			</div>
			<!-- MODAL -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">

			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel" style="text-align:center;">SIGN UP</h4>
			      </div>
			      <div class="modal-body">
			        <form method="POST" action = "Inscrire">
			        
			        <div class="col-sm-12" style="padding:0;margin-bottom:10px;">
				        <div class="col-sm-offset-1 col-sm-2">Nom:
				        </div>
				        <div class=" col-sm-8 col-sm-offset-1" style="margin-left:0px;"><input name="name" type="text" style="width:100%;">
				        </div>
				    </div>
				    <div class="col-sm-12" style="padding:0;margin-bottom:10px;">
				        <div class="col-sm-offset-1 col-sm-2">Prénom:
				        </div>
				        <div class=" col-sm-8 col-sm-offset-1" style="margin-left:0px;"><input name="prenom" type="text" style="width:100%;">
				        </div>
				    </div>
				    <div class="col-sm-12" style="padding:0;margin-bottom:10px;">
				        <div class="col-sm-offset-1 col-sm-2">E-mail:
				        </div>
				        <div class=" col-sm-8 col-sm-offset-1" style="margin-left:0px;"><input name="mail" type="text" style="width:100%;">
				        </div>
				    </div>
			        <div class="col-sm-12" style="padding:0;margin-bottom:10px;">
				        <div class="col-sm-offset-1 col-sm-2">Username:
				        </div>
				        <div class=" col-sm-8 col-sm-offset-1" style="margin-left:0px;"><input name="username" type="text" style="width:100%;">
				        </div>
				    </div>
			        <div class="col-sm-12" style="padding:0;margin-bottom:10px;">
						<div class="col-sm-offset-1 col-sm-2">Password:
				        </div>
				        <div class=" col-sm-8 col-sm-offset-1" style="margin-left:0px;"><input name="password1" type="text" style="width:100%;">
				        </div>
				    </div>
				    <div class="col-sm-12" style="padding:0;margin-bottom:10px;">
				        <div class="col-sm-offset-1 col-sm-2">Confirmation Password:
				        </div>
				        <div class=" col-sm-8 col-sm-offset-1" style="margin-left:0px;"><input name="password2" type="text" style="width:100%;">
				        </div>
				    </div>
					<p style="text-align:center;"><input type="submit"></p>
			        </form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
			<!-- FIN MODAL -->
			
			<!-- MODAL -->
			<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel" style="text-align:center;">SIGN IN</h4>
			      </div>
			      <div class="modal-body">
			        <form action="Connexion" name="connexion" method="post">
			        <div class="col-sm-12" style="padding:0;margin-bottom:10px;">
				        <div class="col-sm-offset-1 col-sm-2">Username:
				        </div>
				        <div class=" col-sm-8 col-sm-offset-1" style="margin-left:0px;"><input name="username" type="text" style="width:100%;">
				        </div>
				    </div>
			        <div class="col-sm-12" style="padding:0;margin-bottom:10px;">
						<div class="col-sm-offset-1 col-sm-2">Password:
				        </div>
				        <div class=" col-sm-8 col-sm-offset-1" style="margin-left:0px;"><input name="password" type="text" style="width:100%;">
				        </div>
				    </div>
					<p style="text-align:center;"><input type="submit"></p>
			        </form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
			<!-- FIN MODAL praveen modal -->
		</div>
		<footer style="background-color:rgb(231, 231, 231);width:100%">
		<p>Futur footer </p>
		</footer>
	<script src="login.js" type="text/javascript"></script>
</body>
</html>