/**
 * \file ArbreBin.c
 * \brief Fonctions associees a l'arbre.
 * \author Ongaro.Y - Lacombe.F
 * \date 7 decembre 2014
 *
 * Definitions du corps des fonctions pour manipuler l'arbre.
 *
 */
#include "ArbreBin.h"
#include <time.h>

/**
 * \fn noeud* Noeud_creer(void* c){
 * \brief Creation d'un noeud.
 *
 * \param c Pointeur generique : la cle du noeud.
 * \return Pointeur vers l'instance de noeud allouee dynamiquement.
 */
noeud* Noeud_creer(void* c)
{

    noeud* n=malloc(sizeof(noeud));
    n->G=NULL;
    n->D=NULL;
    n->cle=c;
    return n;
}


/**
 * \fn ArbreBin* ArbreBin_creer(TYPE type,void (*aff)(void*),int (*cmp)(void*,void*),void (*suppr)(void*)){
 * \brief Creation d'un arbre.
 *
 * \param type Valeur definissant le type de donnee pointee par toutes les cles.
 * \param aff Pointeur vers une fonction d'affichage (peut etre facultatif).
 * \param cmp Pointeur vers une fonction de comparaison (peut etre facultatif).
 * \param suppr Pointeur vers une fonction de suppression (facultatif).
 * \return Pointeur vers l'instance de ArbreBin allouee dynamiquement.
 */
ArbreBin* ArbreBin_creer(TYPE type,void (*aff)(void*),int (*cmp)(void*,void*),void (*suppr)(void*))
{
    ArbreBin* abr=malloc(sizeof(ArbreBin));
    abr->racine=NULL;

    switch(type)
    {
    case INT:
        abr->type=INT;
        break;
    case FLOAT:
        abr->type=FLOAT;
        break;
    case CHAR:
        abr->type=CHAR;
        break;
    case STRING:
        abr->type=STRING;
        break;
    case OTHER:
        abr->type=OTHER;
        abr->affichage=aff;
        abr->compareto=cmp;
        abr->del=suppr;
        if(abr->affichage==NULL || abr->compareto==NULL)
        {
            printf("Le type OTHER requiert un pointeur vers une fonction d'affichage et une fonction de comparaison !\n");
            exit(1);
        }

        break;
    default:
        abr=NULL;
        printf("First argument must be FLOAT,INT,STRING,CHAR or OTHER");
        break;
    }
    return abr;
}

/**
 * \fn void Noeud_ajout(noeud* n,void* cle)
 * \brief Ajout d'un noeud a l'arbre.
 * \param n Noeud actuel dans l'arborescence.
 * \param cle Pointeur generique vers la donnee de la cle.
 *
 * Fonction recursive qui ajoute un noeud dans l'arborescence ainsi
 * que sa cle. Si les deux fils ne sont pas nul, on choisit aleatoirement
 * si l'on poursuit la recursion a gauche ou a droite.
 */
void Noeud_ajout(noeud* n,void* cle)
{


    if(n->G==NULL)
    {
        n->G=malloc(sizeof(noeud));
        ((noeud*)n->G)->cle=cle;
    }
    else if(n->D==NULL)
    {
        n->D=malloc(sizeof(noeud));
        ((noeud*)n->D)->cle=cle;
    }
    else
    {
        srand (time(NULL));
        if (rand()%100 < 49)
            Noeud_ajout((noeud*)n->G,cle);
        else
            Noeud_ajout((noeud*)n->D,cle);
    }
}


/**
 * \fn void ArbreBin_ajouter(ArbreBin* abr,void* cle)
 * \brief Ajout d'un noeud a l'arbre.
 * \param abr Arbre que l'on veut completer
 * \param cle Pointeur generique vers la donnee de la cle.
 * Fonction recursive qui ajoute un noeud dans l'arborescence et sa cle.
 */
void ArbreBin_ajouter(ArbreBin* abr,void* cle)
{
    if(abr->racine==NULL)
    {
      abr->racine=Noeud_creer(cle);
      return;
    }
    Noeud_ajout((noeud*)abr->racine,cle);
}


/**
 * \fn void SArbreBin_chaine(ArbreBin* n,noeud* cur)
 * \brief Affichage de l'arbre.
 * \param n Noeud actuel dans l'arborescence.
 * \param cur Noeud actuel dans l'arborescence.
 *
 * Fonction qui affiche un noeud de l'arbre.
 */
void  SArbreBin_chaine(ArbreBin* n,noeud* cur)
{
    /*Traitement du noeud courant*/
    switch(n->type)
    {
    case INT:
        printf("%d ",*(int*)cur->cle);
        break;
    case FLOAT:
        printf("%f ",*(float*)cur->cle);
        break;
    case CHAR:
        printf("%c ",*(char*)cur->cle);
        break;
    case STRING:
        printf("%s ",(char*)cur->cle);
        break;
    case OTHER:
        n->affichage(cur->cle);
    }
    /*Recursivite sur le fils gauche et le fils droit du noeud courant*/
    if(cur->G!=NULL)
    {
        SArbreBin_chaine(n,(noeud*)cur->G);
    }

    if(cur->D!=NULL)
    {
        SArbreBin_chaine(n,(noeud*)cur->D);
    }
}


/**
 * \fn void ArbreBin_chaine(ArbreBin* n)
 * \brief Affichage de l'arbre.
 * \param n Noeud actuel dans l'arborescence.
 *
 * Fonction qui affiche l'arbre selon un parcours prefixe.
 */
void  ArbreBin_chaine(ArbreBin* n)
{
    SArbreBin_chaine(n,(noeud*)n->racine);
}


/**
 * \fn void SArbreBin_supprimer(ArbreBin* abr,noeud* cur)
 * \brief Suppression d'un noeud.
 * \param cur Pointeur vers un noeud.
 * \param abr Pointeur vers l'arbre a supprimer.
 */
void SArbreBin_supprimer(ArbreBin* abr,noeud* cur)
{
    if(cur->G!=NULL)
    {
        SArbreBin_supprimer(abr,(noeud*)cur->G);
    }
    if(cur->D!=NULL)
    {
        SArbreBin_supprimer(abr,(noeud*)cur->D);
    }

    if(abr->del!=NULL)
    {
        abr->del(cur->cle);
    }
    free(cur);
}


/**
 * \fn void ArbreBin_supprimer(ArbreBin* n)
 * \brief Suppression d'une arborescence.
 * \param n Pointeur vers un arbre binaire.
 * Suppression d'une arborescence. Les donnees pointes
 * par la clé ne sont supprimees que si une fonction
 * de supression est specifiee.
 */
void ArbreBin_supprimer(ArbreBin* n)
{
    SArbreBin_supprimer(n,(noeud*)n->racine);
}


/**
 * \fn void SArbreBin_clone(noeud* src,noeud* dest)
 * \brief Copie de noeud.
 *
 * \param src Un noeud dans l'arborescence source.
 * \param dest Un noeud dans l'arborescence destinataire.
 * Copie du noeud src de l'arborescence source dans le noeud dest de
 * l'arborescence destinataire.
 */
void SArbreBin_clone(noeud* src,noeud* dest)
{
  noeud** temp;
    if(src->G!=NULL)
      {
	temp=((noeud**)&(dest->G));
	*temp=Noeud_creer(((noeud*)src->G)->cle);
	SArbreBin_clone((noeud*)src->G,(noeud*)dest->G);
      }
    if(src->D!=NULL)
      {
	temp=((noeud**)&(dest->D));
	*temp=Noeud_creer(((noeud*)src->D)->cle);
	SArbreBin_clone((noeud*)src->D,(noeud*)dest->D);
      }
}


/**
 * \fn ArbreBin* ArbreBin_clone(ArbreBin* src)
 * \brief Clone l'arbre
 * \param src L'arbre a copier.
 * \return Pointeur vers l'instance de ArbreBin allouee dynamiquement.
 *
 * La structure de l'arbre est copiee. Les cles sont seulement copiees par
 * pointeur. Copie non profonde.
 *
 */
ArbreBin* ArbreBin_clone(ArbreBin* src)
{
    ArbreBin* cpy;

    if(src!=NULL)
    {
        cpy=ArbreBin_creer(src->type,src->affichage,src->compareto,src->del);
        cpy->racine=Noeud_creer(((noeud*)src->racine)->cle);
        /*((noeud*)cpy->racine)->cle=((noeud*)src->racine)->cle;*/
        SArbreBin_clone((noeud*)src->racine,(noeud*)cpy->racine);
    }

    return cpy;
}




/**
 * \fn SArbreBin_compare(noeud* n1,noeud* n2,ArbreBin* ctxt)
 * \brief Compare deux noeuds.
 * \param n1 Un noeud du premier arbre a comparer.
 * \param n2 Un noeud du second arbre a comparer.
 * \param ctxt Pointeur vers le premeir arbre.
 * \return Entier egal a 0 si chaque noeud est identique.
 *
 * Compare deux noeuds. Cette fonction utilise la fonction
 * de comparaison passée en parametre pour comparer les clés.
 */
int SArbreBin_compare(noeud* n1,noeud* n2,ArbreBin* ctxt){

  if(n1!=NULL && n2!=NULL){
    if(ctxt->type==INT || ctxt->type==CHAR){
      if( (*(int*)n1->cle) > (*(int*)n2->cle) ){
	return 1 + SArbreBin_compare((noeud*)n1->G,(noeud*)n2->G,ctxt) + SArbreBin_compare((noeud*)n1->D,(noeud*)n2->D,ctxt);
      }
      if( (*(int*)n1->cle) < (*(int*)n2->cle) ){
	return -1 + SArbreBin_compare((noeud*)n1->G,(noeud*)n2->G,ctxt) + SArbreBin_compare((noeud*)n1->D,(noeud*)n2->D,ctxt);
      }
      if( (*(int*)n1->cle) == (*(int*)n2->cle) ){
	return 0 + SArbreBin_compare((noeud*)n1->G,(noeud*)n2->G,ctxt) + SArbreBin_compare((noeud*)n1->D,(noeud*)n2->D,ctxt);
      }
    }

    if(ctxt->type==FLOAT){
      if( (*(float*)n1->cle) > (*(float*)n2->cle) ){
	return 1 + SArbreBin_compare((noeud*)n1->G,(noeud*)n2->G,ctxt) + SArbreBin_compare((noeud*)n1->D,(noeud*)n2->D,ctxt);
      }
      if( (*(float*)n1->cle) < (*(float*)n2->cle) ){
	return -1 + SArbreBin_compare((noeud*)n1->G,(noeud*)n2->G,ctxt) + SArbreBin_compare((noeud*)n1->D,(noeud*)n2->D,ctxt);
      }
      if( (*(float*)n1->cle) == (*(float*)n2->cle) ){
	return 0 + SArbreBin_compare((noeud*)n1->G,(noeud*)n2->G,ctxt) + SArbreBin_compare((noeud*)n1->D,(noeud*)n2->D,ctxt);
      }
    }

    if(ctxt->type==STRING){
      return strcmp((char*)n1->cle,(char*)n2->cle)+SArbreBin_compare((noeud*)n1->G,(noeud*)n2->G,ctxt)+SArbreBin_compare((noeud*)n1->D,(noeud*)n2->D,ctxt);
    }

    if(ctxt->type==OTHER){
      return ctxt->compareto(n1->cle,n2->cle) + SArbreBin_compare((noeud*)n1->G,(noeud*)n2->G,ctxt)+SArbreBin_compare((noeud*)n1->D,(noeud*)n2->D,ctxt);
    }
  }

  if(n1==NULL && n2!=NULL){return -1; }
  if(n1!=NULL && n2==NULL){ return 1; }

  return 0;
}

/**
 * \fn ArbreBin_compare(ArbreBin* a1,ArbreBin* a2)
 * \brief Compare deux arbre.
 * \param a1 Premier arbre a comparer.
 * \param a2 Second arbre a comparer.
 * \return Entier egal a 0 si les arbres sont identique
 *
 */
int ArbreBin_compare(ArbreBin* a1,ArbreBin* a2)
{
    return SArbreBin_compare((noeud*)a1->racine,(noeud*)a2->racine,a1);
}

