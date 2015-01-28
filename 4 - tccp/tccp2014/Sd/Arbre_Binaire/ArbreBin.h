/**
 * \file ArbreBin.h
 * \brief En tete arbre binaire
 * \author Ongaro.Y - Lacombe.F
 * \date 7 decembre 2014
 *
 * Definition des differentes structures representant l'arbre binaire
 *
 */

#ifndef ARBREBIN_H
#define ARBREBIN_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * \enum TYPE
 * \brief Constantes definissant un type.
 *
 * Cette enumeration permet de definir le type de donnees qui seront
 * stockees dans l'arbre.
 */

typedef enum{
  FLOAT,INT,CHAR,STRING,OTHER
} TYPE;

/**
 * \struct noeud
 * \brief Un noeud de l'arbre.
 *
 * Cette structure opaque pour l'utilisateur represente les noeuds de l'arbre cree. Elle contient des
 * pointeurs vers d'autres structures noeud (ses fils) ainsi qu'un pointeur
 * generique vers sa cle.
 */

typedef struct{
  struct noeud* G; /*!<Pointeur vers un noeud : le fils gauche de ce noeud.*/
  struct noeud* D; /*!<Pointeur vers un noeud : le fils droit de ce noeud.*/
  void* cle; /*!<Pointeur generique vers la cle contenue dans le noeud*/
} noeud;

/**
 * \struct ArbreBin
 * \brief L'arbre et ses informations.
 *
 * C'est cette structure sert d'enveloppe, elle est directement manipulee par
 * l'utilisateur. Elle contient la racine de l'arbre ainsi que le type de
 * donnees vers laquelle la cle que chaque noeud pointera (1 seul type de donnee par
 * arbre). Elle contient egalement des pointeurs vers des fonctions qui ne sont
 * utilisees que dans le cas ou l'arbre contiendra des types de donnees personnalisees
 * (structures,tableaux) : Un pointeur vers une fonction permettant d'afficher ce qui
 * est pointe par la cle des noeuds et un pointeur vers une fonction de comparaison
 * permettant de tester l'egalitee entre deux objets pointes par deux cles.
 * La fonction de suppression del est facultative, elle permet de desallouer la zone memoire
 * pointee par la cle de chaque noeud lors de la destruction de l'arbre.
 * Cette fonction n'est basiquement constituee que d'un free() et n'est a remplir
 * que si la cle pointe vers une zone memoire allouee dynamiquement (malloc/calloc).
 */

typedef struct{
  TYPE type; /*!<Le type de donnee pointe par la cle des noeud.*/
  noeud* racine; /*!<Pointeur vers un noeud qui est la racine de l'arbre.*/
  void (*affichage)(void*);/*!<Pointeur vers une fonction d'affichage.*/
  int (*compareto)(void*,void*); /*!<Pointeur vers une fonction de comparaison.*/
  void (*del)(void*); /*!<Pointeur vers une fonction de suppression qui sera utilisee sur la cle de chaque noeud.*/
} ArbreBin;


noeud* Noeud_creer(void*);
ArbreBin* ArbreBin_creer(TYPE,void (*aff)(void*),int (*cmp)(void*,void*),void (*suppr)(void*));
void Noeud_ajout(noeud*,void*);
void ArbreBin_ajouter(ArbreBin*,void*);
void SArbreBin_chaine(ArbreBin*,noeud*);
void ArbreBin_chaine(ArbreBin*);
void SArbreBin_supprimer(ArbreBin*,noeud*);
void ArbreBin_supprimer(ArbreBin*);
void SArbreBin_clone(noeud*,noeud*);
ArbreBin* ArbreBin_clone(ArbreBin*);
int SArbreBin_compare(noeud*,noeud*,ArbreBin*);
int ArbreBin_compare(ArbreBin*,ArbreBin*);
#endif
