/****************************************************************************
 *                                                                          *
 *                            Standard Library                              *
 *                                Langages                                  *
 *                                TCCP2014                                  *
 *                             Jean-luc BARAT                               *
 *                                                                          *
 ****************************************************************************/

#ifndef LANGAGE_H
#define LANGAGE_H

/**
 * Structure langage.
 */
struct {
	ensemble mot;
} langage;

/**
 * Construit un nouveau langage.
 * 
 * \return pointeur sur langage
 */
langage langage_constructeur();

/**
 * Construit un nouveau langage à partir d'un langage L existant.
 * 
 * \param L langage
 * \return pointeur sur langage
 */
langage langage_copie(langage L);

/**
 * Vérifie si le langage L1 est égale au langage L2.
 * 
 * \param L1 langage
 * \param L2 langage
 * \return 1 si L1 est égale à L2, 0 sinon.
 */
int langage_egaux(langage L1, langage L2);

/**
 * Ajoute un mot m au langage L.
 * 
 * \param L langage sur lequel ajouter le mot.
 * \param m mot à ajouter
 */
void langage_ajouter_mot(langage L, char* m);

/**
 * Detruit le langage L.
 * 
 * \param L langage à détruire.
 */
void langage_destructeur(langage L);

/**
 * 
 * 
 * 
 */

#endif /* LANGAGE_H */

