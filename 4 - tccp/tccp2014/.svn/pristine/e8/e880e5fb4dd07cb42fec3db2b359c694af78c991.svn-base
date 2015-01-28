#ifndef PILE_H
#define PILE_H
#include<stdlib.h>
#include<stdio.h>
#include<string.h>

#define SD_PILE_MAX_SIZE 1073741823

/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\struct <sd_pile>
 *\details {Main structure of the pile containing the pile size (the size that is actually reachable by the user), its capacity (the size actually reserved in memory) and its containt itself into an array of pointors. In order to store every possible types, generic void* type is used. Accessing to an element require the use of a cast before the accessing function. In order to facilitate the use of the associated function, the sd_pile prefixe is not needed in use}
 */

struct sd_pile{
     size_t v_size; /*number of element actually usable by user*/
     size_t v_capacity; /*number of element really alocated in memory*/
     void** content; /*array of pointors*/

     int (*is_null)(struct sd_pile* this);
     size_t (*size)(struct sd_pile* this);
     size_t (*capacity)(struct sd_pile *pile);
     int (*is_empty)(struct sd_pile *this);
     void (*reserve)(size_t new_capacity, struct sd_pile *this);
     void* (*back)(struct sd_pile *this);
     void (*push_back)(void* element, struct sd_pile *this);
     void (*pop_back)(struct sd_pile * this);
     void (*erase)(size_t begin, size_t end, struct sd_pile *this);
     void (*clear)(struct sd_pile *this);
     void (*info)(char* info, struct sd_pile *this);
     struct sd_pile* (*replicate)(struct sd_pile *this);
};typedef struct sd_pile sd_pile;

typedef struct sd_pile* Pile;


/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\fn struct sd_pile_new()
 *\details {create and initialize a sd_pile struct, and return it}
 */
struct sd_pile *sd_pile_new();

/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\fn void sd_pile_delete(struct sd_pile* this)
 *\details {Delete the structure passed in argument. The element pointed by the pile must be deleted first}
 */
void sd_pile_delete(struct sd_pile* this);

/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\fn void sd_pile_delete(struct sd_pile* this)
 *\details {Erase all elements of the pile, setting its size to 0. If this pointer is NULL, it causes the end of the programm}
 */
void sd_pile_clear(struct sd_pile* this);

/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\fn int sd_pile_is_null(struct sd_pile* this)
 *\details {Return 1 if the pile's pointer is NULL, 0 else}
 */
int sd_pile_is_null(struct sd_pile* this);

/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\fn size_t sd_pile_size(struct sd_pile* this)
 *\details {Return the size fo the pile. If this pointer is NULL, it causes the end of the programm}
 */
size_t sd_pile_size(struct sd_pile* this);

/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\fn size_t sd_pile_capacity(struct sd_pile* this)
 *\details {Return the pile capacity. If this pointer is NULL, it causes the end of the programm}
 */  
size_t sd_pile_capacity(struct sd_pile *this);

/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\fn int sd_pile_is_empty(struct sd_pile* this)
 *\details {Return if the pile is empty. If this pointer is NULL, it causes the end of the programm}
 */
int sd_pile_is_empty(struct sd_pile *this);

/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\fn void sd_pile_reserve(size_t new_capacity, struct sd_pile* this)
 *\details {Change the size of the pile, causing a reallocation if new_capacity is superior to the current capacity. If this pointer is NULL, or if the reallocation isn't possible, it causes the end of the programm}
 */
void sd_pile_reserve(size_t new_capacity, struct sd_pile *this);

/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\fn void* sd_pile_back(size_t i, struct sd_pile* this)
 *\details {Return a pointer on the last element of the pile. If the pile is NULL, it causes the end of the programm}
 */
void* sd_pile_back(struct sd_pile *this);

/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\fn void* sd_pile_push_back(void* element, struct sd_pile* this)
 *\details {Increase the pile size by 1 and put element at the end. If this pointer is NULL, it causes the end of the programm}
 */
void sd_pile_push_back(void* element, struct sd_pile * this);

/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\fn void sd_pile_pop_back(struct sd_pile* this)
 *\details {Destroy the last element of the pile and reduce its size by 1. If this pointer is NULL, it causes the end of the programm}
 */
void sd_pile_pop_back(struct sd_pile * this);

/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\fn void sd_pile_info(char* info, struct sd_pile* info)
 *\details {Fill info with a string describing the pile. info should be of a size of 100 at least. If this pointer is NULL, it causes the end of the programm}
 */
void sd_pile_info(char* info, struct sd_pile *this);

/*!
 *\author Cyril Barcelo
 *\author Samuel Juhel
 *\fn struct sd_pile* sd_pile_replicate(struct sd_pile* this)
 *\details {Return a pile with the same caracteristics than this. This means that both piles have pointers on the sames objects. If this pointer is NULL, it causes the end of the programm}
 */
struct sd_pile* sd_pile_replicate(struct sd_pile *this);

#endif /* PILE_H */
