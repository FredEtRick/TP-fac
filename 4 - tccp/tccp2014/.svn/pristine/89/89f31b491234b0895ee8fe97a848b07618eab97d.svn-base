/**
 * \file structure_nd.h
 * \brief Declaration  des  structure utilisé  pour implémenter  la bibliothéque
 * \author Mohand  MAMMA
 * \date De  la derniere  mise  a  jour :17 decembre 2014
 *
 * Declarations  des  structures   nécessaire  a  l'implémentation  de la  bibliothéque automate non_deterministe
 *
 */
#ifndef STRUCTURE_ND_H_INCLUDED
#define STRUCTURE_ND_H_INCLUDED
#include <stdio.h>
#include <stdlib.h>

//Maccros
#define NON_ETAT -1
#define ETAT_INIT 0
#define ETAT_NORMAL 1
#define ETAT_FINAL 2
#define ETAT_INITFINAL 3

#define Etat int
#define Alphabet char


/**
 * \struct alphabet
 * \brief liste_alphabet qui  nous permet  de gerer  les  differente
 * lettre a utiliser  pour  nos  transitions
 */
//Etat
typedef struct alphabet{
char Lettre;
struct alphabet *suivant;
}*liste_alphabet;
/**
 * \struct liste_etats
 *
 */
typedef struct etat{
char id;
int statue;
struct etat *etatSuivant;
}*liste_etats;
/**
 * \struct liste_transitions
 *
 */
typedef struct transition{
    Etat depart;
    char delta;
    Etat arrive;
    struct transition *suivant;
}*liste_transitions;

/**
 * \struct automate_nd
 *
 */
typedef struct automate_nd{
    liste_alphabet L;
    liste_etats E;
    liste_etats F;
    liste_transitions T;
    Etat I;
}*automate_nd;


#endif // STRUCTURE_ND_H_INCLUDED
