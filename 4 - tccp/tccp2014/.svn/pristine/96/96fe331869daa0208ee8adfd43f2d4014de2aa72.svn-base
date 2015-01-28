#ifndef VECTOR_H
#define VECTOR_H

#include<stdlib.h>
#include<stdio.h>
#include<string.h>

#define SD_VECTOR_MAX_SIZE 1073741823
#define SD_VECTOR_LAST_IS_REPEATER 1
#define SD_VECTOR_LAST_IS_ITERATOR 2

/*!
 *\author Phillipot Quentin 
 *\author Guiraud Emmanuel 
 *\struct <sd_vector>
 *\details {Main structure of the vector containing the vector size (the size that is actually reachable by the user), its capacity (the size actually reserved in memory) and its containt itself into an array of pointors. In order to store every possible types, generic void* type is used. Accessing to an element require the use of a cast before the accessing function. In order to facilitate the use of the associated function, the sd_vector prefixe is not needed in use}
 */

struct sd_vector{
  size_t v_size; /*number of element actually usable by user*/
  size_t v_capacity; /*number of element really alocated in memory*/
  void** content; /*array of pointors*/

  int (*is_null)(struct sd_vector* this);
  size_t (*size)(struct sd_vector* this);
  void (*resize)(size_t size, void* value, struct sd_vector* this);
  size_t (*capacity)(struct sd_vector *vector);
  int (*is_empty)(struct sd_vector *this);
  void (*reserve)(size_t new_capacity, struct sd_vector *this);
  void (*shrink_to_fit)(struct sd_vector *this);
  void* (*at)(size_t i, struct sd_vector *this);
  void* (*front)(struct sd_vector *this);
  void* (*back)(struct sd_vector *this);
  void (*push_back)(void* element, struct sd_vector *this);
  void (*pop_back)(struct sd_vector * this);
  void (*insert)(size_t begin, void* value, size_t repeater, struct sd_vector* this);
  void (*erase)(size_t begin, size_t end, struct sd_vector *this);
  void (*swap)(struct sd_vector *this, struct sd_vector *other);
  void (*clear)(struct sd_vector *this);
  void (*emplace)(size_t position, void *value, struct sd_vector *this);
  void (*shiftr)(size_t begin, size_t space, struct sd_vector *this);
  void (*shiftl)(size_t begin, size_t space, struct sd_vector *this);
  void (*info)(char* info, struct sd_vector *this);
  struct sd_vector* (*replicate)(struct sd_vector *this);
};

typedef struct sd_vector sd_vector;

typedef struct sd_vector* Vector;


/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn struct sd_vector_new()
 *\details {create and initialize a sd_vector struct, and return it}
 */
struct sd_vector *sd_vector_new();

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void sd_vector_delete(struct sd_vector* this)
 *\details {Delete the structure passed in argument. The element pointed b the vector must be deleted first}
 */
void sd_vector_delete(struct sd_vector* this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn int sd_vector_is_null(struct sd_vector* this)
 *\details {Return 1 if the vector's pointer is NULL, 0 else}
 */
int sd_vector_is_null(struct sd_vector* this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn size_t sd_vector_size(struct sd_vector* this)
 *\details {Return the size fo the vector. If this pointer is NULL, it causes the end of the programm}
 */
size_t sd_vector_size(struct sd_vector* this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void sd_vector_resize(size_t size, void* value, struct sd_vector* this)
 *\details {Change the vector's size: if the new size is inferior to the actual, the vector will be reduced, losing elements out of the new range, else it's upgraded on the capacity. If size is superior to capacity, a reallocation is made and new elements are initialized to value. If no specific values are needed, set on NULL. If this pointer is NULL, it causes the end of the programm}
 */
void sd_vector_resize(size_t size, void* value, struct sd_vector* this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn size_t sd_vector_capacity(struct sd_vector* this)
 *\details {Return the vector capacity. If this pointer is NULL, it causes the end of the programm}
 */  
size_t sd_vector_capacity(struct sd_vector *this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn int sd_vector_is_empty(struct sd_vector* this)
 *\details {Return if the vector is empty. If this pointer is NULL, it causes the end of the programm}
 */
int sd_vector_is_empty(struct sd_vector *this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void sd_vector_reserve(size_t new_capacity, struct sd_vector* this)
 *\details {Change the size of the vector, causing a reallocation if new_capacity is superior to the current capacity. If this pointer is NULL, or if the reallocation isn't possible, it causes the end of the programm}
 */
void sd_vector_reserve(size_t new_capacity, struct sd_vector *this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void sd_vector_shrink_to_fit(struct sd_vector* this)
 *\details {Reduce the vector capacity to its current size}
 */
void sd_vector_shrink_to_fit(struct sd_vector *this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void* sd_vector_at(size_t i, struct sd_vector* this)
 *\details {Return a pointer on the element i of the vector. If the vector is NULL, it causes the end of the programm}
 */
void* sd_vector_at(size_t i, struct sd_vector *this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void* sd_vector_front(size_t i, struct sd_vector* this)
 *\details {Return a pointer on the first element of the vector. If the vector is NULL, it causes the end of the programm}
 */
void* sd_vector_front(struct sd_vector *this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void* sd_vector_back(size_t i, struct sd_vector* this)
 *\details {Return a pointer on the last element of the vector. If the vector is NULL, it causes the end of the programm}
 */
void* sd_vector_back(struct sd_vector *this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void* sd_vector_push_back(void* element, struct sd_vector* this)
 *\details {Increase the vector size by 1 and put element at the end. If this pointer is NULL, it causes the end of the programm}
 */
void sd_vector_push_back(void* element, struct sd_vector * this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void sd_vector_pop_back(struct sd_vector* this)
 *\details {Destroy the last element of the vector and reduce its size by 1. If this pointer is NULL, it causes the end of the programm}
 */
void sd_vector_pop_back(struct sd_vector * this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void sd_vector_insert(size_t begin, void* value, size_t repeater, struct sd_vector* this)
 *\details {Insert the value in the vector from begin to begin+repaeter. If repeater = 1, only one element is inserted. All previous elements are shifted in consequence to the end of the vector. The size and the capacity of the vector are modified as needed. If this pointer is NULL, it causes the end of the programm. If this pointer is NULL, it causes the end of the programm}
 */
void sd_vector_insert(size_t begin, void* value, size_t repeater, struct sd_vector *this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void sd_vector_erase(size_t begin, size_t end, struct sd_vector* this)
 *\details {Erase all elements from begin to end. All element above end are shifted to the beginning of the vector. The size of the vector is reduced as needed. If this pointer is NULL, it causes the end of the programm}
 */
void sd_vector_erase(size_t begin, size_t end, struct sd_vector *this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void sd_vector_swap(struct sd_vector*, struct sd_vector* this)
 *\details {Swap the content of the vectors}
 */
void sd_vector_swap(struct sd_vector *other, struct sd_vector * this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void sd_vector_clear(struct sd_vector* this)
 *\details {Erase all elements of the vector, setting its size to 0. If this pointer is NULL, it causes the end of the programm}
 */
void sd_vector_clear(struct sd_vector* this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void sd_vector_emplace(size_t position, void* value, struct sd_vector* this)
 *\details {Change the element at position by the one pointed by value. If this pointer is NULL, it causes the end of the programm}
 */
void sd_vector_emplace(size_t position, void *value, struct sd_vector *this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void sd_vector_shiftr(size_t begin, size_t space, struct sd_vector* this)
 *\details {Shift all element from begin to space by space size to the end of the vector. This function should not be needed by the user. If this pointer is NULL, it causes the end of the programm}
 */
void sd_vector_shiftr(size_t begin, size_t space, struct sd_vector *this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void sd_vector_shiftl(size_t begin, size_t space, struct sd_vector* this)
 *\details {Shift all element from begin to space by space size to the beginning of the vector. This function should not be needed by the user. If this pointer is NULL, it causes the end of the programm}
 */
void sd_vector_shiftl(size_t begin, size_t space, struct sd_vector *this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn void sd_vector_info(char* info, struct sd_vector* info)
 *\details {Fill info with a string describing the vector. info should be of a size of 100 at least. If this pointer is NULL, it causes the end of the programm}
 */
void sd_vector_info(char* info, struct sd_vector *this);

/*!
 *\author Phillipot Quentin
 *\author Guiraud Emmanuel
 *\fn struct sd_vector* sd_vector_replicate(struct sd_vector* this)
 *\details {Return a vector with the same caracteristics than this. This means that both vectors have pointers on the sames objects. If this pointer is NULL, it causes the end of the programm}
 */
struct sd_vector* sd_vector_replicate(struct sd_vector *this);

#endif
