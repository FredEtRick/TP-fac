#include <stdio.h>
#include <stdlib.h>

#include "../Include/Car.h"

car car_creer(char i) {
	return (char *)i;
}

car addition_car(car e, char i) {	
	char a = (char)e;
	a+=i;	
	return car_creer(a);
} 

car soustraction_car(car e, char i) {	
	char a = (char)e;
	a-=i;	
	return car_creer(a);
} 

car multiplication_car(car e, char i) {	
	char a = (char)e;
	a*=i;	
	return car_creer(a);
} 

car division_car(car e, char i) {	
	char a = (char)e;
	a/=i;	
	return car_creer(a);
} 

int car_detruire(car e) {
	free(e);
}

car car_clone(car e) {
	return (char *)e;
}

int car_egal(car e1, car e2) {
	if((char *)e1 == (char *)e2)
		return 1;
	return 0;
}

int car_compare(car e1, car e2){
	if((char *)e1 > (char *)e2) 
		return 1;
	else if((char *)e1 == (char *)e2)
		return 0;
	return -1;
}

char* car_chaine(car e) {
	char desc[200];
	sprintf(desc,"Le car vaut %c",(char *) e);
	return desc;
}


void testeurcar() {

	printf("Création car\n");
	car e = car_creer('a');
	car f = addition_car(e,'b'); /*Les autres types de calcul sont exactement identiques, donc on ne montre pas que cela fonctionne.*/
	printf("car crée\n");
	printf("%s\n",car_chaine(e));
	printf("%s\n",car_chaine(f));

	car e2 = e;

	if(car_egal(e,e2) == 1)
		printf("Egalité entre deux cars égaux!\n");

	if(car_compare(e,f) == -1)
		printf("f est bien plus grand que e!\n");
}
