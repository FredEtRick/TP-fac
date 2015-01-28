/**
 * \brief This file is a part of the C LinkedList library.
 * 
 * \file LinkedList.c
 * \author Loïc FORTIN <loic.fortin@etud.univ-montp2.fr>
 * \author Charly MAËDER
 * 
 * \version 1.2.0
 *
 * \date 6 octobre 2014, 07:41
 */

#include "LinkedList.h"

void ll_clear(struct LinkedList* list) {
    // Iterate until the list is empty
    while(!ll_empty(list)) {
        ll_remove(list);
    }
}

struct LinkedList* ll_clone(struct LinkedList* list) {
    struct LinkedList* tmp = ll_create();
    struct Node* ite = list->first;
    
    // Iterate until the end of the list
    while(ite) {
        void** value = (void**)malloc(sizeof(void*));
        
        if(!value)
            exit(MEMORY_ALLOCATION_FAIL_EXCEPTION);
        
        memcpy(value, ite->value, sizeof(void*));
        ll_push_back(tmp, value);
        ite = ite->next;
        
        if(ite == list->first) {
            exit(CIRCULAR_REFERENCE_EXCEPTION);
        }
    }
    
    return tmp;
}

bool ll_contains(struct LinkedList* list, void* value) {
    if(ll_empty(list))
        return false;
    
    struct Node* ite = list->first;
    
    // Iterate until we reach the value
    while(ite && (memcmp(ite->value, value, sizeof(void*)) != 0)) {
        ite = ite->next;
        
        if(ite == list->first) {
            exit(CIRCULAR_REFERENCE_EXCEPTION);
        }
    }
    
    return ((ite && (memcmp(ite->value, value, sizeof(void*)) == 0)) ? true : false);
}

struct LinkedList* ll_create() {
    struct LinkedList* list = (struct LinkedList*) malloc(sizeof(struct LinkedList));
    
    if(!list)
        exit(MEMORY_ALLOCATION_FAIL_EXCEPTION);
    
    list->first = NULL;
    list->last = NULL;
    list->length = 0;
    
    return list;
}

void ll_destroy(struct LinkedList* list) {
    ll_clear(list);
    free(list);
}

bool ll_empty(struct LinkedList* list) {
    return ((list->length == 0) ? true : false);
}

void* ll_first(struct LinkedList* list) {
    if(ll_empty(list))
        exit(EMPTY_LIST_EXCEPTION);
    
    return list->first->value;
}

void* ll_get(struct LinkedList* list, size_t index) {
    if(ll_empty(list))
        exit(EMPTY_LIST_EXCEPTION);
    
    //if(index < 0 || index >= list->length)
    if(index >= list->length)
        exit(INDEX_OUT_OF_RANGE_EXCEPTION);
    
    struct Node* ite = list->first;
    size_t i = 0;
    
    // Iterate until we reach the position
    while(i != index) {
        ite = ite->next;
        ++i;
    }
    
    return ite->value;
}

void ll_insert(struct LinkedList* list, size_t index, void* value, size_t n) {
    if(n < 1)
        exit(NUMBER_INSERTION_EXCEPTION);
    
    size_t k = 0; // Number of elements insered
    
    // If list is empty AND index == 0, we create a new element
    if(ll_empty(list) && index == 0) {
        struct Node* tmp = (struct Node*) malloc(sizeof(struct Node));

        if(!tmp)
            exit(MEMORY_ALLOCATION_FAIL_EXCEPTION);

        // Updating element
        tmp->previous = NULL;
        tmp->next = NULL;
        tmp->value = value;

        // Updating list
        list->first = tmp;
        list->last = tmp;
        ++list->length;
        
        ++k;
    }

    //if(index < 0 || index >= list->length)
    if(index >= list->length)
        exit(INDEX_OUT_OF_RANGE_EXCEPTION);
    
    struct Node* ite = list->first;
    size_t j = 0;
    
    // Iterate until we reach the position
    while(j != index) {
        ite = ite->next;
        ++j;
    }
    
    while(k < n) {
        struct Node* tmp = (struct Node*) malloc(sizeof(struct Node));

        if(!tmp)
            exit(MEMORY_ALLOCATION_FAIL_EXCEPTION);
        
        // Updating element
        tmp->previous = ite->previous;
        tmp->next = ite;
        tmp->value = value;
        ite->previous = tmp;
        
        // If it is the first element, we need to update the list
        if(tmp->previous == NULL)
            list->first = tmp;
        else
            (tmp->previous)->next = tmp;
        
        ++list->length;
        
        ++k;
    }
}

void* ll_last(struct LinkedList* list) {
    if(ll_empty(list))
        exit(EMPTY_LIST_EXCEPTION);
    
    return list->last->value;
}

void* ll_pop_back(struct LinkedList* list) {
    void* value = ll_last(list);
    
    ll_remove_at(list, list->length - 1);
    
    return value;
}

void* ll_pop_front(struct LinkedList* list) {
    void* value = ll_first(list);
    
    ll_remove(list);
    
    return value;
}

void ll_push_back(struct LinkedList* list, void* value) {
    if(ll_empty(list)) {
        ll_push_front(list, value);
    }
    else {
        ll_insert(list, list->length - 1, value, 1);
        ll_swap(list, list->length - 2, list->length - 1);
    }
}

void ll_push_front(struct LinkedList* list, void* value) {
    
    ll_insert(list, 0, value, 1);
}

void ll_remove(struct LinkedList* list) {
    ll_remove_at(list, 0);
}

void ll_remove_at(struct LinkedList* list, size_t index) {
    if(ll_empty(list))
        exit(EMPTY_LIST_EXCEPTION);
    
    //if(index < 0 || index >= list->length)
    if(index >= list->length)
        exit(INDEX_OUT_OF_RANGE_EXCEPTION);
    
    struct Node* tmp = list->first;
    size_t i = 0;
    
    // Iterate until we reach the position
    while(i != index) {
        tmp = tmp->next;
        ++i;
    }
    
    free(tmp->value);
    
    if(tmp->previous != NULL) {
        (tmp->previous)->next = tmp->next;
    }
    else {
        list->first = tmp->next;
    }
    
    if(tmp->next != NULL) {
        (tmp->next)->previous = tmp->previous;
    }
    else {
        list->last = tmp->previous;
    }
    
    tmp->previous = NULL;
    tmp->next = NULL;
    
    free(tmp);
    
    --list->length;
}

size_t ll_size(struct LinkedList* list) {
    return list->length;
}

void ll_swap(struct LinkedList* list, size_t x, size_t y) {
    if(ll_empty(list))
        exit(EMPTY_LIST_EXCEPTION);
    
    //if(x < 0 || x >= list->length)
    if(x >= list->length)
        exit(INDEX_OUT_OF_RANGE_EXCEPTION);
    
    //if(y < 0 || y >= list->length)
    if(y >= list->length)
        exit(INDEX_OUT_OF_RANGE_EXCEPTION);
    
    struct Node* xtmp = list->first;
    size_t i = 0;
    
    // Iterate until we reach the position
    while(i != x) {
        xtmp = xtmp->next;
        ++i;
    }
    
    struct Node* ytmp = list->first;
    size_t j = 0;
    
    // Iterate until we reach the position
    while(j != y) {
        ytmp = ytmp->next;
        ++j;
    }
    
    void* vtmp = xtmp->value;
    xtmp->value = ytmp->value;
    ytmp->value = vtmp;
}
