<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.IOException" %>

<!DOCTYPE html>
<html style="height: 100%">
<head>
	
	<title>Home</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
	<link rel="stylesheet" type="text/css" href="css/header.css" />
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
		<% ArrayList<String> id_maison = (ArrayList<String>)session.getAttribute("id_maison");%>
			<h1 style="text-align:center;">Vos Resultats de recherche :</h1>
			
			  <c:forEach items="${ messages2 }" var="messages2" varStatus="boucle">
            <p><img src="img/<%= id_maison.remove(0) %>" width="80" height="80" alt="Photo de maison" /> ${ messages2 } <a href="recherche?num=<%= id_maison.remove(0) %>">Lien</a> </p>
        </c:forEach>
		</div>
		<div>
		

			
			
			
		</div>
	</div>
<footer style="background-color:rgb(231, 231, 231);width:100%">
	<p>Future footer </p>

</footer>
</body>
</html>