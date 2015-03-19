package Modéle;

import java.util.Date;

public class Taches {

	private String nom; 
	private Categorie categorie;
	private String description; 
	private int prioritee; 
	
	private Date date_deb; 
	private Date date_fin; 
	private int duree;  // En  minutes 
	private Horraire heure_deb;
	private Horraire heure_fin; 
	
	private boolean aplanifie; 
	private int repetition; 
	
	
	///////Constructeur////////

	public  Taches(){
	}
	public Taches(String n,Categorie c,int p,int d){
		nom=n; 
		categorie=c; 
		prioritee=p; 
		duree=d; 
	}
	
	//////getters//////////
	public String getNom(){
		return nom; 
	}
	public Categorie getCatégorie(){
		return categorie; 
	}
	public String getDescription(){
		return description; 
	}
	public int getPriorité(){
		return prioritee ; 
	}
	public Date getDatedeb(){
		return date_deb;
	}
	 public Date getDateFin(){
			return date_fin; 
		}
	public Horraire getHeureDeb(){
			return heure_deb; 
		}
	public  Horraire getHeureFin(){
		return heure_fin;
	}
	public boolean getAplanifie(){
			return aplanifie; 
		}	

	
	
	}




