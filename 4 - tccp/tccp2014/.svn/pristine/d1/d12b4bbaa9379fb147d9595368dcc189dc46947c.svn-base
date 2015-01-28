/**
* Structure représentant un caractère.
* @author Lucas Chabalier - Lucas Roulette
* @version 1.0
*/

#ifndef CAR_H
#define CAR_H




  /**
   * @typedef Définit le type car, dérivé du type primitif char.
   */
  typedef char* car;

  /**
   * @fn Crée un car, à partir d'un char.
   * @param Un char c.
   * @return Le car initialisé.
   */
  car car_creer(char c);

  /**
   * @fn Détruit le car passé en paramètre.
   * @param c, le car à détruire.
   * @return 0 si il n'y a eu aucun problème, 1 sinon.
   */
  int car_detruire(car c);

  /**
   * @fn Crée un car, à partir d'un car donné.
   * @param c, le car à cloner.
   * @return Un car crée à partir de c.
   */
  car car_clone(car c);

  /**
   * @fn Vérifie si deux car ont la meme valeur (selon la table ASCII).
   * @param Deux car, c1 et c2.
   * @return 1 si ils sont égaux, 0 sinon.
   */
  int car_egal(car c1, car c2);

  /**
   * @fn Compare deux car selon la table ASCII.
   * @param Deux car, c1 et c2.
   * @return 0 si ils sont égaux, 1 si c1 > c2, -1 sinon.
   */
  int car_compare(car c1, car c2);

  /**
   * @fn Décrit le car.
   * @param c, le car à décrire.
   * @return Une chaine, décrivant c.
   */
  char* car_Chaine(car c);

car addition_car(car e, char i);

  /**
   * @fn Division.
   * @param e, le char à calculer, i la valeur à diviser
   * @return Un car, résultat de e/i
   */
car division_car(car e, char i);

  /**
   * @fn Soustracion.
   * @param e, le char à calculer, i la valeur à enlever.
   * @return Un car, résultat de e-i
   */
car soustraction_car(car e, char i);

  /**
   * @fn Multiplication
   * @param e, le char à calculer, i le facteur de multiplication.
   * @return Un car, résultat de e*i
   */
car multiplication_car(car e, char i);
void testeurcar();

#endif /* CAR_H */
