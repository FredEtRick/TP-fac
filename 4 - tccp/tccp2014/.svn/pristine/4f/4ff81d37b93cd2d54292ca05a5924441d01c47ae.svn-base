#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Grammaire
{
    int nbElementaE, nbElementaA, nbElementProd;
    char** alphabetEntree;                              // minuscules uniquement ex: a, b, c...
    char** alphabetAuxiliaire;                          // majuscules uniquement ex: S, T, U
    char* axiome;                                       // par convention ce sera S
    char** productions;                                 // de la forme S --> aSb
} Grammaire;

Grammaire Grammaire_creer(int nbaE, int nbaA, int nbProd, char** aE, char** aA, char* aX, char** prod)
{
    int i=0;

    Grammaire G;

    G.nbElementaE=nbaE;
    G.nbElementaA=nbaA;
    G.nbElementProd=nbProd;

    G.alphabetEntree=malloc(nbaE * sizeof(char *));
    for(i=0; i<nbaE; i++)
    {
        G.alphabetEntree[i]=malloc(strlen(aE[i])+1);
        G.alphabetEntree[i]=aE[i];
    }

    G.alphabetAuxiliaire=malloc(nbaA * sizeof(char*));
    for(i=0; i<nbaA; i++)
    {
        G.alphabetAuxiliaire[i]=malloc(strlen(aA[i])+1);
        G.alphabetAuxiliaire[i]=aA[i];
    }

    G.axiome=malloc(strlen(aX)+1);
    G.axiome=aX;

    G.productions=malloc(nbProd * sizeof(char *));
    for(i=0; i<nbProd; i++)
    {
        G.productions[i]=malloc(strlen(prod[i])+1);
        G.productions[i]=prod[i];
    }

    return G;
}

int Grammaire_detruire(Grammaire G)
{
    int i;

    for(i=0; i<G.nbElementaE; i++)
    {
        free(G.alphabetEntree[i]);
    }
    free(G.alphabetEntree);

    for(i=0; i<G.nbElementaA; i++)
    {
        free(G.alphabetAuxiliaire[i]);
    }
    free(G.alphabetAuxiliaire);

    free(G.axiome);

    for(i=0; i<G.nbElementProd; i++)
    {
        free(G.productions[i]);
    }
    free(G.productions);

    return 0;
}

Grammaire Grammaire_clone(const Grammaire G)
{
    int i;

    Grammaire G2;

    G2.nbElementaE=G.nbElementaE;
    G2.nbElementaA=G.nbElementaA;
    G2.nbElementProd=G.nbElementProd;

    G2.alphabetEntree=malloc(G.nbElementaE * sizeof(char*));
    for(i=0; i<G.nbElementaE; i++)
    {
        G2.alphabetEntree[i]=malloc(strlen(G.alphabetEntree[i]));
        G2.alphabetEntree[i]=G.alphabetEntree[i];
    }

    G2.alphabetAuxiliaire=malloc(G.nbElementaA * sizeof(char*));
    for(i=0; i<G.nbElementaA; i++)
    {
        G2.alphabetAuxiliaire[i]=malloc(strlen(G.alphabetAuxiliaire[i]));
        G2.alphabetAuxiliaire[i]=G.alphabetAuxiliaire[i];
    }

    G2.axiome=malloc(strlen(G.axiome)+1);
    G2.axiome=G.axiome;

    G2.productions=malloc(G.nbElementProd * sizeof(char*));
    for(i=0; i<G.nbElementProd; i++)
    {
        G2.productions=malloc(strlen(G.productions[i]));
        G2.productions[i]=G.productions[i];
    }

    return G2;
}


int Grammaire_egal(Grammaire G1, Grammaire G2)
{
    int i;
    int j;
    int cpt;
    if(G1.nbElementaE!=G2.nbElementaE)
    {
        return 0;
    }
    else
    {
        cpt=0;
        for(i=0; i<G1.nbElementaE; i++)
        {
            for(j=0; j<G1.nbElementaE; j++)
            {
                if(G1.alphabetEntree[i]==G2.alphabetEntree[j])
                {
                    cpt++;
                }
            }
        }
        if(cpt!=G1.nbElementaE)
        {
            return 0;
        }
    }
    if(G1.nbElementaA!=G2.nbElementaA)
    {
        return 0;
    }
    else
    {
        cpt=0;
        for(i=0; i<G1.nbElementaA; i++)
        {
            for(j=0; j<G1.nbElementaA; j++)
            {
                if(G1.alphabetAuxiliaire[i]==G2.alphabetAuxiliaire[j])
                {
                    cpt++;
                }
            }
        }
        if(cpt!=G1.nbElementaA)
        {
            return 0;
        }
    }

    if(G1.axiome!=G2.axiome)
    {
        return 0;
    }

    if(G1.nbElementProd!=G2.nbElementProd)
    {
        return 0;
    }
    else
    {
        cpt=0;
        for(i=0; i<G1.nbElementProd; i++)
        {
            for(j=0; j<G1.nbElementProd; j++)
            {
                if(G1.productions[i]==G2.productions[j])
                {
                    cpt++;
                }
            }
        }
        if(cpt!=G1.nbElementProd)
        {
            return 0;
        }
    }
    return 1;
}


char* Grammaire_chaine(Grammaire G)
{
    int i;
    char* chaine=malloc(500*sizeof(char));
    strcpy(chaine,"Grammaire <(");

    for(i=0; i<G.nbElementaE; i++)
    {
        strcat(chaine,G.alphabetEntree[i]);
        if(i!=G.nbElementaE-1)
        {
            strcat(chaine,",");
        }
    }
    strcat(chaine,"),(");
    for(i=0; i<G.nbElementaA; i++)
    {
        strcat(chaine,G.alphabetAuxiliaire[i]);
        if(i!=G.nbElementaA-1)
        {
            strcat(chaine,",");
        }
    }
    strcat(chaine,"),(");
    strcat(chaine,G.axiome);
    strcat(chaine,"),(");
    for(i=0; i<G.nbElementProd; i++)
    {
        strcat(chaine,G.productions[i]);
        if(i!=G.nbElementProd-1)
        {
            strcat(chaine,",");
        }
    }
    strcat(chaine,")>");
    return chaine;
}
