public class Taches{
    private String NomTache;
    private int prio;
    private Categorie categ;
    private String Desp;
    private Date Date_Deb;
    private Date Date_Fin;
    private Horaire horaire;
    private int duree;
    private boolean aplanifier;
    private int repetition;
    private Taches tacheMere;


    public Taches()
    {
		NomTache = "";
		prio = 0;
		categ = new Categorie();
		Desp = "";
		Date_Deb = new Date();
		Date_Fin = new Date();
		horaire = new Horaire();
		duree = 0;
		aplanifier = false;
		repetition = 0;
		tacheMere = null;
    }
    
    public Taches(String n,Categorie c,Date d,Date f, Horaire h)
    {
		NomTache = n;
		categ = new Categorie(c);
		Date_Deb = new Date(d);
		Date_Fin = new Date(f);
		horaire = h;
    }

    public String getNomTache(){return NomTache;}
    public int getPrio(){return prio;}
    public Categorie getCateg(){return categ;}
    public String getDesp(){return Desp;}
    public Date getDate_Deb(){return Date_Deb;}
    public Date getDate_Fin(){return Date_Fin;}
    public int getDuree(){return duree;}
    public int getRepetition(){return repetition;}

    public void setNomTache(String n){NomTache = n;}
    public void setPrio(int p){prio = p;}
    public void setCateg(Categorie c){categ = new Categorie(c);}
    public void setDesp(String s){Desp = s;}
    public void setDate_Deb(Date d){Date_Deb = new Date(d);}
    public void setDate_Fin(Date f){Date_Fin = new Date(f);}
    public void setDuree(int d){duree = d;}
    public void setRepetition(int r){repetition = r;}

    public String toString(){
	return "Nom de la tache : "+this.NomTache+"\nCategorie : "+this.categ+"\nDate Debut : "+this.Date_Deb+"\nDate Fin : "+this.Date_Fin+
	"\nHoraire :\n"+this.horaire;
    }
}