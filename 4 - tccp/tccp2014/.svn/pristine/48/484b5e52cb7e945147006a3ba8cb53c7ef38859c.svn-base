#include "abr.h"

abr * abr_creer(){
	/* création dynamique d'un arbre */
	abr *arbre=malloc(sizeof(abr));
	if(!arbre)fprintf(stderr, "Erreur à l'allocation memoire.\n");
	
	arbre->racine=NULL;
	return arbre;
}

void abr_detruire(abr *arbre){
	/* destruction d'un arbre n'est rien d'autre que la destruction de chaque branche */
	abr_detruire_branche(arbre->racine);
	free(arbre);
}

abr * abr_clone(abr original){
	/* construction d'un arbre par copie */
	abr *arbre=malloc(sizeof(abr));	
	arbre->racine=original.racine;
	return arbre;
}

noeud abr_creer_noeud(objet x){
	/* création d'un noeud */
	noeud n=malloc(sizeof(struct noeud));
	n->cle=x;
	n->pere=NULL;
	n->filsD=NULL;
	n->filsG=NULL;
	return n;
}

void abr_detruire_noeud(noeud knot){
	/* destruction d'un noeud */
	free(knot);
}

void abr_detruire_branche(noeud knot){
	/* destruction récursive d'un branche */	
	if(knot!=NULL){
		abr_detruire_branche(knot->filsD);
		abr_detruire_branche(knot->filsG);
		abr_detruire_noeud(knot);
	}
}

noeud abr_rechercher(noeud racine,objet x){
	/* recherche récursive*/ 
	if((racine==NULL) || (racine->cle==x))
	{
		return racine;
	}
	else
	{
		if(racine->cle<x)
		{
			return abr_rechercher(racine->filsD,x);
		}
		else
		{
			return abr_rechercher(racine->filsG,x);
		}
	}
}

noeud abr_minimum(noeud racine){
	/* le minimum d'un ABR est le noeud le plus à gauche */
	noeud pointeur=racine;
	if(pointeur==NULL)return NULL;
	while(pointeur->filsG!=NULL)pointeur=pointeur->filsG;
	return pointeur;
}

noeud abr_maximum(noeud racine){
	/* le maximum d'un ABR est le noeud le plus à droite */
	noeud pointeur=racine;
	if(pointeur==NULL)return NULL;
	while(pointeur->filsD!=NULL)pointeur=pointeur->filsD;
	return pointeur;
}

noeud abr_predecesseur(noeud knot){
	/* le noeud avec une valeur plus petite ou egale, la plus proche de knot */
	noeud pointeur1,pointeur2;
	if((knot->filsG)!=NULL) return abr_maximum(knot->filsG);
	pointeur1=knot->pere;
	pointeur2=knot;
	while(pointeur1!=NULL && pointeur2==pointeur1->filsG)
	{
		pointeur2=pointeur1;
		pointeur1=pointeur1->pere;
	}
	return pointeur1;
}

noeud abr_successeur(noeud knot){
	/* le noeud avec une valeur plus grande ou egale, la plus proche de knot */
	noeud pointeur1,pointeur2;
	if((knot->filsD)!=NULL) return abr_minimum(knot->filsD);
	pointeur1=knot->pere;
	pointeur2=knot;
	while(pointeur1!=NULL && pointeur2==pointeur1->filsD)
	{
		pointeur2=pointeur1;
		pointeur1=pointeur1->pere;
	}
	return pointeur1;
}

void abr_inserer(abr *arbre,objet x){
	/* création d'un noeud et parcours vertical de l'arbre jusqu'à une feuille qui puisse contenir x */
	noeud n=abr_creer_noeud(x);
	noeud pointeur1=NULL,pointeur2=arbre->racine;
	while(pointeur2!=NULL)
	{
		pointeur1=pointeur2;
		if((pointeur2->cle)>=x)
		{
			pointeur2=pointeur2->filsG;		
		}
		else
		{
			pointeur2=pointeur2->filsD;
		}
	}
	n->pere=pointeur1;
	if(pointeur1==NULL)
	{
		arbre->racine=n;
	}
	else
	{
		if(pointeur1->cle>=x)
		{
			pointeur1->filsG=n;
		}
		else
		{
			pointeur1->filsD=n;	
		}
	}
}

void abr_supprimer(abr* arbre,noeud n){
	noeud pointeur1,pointeur2;

	/* on détermine le noeud à détruire */
	if((n->filsG==NULL) || (n->filsD==NULL))
	{
		pointeur1=n;
	}
	else
	{
		pointeur1=abr_successeur(n);
	}

	/* on détermine le fils du noeud à détruire, NULL si c'est une feuille*/ 
	if(pointeur1->filsG != NULL)
	{	
		pointeur2=pointeur1->filsG;	
	}
	else
	{
		pointeur2=pointeur1->filsD;
	}

	/* avant de détruire un noeud on le détache de l'arbre afin de ne pas créer de "trou" */
	if(pointeur2 != NULL)
	{
		pointeur2->pere=pointeur1->pere;
	}
	if(pointeur1->pere==NULL)
	{
		arbre->racine=pointeur2;
	}
	else
	{
		if(pointeur1==((pointeur1->pere)->filsG))
		{
			(pointeur1->pere)->filsG=pointeur2;
		}
		else
		{
			(pointeur1->pere)->filsD=pointeur2;
		}
	}

	/* si le noeud à détruire n'est pas celui contenant x, on écrase les valeurs du noeud x*/
	if(pointeur1!=n)
	{
		n->cle=pointeur1->cle;	
	}

	/* destruction */
	abr_detruire_noeud(pointeur1);
}

int main(){return 0;}


