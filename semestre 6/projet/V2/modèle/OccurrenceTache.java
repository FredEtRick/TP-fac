//package modele;

public class OccurrenceTache
{
	private Taches tache;
	private Dates heureDeb;
	private Dates heureFin;
	private int duree;
	public OccurrenceTache()
	{
		tache = null;
		heureDeb = new Dates();
		heureFin = new Dates();
	}
	public OccurrenceTache(Taches t)
	{
		tache = t;
		heureDeb = new Dates();
		heureFin = new Dates();
	}
	public OccurrenceTache(Taches t, Dates debut, Dates fin, Agenda a)
	{
		Dates tot = new Dates(debut.getAnnee(), debut.getMonth(), debut.getDate(), debut.getHours()+t.getDureeMin(), debut.getMinutes());
		Dates tard = new Dates(debut.getAnnee(), debut.getMonth(), debut.getDate(), debut.getHours()+t.getDureeMax(), debut.getMinutes());
		boolean tropCourt = fin.before(tot);
		boolean tropLong = fin.after(tard);
		boolean tropTot = (debut.getHours() < t.getHeureDeb());
		boolean tropTard = (fin.getHours() > t.getHeureFin());
		if (tropCourt || tropLong || tropTot || tropTard)
		{
			if (tropCourt)
			{
				System.out.println("trop court");
			}
			if (tropLong)
			{
				System.out.println("trop long");
			}
			if (tropTot)
			{
				System.out.println("trop tot");
			}
			if (tropTard)
			{
				System.out.println("trop tard");
			}
		}
		else
		{
			this.tache = t;
			this.heureDeb = debut;
			this.heureFin = fin;
			int val = tache.getPlanifie();
			int difference = heureFin.getHours()-heureDeb.getHours();
			while (val+difference > tache.getDuree())
			{
				heureFin.setHours(heureFin.getHours()-1);
				difference = heureFin.getHours()-heureDeb.getHours();
			}
			tache.setPlanifie(val + difference);
			this.duree = difference;
			if (this.duree > 0)
				a.ajouterOccurrence(this);
			else
				System.out.println("ATTENTION : duree occurrence inférieur à 0 !!! Sans doutes avez vous assez planifié.");
		}
	}
	
	public Taches getTache(){return tache;}
	public void setTache(Taches t){tache = t;}
	public Dates getHeureDeb(){return heureDeb;}
	public void setHeureDeb(Dates deb){heureDeb = deb;}
	public Dates getHeureFin(){return heureFin;}
	public void setHeureFin(Dates fin){heureFin = fin;}
	public int getDuree(){return duree;}
	public void setDuree(int duree){this.duree = duree;}
	
	public String toString()
	{
		String s = "tache de l'occurrence : " + tache.getNomTache();
		s += "\nheure de début : " + heureDeb;
		s += "\nheure de fin : " + heureFin;
		s += "\nduree : " + duree;
		return s;
	}
}