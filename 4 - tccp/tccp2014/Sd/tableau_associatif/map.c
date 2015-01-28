/**
 *\file map.c
 *\brief Implementation des fonctions definies dans map.h
 *\author Abdoulaye Diallo, Redoine El Ouasti
 *\version 0.2
 *\date 2014-12-10
 *
 * Implementation des differentes fonctions definies dans map.h
 *
 */



#include "map.h"

map_struct *map_creer (void){
	map_struct *p_table = NULL;
	p_table = malloc (sizeof (*p_table));
	
	if (p_table != NULL){
		p_table->p_cell = NULL;
		p_table->size = 0;
	}
	else{
		fprintf (stderr, "Memoire insufisante\n");
		exit (EXIT_FAILURE);
	}
	return (p_table);
}


void map_ajouter (map_struct * p_table, const char *key, void *data){
	if (p_table != NULL && key != NULL)	{
		int i = 0;
		cell *p_cell = NULL;
		void *tmp;
		while (i < p_table->size)
		{
			if (strcmp (p_table->p_cell[i].key, key) == 0) /* si clé existe, on remplace */
			{
				p_cell = &p_table->p_cell[i]; 
				break;
			}
			i++;
		}
		if (p_cell == NULL) /* si clé n'existe pas, on la crée*/
		{
			p_table->size++; /*on augmente la taille du tableau */
			tmp = realloc (p_table->p_cell,	sizeof (*p_table->p_cell) * p_table->size);
			if (tmp != NULL)
			{
			p_table->p_cell = tmp;
			p_cell = &p_table->p_cell[p_table->size - 1];  /*p_cell pointe maintenant sur une cellule valide du tableau  */
			p_cell->key = NULL;
			}
			else
			{
			fprintf (stderr, "Memoire insufisante\n");
			exit (EXIT_FAILURE);
			}
		}
		/* on redimensionne la taille en fonction du parametre de la fonction, on le copie et enfin on copie le pointeur sur la data (utilisateur) */
		tmp = realloc (p_cell->key,sizeof (*p_cell->key) * (strlen (key) + 1));
		if (tmp != NULL)
		{
			p_cell->key = tmp;
			strcpy (p_cell->key, key);
			p_cell->data = data;
		}
		else
		{
			fprintf (stderr, "Memoire insufisante\n");
			exit (EXIT_FAILURE);
		}
	}
	else
	{
		fprintf (stderr, "Memoire insufisante\n");
		exit (EXIT_FAILURE);
	}
	return;
}

void * map_chercher(map_struct * p_table, const char *key)
{
	void *data = NULL;
	if (p_table != NULL && key != NULL){
		int i = 0;
		while (i < p_table->size){
			if (strcmp (p_table->p_cell[i].key, key) == 0){
				data = (p_table->p_cell)[i].data;
				break;
			}
		i++;
		}
	}
	return (data);
}

void map_detruire (map_struct ** p_table){
	int i;
	for (i = 0; i < (*p_table)->size; i++)
		free ((*p_table)->p_cell[i].key);
	free ((*p_table)->p_cell);
	free (*p_table);
	*p_table = NULL;
	return;
}

void map_chaine(map_struct * p_table){
	printf("Affichage du tableau associatif (map): taille = %d \n", p_table->size);
	int i;
	for (i = 0; i < p_table->size; i++)
		printf("%s ==> %p \n",(p_table->p_cell)[i].key ,(p_table->p_cell)[i].data);
	return;
}

map_struct* map_clone (map_struct* p_table){
	map_struct* copie = map_creer();
	/*int i;
	for (i = 0; i < p_table->size; i++){
		(copie->p_cell)[i].key = (p_table->p_cell)[i].key;
		(copie->p_cell)[i].data = (p_table->p_cell)[i].data;
	}*/
	bcopy(p_table,copie,(size_t)sizeof(*p_table));
	return copie;
}
