/**
 * \file grammaire.c
 * \brief Structure de donnée et fonctions relatives aux grammaires.
 * \author Pierre-Louis Latour & Simon Galand
*/
#ifndef GRAMMAIRE_H
#define GRAMMAIRE_H
/**
 * \struct Grammaire
 * \brief La structure grammaire comporte les alphabets d'entrée et
 auxiliaire, l'axiome, les productions ainsi que les nombres d'éléments.
 */
typedef struct Grammaire
{
    int nbElementaE, nbElementaA, nbElementProd;
    char** alphabetEntree;      // minuscules uniquement ex: a, b, c...
    char** alphabetAuxiliaire;     // majuscules uniquement ex: S, T, U
    char* axiome;           // par convention ce sera S
    char** productions;             // de la forme S --> aSb
} Grammaire;

/**
 * \fn Grammaire Grammaire_creer(int nbaE, int nbaA, int nbProd, char** aE, char** aA, char* aX, char** prod)
 * \brief Constructeur de Grammaire.
 * \param nbaE Entier correspondant au nombre de lettres de l'aphabet d'entrée.
 * \param nbaA Entier correspondant au nombre de lettres de l'aphabet auxiliaire.
 * \param nbProd Entier correspondant au nombre de règles de production.
 * \param aE Tableau de chaînes de caractères contenant l'alphabet d'entrée.
 * \param aA Tableau de chaînes de caractères contenant l'alphabet auxiliaire.
 * \param aX Chaîne de caractère correspondant à l'axiome.
 * \param prod Tableau de chaines de caractères contenant les règles de production.
 * \return Grammaire créée à l'aide des différents paramètres d'entrée.
*/
Grammaire Grammaire_creer(int nbaE, int nbaA, int nbProd, char** aE, char** aA, char* aX, char** prod);

/**
 * \fn int Grammaire_detruire(Grammaire G)
 * \brief Destructeur de grammaire.
 * \param G La grammaire que l'on cherche à détruire.
 * \return Retourne 0 si la grammaire a bien été détruite.
*/
int Grammaire_detruire(Grammaire G);

/**
 * \fn Grammaire Grammaire_clone(const Grammaire G)
 * \brief Clone la Grammaire G et la renvoie (constructeur par recopie).
 * \param G La grammaire que l'on veut cloner.
 * \return Retourne la grammaire clonée.
*/
Grammaire Grammaire_clone(const Grammaire G);

/**
 * \fn int Grammaire_egal(Grammaire G1, Grammaire G2)
 * \brief Teste l'égalité entre deux grammaire et retourne 1 si elle sont égales.
 Sinon la fonction retourne 0.
 * \param G1 La grammaire à comparer à G2 pour le test d'égalité.
 * \param G2 La grammaire à comparer à G1 pour le test d'égalité.
 * \return Entier égal à 1 si les grammaires sont égales, sinon égal à 0.
*/
int Grammaire_egal(Grammaire G1, Grammaire G2);

/**
 * \fn char* Grammaire_chaine(Grammaire G)
 * \brief Permet d'exprimer la grammaire sous forme d'un char* pour un affichage.
 * \param G La grammaire que l'on veut traduire en chaîne.
 * \return Char* contenant l'expression de la grammaire.
*/
char* Grammaire_chaine(Grammaire G);
#endif // GRAMMAIRE_H
