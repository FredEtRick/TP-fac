//package modele;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.Serializable;

public class Dates extends Date implements Serializable
{
	// hérite de year month date (jour) hours et minutes
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
		super (annee-1900, mois, jour); // -1900 car Date démarre de l'an 1900, donc si on retire pas 1900 il faut tapper 115 pour 2015
	}
	public Dates(int annee, int mois, int jour, int heure, int minutes)
	{
		super (annee-1900, mois, jour, heure, minutes);
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
	public int getAnnee() // EN FRANCAIS pour l'année, en anglais pour le reste. Car je n'ai changé que l'année.
	{
		return this.getYear()+1900;
	}
	public void setAnnee(int annee)
	{
		this.setYear(annee + 1900);
	}
}