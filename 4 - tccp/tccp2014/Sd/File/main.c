/*! \mainpage Structure de File
 * Cette documentation regroupe les différentes fonctions de la structure de données générique FIFO
 */

#include <stdio.h>
#include <stdlib.h>
#include "file.h"

int main()
{
    int x = 5;
    int y = 25;
    int z = 75;
    int a = 2;
    File* f = File_creer();
    File* g = NULL;
    char chaine[50];

    File_enfiler(f, &x);
    File_enfiler(f, &y);
    File_enfiler(f, &z);
    File_enfiler(f, &a);

    g = File_clone(f);
    if(File_egal(f, g))
    {
        printf("Les deux files sont égales\n");
    }
    File_defiler(g); f->debut = g->debut;
    if(File_compare(f, g) != 0)
    {
        printf("Les files ne sont plus de tailles égales\n");
    }

    printf("Le contenu de la file f : \n");
    File_chaine(f, intToString, chaine);
    printf("%s\n", chaine);
    File_detruire(f);
    return 0;
}
