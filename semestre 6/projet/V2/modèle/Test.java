//package modele;

import java.util.ArrayList;
import java.util.ListIterator;

public class Test
{
    public static void main(String [] args)
    {
    	// test dates
		Dates date = new Dates(2016, 4, 11, 10, 30);
		Dates date2 = new Dates(date);
		System.out.println(date + "\n" + date2 + "\n" + date.getHours());
		date.setDate(date.getDate()+40);
		System.out.println(date + " " + date.compareTo(date2) + " " + date.equals(date2));
		
		// test categories taches et planificateur
		Planificateur p = new Planificateur();
		Categorie cat = new Categorie("sport", Couleur.Rouge);
		Taches t = new Taches("vélo", cat, new Dates(), new Dates(2015, 10, 1, 8, 0));
		p.ajouterTache(t);
		System.out.println(p);
		
		// test occurrenceTache et agenda
		Agenda a = new Agenda();
		Dates debut1 = new Dates(2015, 3, 13, 10, 0);
		Dates fin1 = new Dates(2015, 3, 13, 12, 0);
		OccurrenceTache o1 = new OccurrenceTache(t, debut1, fin1, a);
		System.out.println(a);
		System.out.println(p); // Pour voir le changement de "déjà planifié"
		
		Dates debut2 = new Dates(2015, 3, 20, 10, 0);
		Dates fin2 = new Dates(2015, 3, 20, 12, 0);
		OccurrenceTache o2 = new OccurrenceTache(t, debut2, fin2, a);
		System.out.println(a);
		System.out.println(p);
		
		Dates debut3 = new Dates(2015, 3, 21, 10, 0);
		Dates fin3 = new Dates(2015, 3, 21, 12, 0);
		OccurrenceTache o3 = new OccurrenceTache(t, debut3, fin3, a);
		System.out.println(a);
		System.out.println(p);
		
		Dates debut4 = new Dates(2015, 3, 22, 10, 0);
		Dates fin4 = new Dates(2015, 3, 22, 12, 0);
		OccurrenceTache o4 = new OccurrenceTache(t, debut4, fin4, a);
		System.out.println(a);
		System.out.println(p);
		
		Dates debut5 = new Dates(2015, 3, 23, 10, 0);
		Dates fin5 = new Dates(2015, 3, 23, 12, 0);
		OccurrenceTache o5 = new OccurrenceTache(t, debut5, fin5, a);
		System.out.println(a);
		System.out.println(p);
		
		// on a assez planifié ! Le suivant c'est juste pour tester quand on planifie trop
		
		Dates debut6 = new Dates(2015, 3, 23, 10, 0);
		Dates fin6 = new Dates(2015, 3, 23, 12, 0);
		OccurrenceTache o6 = new OccurrenceTache(t, debut6, fin6, a);
		System.out.println(a);
		System.out.println(p);
    }
}