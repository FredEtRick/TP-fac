#ifndef GRAPHE_H
#define GRAPHE_H

#include <stdio.h>
#include <stdlib.h>

/**
* \file graphe.h
* \version 0.1
* \author Nicolas Begin et Lilian Arroyo
* \date 10 décembre 2014
* \brief  Bibliothèque sur les graphes
*/

/**
 * \struct vector
 * \brief Objet reproduisant un vector c++.
 */
typedef struct
{
    int* elem;
    int taille;
    int nbElem;
} vector;
/**
 * \struct graphe
 * \brief Graphe par liste de voisins ou liste d'arêtes.
 */
typedef struct
{
    int nbP, nbA; 		//Nombre de points et d'arêtes
    int** coordP;
    int** aretes;
    int* comp;
    int** kruskal;		//Arbre correspond à l'algorithme de kruskal
    int dmax;
    vector* voisins;	//Tableau de vector pour lister les voisins
} graphe;

//fonctions de base pour créer le graphe, les composantes et les voisins
/**
    * \fn creer_graphe()
    * \brief Construit un graphe
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
graphe creer_graphe();
/**
    * \fn affichage(graphe)
    * \brief Affiche un graphe.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void affichage(graphe);
/**
    * \fn detruire_graphe(graphe)
    * \brief Détruit un graphe.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void detruire_graphe(graphe);
/**
    * \fn creer_voisins(graphe)
    * \brief creer un liste de voisins.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void creer_voisins(graphe);
/**
    * \fn creer_composantes(graphe)
    * \brief Creer une composante.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 01 avril 2014
    */
void creer_composantes(graphe);
/**
    * \fn afficheC(graphe)
    * \brief Affiche les composantes.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void afficheC(graphe);
/**
    * \fn tailleC(graphe)
    * \brief Affiche taille des composantes.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void tailleC(graphe);
/**
    * \fn distances(graphe)
    * \brief Calcule la distance entre 2 points d'une arête.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void distances(graphe);
/**
    * \fn afficheD(graphe)
    * \brief Affiche la distance entre les points.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void afficheD(graphe);


//Algorithmes majeurs des graphes avec la fonction pour les tracer en PostScript
/**
    * \fn tracage(graphe, double, double*, int*, FILE*)
    * \brief Trace .
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void tracage(graphe, double, double*, int*, FILE*);
/**
    * \fn kruskal(graphe)
    * \brief Algorithme de Kruskal.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void kruskal(graphe);
/**
    * \fn dijkstra(graphe)
    * \brief Algorithme de Dijkstra.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void dijkstra(graphe);
/**
    * \fn parcours_largeur(graphe)
    * \brief Algorithme de parcours en largeur.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void parcours_largeur(graphe);
/**
    * \fn parcours_profondeur(graphe)
    * \brief Algorithme de parcours en largeur.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void parcours_profondeur(graphe);
/**
    * \fn creer_vector()
    * \brief Creer un vector.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
vector creer_vector();
/**
    * \fn push(vector*, int);
    * \brief Ajoute un élément au vector.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void push(vector*, int);
/**
    * \fn pop(vector*)
    * \brief Retire un élément du vector.
    * \version 0.1
    * \author Nicolas Begin et Lilian Arroyo
    * \date 10 décembre 2014
    */
void pop(vector*);


#endif
