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
		Dates tot = new Dates(debut.getYear(), debut.getMonth(), debut.getDate(), debut.getHours()+t.getDureeMin(), debut.getMinutes()); // calcul la date qui sert de borne inférieur pour accepter la date fin
		Dates tard = new Dates(debut.getYear(), debut.getMonth(), debut.getDate(), debut.getHours()+t.getDureeMax(), debut.getMinutes()); // borne supérieur
		boolean tropCourt = fin.before(tot); // dure pas assez longtemps
		boolean tropLong = fin.after(tard); // dure trop longtemps
		boolean tropTot = (debut.getHours() < t.getHeureDeb()); // planifié à une date où on ne peut pas encore travailler dessus
		boolean tropTard = (fin.getHours() > t.getHeureFin()); // date où on ne peut plus travailler dessus
		boolean anterieur = (debut.before(t.getDate_Deb()));
		boolean posterieur = (fin.after(t.getDate_Fin()));
		if (tropCourt || tropLong || tropTot || tropTard || anterieur || posterieur)
		{
			if (tropCourt)
				System.out.println("trop court");
			if (tropLong)
				System.out.println("trop long");
			if (tropTot)
				System.out.println("trop tot");
			if (tropTard)
				System.out.println("trop tard");
			if (anterieur)
				System.out.println("date de début antiérieur à la période dans laquelle on peut travailler");
			if (posterieur)
				System.out.println("date de fin postérieur à la période au delà de laquelle on doit avoir fini");
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
	public Dates getHeureDeb(){return heureDeb;}
	public Dates getHeureFin(){return heureFin;}
	public int getDuree(){return duree;}
	
	public void setTache(Taches t){tache = t;}
	public void setHeureDeb(Dates deb){heureDeb = deb;}
	public void setHeureFin(Dates fin){heureFin = fin;}
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