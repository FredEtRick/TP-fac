#ifndef FILE_H_INCLUDED
#define FILE_H_INCLUDED

/*!
 * \file file.h
 * \brief Structure de données génériques FIFO.
 * \author Lemattre Julien et Veber Axel
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*!
 * \struct Element
 * \brief Contient un élément d'une file, et pointe vers l'élément suivant.
 */

typedef struct Element
{
    void* valeur;
    struct Element* succ;
} Element;

/*!
 * \struct File
 * \brief Contient la tête, la queue et la taille de la file.
 */

typedef struct File
{
    Element* debut;
    Element* fin;
    int taille;
} File;

/*--------------------------------------Opérations sur les files--------------------------------------*/
/*!
 * \fn File* File_creer(void)
 * \brief Crée une file vide.
 * \author Veber Axel
 * \return Un pointeur vers la file crée.
 */
File* File_creer();

/*!
 * \fn void File_detruire(File* f)
 * \brief Dépile tout les éléments de la file et la détruit.
 * \author Veber Axel
 * \param f Un pointeur de la file à détruire.
 */
void File_detruire(File* f);

/*!
 * \fn int File_estVide(File* f)
 * \brief Test si une pile est vide ou non.
 * \author Veber Axel
 * \param f Un pointeur vers la pile à tester.
 * \return Renvoie 1 si la pile est vide, 0 sinon.
 */
int File_estVide(File* f);

/*!
 * \fn void* File_defiler(File* f)
 * \brief Extrait l'élément le plus ancien de la file.
 * \author Lemattre Julien
 * \param f Un pointeur vers la pile à défiler.
 * \return Renvoie un pointeur vers la valeur de l'élément défilé. Renvoie NULL si la file est vide.
 */
void* File_defiler(File *f);

/*!
 * \fn void File_enfiler(File* f, void* o)
 * \brief Rajoute un élément dans la file.
 * \author Veber Axel
 * \param f Un pointeur vers la pile à enfiler.
 * \param o Un pointeur vers la valeur à enfiler.
 */
void File_enfiler(File* f, void* o);

/*!
 * \fn int File_compare(File* f, File* g)
 * \brief Compare la taille de deux files f et g.
 * \author Lemattre Julien
 * \param f Un pointeur vers la première pile à comparer.
 * \param g Un pointeur vers la deuxième pile à comparer.
 * \return Renvoie 0 si f et g sont de la même taille, renvoie <0 si g et plus grand que f, >0 sinon.
 */
int File_compare(File *f, File *g);

/*!
 * \fn File* File_clone(File* f)
 * \brief Clone une file (non récursif).
 * \author Lemattre Julien
 * \param f Un pointeur vers la pile à cloner.
 * \return Un pointeur vers le clone de f.
 */
File* File_clone(File *f);

/*!
 * \fn int File_egal(File* f, File* g)
 * \brief Vérifie si deux files ont les mêmes éléments
 * \author Lemattre Julien
 * \param f Un pointeur vers la première pile à vérifier.
 * \param g Un pointeur vers la deuxième pile à vérifier.
 * \return Renvoie 1 si les files ont les mêmes éléments, 0 sinon.
 */
int File_egal(File *f, File *g);

/*!
 * \fn void File_chaine(File* f, void (*toString)(void*, char*), char* chaine)
 * \brief Met le contenu de la file dans une chaîne de caractères.
 * \author Veber Axel
 * \param f Un pointeur vers la file.
 * \param toString Un pointeur vers la fonction permettant d'interpréter les éléments en chaîne de caractères.
 * \param chaine Un pointeur vers la chaîne de caractères en résultat.
 */
void File_chaine(File* f, void (*toString)(void*, char*), char* chaine);

/*--------------------------------------Fonctions de conversions pour file_chaine()--------------------------------------*/
/*!
 * \fn void intToString(void* element, char* str)
 * \brief Met la valeur d'un entier dans une chaîne de caractères.
 * \author Veber Axel
 * \param element Un pointeur vers la valeur à convertir.
 * \param str Un pointeur vers la chaîne de caractères de sortie.
 */
void intToString(void* element, char* str);

/*!
 * \fn void charToString(void* element, char* str)
 * \brief Met un caractère dans une chaîne de caractères.
 * \author Veber Axel
 * \param element Un pointeur vers la valeur à convertir.
 * \param str Un pointeur vers la chaîne de caractères de sortie.
 */
void charToString(void* element, char* str);

/*!
 * \fn void stringToString(void* element, char* str)
 * \brief Met une chaîne de caractères dans une autre chaîne de caractères.
 * \author Veber Axel
 * \param element Un pointeur vers la valeur à convertir.
 * \param str Un pointeur vers la chaîne de caractères de sortie.
 */
void stringToString(void* element, char* str);

/*!
 * \fn void floatToString(void* element, char* str)
 * \brief Met la valeur d'un flottant dans une chaîne de caractères.
 * \author Veber Axel
 * \param element Un pointeur vers la valeur à convertir.
 * \param str Un pointeur vers la chaîne de caractères de sortie.
 */
void floatToString(void* element, char* str);

#endif /* FILE_H_INCLUDED*/
