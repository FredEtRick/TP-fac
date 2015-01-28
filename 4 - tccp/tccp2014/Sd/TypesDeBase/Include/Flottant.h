/**
* Structure représentant un nombre flottant.
* @author Lucas Chabalier - Lucas Roulette
* @version 1.0
*/

#ifndef FLOTTANT_H
#define FLOTTANT_H

  /**
   * @typedef Définit le type flottant, dérivé du type primitif float
   */
  typedef float* flottant;

  /**
   * @fn Création d'un flottant à partir d'un float.
   * @param f, un float pour donner une valeur au flottant.
   * @return Retourne le flottant crée.
   */
  flottant flottant_creer(float f);

  /**
   * @fn Destruction d'un flottant
   * @param f, le flottant qu'on veut détruire
   * @return Retourne 0 si le flottant est détruit
1 si il y a eu une erreur.
   */
  int flottant_detruire(flottant f);

  /**
   * @fn Clonage d'un flottant.
   * @param f, le flottant qu'on veut cloner.
   * @return Le flottant crée.
   */
  flottant flottant_clone(flottant f);

  /**
   * @fn Vérifie si deux flottant ont la meme valeur.
   * @param Deux flottant, f1 et f2.
   * @return 1 si ils sont égaux, 0 sinon.
   */
  int flottant_egal(flottant f1,flottant f2);

  /**
   * @fn Compare deux flottants.
   * @param Deux flottant, f1 et f2.
   * @return 0 si ils sont égaux, 1 si f1 > f2, -1 sinon.
   */
  int flottant_compare(flottant f1, flottant f2);

  /**
   * @fn Descripteur du flottant.
   * @param f, le flottant à décrire.
   * @return Une chaine décrivant le flottant f.
   */
  char* flottant_chaine(flottant f);

  /**
   * @fn Addition
   * @param e, le flottant à calculer, i la valeur à ajouter
   * @return Un flottant, résultat de e+i
   */
flottant addition_flottant(flottant e, float i);

  /**
   * @fn Division.
   * @param e, le flottant à calculer, i la valeur à diviser
   * @return Un flottant, résultat de e/i
   */
flottant division_flottant(flottant e, float i);

  /**
   * @fn Soustracion.
   * @param e, l'flottant à calculer, i la valeur à enlever.
   * @return Un flottant, résultat de e-i
   */
flottant soustraction_flottant(flottant e, float i);

  /**
   * @fn Multiplication
   * @param e, le flottant à calculer, i le facteur de multiplication.
   * @return Un flottant, résultat de e*i
   */
flottant multiplication_flottant(flottant e, float i);
void testeurFlottant();


#endif /* FLOTTANT_H */
