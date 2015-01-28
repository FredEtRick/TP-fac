/**
* Structure représentant une chaîne de caractères.
* @author Lucas Chabalier - Lucas Roulette
* @version 1.0
*/

#ifndef CHAINE_H
#define CHAINE_H


#include "Entier.h"
#include "Car.h"

  /**
   * @typedef Définit le type chaine, composé de la longueur du tableau de car, et du tableau en lui-meme.
   */
  /*typedef char** chaine;*/
  typedef struct {
    char* tab;
    } chaine;

  /**
   * @fn Crée une chaine vide.
   * @param 
   * @return La chaine créee et prete à etre utilisée
   */
  chaine Chaine_creer();

  /**
   * @fn Désalloue la mémoire utilisée par le tableau et détruit la chaine.
   * @param c, la chaine à détruire.
   * @return 0 si la destruction s'est déroulée normalement
 1 si il y a eu un problème.
   */
  int Chaine_detruire(chaine c);

  /**
   * @fn Clone une chaine à partir d'une chaine déjà existante.
   * @param c, la chaine à cloner.
   * @return Une chaine qui aura les memes valeurs que c.
   */
  chaine Chaine_clone(chaine c);

  /**
   * @fn Vérifie si deux chaines sont identiques
   * @param Deux chaine c1 et c2
   * @return Valeur booléenne : 1 si c1 et c2 sont identiques, 0 sinon.
   */
  int Chaine_egal(chaine c1, chaine c2);

  /**
   * @fn Décrit la chaine.
   * @param c, la chaine à décrire.
   * @return une chaine, contenant les valeurs dans la chaine c.
   */
  chaine Chaine_Chaine(chaine c);



#endif /* CHAINE_H */
