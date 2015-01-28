#ifndef ABR__H
#define ABR__H
/**
 *\file abr.h
 *\brief Structure de données générique Arbre Binaire de Recherche
 *\author Daniel Antunes
 */

#include <stdio.h>
#include <stdlib.h>

typedef void * objet;

typedef struct noeud * noeud;

/**
 *\author Daniel Antunes
 *\struct noeud
 *\brief Structure noeud contenant la valeur de l'objet, la clé
 *		 et des pointeur sur le père du noeud, NULL pour la racine de l'arbre
 *		 et les enfants du noeud, fils gauche filsG et fils droit filsD
 */

struct noeud
{
	objet cle;
	noeud pere;
	noeud filsG;
	noeud filsD;
};

/**
 *\author Daniel Antunes
 *\struct abr_struct
 *\brief Structure abr_struct représentant les ABR avec comme attribut un pointeur 
 * 		 sur un noeud, la racine
 */

struct abr_struct
{
	noeud racine;
}typedef abr;

/**
 * \fn abr * abr_creer();
 * \brief Crée un ABR sans paramètres.
 * \author Daniel Antunes
 * \return Renvoie un pointeur sur une instance de la structure abr_struct.
 */

abr * abr_creer();

/**
 * \fn void abr_detruire(abr *);
 * \brief Détruit un ABR pointé en paramètre.
 * \author Daniel Antunes
 * \return Renvoie un pointeur sur l'instance de la structure abr_struct qui vient d'être crée.
 */

void abr_detruire(abr *);

/**
 * \fn abr * abr_clone(abr);
 * \brief Crée un ABR par copie.
 * \author Daniel Antunes
 * \param abr une instance de la structure abr_struct que l'on veut copier.
 * \return Renvoie un pointeur sur l'instance de la structure abr_struct qui vient d'être crée.
 */

abr * abr_clone(abr);

/**
 * \fn noeud abr_creer_noeud(objet);
 * \brief Crée un noeud.
 * \author Daniel Antunes
 * \param objet, la valeur à donner au noeud.
 * \return Renvoie un pointeur sur l'instance de la structure noeud qui vient d'être crée.
 */

noeud abr_creer_noeud(objet);

/**
 * \fn void abr_detruire_noeud(noeud);
 * \brief Détruit un noeud.
 * \author Daniel Antunes
 * \param noeud, un pointeur sur l'instance de la structure noeud qu'on veut détruire.
 */

void abr_detruire_noeud(noeud);

/**
 * \fn void abr_detruire_branche(noeud);
 * \brief Détruit une branche d'un arbre (un noeud, plus tous les noeuds déscendants de ce dernier).
 * \author Daniel Antunes
 * \param noeud,  un pointeur sur l'instance de la structure noeud représentant la racine de la branche.
 */

void abr_detruire_branche(noeud);

/**
 * \fn noeud abr_rechercher(noeud,objet);
 * \brief Recherche d'un noeud dans un arbre.
 * \author Daniel Antunes
 * \param noeud, la racine, pointeur sur un noeud, de l'arbre dans lequel on cherche.
 * \param objet, la valeur du noeud que l'on cherche.
 * \return Renvoie un pointeur sur l'instance de la structure noeud qu'on cherche si il est présent dans l'arbre, NULL sinon.
 */

noeud abr_rechercher(noeud,objet);

/**
 * \fn noeud abr_minimum(noeud);
 * \brief Recherche du minimum d'un arbre.
 * \author Daniel Antunes
 * \param noeud, la racine, pointeur sur un noeud, de l'arbre dans lequel on cherche.
 * \return Renvoie un pointeur sur l'instance de la structure noeud qu'on cherche (noeud minimum), NULL si l'arbre est vide.
 */

noeud abr_minimum(noeud);

/**
 * \fn noeud abr_maximum(noeud);
 * \brief Recherche du maximum d'un arbre.
 * \author Daniel Antunes
 * \param noeud, la racine, pointeur sur un noeud, de l'arbre dans lequel on cherche.
 * \return Renvoie un pointeur sur l'instance de la structure noeud qu'on cherche (noeud maximum), NULL si l'arbre est vide.
 */

noeud abr_maximum(noeud);

/**
 * \fn noeud abr_predecesseur(noeud);
 * \brief Recherche du prédécesseur d'un noeud.
 * \author Daniel Antunes
 * \param noeud, pointeur sur un noeud de l'arbre duquel on cherche le prédécesseur.
 * \return Renvoie un pointeur sur l'instance de la structure noeud qui contient le prédécesseur cherché, NULL le noeud passé en paramètre est le plus petit de l'arbre.
 */

noeud abr_predecesseur(noeud);

/**
 * \fn noeud abr_successeur(noeud);
 * \brief Recherche du successeur d'un noeud.
 * \author Daniel Antunes
 * \param noeud, pointeur sur un noeud de l'arbre duquel on cherche le successeur.
 * \return Renvoie un pointeur sur l'instance de la structure noeud qui contient le successeur cherché, NULL le noeud passé en paramètre est le plus grand de l'arbre.
 */

noeud abr_successeur(noeud);

/**
 * \fn void abr_inserer(abr*,objet);
 * \brief Insertion d'un noeud dans un arbre, respectant les règles de définition des ABR.
 * \author Daniel Antunes
 * \param abr*, pointeur sur un arbre dans lequel on veut insérer une valeure.
 * \param objet, valeure à insérer dans l'arbre.
 */

void abr_inserer(abr*,objet);

/**
 * \fn void abr_supprimer(abr*,noeud);
 * \brief Suppression d'un noeud dans un arbre, respectant les règles de définition des ABR.
 * \author Daniel Antunes
 * \param abr*, pointeur sur un arbre dans lequel on veut supprimer un noeud.
 * \param noeud, pointeur sur un noeud de l'arbre, que l'on souhaite supprimer.
 */

void abr_supprimer(abr*,noeud);

#endif
