/**
 *\file test_map.c
 *\brief Test unitaire
 *\author Abdoulaye DIALLO, Redoine EL Ouasti
 *\version 0.2
 *\date 2014-12-11
 *
 * Map en C : tests unitaires
 *
 */


#include "map.h"

int main(){

	map_struct* hash = NULL;
	hash = map_creer();
	
	map_ajouter(hash,"1",(void*)1);
	map_ajouter(hash,"toto",(void*)"titi");
	
	map_chaine(hash);
	
	char* a;
	a = map_chercher(hash,"toto");
	printf("%s\n",a);
	
	map_detruire(&hash);

	return 0;
}
