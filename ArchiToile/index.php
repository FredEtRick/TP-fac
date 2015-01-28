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
					<td></td>
					<td>disque dur Seagate 500 Go</td>
					<td>100€</td>
					<td>taille 135x87x30, temps d'accès moyen 12ms</td>
				</tr>
				<tr>
					<td></td>
					<td>disque dur Western 750 Go</td>
					<td>120€</td>
					<td>taille 155x88x32, temps d'accès moyen 15ms</td>
				</tr>
				<tr>
					<td></td>
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
					<td></td>
					<td>clavier logitech</td>
					<td>10€</td>
					<td>filaire USB2, contrôles multimedia</td>
				</tr>
				<tr>
					<td></td>
					<td>souris logitech</td>
					<td>12€</td>
					<td>optique, filaire USB2</td>
				</tr>
				<tr>
					<td></td>
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
					<td></td>
					<td>enceintes 5W</td>
					<td>30€</td>
					<td>filaire USB2</td>
				</tr>
				<tr>
					<td></td>
					<td>tapis souris</td>
					<td>5€</td>
					<td></td>
				</tr>
			</table>
			<form action="" method="get">
				<label for="qdd">Quantité de disques durs</label>
				<input type="number" name="qdd" id="qdd" min="0" max="1000" step="1" value="1" />
				<select name="disque" multiple="multiple">
					<option value="seagate">disque dur Seagate 500 Go</option>
					<option value="western">disque dur Western 750 Go</option>
					<option value="externe">disque dur Externe 500 Go</option>
				</select>
				<br />
				
				<label for="clavier">clavier logitech (10€)</label>
				<input type="checkbox" name="souris" id="clavier" value="clavier" />
				<label for="souris">souris logitech (12€)</label>
				<input type ="checkbox" name="souris" id="souris" value="souris" />
				<label for="clavierSouris">clavier souris sans fil (35€)</label>
				<input type="checkbox" name="souris" id="clavierSouris" value="clavierSouris" checked="checked" />
				<br />
				
				<label for="enceintes">enceintes 5W (30€)</label>
				<input type="radio" name="materiel" id="enceintes" value="enceintes" checked="checked" />
				<label for="tapis">tapi souris (5€)</label>
				<input type="radio" name="materiel" id="tapis" value="tapis" />
				<br />
				
				<label for="email">Adresse email</label>
				<input type="email" id="email" placeholder="Saisissez email" required="required" />
				<br />
				
				<label for="nom">Nom</label>
				<input type="text" id="nom" /> <!-- RESTE A FORCER LES MAJUSCULES !!! -->
				<br />
				
				<input type="submit" name="envoie" value="Envoyer" />
				
			</form>
			
			<form action="" method="get">
				<table>
					<th>
						<td>
							A
						</td>
						<td>
							B
						</td>
						<td>
							C
						</td>
						<td>
							D
						</td>
						<td>
							E
						</td>
					</th>
					<tr>
						<td>
							
						</td>
						<td>
							<input type="submit" name="1,1" value="?" />
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
					</tr>
				</table>
			</form>
			
			<!-- RESTE A FAIRE LA BATAILLE NAVALE !!!
			Mais j'y arrive pas : comment faire sans php ni javascript ? -->
		</div>
		<hr />
		<footer>
			<p>INFOCOM : le leader de la vente de matériel informatique</p>
		</footer>
	</body>
</html>