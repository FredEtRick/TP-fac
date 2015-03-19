import java.util.*;
public class Date // existe déjà dans java ?
    {
      
      private int heure,minute,jour,mois,annee;
     
	public Date(){}
      public Date(int heure,int minute,int jour, int mois, int annee)
      {
        this.heure  = heure;
        this.minute = minute;
        this.jour   = jour;
        this.mois   = mois;
        this.annee  = annee;
      }
	public Date(Date d){
	    this.heure = d.heure;
	    this.minute = d.minute;
	    this.jour = d.jour;
	    this.mois = d.mois;
	    this.annee = d.annee;
	}
      
      public int getHeure()  { return heure; }
      public int getMinute() { return minute; }
      public int getJour()   { return jour; }
      public int getMois()   { return mois; }
      public int getAnnee()  { return annee; }
      
      public String toString()
      {
        return heure + ":"
             + minute + " le "
             + jour + "/"
             + mois + "/"
             + annee;
      }
      
      public boolean identique(Date d)
      {
        return (   d.heure  == heure
                && d.minute == minute
                && d.jour   == jour
                && d.mois   == mois
                && d.annee  == annee);
      }
      
      public boolean avant(Date d)
      {
        if(annee<d.getAnnee())
          return true;
        else
          if(mois<d.getMois())
            return true;
          else
            if(jour<d.getJour())
              return true;
            else
              if(heure*60+minute<d.getHeure()*60+d.getMinute())
                return true;
              else
                return false;
      }
      
      public boolean apres(Date d)
      {
        return (!(avant(d) || identique(d)));
      }
      
      public boolean memeJour(Date d)
      {
        return (   d.jour   == jour
                && d.mois   == mois
                && d.annee  == annee);
      }
     
    }