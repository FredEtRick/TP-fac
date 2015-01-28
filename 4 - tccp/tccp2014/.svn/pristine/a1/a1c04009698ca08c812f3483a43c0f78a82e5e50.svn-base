/**
 * \brief This file is a part of the C LinkedList library.
 * 
 * \file LinkedList.h
 * \author Loïc FORTIN <loic.fortin@etud.univ-montp2.fr>
 * \author Charly MAËDER
 * 
 * \version 1.2.0
 *
 * \date 3 october 2014, 09:08
 */

#ifndef LINKEDLIST_H
#define	LINKEDLIST_H

#ifdef	__cplusplus
extern "C" {
#endif

#include <stdlib.h>
#include <stdbool.h> // bool
#include <string.h> // memcpy, memcmp

#define EMPTY_LIST_EXCEPTION 10
#define INDEX_OUT_OF_RANGE_EXCEPTION 11
#define NUMBER_INSERTION_EXCEPTION 12
#define MEMORY_ALLOCATION_FAIL_EXCEPTION 13
#define CIRCULAR_REFERENCE_EXCEPTION 14

/**
 * \struct Node
 * \brief Single element on the list
 * 
 * This structure represent a single element (node) on the list.
 * It stores the data and has a pointer to the previous and next elements (node) of the list.
 */
struct Node {
    void* value; /*!< Value of the element */
    struct Node* previous; /*!< Pointer to the previous element */
    struct Node* next; /*!< Pointer to the next element */
};

/**
 * \struct LinkedList
 * \brief Linked list
 * 
 * This structure represent the doubly linked list.
 * It stores the length of the list and has a pointer to the first and last elements.
 */
struct LinkedList {
    size_t length; /*!< Length of the list */
    struct Node* first; /*!< Pointer to the first element of the list */
    struct Node* last; /*!< Pointer to the last element of the list */
};

/**
 * \brief Removes all elements from the list container (which are destroyed), and leaving the container with a size of 0.
 * 
 * \param list Pointer to the container.
 */
void ll_clear(struct LinkedList* list);

/**
 * \brief Returns a copy of the LinkedList.
 * 
 * \param list Pointer to the container.
 * 
 * \return A copy of the list
 */
struct LinkedList* ll_clone(struct LinkedList* list);

/**
 * \brief Returns true if this list contains the specified element, false otherwise.
 * 
 * \param list Pointer to the container
 * \param value The value to search for.
 */
bool ll_contains(struct LinkedList* list, void* value);

/**
 * \brief Create a new list container.
 * 
 * \param list Pointer to the container.
 * 
 * \return A new LinkedList
 */
struct LinkedList* ll_create();

/**
 * \brief Destroy a list container
 * 
 * \param list Pointer to the container.
 */
void ll_destroy(struct LinkedList* list);

/**
 * \brief Returns whether the list container is empty (i.e. whether its size is 0).
 * 
 * \param list Pointer to the container.
 * 
 * \return true if the container size is 0, false otherwise.
 */
bool ll_empty(struct LinkedList* list);

/**
 * \brief Returns the value of the first element in this list. 
 * 
 * \param list Pointer to the container.
 * 
 * \return The value of the first element in the list
 */
void* ll_first(struct LinkedList* list);

/**
 * \brief Returns the value of the element at the specified position in this list. 
 * 
 * \param list Pointer to the container.
 * 
 * \return The value of an element at a specified position in the list
 */
void* ll_get(struct LinkedList* list, size_t index);

/**
 * \brief The container is extended by inserting new elements before the element at the specified position.
 *        This effectively increases the list size by the amount of elements inserted.
 * 
 * \param list Pointer to the container.
 * \param index Inserts the element at the specified position in this list.
 * \param value Value of the inserted elements.
 * \param n Number of elements to insert. Each element is initialized to a copy of value.
 */
void ll_insert(struct LinkedList* list, size_t index, void* value, size_t n);

/**
 * \brief Returns the value of the last element in this list. 
 * 
 * \param list Pointer to the container.
 * 
 * \return The value of the last element in the list
 */
void* ll_last(struct LinkedList* list);

/**
 * \brief Removes and returns the value of the last element in the list container, effectively reducing the container size by one.
 *        This destroys the removed element.
 * 
 * \param list Pointer to the container.
 * 
 * \return The value of the last element of this list
 */
void* ll_pop_back(struct LinkedList* list);

/**
 * \brief Removes and returns the value of the the first element in the list container, effectively reducing its size by one.
 *        This destroys the removed element.
 * 
 * \param list Pointer to the container.
 * 
 * \return The value of the first element of this list
 */
void* ll_pop_front(struct LinkedList* list);

/**
 * \brief Adds a new element at the end of the list container, after its current last element. The content of data is copied to the new element.
 *        This effectively increases the container size by one.
 * 
 * \param list Pointer to the container.
 * \param value Value to be copied to the new element.
 */
void ll_push_back(struct LinkedList* list, void* value);

/**
 * \brief Inserts a new element at the beginning of the list, right before its current first element. The content of data is copied to the inserted element.
 *        This effectively increases the container size by one.
 * 
 * \param list Pointer to the container.
 * \param value Value to be copied to the new element.
 */
void ll_push_front(struct LinkedList* list, void* value);

/**
 * \brief Removes the head (first element) of this list.
 *        This destroys the removed element.
 * 
 * \param list Pointer to the container.
 */
void ll_remove(struct LinkedList* list);

/**
 * \brief Removes the element at the specified position in this list.
 *        This destroys the removed element.
 * 
 * \param list Pointer to the container
 * \param index The index of the element to be removed
 */
void ll_remove_at(struct LinkedList* list, size_t index);

/**
 * \brief Returns the number of elements in the list container.
 * 
 * \param list Pointer to the container
 * 
 * \return The size of the container
 */
size_t ll_size(struct LinkedList* list);

/**
 * \brief Exchanges the value of x by the value of y, which is another value of the same type. Sizes may differ.
 *        After the call to this function, the elements in x are those which were in y before the call, and the elements of y are those which were in x. 
 * 
 * \param list Pointer to the doubly linked list
 * \param x Position of the first element
 * \param y Position of the second element
 */
void ll_swap(struct LinkedList* list, size_t x, size_t y);


#ifdef	__cplusplus
}
#endif

#endif	/* LINKEDLIST_H */

