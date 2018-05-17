<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.IOException" %>
<!DOCTYPE html>
<html style="height: 100%">
<head>
	
	<title>Profile</title>
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
<body>
<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="col-md-12">
			<h1 style="text-align:center;">MAISON CHOISIE</h1>
			<% ArrayList<String> infos_maison = (ArrayList<String>)request.getAttribute("INF_MAISON");%>
			<h2><%=session.getAttribute("id_choisi")%></h2>
			<img src="img/<%= infos_maison.remove(0) %>" width="350" height="300" alt="Photo de maison" />
			<h2>Informations sur le propriétaire : <%= infos_maison.remove(0) %></h2>
			<h2>Ville : <%= infos_maison.remove(0) %></h2>
			<h2>Description : <%= infos_maison.remove(0) %></h2>
		</div>
	</div>
<jsp:include page="footer.jsp"/>
	<script src="login.js" type="text/javascript"></script>
</body>
</html>