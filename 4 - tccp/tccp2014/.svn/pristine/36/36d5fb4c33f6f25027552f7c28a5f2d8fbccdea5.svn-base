/**
 * \file testBoiteAlea.c
 * \brief Programme de tests.
 * \author Barthélémy Antonin, Deng YongYan
 * \version 0.1
 * \date 09 décembre 2014
 *
 * Programme de test pour BoiteAlea.
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include "boiteAlea.h"
#include "typesBase/typeBase.h"

int main(int argc, char* argv[])
{ 
  BoiteAlea box = boiteAlea_creer();
  
  boiteAlea_ajouter(box,Flottant_Creer(18));
  boiteAlea_ajouter(box,Car_Creer('R'));
  for(int i=2;i<9;i++)
    {
      boiteAlea_ajouter(box,Entier_Creer(i));
    }
  boiteAlea_ajouter(box,String_Creer("Good"));
  printf("On creer une première boiteAlea.\n");
  printf("Box ==>");

  boiteAlea_afficher(box);

  printf("\n");

  BoiteAlea box2 = boiteAlea_creerParam(boiteAlea_tirage(box,4),4);

  printf("On creer une deuxième boite Box2 qu'on hydrate en effectuant un tirage dans Box.\n");
  printf("Box ==>");
  boiteAlea_afficher(box);
  printf("Box2 ==>");
  boiteAlea_afficher(box2);

  printf("\n");

  printf("On effectue un tirage dans Box2 : ");
  Affiche(boiteAlea_piocher(box2));
  printf("\nBox2 ==>"); 
  boiteAlea_afficher(box2);

  printf("Les boites sont détruites\n");

  boiteAlea_detruire(box);
  boiteAlea_detruire(box2);
  

  return 0;
}
