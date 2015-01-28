#include "file.h"

File* File_creer()
{
	File* f = malloc(sizeof(File));
	f->debut = NULL;
	f->fin = NULL;
	f->taille = 0;
	printf("DEBUG : File cree\n");
	return f;
}

void File_detruire(File* f)
{
	Element* p = f->debut;

	while(p!=NULL)
	{
		File_defiler(f);
		p = f->debut;
	}

	free(f);
	printf("DEBUG : File detruite\n");
}

int File_estVide(File* f)
{
	return (f->taille==0);
}

void* File_defiler(File *f)
{
	if(f->debut == NULL)
	{
		printf("File vide\n");
		return NULL;
	}
	else
	{
		Element* deb = f->debut;
		void* buff = f->debut->valeur;
		f->debut=f->debut->succ;
		free(deb);
		printf("DEBUG : Defilage reussie\n");
		return buff;
	}
}

void File_enfiler(File* f, void* o)
{
	Element* e = malloc(sizeof(Element));
	e->succ = NULL;
	e->valeur = o;

	/*Si la file est vide, l'element qu'on enfile est le debut de la file*/
	if(f->debut == NULL)
	{
		f->debut = e;
	}

	/*Si la file n'est pas vide, alors le dernier élément a pour successeur
	celui qu'on vient d'enfiler*/
	if(f->fin != NULL)
	{
		f->fin->succ = e;
	}

	f->fin = e;
	f->taille++;
	printf("DEBUG : Enfilage reussi\n");
}

int File_compare(File *f, File *g)
{
	return (f->taille)-(g->taille);
}

File* File_clone(File *f)
{

	File* g = File_creer();
	g->debut=f->debut;
	g->fin=f->fin;
	g->taille=f->taille;

	return g;

}

int File_egal(File *f, File *g)
{
    Element* p = NULL;
    Element* q = NULL;
    int egal = 1;
	/*On teste les file vides*/
	if(f->debut==NULL || g->debut==NULL)
	{
		if(g->debut==NULL && f->debut==NULL)
		{
			return 1;
		}
		else
		{
			printf("DEBUG : une file vide.\n");
			return 0;
		}
	}

	/*On vérifie qu'elles ont la même taille*/
	if(f->taille != g->taille)
	{
		printf("DEBUG : tailles de files differentes.\n");
		return 0;
	}

	p = malloc(sizeof(Element));
	q = malloc(sizeof(Element));
	p = f->debut;
	q = g->debut;

	while((p->succ!=NULL)&&(egal==1))
	{
		if(p->valeur != q->valeur)
			egal=0;

		p=p->succ;
		q=q->succ;

	}

	return egal;

}

void File_chaine(File* f, void (*toString)(void*, char*), char* chaine)
{
	Element* p = f->debut;
	char buffer[50];

    chaine[0] = '\0';
    (*toString)(p->valeur, buffer);
    strcat(chaine, buffer);
    strcat(chaine, " ");
    do
    {
        p = p->succ;
        (*toString)(p->valeur, buffer);
        strcat(chaine, buffer);
        strcat(chaine, " ");
    }while(p->succ != NULL);
}

//Fonctions de conversions pour file_chaine()

void intToString(void* element, char* str)
{
    int x = *(int*)element;
    sprintf(str, "%d", x);
}

void charToString(void* element, char* str)
{
    char c = *(char*)element;
    sprintf(str, "%c", c);
}

void stringToString(void* element, char* str)
{
    char* s = *(char**)element;
    sprintf(str, "%s", s);
}

void floatToString(void* element, char* str)
{
    float x = *(float*)element;
    sprintf(str, "%f", x);
}
