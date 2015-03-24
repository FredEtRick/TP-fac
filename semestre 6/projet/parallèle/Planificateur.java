//package modele;

import java.util.ArrayList;
import java.util.ListIterator;
import java.lang.Thread;
import java.lang.InterruptedException;
import java.util.Random;

public class Planificateur
{
	// attribut : liste de taches aisément redimensionnable (juste pour tester sans BDD mais pas utile avec)
	private ArrayList<Taches> listeTaches;
	
	// méthodes basiques
	public Planificateur()
	{
		listeTaches = new ArrayList<Taches>();
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
		listeTaches.remove(index - 1);
	}
	public Taches getTache(int index)
	{
		return listeTaches.get(index - 1);
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
	
	// création d'un TabTaches à partir de la liste (pour trier facilement)
	public TabTaches tabTaches ()
	{
		TabTaches tab = new TabTaches(listeTaches.size());
		ListIterator li = listeTaches.listIterator();
		int i = 0;
		while (li.hasNext())
		{
			tab.set(i, (Taches) li.next());
			i++;
		}
		return tab;
	}
	
	public Dates placerJ (Dates deb, Dates fin) // choisit une date entre les deux bornes aléatoirement. Abandon de l'ancienne méthode beaucoup trop buggée.
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
					date = r.nextInt(28) + 1; // je compte pas les années bissextiles pour l'instant... Trop long !
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
				date = r.nextInt(28) + 1; // je compte pas les années bissextiles pour l'instant... Trop long !
			else
				date = r.nextInt(31) + 1;
			hours = r.nextInt(24);
			minutes = r.nextInt(4)*15; // pour avoir des heures à peu prés carrées, callées sur des quarts d'heures
		}
		return new Dates(year, month, date, hours, minutes);
	}
	
	// version PAS OPTIMALE DU TOUT, CECI N'EST PAS LA VERSION FINALE ! Elle est très lente et loin d'être parfaite. J'avais fait une version un peu mieux mais elle est buggée.
	public void planifier (/*TabTaches tab, */Agenda a) // note : agenda c'est juste pour les tests, avec la BDD il n'y en aura surement pas besoin mais sans c'est utile pour les tests
	{
		System.out.println("\n\n1\n\n");
		TabTaches tab = tabTaches();
		tab.triRapide(0, tab.taille()-1);
		a.trier();
		for (int i=0 ; i<tab.taille() ; i++)
		{
			System.out.println("\n\n2\n\n");
			Taches tache = tab.get(i);
			if ((tache.getRepetition() == 0) && tache.getAplanifier()) // sinon s'il y a une répétition, pas besoin de créer une occurrence (il en faudrait une infinité de toute façon) car on peut afficher dans l'agenda direct avec un calcul sur les propriétés
			{
				System.out.println("\n\n3\n\n");
				int duree = tache.getDuree();
				int min = tache.getDureeMin();
				int max = tache.getDureeMax();
				int nombre = (int) (((float) duree / (float) min) + 1);
				Dates deb = new Dates(tache.getDate_Deb());
				Dates fin = new Dates(tache.getDate_Fin());
				Dates lapse = new Dates(fin.creerDuree(deb)); // durée de la période allant de la date limite à la date de commencement
				Dates pas = new Dates(lapse.diviserDuree(nombre)); // pas approximatif devant séparer deux occurrences
				System.out.println("\n lapse : " + lapse + "\npas : " + pas);
				Dates j = placerJ(deb, fin); // endroit où on veut placer l'occurrence je crois
				int apres = a.apres(j); // stockera l'indice de l'occurrence d'agenda suivant j.
				// Dates dureeMinDate = new Dates(0, 0, 0, tache.getDureeMin(), 0); marche pas : Date refuse de construire une date antérieure à l'an 2
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
					Dates jFin = new Dates(j);
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
					else// if (apres == -1) // aucune occurrence dans l'agenda. Dans ce cas, juste besoin de regarder les taches réccurrentes.
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
							if (t.getRepetition() > 0) // si l'événement est récurrent
							{
								System.out.println("\n\n8\n\n");
								System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
								Dates heureDebRep = new Dates(t.getHeureDebRep());
								Dates heureFinRep = new Dates(t.getHeureFinRep());
								int rep = t.getRepetition();
								Dates avantJ = new Dates(j);
								//j.setHours(j.getHours()-t.getDuree()); je sais plus pourquoi j'avais fait ça mais c'est bizarre...
								if (heureDebRep.after(jFin))
								{
									System.out.println("\n\n9\n\n"); // cette tache a répétition n'est pas génante. Mais peut être que d'autres le sont.
									System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
								}
								else if (heureDebRep.after(avantJ)) // la répétition commence plus tot que j + la duree de la tache a placer, mais pas assez tot pour que sa première occurrence n'ait le temps de finir
								{
									System.out.println("\n\n10\n\n");
									System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
									System.out.println("heureDebRep : " + heureDebRep + "\nfin : " + fin + "\nj : " + j + "\njFin : " + jFin + "\n");
									j = placerJ(deb, fin);
									changer = true; // on en a trouvé une génante, on réésaie avec une date ultérieure
								}
								else // la première occurrence de la tache qui se répète est avant l'endroit où on veut placer la tache "tache"
								{ // il faut donc vérifier si la date qui sépare le début de la répétition de la date ou on veut placer tache est un multiple de l'intervalle de répétition
									System.out.println("\n\n11\n\n");
									System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
									Dates j2 = new Dates(j);
									int joursEcart = 0;
									while (j2.getYear() > heureDebRep.getYear() || j2.getMonth() > heureDebRep.getMonth() || j2.getDate() > heureDebRep.getDate())
									{
										System.out.println("\n\n12\n\n");
										System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
										j2.setDate(j2.getDate()-1);
										joursEcart++;
										System.out.println("\njoursEcart : " + joursEcart + "\nj2 : " + j2 + "\nheureDebRep : " + heureDebRep + "\n");
									}
									if ((joursEcart % rep) == 0)
									{
										System.out.println("\n\n13\n\n");
										System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
										if (j2.after(heureDebRep))
										{
											System.out.println("\n\n14\n\n");
											System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
											if (heureFinRep.after(j2))
											{
												System.out.println("\n\n15\n\n");
												System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
												j = placerJ(deb, fin);
												System.out.println("\nAAAAAAAAAAAA heureFinRep.soustraire(j2) : " + heureFinRep.soustraire(j2) + " AAAAAAAAAAAAA\n");
												changer = true;
											} // sinon c'est bon on y touche pas
										}
										else
										{
											System.out.println("\n\n16\n\n");
											System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
											if (jFin.after(heureDebRep))
											{
												System.out.println("\n\n17\n\n");
												System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\n");
												j = placerJ(deb, fin);
												changer = true;
											}
										}
									}
									// pas de else : c'est pas génant si la réccurrence ne tombe pas sur la date
								}
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
						jFin = new Dates(j);
						jFin.setHours(jFin.getHours()+min);
						OccurrenceTache o = new OccurrenceTache(tache, j, jFin, a); // PLUS TARD, essayer de planifier le plus long possible
						System.out.println(a);
						j = placerJ(deb, fin); // on va chercher plus loin pour placer la prochaine occurrence
						jFin = new Dates(j);
						jFin.setHours(jFin.getHours()+min);
						System.out.println("\nj : " + j + "\njFin : " + jFin + "\nchanger : " + changer + "\npas : " + pas + "\nj.additionnerDuree(pas) : " + j.additionnerDuree(pas) + "\n");
					}
				}
			}
		}
	}
}