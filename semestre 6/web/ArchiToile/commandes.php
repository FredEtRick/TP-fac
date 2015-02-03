<!doctype html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<meta name="keywords" content="factorielle" />
		<meta name="description" content="calcul de factorielle" />
		<meta name="author" content="Frederic Malard" />
		<title>factorielle</title>
		<link rel="stylesheet" href="style.css">
	</head>
	<?php
		$larticle=array('marteau'=>10, 'tenaille'=>5, 'vis'=>5.2, 'clou'=>5.8, 'tournevis'=>7, 'ciseau'=>4, 'toile emeri'=>3);
		if(isset($_GET['nbMarteaux']))
			$nbMarteaux = $_GET['nbMarteaux'];
		else
			$nbMarteaux = 0;
		if(isset($_GET['nbTenailles']))
			$nbTenailles = $_GET['nbTenailles'];
		else
			$nbTenailles = 0;
		if(isset($_GET['nbVis']))
			$nbVis = $_GET['nbVis'];
		else
			$nbVis = 0;
		if(isset($_GET['nbClous']))
			$nbClous = $_GET['nbClous'];
		else
			$nbClous = 0;
		if(isset($_GET['nbTournevis']))
			$nbTournevis = $_GET['nbTournevis'];
		else
			$nbTournevis = 0;
		if(isset($_GET['nbCiseaux']))
			$nbCiseaux = $_GET['nbCiseaux'];
		else
			$nbCiseaux = 0;
		if(isset($_GET['nbToileEmeri']))
			$nbToileEmeri = $_GET['nbToileEmeri'];
		else
			$nbToileEmeri = 0;
	?>
	<body>
		<header>
			<h1>factorielle</h1>
		</header>
		<hr />
		<form action="" method="get">
			<input type="hidden" name="nbMarteaux" value="<?php $nbMarteaux ?>" />
			<input type="hidden" name="nbTenailles" value="<?php $nbTenailles ?>" />
			<input type="hidden" name="nbVis" value="<?php $nbVis ?>" />
			<input type="hidden" name="nbClous" value="<?php $nbClous ?>" />
			<input type="hidden" name="nbTournevis" value="<?php $nbTournevis ?>" />
			<input type="hidden" name="nbCiseaux" value="<?php $nbCiseaux ?>" />
			<input type="hidden" name="nbToileEmeri" value="<?php $nbToileEmeri ?>" />
			<label>Nouvel article : </label>
			<select name="article">
				<option value="marteau">marteau</option>
				<option value="tenaille">tenaille</option>
				<option value="vis">vis</option>
				<option value="clou">clou</option>
				<option value="tournevis">tournevis</option>
				<option value="ciseau">ciseau</option>
				<option value="toile emeri">toile emeri</option>
			</select>
		</form>
		<?php
			
		?>
	</body>
	<?php
		/*
		
		if(isset($_GET['nbCommandes']))
			$nbCommandes = $_GET['nbCommandes'] + 1;
		else
			$nbCommandes = 1;

		<input type="hidden" name="nbCommandes" value="<?php echo $nbCommandes; ?>" />

		for($i=1 ; $i<=$nbCommandes ; $i++)
		{
			echo "<label>article : </label>";
			echo "<select name=\"choix" . $i . "\">";
			foreach ($larticle as $cle => $valeur)
			{
				echo "<option value=\"" . &cle . "\""
				if (isset($_GET[$choix'$i']
				echo "></option>";
			}
			echo "</select>";
		}*/
	?>
</html>
