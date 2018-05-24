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
	<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="col-sm-12" style="padding:0;margin-top:15px;">
			<p style="text-align:center;font-size:20px;">Page de profil
			</p>
			<p style="text-align:center;font-size:15px;">Vous pouvez modifier vos données.
			</p>
		</div>
		<div class="col-sm-12" style="padding:0;margin-top:15px;">
		<form class="form-horizontal" action="Profil" name="Profil" method="post">
			<div class="form-group">
				<label class="col-sm-offset-2 col-sm-1 control-label">Nom:</label>
				<div class="col-sm-6">
	  				<div class="input-group">
	    				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	    				<input id="nom_user_modif" type="text" class="form-control" name="nom_user_modif" placeholder="Nom" value="${ Nom_User }">
	  				</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-2 col-sm-1 control-label">Prenom:</label>
				<div class="col-sm-6">
	  				<div class="input-group">
	    				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	    				<input id="prenom_user_modif" type="text" class="form-control" name="prenom_user_modif" placeholder="prenom" value="${ Prenom_User }">
	  				</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-2 col-sm-1 control-label">E-mail:</label>
				<div class="col-sm-6">
	  				<div class="input-group">
	    				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	    				<input id="mail_modif" type="text" class="form-control" name="mail_modif" placeholder="e-mail" value="${ mail }">
	  				</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-2 col-sm-1 control-label">Username:</label>
				<div class="col-sm-6">
	  				<div class="input-group">
	    				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	    				<input id="username_modif" type="text" class="form-control" name="username_modif" placeholder="username" value="${ Username }">
	  				</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-2 col-sm-1 control-label">Password:</label>
				<div class="col-sm-6">
	  				<div class="input-group">
	    				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	    				<input id="password_modif" type="text" class="form-control" name="password_modif" placeholder="password" value="${ Password }">
	  				</div>
				</div>
			</div>
			<p style="text-align:center;">
			<button type="submit" value="submit" class="btn btn-lg btn-warning" id="change_info" onclick="">Modifier vos données</button>
			</p>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
	</body>
</html>