/**
 * @file analex.c  
 * @author Michel Meynard
 * @brief Prog principal appelant analex()
 */
#include <stdio.h>
#include <string.h>
#include "afd.h"		/* Définition de l'AFD et des JETONS */
#include "analex.h"		/* Définition de la fon : int analex() */

int main(){			/* Construction de l'AFD */
	int j;			/* jeton retourné par analex() */
	char *invite="Saisissez des identifiants, le mot-clé if, des entiers décimaux, des flottants sans exposants ou (ou et) des séparateurs :\n";//"Saisissez un(des) mot(s) matchant a(b+c)?|bd, (les bd sont considérés comme des commentaires donc sont filtrés) suivi de EOF (CTRL-D) SVP : ";
	creerAfd();			/* Construction de l'AFD à jeton */
	printf("%s",invite);		/* prompt */
	char* jeton[4];
	jeton[0] = "identificateur";
	jeton[1] = "if";
	jeton[2] = "décimal";
	jeton[3] = "flotant";
	while((j=analex())){		/* analyser tq pas jeton 0 */
		if (j < 256)
			printf("Jeton = '%c' ; Lexeme = %s\n", j,lexeme);
		else if ((j > 300) && (j < 305))
			printf("Jeton = %s ; Lexeme = %s\n", jeton[j-301],lexeme);
		else
			printf("JETON NON PREVU : Jeton = %d ; Lexeme = %s\n", j,lexeme);
	}
	return 0;
}
