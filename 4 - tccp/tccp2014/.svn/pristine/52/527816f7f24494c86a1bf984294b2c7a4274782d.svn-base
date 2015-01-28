/**
 * \file boiteAlea.c
 * \brief Definition des fonctions sur BoiteAléa.
 * \author Barthélémy Antonin, Deng YongYan
 * \version 0.1
 * \date 09 décembre 2014
 *
 */

/**
 * @mainpage Projet: La boite aléatoire.

 *
 *Description de la bibliothèque : 
 
  BoiteAlea permet de stocker des Type dans une structure et d'y effectuer des 
  tirages sans remises. On notera que la compléxité d'un tirage est en O(1).
 *
 *
 *\author Barthélémy Antonin, Deng YongYan
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "boiteAlea.h"

/**
 * \fn BoiteAlea boiteAlea_creer()
 * \brief Constructeur de BoiteAlea.
 *
 * \return Un pointeur sur une instance de BoiteAlea
 */
BoiteAlea boiteAlea_creer()
{
  BoiteAlea box = malloc(sizeof(struct BoiteAlea));
  box->tableau  = NULL;
  box->tabTaille = 0;
  srand(time(NULL));
  return box;
}

/**
 * \fn BoiteAlea_creerParam(Type* tableau, int tabTaille)
 * \brief Constructeur paramétré de BoitAlea
 *
 * \param tableau un pointeur de Type, tabTaille un entier qui représente la taille du tableau 
 * \return Un pointeur sur une instance de BoiteAlea paramétré
 */
BoiteAlea boiteAlea_creerParam(Type* tableau, int tabTaille)
{
  BoiteAlea box = malloc(sizeof(struct BoiteAlea));
  box->tableau = tableau;
  box->tabTaille = tabTaille;
  srand(time(NULL));
  return box;
}

/**
 * \fn void boiteAlea_detruire(BoiteAlea box)
 * \brief Fonction de destruction de l'instance de BoiteAlea.
 *
 * \param box Instance de BoiteAlea
 */
void boiteAlea_detruire(BoiteAlea box)
{
  free(box->tableau);
  free(box);
}

/**
 * \fn void boiteAlea_afficher(BoiteAlea box)
 * \brief Fonction d'affichage de BoiteAlea
 *
 * \param box Instance de BoiteAlea
 */
void boiteAlea_afficher(BoiteAlea box)
{
  printf("{ ");
  for(int i=0;i<box->tabTaille;i++)
    {
      Affiche((Type)box->tableau[i]);
      i!=box->tabTaille-1? printf(","): printf(" }");//mange ma ternaire
    }
  printf(" --> size = %d\n",box->tabTaille);
}

/**
 * \fn BoiteAlea boiteAlea_cloner(BoiteAlea box)
 * \brief Constructeur par copie de BoiteAlea
 *
 * \param box Instance de BoiteAlea
 * \return box2 Une instance de BoiteAlea
 */
BoiteAlea boiteAlea_cloner(BoiteAlea box)
{
  BoiteAlea box2 = boiteAlea_creer();
  Type* tabtemp = malloc(box->tabTaille * sizeof(Type));
  for(int i=0;i<box->tabTaille;i++)
    {
      tabtemp[i]=box->tableau[i];
    }
  box2->tableau = tabtemp;
  box2->tabTaille = box->tabTaille;
  return box2;
}

/**
 * \fn void boiteAlea_ajouter(BoiteAlea box,Type t)
 * \brief Fonction d'ajout d'élément de BoiteAlea
 *
 * \param box Instance de BoiteAlea, t Instance de Type
 */
void boiteAlea_ajouter(BoiteAlea box,Type t)
{
  box->tabTaille++;
  Type* tabTemp = (Type*) realloc( box->tableau, (box->tabTaille)*sizeof(Type) );
  box->tableau = tabTemp;
  box->tableau[box->tabTaille - 1] = t;
}

/**
 * \fn Type boiteAlea_piocher(BoiteAlea box)
 * \brief Fonction de pioche dans la "boite"
 *
 * \param box Instance de BoiteAlea
 * \return t Le type pioché dans l'instance de BoiteAlea
 */
Type boiteAlea_piocher(BoiteAlea box)
{
  //Tirage d'un element
  int indexAlea =  rand() % box->tabTaille;
  Type t = NULL;
  if(box->tabTaille)
    {
      t=(Type) Clone(box->tableau[indexAlea]);
      
      //Echange element tiré et dernier 
      box->tableau[indexAlea] = (Type) Clone(box->tableau[box->tabTaille - 1]);
      
      //Realocation de la taille du tableau 
      box->tabTaille--;
      box->tableau = (Type*) realloc(box->tableau, (box->tabTaille*sizeof(Type)));
    }
  return t;
}

/**
 * \fn Type* boiteAlea_tirage(BoiteAlea box,int n)
 * \brief Fonction de pioche répété
 *
 * \param box Instance de BoiteAlea, n Nombre de tirage à effectuer
 * \return tab Un tableau constitué des tirage dans box 
 */
Type* boiteAlea_tirage(BoiteAlea box,int n)
{
  Type* tab = NULL;
  if(n<=box->tabTaille)
    {
      tab = malloc(sizeof(Type)*n);
      for(int i=0;i<n;i++)
	{
	  tab[i]=boiteAlea_piocher(box);
	}
      
    }
      return tab;
}


