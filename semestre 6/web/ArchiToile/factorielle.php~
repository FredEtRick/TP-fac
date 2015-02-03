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
		function factorielle($arg)
		{
			if ($arg < 0)
				echo "probleme";
			else if ($arg == 0)
				return 1;
			else
				return (factorielle($arg - 1) * $arg);
		}
	?>
	<body>
		<header>
			<h1>factorielle</h1>
		</header>
		<hr />
		<form action="" method="get">
			<label>de quel nombre voulez vous obtenir la factorielle ?</label>
			<input type="number" name="nombre" min="0" step="1" />
		</form>
		<?php
			if (isset($_GET['nombre']))
				echo factorielle($_GET['nombre']);
		?>
	</body>
</html>
