public class Test
{

    public static void main(String [] args){
		Couleur c1 = Couleur.Rouge;
		Categorie categ1 = new Categorie("Reunion",c1);
		Date Dd1 = new Date(9,30,01,01,2015);
		Date Df1 = new Date(10,30,10,01,2015); // changement date fin car lapse sur lequel s'étale toute la tache, mais pas sur d'avoir compris
		Horaire h1 = new Horaire(new Date(18,30,01,01,2015), new Date(21,00,01,01,2015));
		Taches t1 = new Taches("Réunion TER",categ1,Dd1,Df1,h1);
		
		Couleur c2 = Couleur.Jaune;
		Categorie categ2 = new Categorie("Sport", c2);
		Date Dd2 = new Date(8,00,07,9,2015);
		Date Df2 = new Date(20,00,15,06,2016);
		Horaire h2 = new Horaire(new Date(10,30,01,10,2015), new Date(12,00,01,10,2015));
		Taches t2 = new Taches("Vélo",categ2,Dd2,Df2,h2);
		
		Horaire h3 = new Horaire(new Date(18,30,03,10,2015), new Date(20,00,03,10,2015));
		Taches t3 = new Taches("jogging",categ2,Dd2,Df2,h3);
		
		Planificateur p = new Planificateur();
		p.ajouterTache(t1);
		p.ajouterTache(t2);
		p.ajouterTache(t3);
		System.out.println(p);
		System.out.println(p.getTache(2));
		p.supprimerTache(1);
		System.out.println(p);
    }
}