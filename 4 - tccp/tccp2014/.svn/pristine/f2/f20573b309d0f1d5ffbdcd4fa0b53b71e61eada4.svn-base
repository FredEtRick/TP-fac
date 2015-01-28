/**
 *\file tableHachage.h
 *\brief Tableau associatif 
 *\author Abdoulaye Diallo, Redoine EL Ouasti
 *\version 0.2
 *\date 2014-12-09
 *
 * Tableau associatif (map, tableau de hashage) implementé en c à l'image de ceux qui existent dans d'autres langages.
 *
 */ 



#ifndef MAP
#define MAP

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <strings.h>

/**
 * author Abdoulaye Diallo, Redoine EL Ouasti
 * \struct cell
 * \brief La structure "cell" modelise une cellule du tableau asociatif, contenant la clé de type char* ainsi que les données de type générique 
 */
typedef struct{
	char *key; /*!< sert a stocker les clés de la structure */
	void *data; /*!< sert a stocker les données de la structure */
} cell;


/**
 * author Abdoulaye Diallo
 * \struct map_struct
 * \brief La structure "map_struct" represente le tableau associatif: l'ensemble des cellules et la taille  
 */
typedef struct{
	cell *p_cell;
	int size;
} map_struct;

/**
 * \author Abdoulaye Diallo
 * \fn map_struct *map_creer (void);
 * \brief La fonction "hashTable_creer" permet de creer en memoire et d'initialiser la structure.
 * \return un pointeur de type map_struct
*/
map_struct *map_creer (void);

/**
 * \author Abdoulaye Diallo, redoine EL Ouasti
 * \fn void map_ajouter (map_struct * p_table, const char *key, void *data)
 * \brief La fonction "map_ajouter" permet d'ajouter un nouvel element dans la structure representant le map.
 * \param p_table - la structure dans laquelle on ajoute l'element.
 * \param key - la clé à ajouter.
 * \param data - la donnée correspondante à ajouter.
*/
void map_ajouter (map_struct * p_table, const char *key, void *data);

/**
 * \author Abdoulaye Diallo, redoine EL Ouasti
 * \fn void* map_chercher(map_struct * p_table, const char *key)
 * \brief La fonction "map_chercher" permet de trouver un element dans la structure representant le map.
 * \param p_table - la structure dans laquelle on doit chercher.
 * \param key - la clé à chercher.
*/
void* map_chercher(map_struct * p_table, const char *key);

/**
 * \author Abdoulaye Diallo, redoine EL Ouasti
 * \fn void map_detruire (map_struct** p_table)
 * \brief La fonction "map_detruire" permet de supprimer et de désallouer en memoire la structure.
 * \param p_table - la structure à supprimer.
*/
void map_detruire (map_struct** p_table);

/**
 * \author Abdoulaye Diallo, redoine EL Ouasti
 * \fn void map_chaine(map_struct* p_table)
 * \brief La fonction "map_chaine" permet de transformer la structure en chaine. Elle sert de fonction d'affichage.
 * \param p_table - la structure à afficher.
*/
void map_chaine(map_struct* p_table);

/**
 * \author Abdoulaye Diallo, redoine EL Ouasti
 * \fn map_struct* map_clone (map_struct* p_table)
 * \brief La fonction "hashTable_clone" permet de faire une copie de la structure en parammetre. 
 * \param p_table - la structure à copier .
 * \return un pointeur de type map_struct
*/
map_struct* map_clone (map_struct* p_table);
#endif /* not H_TABLEHACHAGE */
