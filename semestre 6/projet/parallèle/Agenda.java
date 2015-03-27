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
	public Agenda(ArrayList<OccurrenceTache> listeOccurrences)
	{
		this.listeOccurrences = listeOccurrences;
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
		OccurrenceTache occurrence = listeOccurrences.get(index); // avant index-1 mais je vois pas pourquoi...
		int duree = occurrence.getDuree();
		Taches tache = occurrence.getTache();
		int planifie = tache.getPlanifie();
		tache.setPlanifie(planifie-duree);
		listeOccurrences.remove(index - 1);
	}
	public OccurrenceTache getOccurrence(int index)
	{
		return listeOccurrences.get(index); // avant index-1 mais je vois pas pourquoi...
	}
	public void setOccurrence(int i, OccurrenceTache o)
	{
		listeOccurrences.set(i, o);
	}
	public int taille()
	{
		return listeOccurrences.size();
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
	
	// tri rapide
	public void echanger (/*OccurrenceTache[] tab, */int i, int j)
	{
		OccurrenceTache tmp = getOccurrence(i);
		setOccurrence(i, getOccurrence(j));
		setOccurrence(j, tmp);
	}
	public int partition (/*OccurrenceTache[] tab, */int deb, int fin)
	{
		OccurrenceTache dernier = getOccurrence(fin);
		int milTri = deb-1;
		for (int finTri=deb ; finTri<fin ; finTri++)
		{
			if (getOccurrence(finTri).getHeureDeb().before(dernier.getHeureDeb()))
			{
				milTri++;
				echanger(/*tab, */milTri, finTri);
			}
		}
		echanger (/*tab, */milTri+1, fin);
		return milTri+1;
	}
	public void triRapide (/*OccurrenceTache[] tab, */int deb, int fin) // à appeler une première fois avec deb=1 et fin=longueurTab
	{
		if (deb < fin)
		{
			int pivot = partition (/*tab, */deb, fin);
			triRapide (/*tab, */deb, pivot-1);
			triRapide (/*tab, */pivot+1, fin);
		}
	}
	public void trier()
	{
		triRapide(0, taille()-1);
	}
	
	// recherche de l'indice de l'occurrence suivant une certaine date
	public int apres(Date d)
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
