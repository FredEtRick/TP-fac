/**
 * @file afd.h     
 * @author Michel Meynard
 * @brief Définition d'un AFD
 */
#define EINIT 0
#define EID 1
#define EI 2
#define EIF 3
#define EDEC 4
#define E0 5
#define EFLO 6
#define EPOINT 7
#define ESEP 8
#define ESLASH 9
#define ECOM1 10
#define ECOM2 11
#define EETOILE 12
#define NBETAT 13

void classe(int ed, int cd, int cf, int ef);

int TRANS[NBETAT][256];		/* table de transition : état suivant */
int JETON[NBETAT];		/* jeton à retourner */

void creerAfd(){			/* Construction de l'AFD */
	int i;int j;			/* variables locales */
	for (i=0;i<NBETAT;i++)
	{
		for(j=0;j<256;j++)
			TRANS[i][j]=-1; /* init vide */
		JETON[i]=0;			/* init tous états non finaux */
	}
	
	// ID
	classe(EINIT, 'A', 'Z', EID);
	classe(EINIT, 'a', 'z', EID);
	TRANS[EINIT]['_'] = EID;
	classe(EID, 'A', 'Z', EID);
	classe(EID, 'a', 'z', EID);
	TRANS[EID]['_'] = EID;
	classe(EID, '0', '9', EID);
	
	// IF
	TRANS[EINIT]['i'] = EI;
	classe(EI, 'A', 'Z', EID);
	classe(EI, 'a', 'z', EID);
	TRANS[EI]['_'] = EID;
	classe(EI, '0', '9', EID);
	TRANS[EI]['f'] = EIF;
	
	// entiers décimaux
	classe(EINIT, '1', '9', EDEC);
	TRANS[EINIT]['0'] = E0;
	classe(EDEC, '0', '9', EDEC);
	
	// flottants sans exposants
	TRANS[EINIT]['.'] = EPOINT;
	classe(EPOINT, '0', '9', EFLO);
	classe(EFLO, '0', '9', EFLO);
	TRANS[EDEC]['.'] = EFLO;
	
	// séparateurs
	TRANS[EINIT][' '] = ESEP;
	TRANS[EINIT]['\t'] = ESEP;
	TRANS[EINIT]['\n'] = ESEP;
	TRANS[EINIT]['\r'] = ESEP;
	TRANS[ESEP][' '] = ESEP;
	TRANS[ESEP]['\t'] = ESEP;
	TRANS[ESEP]['\n'] = ESEP;
	TRANS[ESEP]['\r'] = ESEP;
	TRANS[EINIT]['/'] = ESLASH;
	TRANS[ESLASH]['/'] = ECOM1;
	classe(ECOM1, 0, 255, ECOM1);
	TRANS[ECOM1]['\n'] = ESEP;
	TRANS[ESLASH]['*'] = ECOM2;
	classe(ECOM2, 0, 255, ECOM2);
	TRANS[ECOM2]['*'] = EETOILE;
	classe(EETOILE, 0, 255, ECOM2);
	TRANS[EETOILE]['*'] = EETOILE;
	TRANS[EETOILE]['/'] = ESEP;
	
	JETON[EID] = 301;
	JETON[EIF] = 302;
	JETON[EDEC] = 303;
	JETON[EFLO] = 304;
	JETON[ESEP] = -1;
	
	/* Transitions de l'AFD
	TRANS[EINIT]['a']=EA;TRANS[EA]['b']=EAB;TRANS[EAB]['b']=EAB;
	TRANS[EAB]['c']=EABC;TRANS[EINIT]['b']=EB;TRANS[EB]['d']=EBD; 
	JETON[EA]=JETON[EABC]=1;
	JETON[EBD]=-1; /* états finaux */
}

	
void classe(int ed, int cd, int cf, int ef)
{
	for (int i = cd ; i <= cf ; i++)
		TRANS[ed][i] = ef;
}