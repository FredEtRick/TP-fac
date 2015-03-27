//package modele;

import java.util.ArrayList;
import java.util.ListIterator;
import java.lang.Thread;
import java.lang.InterruptedException;
import java.util.Random;
import java.util.Date;

public class Planificateur
{
	// attribut : liste de taches aisément redimensionnable (juste pour tester sans BDD mais pas utile avec)
	private ArrayList<Taches> listeTaches;
	
	// méthodes basiques
	public Planificateur()
	{
		listeTaches = new ArrayList<Taches>();
	}
	public Planificateur(ArrayList<Taches> listeTaches)
	{
		this.listeTaches = listeTaches;
	}
	public ArrayList<Taches> getListeTaches()
	{
		return listeTaches;
	}
	public void ajouterTache (Taches tache)
	{
		listeTaches.add(tache);
	}
	public void supprimerTache (int index)
	{
		listeTaches.remove(index/* - 1*/);
	}
	public Taches getTache(int index)
	{
		return listeTaches.get(index/* - 1*/);
	}
	public void setTache(int i, Taches t)
	{
		listeTaches.add(i, t);
	}
	public int getTaille()
	{
		return listeTaches.size();
	}
	public String toString()
	{
		ListIterator li = listeTaches.listIterator();
		int i = 1;
		String s = "=====================\nLISTE DES TACHES :\n=====================\n\n";
		while (li.hasNext())
		{
			s += ("tache " + i + " :\n\n" + li.next() + "\n\n");
			i++;
		}
		s += "=====================\nFIN AFFICHAGE TACHES\n=====================\n\n";
		return s;
	}
	
	public boolean bissextile(Date d)
	{
		return ((d.getYear()+1900) % 4 == 0 && ((d.getYear()+1900) % 100 != 0 || (d.getYear()+1900) % 400 == 0));
	}
	
	// tri rapide
	public void echanger (/*Taches[] tab, */int i, int j)
	{
		Taches tmp = getTache(i);
		setTache(i, getTache(j));
		setTache(j, tmp);
	}
	public int partition (/*Taches[] tab, */int deb, int fin)
	{
		Taches dernier = getTache(fin);
		int milTri = deb-1;
		for (int finTri=deb ; finTri<fin ; finTri++)
		{
			if (getTache(finTri).getPrio() <= dernier.getPrio())
			{
				milTri++;
				echanger(/*tab, */milTri, finTri);
			}
		}
		echanger (/*tab, */milTri+1, fin);
		return milTri+1;
	}
	public void triRapide (/*Taches[] tab, */int deb, int fin)
	{
		if (deb < fin)
		{
			int pivot = partition (/*tab, */deb, fin);
			triRapide (/*tab, */deb, pivot-1);
			triRapide (/*tab, */pivot+1, fin);
		}
	}
	public void trier()
	{
		triRapide(0, getTaille()-1);
	}
	
	public Date placerJ (Date deb, Date fin) // choisit une date entre les deux bornes aléatoirement. Abandon de l'ancienne méthode beaucoup trop buggée.
	{
		Random r = new Random();
		int year = deb.getYear() + r.nextInt((fin.getYear() + 1) - deb.getYear());
		int month;
		int date;
		int hours;
		int minutes;
		if (year == deb.getYear())
		{
			month = r.nextInt((12 - deb.getMonth()) + 1) + deb.getMonth();
			if (month == deb.getMonth())
			{
				if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
					date = r.nextInt((31 - deb.getDate()) + 1) + deb.getDate();
				else if (month==2)
					date = r.nextInt((28 - deb.getDate()) + 1) + deb.getDate();
				else
					date = r.nextInt((30 - deb.getDate()) + 1) + deb.getDate();
				if (date == deb.getDate())
				{
					hours = r.nextInt(24 - deb.getHours()) + deb.getHours();
					if (hours == deb.getHours())
					{
						minutes = (r.nextInt(4 - (deb.getMinutes() / 15)) + deb.getMinutes() / 15) * 15;
					}
					else
					{
						minutes = r.nextInt(4)*15; // pour avoir des heures à peu prés carrées, callées sur des quarts d'heures
					}
				}
				else
				{
					hours = r.nextInt(24);
					minutes = r.nextInt(4)*15; // pour avoir des heures à peu prés carrées, callées sur des quarts d'heures
				}
			}
			else
			{
				if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
					date = r.nextInt(31) + 1;
				else if (month==2)
				{
					if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
						date = r.nextInt(29) + 1;
					else
						date = r.nextInt(28) + 1;
				}
				else
					date = r.nextInt(31) + 1;
				hours = r.nextInt(24);
				minutes = r.nextInt(4)*15; // pour avoir des heures à peu prés carrées, callées sur des quarts d'heures
			}
		}
		else if (year == fin.getYear())
		{
			month = r.nextInt(fin.getMonth()) + 1;
			if (month == fin.getMonth())
			{
				date = r.nextInt(fin.getDate()) + 1;
				if (date == fin.getDate())
				{
					hours = r.nextInt(fin.getHours() + 1);
					if (hours == fin.getHours())
					{
						minutes = r.nextInt((fin.getMinutes()/15)+1)*15;
					}
					else
					{
						minutes = r.nextInt(4)*15;
					}
				}
				else
				{
					hours = r.nextInt(24);
					minutes = r.nextInt(4)*15; // pour avoir des heures à peu prés carrées, callées sur des quarts d'heures
				}
			}
			else
			{
				if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
					date = r.nextInt(31) + 1;
				else if (month==2)
					date = r.nextInt(28) + 1; // je compte pas les années bissextiles pour l'instant... Trop long !
				else
					date = r.nextInt(31) + 1;
				hours = r.nextInt(24);
				minutes = r.nextInt(4)*15; // pour avoir des heures à peu prés carrées, callées sur des quarts d'heures
			}
		}
		else
		{
			month = r.nextInt(12) + 1;
			if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
				date = r.nextInt(31) + 1;
			else if (month==2)
				if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
					date = r.nextInt(29) + 1;
				else
					date = r.nextInt(28) + 1;
			else
				date = r.nextInt(31) + 1;
			hours = r.nextInt(24);
			minutes = r.nextInt(4)*15; // pour avoir des heures à peu prés carrées, callées sur des quarts d'heures
		}
		return new Date(year, month, date, hours, minutes);
	}
	
	public boolean conflitRepetition(Date j, Date jFin, Date debutRepetition, Date finRepetition, int repetition) // regarde si la date à placer tombe en même temps que la répétition d'une tâche
	{
		boolean conflit = false;
		if (debutRepetition.after(jFin))
		{
			/*System.out.println("\n\n9\n\n"); // cette tache a répétition n'est pas génante. Mais peut être que d'autres le sont.
			System.out.println("\nj : " + j + "\njFin : " + jFin + "\n");*/
			conflit = false;
		}
		else if (finRepetition.after(j)) // la répétition commence plus tot que j + la duree de la tache a placer, mais pas assez tot pour que sa première occurrence n'ait le temps de finir
		{
			/*System.out.println("\n\n10\n\n");
			System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
			System.out.println("heureDebRep : " + heureDebRep + "\nfin : " + fin + "\nj : " + j + "\njFin : " + jFin + "\n");*/
			conflit = true; // on en a trouvé une génante, on réésaie avec une date ultérieure
		}
		else if (j.getHours() > debutRepetition.getHours() && j.getHours() < finRepetition.getHours() || debutRepetition.getHours() > j.getHours() && debutRepetition.getHours() < jFin.getHours()) // la première occurrence de la tache qui se répète est avant l'endroit où on veut placer la tache "tache", et on ne peut pas exclure un conflit en se basant sur les heures.
		{ // il faut donc vérifier si la date qui sépare le début de la répétition de la date ou on veut placer tache est un multiple de l'intervalle de répétition
			/*System.out.println("\n\n11\n\n");
			System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");*/
			Date j2 = (Date) j.clone();
			int joursEcart = 0;
			while (j2.getYear() > debutRepetition.getYear())
			{
				if (bissextile(j2))
				{
					j2.setYear(j2.getYear()-1);
					joursEcart += 366;
				}
				else
				{
					j2.setYear(j2.getYear()-1);
					joursEcart += 365;
				}
			}
			while (j2.getMonth() > debutRepetition.getMonth())
			{
				int moisPrecedent = j2.getMonth() - 1;
				if (moisPrecedent==1 || moisPrecedent==3 || moisPrecedent==5 || moisPrecedent==7 || moisPrecedent==8 || moisPrecedent==10 || moisPrecedent==12)
				{
					j2.setMonth(j2.getMonth()-1);
					joursEcart += 31;
				}
				else if (moisPrecedent==2)
				{
					if (bissextile(j2))
					{
						j2.setMonth(j2.getMonth()-1);
						joursEcart += 29;
					}
					else
					{
						j2.setMonth(j2.getMonth()-1);
						joursEcart += 28;
					}
				}
				else
				{
					j2.setMonth(j2.getMonth()-1);
					joursEcart += 30;
				}
			}
			while (j2.getMonth() < debutRepetition.getMonth())
			{
				int mois = j2.getMonth();
				if (mois==1 || mois==3 || mois==5 || mois==7 || mois==8 || mois==10 || mois==12)
				{
					j2.setMonth(j2.getMonth()+1);
					joursEcart -= 31;
				}
				else if (mois==2)
				{
					if (bissextile(j2))
					{
						j2.setMonth(j2.getMonth()+1);
						joursEcart -= 29;
					}
					else
					{
						j2.setMonth(j2.getMonth()+1);
						joursEcart -= 28;
					}
				}
				else
				{
					j2.setMonth(j2.getMonth()+1);
					joursEcart -= 30;
				}
			}
			if (j2.getDate() > debutRepetition.getDate())
				joursEcart += j2.getDate() - debutRepetition.getDate();
			else if (j2.getDate() < debutRepetition.getDate())
				joursEcart -= debutRepetition.getDate() - j2.getDate();
			/*System.out.println("\n\n12\n\n");
			System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
			j2.setDate(j2.getDate()-1);
			joursEcart++;
			System.out.println("\njoursEcart : " + joursEcart + "\nj2 : " + j2 + "\nheureDebRep : " + heureDebRep + "\n");*/
			if ((joursEcart % repetition) == 0)
			{
				conflit = true;
			}
			else
				conflit = false;
			// pas de else : c'est pas génant si la réccurrence ne tombe pas sur la date
		}
		return conflit;
	}
	
	/*- supprimer apres et chercher dans toutes les occurrences si une est déjà placée là où on veut mettre j
	- ou alors : garder apres (pour recherche en log(n)), mais modifier l'ajout d'occurrence pour la placer en log(n) là où il faut. Ou pas : moi j'utilise des listes, mais... Faisable en BDD ?
	- 2 : Sinon, l'algo récupère toutes les occurrences une première fois au début dans la BDD sous forme de liste, trie la liste juste une fois avec l'intermédiaire d'un tableau, puis après on peut faire des recherches dicho dans la liste puis ajouter de façon triée à la création d'occurrence directement dans la liste, puis, à la fin de l'algo, renvoyer la nouvelle liste triée à mettre dans la BDD
	- 5 : épurer encore planifier et le subdiviser en plein de méthodes
	*/
	
	// version PAS OPTIMALE DU TOUT, CECI N'EST PAS LA VERSION FINALE ! Elle est très lente et loin d'être parfaite. J'avais fait une version un peu mieux mais elle est buggée.
	public void planifier (Agenda a) // note : agenda c'est juste pour les tests, avec la BDD il n'y en aura surement pas besoin mais sans c'est utile pour les tests
	{
		System.out.println("\n\n1\n\n");
		trier();
		for (int i=0 ; i<getTaille() ; i++)
		{
			System.out.println("\n\n2\n\n");
			Taches tache = getTache(i);
			if ((tache.getRepetition() == 0) && tache.getAplanifier()) // sinon s'il y a une répétition, pas besoin de créer une occurrence (il en faudrait une infinité de toute façon) car on peut afficher dans l'agenda direct avec un calcul sur les propriétés
			{
				System.out.println("\n\n3\n\n");
				int duree = tache.getDuree();
				int min = Parametres.getDureeMin();
				int max = Parametres.getDureeMax();
				Date deb = (Date) tache.getDate_Deb().clone();
				Date fin = (Date) tache.getDate_Fin().clone();
				Date j = placerJ(deb, fin); // endroit où on veut placer l'occurrence
				int apres = a.apres(j); // stockera l'indice de l'occurrence d'agenda suivant j.
				while (!tache.planifie())
				{
					apres = a.apres(j);
					System.out.println("\n\n4\n\n");
					a.trier();
					/*try
					{
						Thread.sleep(500);
					}
					catch (InterruptedException e)
					{
						System.out.println(e);
					}*/
					System.out.println("\nj : " + j + "\n");
					Date jFin = (Date) j.clone();
					jFin.setHours(jFin.getHours()+min);
					boolean changer = false;
					if (jFin.after(fin)) // on cherche a planifier à la fin du temps imparti
					{
						System.out.println("\n\n5\n\n");
						System.out.println("\nj : " + j + "\njFin : " + jFin + "\n");
						System.out.println("deb : " + deb + "\nfin : " + fin + "\nj : " + j + "\njFin : " + jFin + "\n");
						j = placerJ(deb, fin); // on réinitialise la date
						changer = true;
					}
					else
					{
						System.out.println("\n\n6\n\n");
						System.out.println("\nj : " + j + "\njFin : " + jFin + "\n");
						ListIterator li = listeTaches.listIterator();
						int k = 0;
						while (li.hasNext() && !changer) // while dans while dans for, risque d'être très couteux en complexité (même si deuxième while est pas très couteux), reflechir à comment réduire
						{
							System.out.println("\n\n7\n\n");
							System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
							Taches t = (Taches) li.next();
							if ((t.getRepetition() > 0) && conflitRepetition(j, jFin, t.getHeureDebRep(), t.getHeureFinRep(), t.getRepetition())) // si l'événement est récurrent et que j tombe dans une des répétitions de t
							{
								j = placerJ(deb, fin);
								changer = true;
							}
						}
						System.out.println("APRES !!!!!!!!!!!!!!!!!!!!! EHUTMUHEMIUGHEIMUHGPIUEHGE : " + apres);
						if (apres < 0 && !changer)
						{
							System.out.println("\n\n17\n\n");
							System.out.println("après < 0"); // c'est bon
						}
						else if (!changer && a.getOccurrence(apres).getHeureDeb().before(jFin)) // l'endroit où on souhaite placer l'occurrence est déjà pris par une autre
						{
							System.out.println("\n\n18\n\n");
							j = placerJ(deb, fin);
							//j.setDate(j.getDate()+1); // pas justifié mais juste pour faire un test
							changer = true;
						}
						// else : rien, c'est bon aussi
					}
					if (!changer) // aucune date récursive n'est embêtante et il n'y a aucune occurrence déjà planifiée donc on peut planifier ici
					{
						System.out.println("\n\n!!!!!!!!!19!!!!!!!!!!\n\n");
						System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
						System.out.println(a);
						jFin = (Date) j.clone();
						jFin.setHours(jFin.getHours()+min);
						int planifie = tache.getPlanifie();
						OccurrenceTache o = new OccurrenceTache(tache, j, jFin/*, a*/); // PLUS TARD, essayer de planifier le plus long possible
						if (tache.getPlanifie() > planifie)
							a.ajouterOccurrence(o); // ajouté pour adapter à la BDD
						System.out.println(a);
						j = placerJ(deb, fin); // on va chercher plus loin pour placer la prochaine occurrence
						jFin = (Date) j.clone();
						jFin.setHours(jFin.getHours()+min);
					}
				}
			}
		}
	}
}
