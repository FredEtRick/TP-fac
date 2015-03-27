//package modele;

import java.util.Date;

public class Taches{ // spécialiser en TacheReccurrente, TacheMemo, et TacheAPlanifier ?
    private String NomTache;
    private int prio;
    private Categorie categ;
    private String Desp;
    private Date Date_Deb;
    private Date Date_Fin;
    private int duree;
    private boolean aplanifier;
    private int repetition;
    private Date heureDebRep; // AJOUT utile pour les taches réccurrentes, pour savoir quand commencer la réccurrence
    private Date heureFinRep;
    private Taches tacheMere; // pas encore implémenté, rajouté car le prof avait demandé à ce qu'on permette une filiation entre les taches (sous taches etc)... Il avait aussi demandé classe Projet mais j'ai pas fait. Tout ça gardé comme amélioration pour plus tard une fois le noyau fonctionnel peut être ?
    private int heureDeb; // l'heure la plus tôt à laquelle on peut travailler dessus (ex : pas avant 8h du mat)
    private int heureFin; // heure la plus tard ...
    private int planifie; // nombre d'heures déjà planifiées (pour comparer avec temps total)
    
	/*// rajouté car le prof avait demandé à ce qu'on puisse spécifier une durée min max etc pour chaque tache
	private int travailHebdo;
	private int dureeMin;
	private int dureeMax;
	private int intervalle;*/

    public Taches()
    {
		NomTache = "";
		prio = 5;
		categ = new Categorie();
		Desp = "";
		Date_Deb = new Date();
		Date_Fin = new Date();
		duree = 10;
		aplanifier = false;
		repetition = 0;
		tacheMere = null;
		heureDeb = 8;
		heureFin = 22;
		planifie = 0;
		/*travailHebdo = 15;
		dureeMin = 1;
		dureeMax = 4;
		intervalle = 5;*/
    }
    
    public Taches(String n, Categorie c, Date d, Date f)
    {
		NomTache = n;
		categ = new Categorie(c);
		Date_Deb = (Date) d.clone();
		Date_Fin = (Date) f.clone();
		prio = 5;
		Desp = "";
		duree = 10;
		aplanifier = false;
		repetition = 0;
		tacheMere = null;
		heureDeb = 8;
		heureFin = 22;
		planifie = 0;
		/*travailHebdo = 15;
		dureeMin = 1;
		dureeMax = 4;
		intervalle = 5;*/
    }
    
    public boolean planifie()
    {
    	if (planifie != duree)
    	{
	    	if (planifie < duree)
	    	{
	    		System.out.println(duree + " " + planifie);
	    		System.out.println("pas encore planifié !");
	    	}
	   		else
	   			System.out.println("'trop' planifié !");
    		return false;
    	}
   		else
   			return true;
    }

    public String getNomTache(){return NomTache;}
    public int getPrio(){return prio;}
    public Categorie getCateg(){return categ;}
    public String getDesp(){return Desp;}
    public Date getDate_Deb(){return Date_Deb;}
    public Date getDate_Fin(){return Date_Fin;}
    public int getDuree(){return duree;}
    public boolean getAplanifier(){return aplanifier;}
    public int getRepetition(){return repetition;}
    public Date getHeureDebRep(){return heureDebRep;}
    public Date getHeureFinRep(){return heureFinRep;}
    public Taches getTacheMere(){return tacheMere;}
    public int getHeureDeb(){return heureDeb;}
    public int getHeureFin(){return heureFin;}
    public int getPlanifie(){return planifie;}
/*	public int getTravailHebdo(){return travailHebdo;}
	public int getDureeMin(){return dureeMin;}
	public int getDureeMax(){return dureeMax;}
	public int getIntervalle(){return intervalle;}*/

    public void setNomTache(String n){NomTache = n;}
    public void setPrio(int p){prio = p;}
    public void setCateg(Categorie c){categ = new Categorie(c);}
    public void setDesp(String s){Desp = s;}
    public void setDate_Deb(Date d){Date_Deb = (Date) d.clone();}
    public void setDate_Fin(Date f){Date_Fin = (Date) f.clone();}
    public void setDuree(int d){duree = d;}
    public void setAplanifier(boolean ap){aplanifier = ap;}
    public void setRepetition(int r){repetition = r;}
    public void setHeureDebRep(Date deb){heureDebRep = deb;}
    public void setHeureFinRep(Date fin){heureFinRep = fin;}
    public void setTacheMere(Taches t){this.tacheMere = t;}
    public void setHeureDeb(int deb){this.heureDeb = deb;}
    public void setHeureFin(int fin){this.heureFin = fin;}
    public void setPlanifie(int p){this.planifie = p;}
/*	public void setTravailHebdo(int travailHebdo){this.travailHebdo = travailHebdo;}
	public void setDureeMin(int dureeMin){this.dureeMin = dureeMin;}
	public void setDureeMax(int dureeMax){this.dureeMax = dureeMax;}
	public void setIntervalle(int intervalle){this.intervalle = intervalle;}*/

    public String toString(){
	return "Nom de la tache : "+this.NomTache+"\nCategorie : "+this.categ+"\nDate Debut : "+this.Date_Deb+"\nDate Fin : "+this.Date_Fin + "\nduree : " + this.duree + "h.\ndéjà planifié : " + this.planifie + "h.";
    }
}
