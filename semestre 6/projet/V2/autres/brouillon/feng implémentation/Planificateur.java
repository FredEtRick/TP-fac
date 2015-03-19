import java.util.ArrayList;
import java.util.ListIterator;

public class Planificateur
{
	private ArrayList<Taches> listeTaches;
	public Planificateur()
	{
		listeTaches = new ArrayList<Taches>();
	}
	public ArrayList<Taches> getlisteTaches()
	{
		return listeTaches;
	}
	public void ajouterTache (Taches tache)
	{
		listeTaches.add(tache);
	}
	public void supprimerTache (int index)
	{
		listeTaches.remove(index - 1);
	}
	public Taches getTache(int index)
	{
		return listeTaches.get(index - 1);
	}
	public String toString()
	{
		ListIterator li = listeTaches.listIterator();
		int i = 1;
		String s = "=====================\nLISTE DES TACHES :\n=====================\n\n";
		while (li.hasNext())
		{
			s += ("tache " + i + " :\n\n" + li.next() + "\n\n");
			i++;
		}
		s += "=====================\nFIN AFFICHAGE\n=====================\n\n";
		return s;
	}
}