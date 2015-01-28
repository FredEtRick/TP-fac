#include <stdio.h>
#include <stdlib.h>
#include "../ArbreBin.h"

typedef struct
{
    float prix;
    int ref;
}produit;

/*La fonction qui sera utilisée par l'arbre binaire pour comparer ses elements*/
int compare(void* a1,void* a2)
{

    produit* pa=a1;
    produit* pb=a2;
        return pa->prix-pb->prix;
}

/*La fonction qui sera utilisée par l'arbre binaire pour afficher ses elements*/
void affiche(void* a1)
{
    produit* pa=a1;
    printf("Ref:%d - Prix:%.2f  ",pa->ref,pa->prix);
}

/*Fonction pour liberer la memoire*/
void supression(void* a1)
{
    printf("Supression du produit\n");
    free(a1);
}

int main()
{
    ArbreBin* a;
    ArbreBin* b;
    int x,y,z;
    x=4; y=2;z=3;
    /*Creation d'un arbre d'entiers*/
    a=ArbreBin_creer(INT,NULL,NULL,NULL);
    ArbreBin_ajouter(a,&x);ArbreBin_ajouter(a,&y);
    ArbreBin_ajouter(a,&z);ArbreBin_ajouter(a,&y);
    printf("Parcours prefixe sur l'arbre A\n");
    ArbreBin_chaine(a);
    /*Clonage de l'arbre a dans b*/
    b=ArbreBin_clone(a);
    printf("\nParcours prefixe sur l'arbre B\n");
    ArbreBin_chaine(b);
    if(ArbreBin_compare(a,b)==0)
        printf("\nLes deux arbres sont indentiques\n");
    ArbreBin_ajouter(b,&x);
    printf("Parcours prefixe sur l'arbre B\n");
    ArbreBin_chaine(b);
    if(ArbreBin_compare(a,b)!=0)
        printf("\nLes deux arbres ne sont pas indentiques\n");

    /*Avec objet personnalise*/
    produit* p1=malloc(sizeof(produit));
    produit* p2=malloc(sizeof(produit));
    p1->prix=15.99;
    p1->ref=456215;
    p2->prix=8.49;
    p2->ref=187741;
    ArbreBin* c;
    ArbreBin* d;
    c=ArbreBin_creer(OTHER,affiche,compare,supression);
    ArbreBin_ajouter(c,p1); ArbreBin_ajouter(c,p2);
    /*Clonage de c dans d*/
    d=ArbreBin_clone(c);
    ArbreBin_ajouter(d,p1);
    ArbreBin_chaine(c); printf("\n"); ArbreBin_chaine(d);
    if(ArbreBin_compare(c,d)!=0)
        printf("\nLes deux arbres ne sont pas indentiques\n");
    ArbreBin_supprimer(c); ArbreBin_supprimer(d);printf("%d",p1->ref);
    return 0;
}
