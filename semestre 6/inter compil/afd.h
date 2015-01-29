/**
 * @file afd.h     
 * @author Michel Meynard
 * @brief Définition d'un AFD
 */
#define EINIT 0
#define EID 1
#define NBETAT 2

int TRANS[NBETAT][256];		/* table de transition : état suivant */
int JETON[NBETAT];		/* jeton à retourner */

void classe (int ei, char cd, char cf, int ea)
{
	for (char c = cd; c <= cf ; c++)
		TRANS[ei][(int)c] = ea;
}

int creerAfd(){			/* Construction de l'AFD */
  int i;int j;			/* variables locales */
  for (i=0;i<NBETAT;i++){
    for(j=0;j<256;j++) TRANS[i][j]=-1; /* init vide */
    JETON[i]=0;			/* init tous états non finaux */
  }
  /* Transitions de l'AFD */
	classe(EINIT, 'A', 'Z', EID);
	classe(EINIT, 'a', 'z', EID);
	classe(EID, 'A', 'Z', EID);
	classe(EID, 'a', 'z', EID);
	classe(EID, '0', '9', EID);
	classe(EID, '_', '_', EID);
	JETON[EID] = 300 + EID;
}
