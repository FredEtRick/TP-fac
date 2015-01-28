/**
 * \file automate_nd.h
 * \brief Declaration  des  fonctions a implémenté.
 * \author Mohand  MAMMA
 * \date De  la derniere  mise  a  jour :17 decembre 2014
 *
 * Declarations  des  fonctions  nécessaire  a  l'implémentation  de la  bibliothéque automate non_deterministe
 *
 */
#ifndef AUTOMATE_ND_H_INCLUDED
#define AUTOMATE_ND_H_INCLUDED
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "structure_nd.h"


/* Les  Etat
***************************************
*/
/**
 * \fn ajouter_nouvel_etat(automate_nd A,Etat destination,int statue);
 *
 * \brief Fonction d'ajout  d'un  etat  dans un  automate  indeterministe.
 *
 * \param A:automate auquel  tu  vas  ajouter  l'etat
 * \param destination:etat  de destination
 * \param statue:type  de l'etat soit(initial,final,ou normal)
 * \return ajout  d'un  etat de  type  statue  dans  l'automate A
 */
void ajouter_nouvel_etat(automate_nd A,Etat destination,int statue);
/**
 * \fn ajouter_etat(automate_nd A);
 *
 * \brief Fonction d'ajout  d'un  etat  dans un  automate  indeterministe.
 *
 * \param A:automate auquel  tu  vas  ajouter  l'etat
 *
 * \return ajout  d'un  etat  dans  l'automate A
 */
void ajouter_etat(automate_nd A);
/**
 * \fn void supprimer_etat(automate_nd A,Etat e);
 *
 * \brief Fonction de suppression  d'un etat  dans  un automate
 * \param A:automate auquel tu va enlever  l'etat  e
 * \param e:l'etat  a supprimer

 * \return supprimer un  etat  e  de l'automate A
 */
void supprimer_etat(automate_nd A,Etat e);
/**
 * \fn int exist_etat(automate_nd A,Etat e);
 *
 * \brief verification  de l'existance  de l'etat  e  dans  l'automate A
 * \param A:automate dans le  quel  tu  veux  verifier
 * \param e:l'etat  a verifier

 */
int exist_etat(automate_nd A,Etat e);
/**
 * \fn Etat etat_prochain(automate_nd A,char a,Etat etatCourant);
 *
 * \brief Recherche de l'etat  prochain
 * \param A:l'automate sur lequel  on  travaille
 * \param e:l'etat  courant
 * \param a:l'etiquette de  la  transition
 * \return 1 si l'etat  e  existe  dans  A ,0 Sinon
 */
Etat etat_prochain(automate_nd A,char a,Etat etatCourant);
/**
 * \fn Etat etat_initial(automate_nd A);
 *
 * \brief Recherche  de l'etat  initial
 * \param A:automate dans le  quel  tu  veux  verifier

 * \return l'etat  initial de  A
 */
Etat etat_initial(automate_nd A);



/*Les Transition
***************************************
*/
/**
 * \fn ajouter_nouvel_transition(automate_nd A,Etat depart,Etat arrive,Alphabet b);
 *
 * \brief Fonction d'ajout  d'une  transition  dans un  automate  indeterministe.
 *
 * \param A:automate courant
 * \param depart: l'etat  de  depart
 * \param arrive: l'etat  de  destination
 * \param b:l'etiquette de la  transition

 * \return ajout  d'une  transition d'etiquette b  dans  l'automate A
 */
void ajouter_nouvel_transition(automate_nd A,Etat depart,Etat arrive,Alphabet b);
/**
 * \fn void ajouter_transition(automate_nd A);
 *
 * \brief Fonction  d'ajout  d'une  transition  dans un automate A
 *
 * \param A:automate courant
 * \return ajout  d'une  transition
 */
void ajouter_transition(automate_nd A);
/**
 * \fn void supprimer_transition(automate_nd A,char delta);
 *
 * \brief Fonction de suppression  d'une transition
 *
 * \param A:automate courant
 * \param delta:l'etiquette de la  transition

 * \return supprimer  une transition
 */

void supprimer_transition(automate_nd A,char delta);

/*Divers
**************************************
*/

/**
 * \fn void affichage_type_etats();
 *
 * \brief Fonction D'Affichage des  différents  types d'etats
 *
 * \return liste  des  différent types  d'etats
 */

void affichage_type_etats();
/**
 * \fn automate_nd automate_creer();
 *
 * \brief Constructeur d'automate  indéterministe
 *
 * \return un  etat indéterministe
 */
automate_nd automate_creer();
/**
 * \fn automate_nd automate_creer_nouvel(liste_alphabet a,liste_etats e,liste_etats f,Etat i,liste_transitions l);
 *
 * \brief Constructeur  d'un  automate  indéterministe avec paramétre
 *
 * \param a:Liste  de l'alphabet
 * \param e:liste  des  etats
 * \param f:liste  des  etat  finaux
 * \param i:etat  initial

 * \return automate indeterministe
 */
automate_nd automate_creer_nouvel(liste_alphabet a,liste_etats e,liste_etats f,Etat i,liste_transitions l);
/**
 * \fn void automate_nd_detruire(automate_nd A);
 *
 * \brief Destructeur  d'automate
 *
 * \param A:autoamte  a  détruire

 * \return destruction  d'un automate
 */
void automate_nd_detruire(automate_nd A);

/**
 * \fn automate_nd automate_nd_clone(automate_nd A);
 *
 * \brief Clonage  d'automate
 *
 * \param A:autoamte  a Cloner

 * \return Un  automate  indéterministe
 */
automate_nd automate_nd_clone(automate_nd A);
/**
 * \fn int est_non_deterministe(automate_nd A,Etat etatdebut,Alphabet e);

 *
 * \brief Verifie  si  l'automate  est  indéterministe
 *
 * \param A:l'automate  courant
 * \param etatdebut:Etat de depart  de l'automate  a  verifier
 * \param Alphabet

 * \return 0 si il  est  non_deterministe,1 sinon
 */
int est_non_deterministe(automate_nd A,Etat etatdebut,Alphabet e);

#endif // AUTOMATE_ND_H_INCLUDED
