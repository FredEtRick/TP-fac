//package modele; commenté car je l'ai rajouté en dernier mais ça fait bugger, j'essairai de bientôt résoudre le problème

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Date;
import java.util.Arrays;

public class Test
{
    public static void main(String [] args)
    {
		//Planificateur p = new Planificateur();
		Categorie cat = new Categorie("sport", Couleur.Rouge);
		
		// TEST TRI RAPIDE
		
		// création quelques taches
		Taches t1 = new Taches("vélo", cat, new Date(115, 1, 1, 8, 0), new Date(115, 10, 1, 8, 0));
		//p.ajouterTache(t1);
		Taches t2 = new Taches("foot", cat, new Date(115, 1, 2, 15, 0), new Date(115, 10, 2, 15, 0));
		//p.ajouterTache(t2);
		t2.setPrio(1);
		Taches t3 = new Taches("parapente", cat, new Date(115, 1, 4, 8, 0), new Date(115, 10, 4, 8, 0));
		//p.ajouterTache(t3);
		t3.setPrio(3);
		Taches t4 = new Taches("jogging", cat, new Date(115, 1, 5, 17, 0), new Date(115, 10, 5, 17, 0));
		//p.ajouterTache(t4);
		t4.setPrio(1);
		Taches t5 = new Taches("roller", cat, new Date(115, 2, 4, 8, 0), new Date(115, 2, 7, 22, 0));
		//p.ajouterTache(t5);
		t3.setPrio(3);
		Taches t6 = new Taches("wingsuit", cat, new Date(115, 1, 4, 8, 0), new Date(115, 10, 10, 8, 0));
		//p.ajouterTache(t6);
		Taches t7 = new Taches("ski", cat, new Date(115, 7, 4, 8, 45), new Date(115, 10, 4, 8, 0));
		//p.ajouterTache(t7);
		t3.setPrio(1);
		
		// création taches réccurrentes
		t1.setRepetition(7);
		t2.setRepetition(7);
		t4.setRepetition(1);
		t1.setHeureDebRep(new Date(115, 1, 1, 8, 0));
		t2.setHeureDebRep(new Date(115, 1, 2, 15, 0));
		t4.setHeureDebRep(new Date(115, 1, 5, 17, 0));
		t1.setHeureFinRep(new Date(115, 1, 1, 10, 0));
		t2.setHeureFinRep(new Date(115, 1, 2, 17, 0));
		t4.setHeureFinRep(new Date(115, 1, 5, 18, 0));
		
		// test fonction planifier
		//Agenda a = new Agenda();
		t3.setAplanifier(true);
		t5.setAplanifier(true);
		t6.setAplanifier(true);
		t7.setAplanifier(true);
		//p.planifier(a);

		OccurrenceTache o1 = new OccurrenceTache(t3, new Date(115, 2, 3, 10, 0), new Date(115, 2, 3, 12, 0));
		OccurrenceTache o2 = new OccurrenceTache(t3, new Date(115, 2, 5, 10, 0), new Date(115, 2, 5, 12, 0));
		OccurrenceTache o3 = new OccurrenceTache(t5, new Date(115, 2, 4, 10, 0), new Date(115, 2, 4, 12, 0));

		ArrayList<Taches> listeTaches = new ArrayList<Taches> (Arrays.asList(t1, t2, t3, t4, t5, t6, t7));
		Planificateur p = new Planificateur (listeTaches);
		ArrayList<OccurrenceTache> listeOccurrences = new ArrayList<OccurrenceTache> (Arrays.asList(o1, o2, o3));
		Agenda a = new Agenda(listeOccurrences);
		p.planifier(a);
		
		System.out.println("\n\n" + p + "\n\n" + a + "\n\n");
    }
}
