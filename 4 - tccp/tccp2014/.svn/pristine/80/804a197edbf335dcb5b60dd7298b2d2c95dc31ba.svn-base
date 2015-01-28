#include <stdio.h>
#include <stdlib.h>
#include "automate_nd.h"
#include "structure_nd.h"

int main()
{char menu[20];
  automate_nd mon_automate= automate_creer();
  
  while(1){
    
    printf("\n Automate indéterministe n");
    printf("\n Liste  des  fonctionnalitées \n\n");
    printf("\t1 - Creer un automate\n");
    printf("\t2 - Ajouter un etat\n");
    printf("\t3 - Ajouter une transition\n");
    printf("\t4 - Afficher l'automate\n");
    printf("\t5 - Detruire l'automate \n");
    printf("\t6 - Clone de l'automate\n");
    printf("\t7 - Quitter\n\n");
    
    scanf("%s",menu);fflush(stdin);
    
    if(menu[0] == '1'){
      mon_automate=automate_creer();
      printf("l'automate viens d'etre  créer\n");
    }
    if(menu[0] == '2'){
      ajouter_etat(mon_automate);
    }
    if(menu[0] == '3'){
      ajouter_transition(mon_automate);
    }
    if(menu[0] == '4'){
      AutomateDeterm_chaine(mon_automate);
    }
    if(menu[0] == '5'){
      automate_nd_detruire(mon_automate);
    }
    if(menu[0] == '6'){
      automate_nd_clone(mon_automate);
    }
    
    if(menu[0] == '8'){
      break;
    }
  }
  return 0;
}




