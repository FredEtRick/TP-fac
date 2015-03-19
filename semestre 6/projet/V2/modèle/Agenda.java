//package modele;

import java.util.*;

public class Agenda
{
	private ArrayList<OccurrenceTache> listeOccurrences;
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
}