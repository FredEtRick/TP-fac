

public class TabOcc // sert à y définir des méthodes particulières
{
	// attribut TabOcc de OccurrenceTache
	private OccurrenceTache[] tab;
	
	// méthodes basiques
	public TabOcc(int taille)
	{
		tab = new OccurrenceTache[taille];
	}
	public TabOcc(TabOcc t)
	{
		tab = new OccurrenceTache[t.taille()];
		for (int i=0 ; i<t.taille() ; i++)
		{
			tab[i] = new OccurrenceTache(t.get(i));
		}
		//tab = t.getTab();
	}
	public int taille()
	{
		return tab.length;
	}
	public OccurrenceTache[] getTab()
	{
		return tab;
	}
	public OccurrenceTache get(int i)
	{
		return tab[i];
	}
	public void set(int i, OccurrenceTache o)
	{
		tab[i] = o;
	}
	public String toString()
	{
		String s = "\n=====================\nELEMENTS DU TabOcc :\n=====================\n\n";
		for (OccurrenceTache o : tab)
			s += o.toString() + "\n\n";
		s += "=====================\nFIN AFFICHAGE TabOcc\n=====================\n\n";
		return s;
	}
	
	// tri rapide
	public void echanger (/*OccurrenceTache[] tab, */int i, int j)
	{
		OccurrenceTache tmp = get(i);
		set(i, get(j));
		set(j, tmp);
	}
	public int partition (/*OccurrenceTache[] tab, */int deb, int fin)
	{
		OccurrenceTache dernier = get(fin);
		int milTri = deb-1;
		for (int finTri=deb ; finTri<fin ; finTri++)
		{
			if (get(finTri).getHeureDeb().before(dernier.getHeureDeb()))
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
}