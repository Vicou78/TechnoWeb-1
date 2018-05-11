<!DOCTYPE html>
<html style="height: 100%">
<head>
	
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>	
<script src="js/jquery.autocomplete.js"></script>


</head>
<body>
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

			</div>
		</div>
	</nav>
	<div class="container">
		<div class="col-md-12">
			<h1 style="text-align:center;">Bienvenue sur notre joli site.</h1>
		</div>
		<div>
		
		<form>
		Veuillez entrer un nom de ville à rechercher :
		de : à:
		dans la ville :
			<input type="text" id="country" name="country"/>
			
			      
			        <button type="button" class="btn btn-default" data-dismiss="modal">Chercher</button>
			      
	</form>
	<script>
		$("#country").autocomplete("getdata.jsp");
	</script>
			
			
			
		</div>
	</div>
<footer style="background-color:rgb(231, 231, 231);width:100%">
	<p>Future footer </p>

</footer>
</body>
</html>