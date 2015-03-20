//package modele; fait bugger donc commenté momentanément

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.Serializable;

public class Dates extends Date implements Serializable
{
	// hérite des attributs year month date (jour) hours et minutes de la classe Date
	// getteurs et setteurs aussi
	// gestion des ajouts de jours etc (limite à 30 pour les jours...)
	// compareTo(date) renvoie 1 si this est après date, 0 si en même temps, -1 si this est avant date
	// before(date) after(date) et equals(date) renvoient des booléens

	public Dates()
	{
		super ();
	}
	public Dates(int annee, int mois, int jour)
	{
		super (annee-1900, mois, jour); // -1900 car Date de java démarre de l'an 1900, donc si on retire pas 1900 il faut tapper 115 pour 2015
	}
	public Dates(int annee, int mois, int jour, int heure, int minutes)
	{
		super (annee-1900, mois, jour, heure, minutes); // retirer 1 au moins car java ajoute 1 tout seul ? (je sais pas du tout pourquoi)
	}
	public Dates(Dates d)
	{
		this.setYear(d.getYear());
		this.setMonth(d.getMonth());
		this.setDate(d.getDate());
		this.setHours(d.getHours());
		this.setMinutes(d.getMinutes());
	}
	
	public String toString()
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String date = df.format(this);
		return date;
	}
	
	public Dates additionner(Dates date)
	{
		Dates d = new Dates();
		d.setYear(this.getYear()+date.getYear());
		d.setMonth(this.getMonth()+date.getMonth());
		d.setDate(this.getDate()+date.getDate());
		d.setHours(this.getHours()+date.getHours());
		d.setMinutes(this.getMinutes()+date.getMinutes());
		return d;
	}
	
	public Dates soustraire(Dates date)
	{
		Dates d = new Dates();
		d.setYear(this.getYear()-date.getYear());
		d.setMonth(this.getMonth()-date.getMonth());
		d.setDate(this.getDate()-date.getDate());
		d.setHours(this.getHours()-date.getHours());
		d.setMinutes(this.getMinutes()-date.getMinutes());
		return d;
	}
	
	public Dates creerDuree(Dates date) // comme soustraire mais avec 3 ans en plus car java peut apparemment pas descendre trop bas dans les dates, du coup pour pas perdre la précision on rajoute 3 ans d'office avant de calculer la durée, puis quand on ajoute la durée il faudra enlever ces 3 ans
	{
		Dates marge = new Dates(3, 0, 0, 0, 0);
		Dates d = new Dates(this.additionner(marge));
		d = new Dates(d.soustraire(date));
		return d;
	}
	
	public Dates additionnerDuree(Dates date) // ajoute une duree (petite date, tranche de temps) a une date (grosse)
	{
		Dates marge = new Dates(3, 0, 0, 0, 0);
		Dates d = new Dates(this.additionner(date));
		d = new Dates(d.soustraire(marge));
		return d;
	}
	
	public Dates soustraireDuree(Dates date) // retire une duree (petite date, tranche de temps) a une date (grosse)
	{
		Dates marge = new Dates(3, 0, 0, 0, 0);
		Dates d = new Dates(this.soustraire(date));
		d = new Dates(d.additionner(marge));
		return d;
	}
	
	public Dates diviserDuree(int n) // Divise une duree (this en l'occurrence). Pas tout a fait correcte, amélioration en cours
	{
		Dates d = new Dates(this);
		d.setYear(d.getYear()*n); // pour pas que la division la fasse passer en dessous de 3 ans pour respecter la marge
		d = new Dates (d.diviser(n));
		int nombre = d.getYear()-3;
		nombre = (int) ((double) nombre / (double) n);
		nombre = nombre + 3;
		d.setYear(nombre);
		return d; // d est toujours une durée !
	}
	
	/*public int convertirMinutes() // pas bon encore, juste reflexion. Servira a diviser plus facilement des dates.
	{
		Dates date = new Dates(this);
		date.setYear(date.getYear()+70);
		return (date.getTime() / 60000);
	}
	
	public Dates diviser(int n) // pas bon encore
	{
		Dates d = new Dates();
		d.setYear(this.getYear() / n);
		int anneesMois = (int) (((double) this.getYear() / (double) n) * 12);
		/*int anneesJours = (int) (((double) this.getYear() / (double) n) * 12);
		int anneesHeures = (int) (((double) this.getYear() / (double) n) * 12);
		int anneesMinutes = (int) (((double) this.getYear() / (double) n) * 12);*/ /*
		d.setMonth(this.getMonth() / n + anneesMois);
		
		d.setDate(this.getDate() / n);
		d.setHours(this.getHours() / n);
		d.setMinutes(this.getMinutes() / n);
		return d;
	}*/
	
	public Dates diviser(int n) // pas tout a fait correcte, amélioration en cours
	{
		Dates d = new Dates();
		d.setYear((int) ((double) this.getYear() / (double) n));
		d.setMonth((int) ((double) this.getMonth() / (double) n));
		d.setDate((int) ((double) this.getDate() / (double) n));
		d.setHours((int) ((double) this.getHours() / (double) n));
		d.setMinutes((int) ((double) this.getMinutes() / (double) n));
		return d;
	}
	
	public int getYear(){return super.getYear()+1900;}
	public void setYear(int annee){super.setYear(annee-1900);}
}