//package modele;

import java.util.*;

public class Agenda
{
	// attributs : liste d'occurences de taches
	private ArrayList<OccurrenceTache> listeOccurrences;
	
	// méthodes classiques
	public Agenda()
	{
		listeOccurrences = new ArrayList<OccurrenceTache>();
	}
	public ArrayList<OccurrenceTache> getlisteOccurrences()
	{
		return listeOccurrences;
	}
	public void ajouterOccurrence (OccurrenceTache occurrence)
	{
		listeOccurrences.add(occurrence);
	}
	public void supprimerOccurrence (int index)
	{
		OccurrenceTache occurrence = listeOccurrences.get(index - 1);
		int duree = occurrence.getDuree();
		Taches tache = occurrence.getTache();
		int planifie = tache.getPlanifie();
		tache.setPlanifie(planifie-duree);
		listeOccurrences.remove(index - 1);
	}
	public OccurrenceTache getOccurrence(int index)
	{
		return listeOccurrences.get(index - 1);
	}
	public String toString()
	{
		ListIterator li = listeOccurrences.listIterator();
		int i = 1;
		String s = "=====================\nLISTE DES OCCURRENCES :\n=====================\n\n";
		while (li.hasNext())
		{
			s += ("occurrence " + i + " :\n\n" + li.next() + "\n\n");
			i++;
		}
		s += "=====================\nFIN AFFICHAGE OCCURRENCES\n=====================\n\n";
		return s;
	}
	
	// création d'un TabOcc à partir de la liste (pour trier facilement)
	public TabOcc tabOcc ()
	{
		TabOcc tab = new TabOcc(listeOccurrences.size());
		ListIterator li = listeOccurrences.listIterator();
		int i = 0;
		while (li.hasNext())
		{
			tab.set(i, (OccurrenceTache) li.next());
			i++;
		}
		return tab;
	}
	
	// tri des occurrences (pour regarder où il reste une place)
	public void trier()
	{
		TabOcc tab = tabOcc();
		tab.triRapide(0, tab.taille()-1);
		listeOccurrences = new ArrayList<OccurrenceTache>();
		for (int i=0 ; i<tab.taille() ; i++)
		{
			ajouterOccurrence(tab.get(i));
		}
	}
	
	// recherche de l'indice de l'occurrence suivant une certaine date
	public int apres(Dates d)
	{
		if (listeOccurrences.size() == 0)
			return -1; // -1 = pas encore d'occurrences
		else if (listeOccurrences.size() == 1)
		{
			if (listeOccurrences.get(0).getHeureFin().before(d))
			{
				System.out.println("premier -2");
				return -2; // -2 = après toute occurrence
			}
			else
			{
				System.out.println("premier 0");
				return 0; // c'est pas un code particulier, ça veut dire "la 'case' 0"
			}
		}
		else if (listeOccurrences.get(0).getHeureFin().after(d))
		{
			System.out.println("deuxième 0");
			return 0;
		}
		else if (listeOccurrences.get(listeOccurrences.size()-1).getHeureFin().before(d))
		{
			System.out.println("deuxième -2");
			return -2;
		}
		else
		{
			int bas = 0;
			int haut = listeOccurrences.size()-1;
			int milieu;
			int rang = -1;  
			do
			{ 
				milieu = (bas + haut) / 2;
				/*if (milieu == 0) // plus moyen de me souvenir pourquoi j'ai fait ça
				{
					System.out.println("troisième 0");
					return 0;
				}
				else*/ if (listeOccurrences.get(milieu).getHeureFin().after(d) && listeOccurrences.get(milieu-1).getHeureFin().before(d)) // l'occurrence milieu est la première à succéder d, ou est pendant d
					return milieu; 
				else if (listeOccurrences.get(milieu).getHeureFin().before(d))
				{
					System.out.println(bas + " " + milieu + " " + haut);
					bas = milieu + 1;
				}
				else
					haut = milieu-1; 
			} 
			while (bas <= haut);
			System.out.println("problème : occurrence après date non trouvée");
			return -3;
		}
	}
}