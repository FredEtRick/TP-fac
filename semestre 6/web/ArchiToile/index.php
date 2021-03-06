<!doctype html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<meta name="keywords" content="infocom, materiel, informatique, vente" />
		<meta name="description" content="vente de materiel informatique" />
		<meta name="author" content="Frederic Malard" />
		<title>INFOCOM materiel informatique</title>
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<header>
			<h1>INFOCOM - vente de matériel informatique</h1>
		</header>
		<hr />
		<nav>
			<ul>
				<li><a href="#DD">disques durs</a></li>
				<li><a href="#CS">claviers et souris</a></li>
				<li><a href="#divers">divers</a></li>
				<li><a href="factorielle.html">factorielle</a></li>
				<li><a href="commandes.php">commandes</a></li>
			</ul>
		</nav>
		<div class="page">
			<h2 id="DD">Les disques durs</h2>
			<table>
				<th>
					<td>Produit</td>
					<td>Prix</td>
					<td>Description</td>
				</th>
				<tr>
					<td>disque dur Seagate 500 Go</td>
					<td>100€</td>
					<td>taille 135x87x30, temps d'accès moyen 12ms</td>
				</tr>
				<tr>
					<td>disque dur Western 750 Go</td>
					<td>120€</td>
					<td>taille 155x88x32, temps d'accès moyen 15ms</td>
				</tr>
				<tr>
					<td>disque dur Externe 500 Go</td>
					<td>115€</td>
					<td>taille 120x78x32, temps d'accès moyen 20ms</td>
				</tr>
			</table>
			<h2 id="CS">Les claviers et souris</h2>
			<table>
				<th>
					<td>Produit</td>
					<td>Prix</td>
					<td>Description</td>
				</th>
				<tr>
					<td>clavier logitech</td>
					<td>10€</td>
					<td>filaire USB2, contrôles multimedia</td>
				</tr>
				<tr>
					<td>souris logitech</td>
					<td>12€</td>
					<td>optique, filaire USB2</td>
				</tr>
				<tr>
					<td>clavier souris sans fil</td>
					<td>35€</td>
					<td>récepteur USB2</td>
				</tr>
			</table>
			<h2 id="divers">Divers</h2>
			<table>
				<th>
					<td>Produit</td>
					<td>Prix</td>
					<td>Description</td>
				</th>
				<tr>
					<td>enceintes 5W</td>
					<td>30€</td>
					<td>filaire USB2</td>
				</tr>
				<tr>
					<td>tapis souris</td>
					<td>5€</td>
					<td></td>
				</tr>
			</table>
			<form action="" method="get">
				<label for="qdd">Quantité de disques durs</label>
				<input type="number" name="qdd" min="0" max="1000" step="1" value="1" />
				<select name="disque" multiple="multiple">
					<option value="seagate">disque dur Seagate 500 Go</option>
					<option value="western">disque dur Western 750 Go</option>
					<option value="externe">disque dur Externe 500 Go</option>
				</select>
				
			</form>
		</div>
		<hr />
		<footer>
			<p>INFOCOM : le leader de la vente de matériel informatique</p>
		</footer>
	</body>
</html>
