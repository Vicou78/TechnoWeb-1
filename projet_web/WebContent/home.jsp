<% if(session.getAttribute("session")!="on"){

%><jsp:forward page="/home.jsp" />
<%
}%>
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
<body style="background-color:#F7F7F7;">
<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="col-md-12">
			<h1 style="text-align:center;">Bienvenue sur notre joli site.</h1>
		</div>
		<div>
		<form action="recherche" name="recherche" method="post">
		Veuillez entrer un nom de ville à rechercher :
		de :
		<input type="date" name="depart">
		 à:
		 <input type="date" name="arrivee">
		dans la ville :
			<input type="text" id="country" name="country"/>
			
			      
			        <button type="submit" class="btn btn-default" data-dismiss="modal">Chercher</button>
			      
	</form>
	<script>
		$("#country").autocomplete("getdata.jsp");
	</script>
			
			
			
		</div>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>