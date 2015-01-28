/**
 * \brief This file is a part of the C LinkedList library.
 * 
 * \file main.c
 * \author Loïc FORTIN <loic.fortin@etud.univ-montp2.fr>
 * \author Charly MAËDER
 * 
 * \version 1.2.0
 *
 * \date 7 octobre 2014, 10:48
 */

#include <stdio.h>
#include <stdlib.h>
#include "LinkedList.h"

/**
 * \brief Main function
 * \param argc Number of arguments
 * \param argv List of arguments
 * 
 * \return EXIT_SUCCESS if no error
 */
int main(int argc, char** argv) {
    printf("Entering software\n");
    
    struct LinkedList* list = ll_create();
    
    if(ll_empty(list))
        printf("Empty list\n");
    else
        printf("Not empty list\n");
    
    printf("Size of the list : %zu\n", ll_size(list));
    
    printf("Adding values (back)...\n");
    
    for(int i = 1; i <= 10; ++i) {
        int* val = (int*) malloc(sizeof(int));
        *val = i;
        ll_push_back(list, (void*) val);
    }
    
    printf("Size of the list : %zu\n", ll_size(list));
    
    printf("Adding values (front)...\n");
    
    for(int i = 11; i <= 20; ++i) {
        int* val =(int*) malloc(sizeof(int));
        *val = i;
        ll_push_front(list, (void*) val);
    }
    
    printf("Size of the list : %zu\n", ll_size(list));
    
    printf("Adding value 333 at a specified position (11)...\n");
    
    int* val = (int*) malloc(sizeof(int));
    *val = 333;
    ll_insert(list, 11, (void*) val, 1);
    
    printf("Size of the list : %zu\n", ll_size(list));
    
    printf("Swapping first and last values\n");
    
    ll_swap(list, 0, list->length - 1);
    
    printf("Listing values :\n");
    
    for(size_t i = 1; i <= ll_size(list); ++i)
        printf("Number %zu = %d\n", i, *((int*) ll_get(list, i-1)));
    
    printf("Search for value 333... ");
    int* dval = (int*) malloc(sizeof(int));
    *dval = 333;
    if(ll_contains(list, (void*) dval)) {
        printf("found ");
        
        int* sval = (int*) ll_get(list, 11);
        
        printf("(%d)\n", *sval);
    }
    else {
        printf("not found\n");
    }
    
    printf("Search for value 894... ");
    int* dval2 = (int*) malloc(sizeof(int));
    *dval2 = 894;
    if(ll_contains(list, (void*) dval2)) {
        printf("found ");
        
        int* sval2 = (int*) ll_get(list, 11);
        
        printf("(%d)\n", *sval2);
    }
    else {
        printf("not found\n");
    }
    
    printf("Getting value 10 : %d\n", *((int*) ll_get(list, 9)));
    
    printf("Cloning list (name : list2)\n");
    
    struct LinkedList* list2 = ll_clone(list);
    
    printf("Size of list2 : %zu\n", ll_size(list2));
    
    printf("Adding value in front of list2...\n");
    
    int* val3 = (int*) malloc(sizeof(int));
    *val3 = 666;
    ll_push_front(list2, (void*) val3);
    
    for(size_t i = 1; i <= ll_size(list2); ++i)
        printf("list2 : Number %zu = %d\n", i, *((int*) ll_get(list2, i-1)));
    
    printf("Removing first value (list)...\n");
    
    ll_remove(list);
    
    printf("Size of list : %zu\n", ll_size(list));
    
    printf("Clearing all values from list...\n");
    ll_clear(list);
    
    printf("Size of the list : %zu\n", ll_size(list));
    
    for(size_t i = 1; i <= ll_size(list); ++i)
        printf("Number %zu = %d\n", i, *((int*) ll_get(list, i-1)));
    
    printf("Destroying list\n");
    
    ll_destroy(list);
    
    printf("Size of list2 : %zu\n", ll_size(list2));
    
    printf("Destroying list2\n");
    
    ll_destroy(list2);

    printf("Ending software\n");
    
    return (EXIT_SUCCESS);
}

