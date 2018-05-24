<!--<nav class="navbar navbar-default">   
		<div class="container">
			<div class="navbar-header">   
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">BIENVENUE ${ info_user }</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li> <a href="#">Qui somme-nous?</a> </li>
					<li> <a href="#">Nous contacter</a> </li>
					<li> <a href="/projet_web/Connexion" accesskey="1" style="font-size: 20px;">Déconnexion</a> </li>
				</ul>
			</div>
		</div>
	</nav>-->
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="/projet_web/Profil" accesskey="1">Mon Profil</a>
  <a href="/projet_web/QuiSommesNous" accesskey="2">Qui sommes-nous</a>
  <a href="/projet_web/Contacter" accesskey="3">Nous Contacter</a>
    <a href="/projet_web/MesMaisons" accesskey="4">Mes Maisons</a>
  <a href="/projet_web/Parametres" accesskey="5">Paramètres</a>

  <a href="/projet_web/Connexion" accesskey="1">Déconnexion</a>
</div>

<div class="container" style="margin:0;padding:10px;;width:100%;background-color:#B2E3F2;">
<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span> <span style="font-size:30px;margin-left:20px;">Bienvenue ${ info_user }</span>
</div>
<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "50%";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
</script>
