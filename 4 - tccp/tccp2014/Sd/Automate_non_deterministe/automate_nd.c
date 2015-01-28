#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "automate_nd.h"
#include "structure_nd.h"

automate_nd automate_creer(){
  automate_nd mon_automate = (automate_nd)malloc(sizeof(struct automate_nd));
  mon_automate->L = NULL;
  mon_automate->E = NULL;
  mon_automate->F = NULL;
  mon_automate->T = NULL;
  
  return mon_automate;
}
automate_nd automate_creer_nouvel(liste_alphabet a,liste_etats e,liste_etats f,Etat i,liste_transitions t){
  automate_nd mon_automate=(automate_nd)malloc(sizeof(struct automate_nd));
  mon_automate->L=a;
  mon_automate->E=e;
  mon_automate->F=f;
mon_automate->I=i;
 mon_automate->T=t;
 printf("l'automate a bien  été crée!");
 return mon_automate;
}
void automate_nd_detruire(automate_nd A){
  while(A!=NULL){
    liste_alphabet a;
    while(A->L!=NULL){
      a=A->L->suivant;
      free(a);
    }
    liste_etats e;
    while(A->E!=NULL){
      e=A->E->etatSuivant;
      free(e);
    }
    liste_transitions t;
    while(A->T!=NULL){
      t=A->T->suivant;
      free(t);
    }
  }
  free(A);
  printf("l'automate a  bien été supprimé");
}

automate_nd automate_nd_clone(automate_nd A){
  automate_nd automate = (automate_nd)malloc(sizeof(struct automate_nd));
  liste_alphabet a;
  liste_transitions t;
  liste_etats e;
  while(A->E!=NULL){
    ajouter_nouvel_etat(automate,A->E->id,A->E->statue);
    A->E->etatSuivant;
    a->suivant;
  }
  while(A->T!=NULL){
    ajouter_nouvel_transition(automate,A->T->depart,A->T->arrive,A->L->Lettre);
    A->T->suivant;
    t->suivant;
  }
  return automate;
}

void ajouter_nouvel_etat(automate_nd A,Etat destination,int statue){
  liste_etats etatajout=(liste_etats)malloc(sizeof(liste_etats));
  etatajout->id=destination;
  etatajout->statue=statue;
  etatajout->etatSuivant=A->E;
  etatajout=A->E;
}

void ajouter_etat(automate_nd A){
  int t,e;
  
  while(1){
    printf("saisir le numero de l'état:");
    scanf("%d",&e);
    if(exist_etat(A,e)){
      printf("l'etat  est  déja existant! ");
    }
    else{
      //    affichage_type_etats();
      printf("saisir le type  de l'état:");
      scanf("%d",&t);
      if(t<0||t>3){
	printf("erreur de type d'etat");
      }
      ajouter_nouvel_etat(A,e,t);
      
    }
  }
}
int exist_etat(automate_nd A,Etat e){
  int trouve=0;
  liste_etats etat_init=A->E;
  while(etat_init!=NULL){
    if(etat_init->statue==e){
      trouve=1;
      return trouve;
    }
    etat_init->etatSuivant;
  }
  return trouve;
}

Etat etat_prochain(automate_nd A,char l,Etat etatCourant){
  Etat prochain=-1;
  liste_transitions automateTrans=A->T;
  while(A->T!=NULL){
    if(automateTrans->delta==l&&automateTrans->depart==etatCourant){
      prochain=automateTrans->arrive;
    }
    A->E->etatSuivant;
  }
  return prochain;
}

Etat etat_initial(automate_nd A){
  liste_etats liste=A->E;
  Etat etatInit=0;
  while (liste!=NULL){
    if(liste->statue==ETAT_INIT||liste->statue==ETAT_INITFINAL){
      etatInit=liste->id;
    }
    liste->etatSuivant;
  }
  return etatInit;
}
void ajouter_nouvel_transition(automate_nd A,Etat debut,Etat arrivee,char l){
  liste_transitions transi=(liste_transitions)malloc(sizeof(liste_transitions));
  transi->depart=debut;
  transi->arrive=arrivee;
  transi->delta=l;
  transi->suivant=A->T;
  A->T=transi;
}

void  ajouter_transition(automate_nd A){
  Etat debut,fin;
  Alphabet a;
  
  while(1){
    printf("ajouter la  transition: \n");
    scanf("%s",&a);
    printf("avec l'etat  de depart:!\n");
    scanf("%d",&debut);
    printf("et etat  d'arrivee:\n");
    scanf("%d",&fin);
    
    if(exist_etat(A,debut)&&(exist_etat(A,fin))){
      
      ajouter_nouvel_transition(A,debut,fin,a);
    }
    printf("impossible d'ajouter  la transition!");
    
  }
}

int est_non_deterministe(automate_nd A,Etat etatdebut,Alphabet a){
  liste_transitions liste=A->T;
  int  estdeter=0;
  
  while(liste!=NULL){
    if(liste->delta==a&&liste->depart==etatdebut){
      liste->suivant;
      estdeter=1;
    }
estdeter=0;
 printf("l'automate n'est pas indeterministe!");
  }
  
  printf("l'automate est bien  indeterministe!");
  return estdeter;
}
void AutomateDeterm_chaine(automate_nd A){
  
  
  if(A->E != NULL){
    printf("Les etats sont :\n");
    liste_etats initial = A->E;
    while(A->E != NULL){
      printf("- %d : ",A->E->id);
      if(A->E->statue== NON_ETAT)
	printf("Erreur de statut\n");
      if(A->E->statue== ETAT_NORMAL)
	printf("Etat normal\n");
      if(A->E->statue == ETAT_INIT)
	printf("Etat initial\n");
      if(A->E->statue == ETAT_FINAL)
	printf("Etat final\n");
      if(A->E->statue == ETAT_INITFINAL)
	printf("Etat initial & final\n");
      
      A->E = A->E->etatSuivant;
    }
  }
  else{
    printf("Aucun Etat\n");
  }
}
void affichage_type_etats(){
  printf("le types  des etats:\n");
  printf("0:Etat Initial.\n");
  printf("1:Etat 'Normal'.\n");
  printf("2:Etat Final.\n");
  printf("3:Etat Initial et final.\n");
}




