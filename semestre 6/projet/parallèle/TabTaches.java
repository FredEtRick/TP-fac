

public class TabTaches // sert à y définir des méthodes particulières
{
	// attribut TabTaches de taches
	private Taches[] tab;
	
	// méthodes basiques
	public TabTaches(int taille)
	{
		tab = new Taches[taille];
	}
	public TabTaches(TabTaches t)
	{
		tab = new Taches[t.taille()];
		for (int i=0 ; i<t.taille() ; i++)
		{
			tab[i] = t.get(i);
		}
		//tab = t.getTab();
	}
	public int taille()
	{
		return tab.length;
	}
	public Taches[] getTab()
	{
		return tab;
	}
	public Taches get(int i)
	{
		return tab[i];
	}
	public void set(int i, Taches t)
	{
		tab[i] = t;
	}
	public String toString()
	{
		String s = "\n=====================\nELEMENTS DU TabTaches :\n=====================\n\n";
		for (Taches t : tab)
			s += t.toString() + "\n\n";
		s += "=====================\nFIN AFFICHAGE TabTaches\n=====================\n\n";
		return s;
	}
	
	// tri rapide
	public void echanger (/*Taches[] tab, */int i, int j)
	{
		Taches tmp = get(i);
		set(i, get(j));
		set(j, tmp);
	}
	public int partition (/*Taches[] tab, */int deb, int fin)
	{
		Taches dernier = get(fin);
		int milTri = deb-1;
		for (int finTri=deb ; finTri<fin ; finTri++)
		{
			if (get(finTri).getPrio() <= dernier.getPrio())
			{
				milTri++;
				echanger(/*tab, */milTri, finTri);
			}
		}
		echanger (/*tab, */milTri+1, fin);
		return milTri+1;
	}
	public void triRapide (/*Taches[] tab, */int deb, int fin) // à appeler une première fois avec deb=1 et fin=longueurTab
	{
		if (deb < fin)
		{
			int pivot = partition (/*tab, */deb, fin);
			triRapide (/*tab, */deb, pivot-1);
			triRapide (/*tab, */pivot+1, fin);
		}
	}
}