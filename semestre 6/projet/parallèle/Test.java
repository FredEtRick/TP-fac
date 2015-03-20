//package modele; commenté car je l'ai rajouté en dernier mais ça fait bugger, j'essairai de bientôt résoudre le problème

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Date;

public class Test
{
    public static void main(String [] args)
    {
    	
    	
    	/* // test dates
		Dates date = new Dates(2016, 4, 11, 60, -50); // avec 60h et -50min, la classe Date de java fait bien un modulo
		Dates date2 = new Dates(date);
		System.out.println(date + "\n" + date2 + "\n" + date.getHours());
		date.setDate(date.getDate()+40);
		System.out.println(date + " " + date.compareTo(date2) + " " + date.equals(date2) + "\n");
		
		//test calculs sur dates
		System.out.println("date 1 + date 2 :\n" + date.additionner(date2) + "\n\ndate 1 - date 2 :\n" + date.soustraire(date2) + "\n\ndate 1 / date 2 :\n" + date.diviser(4) + "\n\ndate 2 - date 1 - date 1 :\n" + date2.soustraire(date).soustraire(date) + "\n\n"); // note : bug apparemment avec dates négatives mais pas grave pour l'appli
		
		// test categories taches et planificateur
		Planificateur p = new Planificateur();
		Categorie cat = new Categorie("sport", Couleur.Rouge);
		Taches t = new Taches("vélo", cat, new Dates(), new Dates(2015, 10, 1, 8, 0));
		p.ajouterTache(t);
		//System.out.println(p);
		
		// test occurrenceTache et agenda
		Agenda a = new Agenda();
		Dates debut1 = new Dates(2015, 3, 13, 10, 0);
		Dates fin1 = new Dates(2015, 3, 13, 12, 0);
		OccurrenceTache o1 = new OccurrenceTache(t, debut1, fin1, a);
		//System.out.println(p); // Pour voir le changement de "déjà planifié"
		//System.out.println(a);
		
		Dates debut4 = new Dates(2015, 3, 22, 10, 0);
		Dates fin4 = new Dates(2015, 3, 22, 20, 0); // trop long, n'est pas ajouté car 10->20h
		OccurrenceTache o4 = new OccurrenceTache(t, debut4, fin4, a);
		//System.out.println(p);
		//System.out.println(a);
		
		Dates debut3 = new Dates(2015, 3, 21, 4, 0);
		Dates fin3 = new Dates(2015, 3, 21, 6, 0); // trop tot
		OccurrenceTache o3 = new OccurrenceTache(t, debut3, fin3, a);
		//System.out.println(p);
		//System.out.println(a);
		
		Dates debut5 = new Dates(2015, 3, 23, 10, 0);
		Dates fin5 = new Dates(2015, 3, 23, 12, 0);
		OccurrenceTache o5 = new OccurrenceTache(t, debut5, fin5, a);
		//System.out.println(p);
		//System.out.println(a);
		
		Categorie cat2 = new Categorie("études", Couleur.Noir);
		Taches t2 = new Taches("réviser", cat2, new Dates(), new Dates(2015, 4, 1, 8, 0));
		t2.setDuree(3);
		Dates de1 = new Dates(2015, 3, 20, 17, 0);
		Dates fe1 = new Dates(2015, 3, 20, 19, 0);
		OccurrenceTache oe1 = new OccurrenceTache(t2, de1, fe1, a);
		
		// on a assez planifié ! Le suivant c'est juste pour tester quand on planifie trop
		
		Dates debut6 = new Dates(2015, 3, 23, 10, 0); // problème a traiter : ajouter deux fois l'occurrence à la même heure. (le 5 et le 6) traiter dans algo de tri ou ici ?
		Dates fin6 = new Dates(2015, 3, 23, 12, 0);
		OccurrenceTache o6 = new OccurrenceTache(t, debut6, fin6, a);
		
		Dates debut2 = new Dates(2000, 3, 20, 10, 0);
		Dates fin2 = new Dates(2000, 3, 20, 12, 0); // anterieur
		OccurrenceTache o2 = new OccurrenceTache(t, debut2, fin2, a);
		//System.out.println(p);
		//System.out.println(a);
		
		Dates de3 = new Dates(2015, 3, 22, 17, 0);
		Dates fe3 = new Dates(2015, 3, 22, 19, 0);
		OccurrenceTache oe3 = new OccurrenceTache(t2, de3, fe3, a);
		
		Dates de2 = new Dates(2015, 3, 21, 17, 0);
		Dates fe2 = new Dates(2015, 3, 21, 19, 0); // duree revisions nécessité dépassée (besoin 3h, obtiens 3*2h)
		OccurrenceTache oe2 = new OccurrenceTache(t2, de2, fe2, a);
		
		/* // test dates java : je met mars il me dit avril... Comme ça chez tout le monde ?
		Date dateJava = new Date();
		dateJava.setYear(115);
		dateJava.setMonth(3);
		dateJava.setDate(10);
		dateJava.setHours(10);
		dateJava.setMinutes(0);
		System.out.println(dateJava);*/
		/*for (int i=0 ; i<50 ; i++)
		{
			dateComp.setDate(dateComp.getDate()+1);
			System.out.print(a.apres(dateComp));
		}*/
		
		/*System.out.println(p);
		System.out.println(a);

		a.trier();
		
		System.out.println(a);
		
		// test fonction apres agenda
		Dates dateComp = new Dates(2015, 3, 24, 10, 0);
		System.out.println("\n\n" + a + "\n\n" + a.apres(dateComp) + "\n\n" + dateComp);*/
		
		Planificateur p = new Planificateur();
		Categorie cat = new Categorie("sport", Couleur.Rouge);
		
		// TEST TRI RAPIDE
		
		// création quelques taches
		Taches t1 = new Taches("vélo", cat, new Dates(2015, 1, 1, 8, 0), new Dates(2015, 10, 1, 8, 0));
		p.ajouterTache(t1);
		Taches t2 = new Taches("foot", cat, new Dates(2015, 1, 2, 15, 0), new Dates(2015, 10, 2, 15, 0));
		p.ajouterTache(t2);
		t2.setPrio(1);
		Taches t3 = new Taches("parapente", cat, new Dates(2015, 1, 4, 8, 0), new Dates(2015, 10, 4, 8, 0));
		p.ajouterTache(t3);
		t3.setPrio(3);
		Taches t4 = new Taches("jogging", cat, new Dates(2015, 1, 5, 17, 0), new Dates(2015, 10, 5, 17, 0));
		p.ajouterTache(t4);
		t4.setPrio(1);
		
		// tri quelques taches
		TabTaches petitTab = p.tabTaches();
		/*petitTab.triRapide (0, 3);
		for (int i=0 ; i<4 ; i++)
		{
			System.out.println(petitTab.get(i) + "\n" + petitTab.get(i).getPrio() + "\n");
		}*/
		
		// création taches réccurrentes
		t1.setRepetition(7);
		t2.setRepetition(7);
		t4.setRepetition(1);
		t1.setHeureDebRep(new Dates(2015, 1, 1, 8, 0));
		t2.setHeureDebRep(new Dates(2015, 1, 2, 15, 0));
		t4.setHeureDebRep(new Dates(2015, 1, 5, 17, 0));
		t1.setHeureFinRep(new Dates(2015, 1, 1, 10, 0));
		t2.setHeureFinRep(new Dates(2015, 1, 2, 17, 0));
		t4.setHeureFinRep(new Dates(2015, 1, 5, 18, 0));
		
		// test fonction planifier
		Agenda a = new Agenda();
		t3.setAplanifier(true);
		/*Dates daaate = new Dates(1000, 5, 5, 5, 5);
		Dates daaate2 = new Dates(999, 2, 2, 2, 2);
		System.out.println(daaate + "\n" + daaate2);*/
		p.planifier(a);
		
		System.out.println("\n\n" + p + "\n\n" + a + "\n\n");
		
		/* // test tri rapide sur quantité énorme de taches pour tester rapiditer
		TabTaches tabEnorme = new TabTaches(10000);
		Random r = new Random();
		for (int i=0 ; i<10000 ; i++)
		{
			tabEnorme.set(i, new Taches());
			tabEnorme.get(i).setPrio(1+r.nextInt(5));
		}
		System.out.println("\nAVANT TRI :\n");
		for (int i=0 ; i<10000 ; i++)
		{
			System.out.print(tabEnorme.get(i).getPrio());
		}
		System.out.println("\nAPRES TRI :\n");
		tabEnorme.triRapide (0, 9999);
		for (int i=0 ; i<10000 ; i++)
		{
			System.out.print(tabEnorme.get(i).getPrio());
		}
		System.out.println("\n");*/
    }
}
