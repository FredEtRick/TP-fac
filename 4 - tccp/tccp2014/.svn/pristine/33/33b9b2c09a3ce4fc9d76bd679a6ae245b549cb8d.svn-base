#include <stdio.h>
#include <stdlib.h>

#include "../Include/Flottant.h"


flottant flottant_creer(float i) {
	flottant f= &i;	
	printf("%f\n", *f);
	return f;
}

flottant addition_flottant(flottant e, float i) {	
	float a = *e;
	a+=i;	
	return flottant_creer(a);
} 

flottant soustraction_flottant(flottant e, float i) {	
	float a = *e;
	a-=i;	
	return flottant_creer(a);
} 

flottant multiplication_flottant(flottant e, float i) {	
	float a = *e;
	a*=i;	
	return flottant_creer(a);
} 

flottant division_flottant(flottant e, float i) {	
	float a = *e;
	a/=i;	
	return flottant_creer(a);
} 

int flottant_detruire(flottant e) {
	free(e);
	return 0;
}

flottant flottant_clone(flottant e) {
	return e;
}

int flottant_egal(flottant e1, flottant e2) {
	if(*e1 == *e2)
		return 1;
	return 0;
}

int flottant_compare(flottant e1, flottant e2){
	if(*e1 > *e2) 
		return 1;
	else if(*e1 == *e2)
		return 0;
	return -1;
}

char* flottant_chaine(flottant e) {
	char desc[200];
	sprintf(desc,"Le flottant vaut %f",*e);
	return desc;
}

void testeurflottant() {

	printf("Création flottant\n");
	float a=7.1,b=6.5;
	flottant e = flottant_creer(7.1);
	flottant f = addition_flottant(e,6.5); /*Les autres types de calcul sont exactement identiques, donc on ne montre pas que cela fonctionne.*/
	printf("flottant crée\n");
	printf("%s\n",flottant_chaine(e));
	printf("%s\n",flottant_chaine(f));

	flottant e2 = e;

	if(flottant_egal(e,e2) == 1)
		printf("Egalité entre deux flottants égaux!\n");

	if(flottant_compare(e,f) == -1)
		printf("f est bien plus grand que e!\n");
}

