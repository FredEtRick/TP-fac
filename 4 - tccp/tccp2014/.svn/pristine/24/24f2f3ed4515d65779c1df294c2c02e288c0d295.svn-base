#include "pile.h"


int main(int argc, char *argv[])
{
     int a=12;
     int b=5;
     int* element1;
     int* element2;
     *element1=a;
     *element2=b;
     Pile pile1=sd_pile_new();
     Pile pile2=sd_pile_new();
     Pile pile3=sd_pile_new();
     Pile pile4=sd_pile_new();
     if(sd_pile_is_null(pile4)==0){
	  printf("pile4 est null");
     }
     sd_pile_delete(pile4);
     sd_pile_push_back(element1,pile1);
     int sommet=(*sd_pile_back(pile1));
     printf("Le sommet de la pile1 contient %d\n", sommet);
     sd_pile_push_back(element2,pile1);
     printf("Le sommet de la pile1 contient %d\n", (*sd_pile_back(pile1)));
     printf("La pile1 a donc une taille de %d\n", sd_pile_size(pile1));
     sd_pile_clear(pile1);
     if(sd_pile_is_empty(pile1)==0){
	  printf("Après clear, la pile1 est vide\n");
     }
     
     return 0;
}
