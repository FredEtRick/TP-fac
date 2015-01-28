#include <stdio.h>
#include <stdlib.h>

#include "../Include/Entier.h"

entier entier_creer(int i) {
	return (int *)i;
}

entier addition_entier(entier e, int i) {	
	int a = (int)e;
	a+=i;	
	return entier_creer(a);
} 

entier soustraction_entier(entier e, int i) {	
	int a = (int)e;
	a-=i;	
	return entier_creer(a);
} 

entier multiplication_entier(entier e, int i) {	
	int a = (int)e;
	a*=i;	
	return entier_creer(a);
} 

entier division_entier(entier e, int i) {	
	int a = (int)e;
	a/=i;	
	return entier_creer(a);
} 

int entier_detruire(entier e) {
	free(e);
}

entier entier_clone(entier e) {
	return (int *)e;
}

int entier_egal(entier e1, entier e2) {
	if((int *)e1 == (int *)e2)
		return 1;
	return 0;
}

int entier_compare(entier e1, entier e2){
	if((int *)e1 > (int *)e2) 
		return 1;
	else if((int *)e1 == (int *)e2)
		return 0;
	return -1;
}

char* entier_chaine(entier e) {
	char desc[200];
	sprintf(desc,"L'entier vaut %d",(int *) e);
	return desc;
}


void testeurEntiers() {

	printf("Création entier\n");
	entier e = entier_creer(7);
	entier f = addition_entier(e,6); /*Les autres types de calcul sont exactement identiques, donc on ne montre pas que cela fonctionne.*/
	printf("Entier crée\n");
	printf("%s\n",entier_chaine(e));
	printf("%s\n",entier_chaine(f));

	entier e2 = e;

	if(entier_egal(e,e2) == 1)
		printf("Egalité entre deux entiers égaux!\n");

	if(entier_compare(e,f) == -1)
		printf("f est bien plus grand que e!\n");
}
