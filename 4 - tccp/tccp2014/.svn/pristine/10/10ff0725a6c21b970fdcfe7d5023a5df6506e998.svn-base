/**
* Structure représentant un nombre entier.
* @author Lucas Chabalier - Lucas Roulette
* @version 1.0
*/

#ifndef ENTIER_H
#define ENTIER_H




  /**
   * @typedef Définit le type entier, dérivé du type primitif int.
   */
  typedef int* entier;

  /**
   * @fn Création d'un entier à partir d'un int.
   * @param i, un int.
   * @return Un entier initialisé.
   */
  entier entier_creer(int i);

  /**
   * @fn Détruit l'entier passé en paramètre.
   * @param e, l'entier à détruire.
   * @return 0 si il n'y a eu aucun problème, 1 sinon.
   */
  int entier_detruire(entier e);
  
  /**
   * @fn Crée un entier, à partir d'un entier donné.
   * @param e, l'entier à cloner.
   * @return Un entier crée à partir de e.
   */
  entier entier_clone(entier e);
  
  /**
   * @fn Vérifie si deux entiers ont la meme valeur.
   * @param Deux entier, e1 et e2.
   * @return 1 si ils sont égaux, 0 sinon.
   */
  int entier_egal(entier e1, entier e2);
  
  /**
   * @fn Compare deux entiers.
   * @param Deux entiers, e1 et e2.
   * @return 0 si ils sont égaux, 1 si e1 > e2, -1 sinon. 
   */
  int entier_compare(entier e1, entier e2);
  
  /**
   * @fn Décrit un entier.
   * @param e, l'entier à décrire.
   * @return Une chaine, décrivant e.
   */
  char* entier_chaine(entier e);

  /**
   * @fn Addition
   * @param e, l'entier à calculer, i la valeur à ajouter
   * @return Un entier, résultat de e+i
   */
entier addition_entier(entier e, int i);

  /**
   * @fn Division.
   * @param e, l'entier à calculer, i la valeur à diviser
   * @return Un entier, résultat de e/i
   */
entier division_entier(entier e, int i);

  /**
   * @fn Soustracion.
   * @param e, l'entier à calculer, i la valeur à enlever.
   * @return Un entier, résultat de e-i
   */
entier soustraction_entier(entier e, int i);

  /**
   * @fn Multiplication
   * @param e, l'entier à calculer, i le facteur de multiplication.
   * @return Un entier, résultat de e*i
   */
entier multiplication_entier(entier e, int i);

void testeurEntiers();
#endif /* ENTIER_H */
