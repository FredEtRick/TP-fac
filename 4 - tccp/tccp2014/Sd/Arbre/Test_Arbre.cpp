#include <stdio.h>
#include <stdlib.h>
#include "Arbre.h"

int main(int argc,char* argv[])
{
	TREE T=create_tree(1993);
	TREE X=T->addChild(T,25896);
	TREE Y=T->addChild(T,00012);
	TREE Z=T->addChild(T,1986);
	TREE U=B->addChild(X,"JIHEN");
	TREE V=B->addChild(X,'B');
	printf("test OF accessors :\n");
	printf("%d\n",T->C);
	printf("Test Chaine: %s \n", T->chaine(T));
	printf("%d\n",X->C);
	printf("%d\n",Y->C);
	printf("%d\n",Z->C);
	printf("test OF char : ");
	printf("%c\n",V->C);
	printf("test of chaine : ");
	printf("%s\n",U->C);
	printf("test getChild :\n");
	printf("%d\n",T->getChild(T,1)->C);
	printf("%d\n",T->getChild(T,2)->C);
	printf("%d\n",T->getChild(T,3)->C);
	printf("exceeded test  : ");
	if(T->getChild(T,4)==NULL)
		printf("success.\n");
	printf("test NbreElemTREE : %d\n",T->NbreElemTREE(T));
	printf("test isSheet:\n");
	if(T->isSheet(T))
		printf("True\n");
	else
		printf("False\n");
	if(V->isSheet(V))
		printf("True\n");
	else
		printf("False\n");
	printf("Test clone :\n");
	printf("\tTree TO CLONE: X :: %s\n", X->chaine(X));
	TREE W=X->cloneRacine(X);
	printf("\tafter cloning :\n");
	printf("\t\tOriginal : %s (%d)\n",X->chaine(X),X->C);
	printf("\t\tClone : %s (%d)\n",W->chaine(W),W->C);
	printf("\tModification Original.\n");
	X->C=25896;
	printf("\t\tOriginal : %s (%d)\n",X->chaine(X),X->C);
	printf("\t\tClone : %s (%d)\n",W->chaine(W),W->C);
	printf("Transplantation of a Tree 3 cells.\n");
	TREE H=create_tree(1234);
	TREE I=H->addChild(H,8689);
	TREE J=H->addChild(H,1);
	Y->graft_tree(Y,H);
	printf("nb items of the new Tree : %d\n",T->NbreElemTREE(T));
	printf("Clear tree: \n");
	if(T->clearTree(T)==0)
		printf("\tDestruction of the tree T.\n");
	if(W->clearTree(W)==0)
		printf("\tDestruction of the clone W.\n");
	return 0;
}
