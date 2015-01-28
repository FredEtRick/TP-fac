#include"pile.h"

struct sd_pile* sd_pile_new()
{

  struct sd_pile *this = malloc(sizeof(struct sd_pile)); 
  this->v_size=0;
  this->v_capacity = 1;
  
  this->content = malloc((this->v_capacity) * (sizeof(void*)));

  this->is_null = sd_pile_is_null;
  this->size=sd_pile_size;
  this->capacity=sd_pile_capacity;
  this->is_empty=sd_pile_is_empty;
  this->reserve=sd_pile_reserve;
  this->back=this->content[this->v_size];
  this->push_back=sd_pile_push_back;
  this->pop_back=sd_pile_pop_back;
  this->clear=sd_pile_clear;
  this->info=sd_pile_info;
  this->replicate=sd_pile_replicate;
  return this;
}

int sd_pile_is_null(struct sd_pile* this)
{
  if(this == NULL)
    return 1;
  else
    return 0;
}

void sd_pile_delete(struct sd_pile* this)
{
  if(!sd_pile_is_null(this))
    {
      free(this->content);
      free(this);
      }
}

void sd_pile_clear(struct sd_pile *this)
{
  if(sd_pile_is_null(this))
    {
      fprintf(stderr, "clear() - Error: pile is NULL");
      exit(1) ;
    }
  while(sd_pile_size(this)!=0){
       sd_pile_pop_back(this);
  }
}

size_t sd_pile_size(struct sd_pile* this)
{
  if(sd_pile_is_null(this))
    {
      fprintf(stderr, "size() - Error: pile is NULL");
      exit(1) ;
    }
  else
    return this->v_size;
}

size_t sd_pile_max_size(){
  return SD_PILE_MAX_SIZE;
}


size_t sd_pile_capacity(struct sd_pile *this)
{

  if(sd_pile_is_null(this))
    {
      fprintf(stderr, "capacity() - Error: pile is NULL");
      exit(1) ;
    }
  
  return this->v_capacity;
}

int sd_pile_is_empty(struct sd_pile *this)
{
  if(sd_pile_is_null(this))
    {
      fprintf(stderr, "empty() - Error: pile is NULL");
      exit(1) ;
    }
  
  return this->v_size==0;
}


void sd_pile_reserve(size_t new_capacity, struct sd_pile *this){
  if(new_capacity<0){
     fprintf(stderr, "reserve() - Error: new_capacity is negative");
     exit(1);
  }
  if(sd_pile_is_null(this))
    {
      fprintf(stderr, "reserve() - Error: pile is NULL");
      exit(1) ;
    }


  if(new_capacity < SD_PILE_MAX_SIZE)
    {
      this->v_capacity = new_capacity;
      if( ((this->content = (void **)realloc(this->content, new_capacity * sizeof(void *)))==NULL))
	{
	  fprintf(stderr, "reserve() - Error: reallocation failed");
	  exit(1);
	}
    }
  else
    { 
      fprintf(stderr, "capacity() - Error: new capacity superior to MAX_CAPACITY");
      exit(1);
    }
  if(this->v_size > this->v_capacity)
    this->v_size=this->v_capacity;
    
  printf("resize\n");
}

// Element access : 

void* sd_pile_back(struct sd_pile *this)
{
  if(sd_pile_is_null(this))
    {
      fprintf(stderr, "back() - Error: pile is NULL");
      exit(1) ;
    }
  if(sd_pile_is_empty(this))
    return NULL;
  else 
    return this->back;
}



//Modifiers:

void sd_pile_push_back(void* element, struct sd_pile * this){
  if(sd_pile_is_null(this))
    {
      fprintf(stderr, "push_back() - Error: pile is NULL");
      exit(1) ;
    }
  
  // On s'assure d'avoir la capacité de stockage, et on la double dans le cas contraire :

  if( (this->v_size +1) > (this->v_capacity) ) 
      sd_pile_reserve(2 * this->v_capacity, this);

  // On accepte l'element :
  this->content[this->v_size] = element;

  // On augmente la taille.
  this->v_size++; 
}

void sd_pile_pop_back(struct sd_pile * this)
{
  if(sd_pile_is_null(this))
    {
      fprintf(stderr, "pop_back() - Error: pile is NULL");
      exit(1) ;
    }
  if(this->v_size > 0)
    this->v_size--;
}

void sd_pile_info(char* info, struct sd_pile *this)
{
  if(sd_pile_is_null(this))
    {
      fprintf(stderr, "info() - Error: pile is NULL");
      exit(1) ;
    }
  sprintf(info,"La pile à une taille de: %d élément(s)\npour une capacité de: %d élément(s)\n", (int)this->v_size, (int)this->v_capacity);
}

struct sd_pile* sd_pile_replicate(struct sd_pile *this)
{
  if(this == NULL)
    return NULL;
  else
    {
      struct sd_pile* tmp = sd_pile_new();
      tmp->reserve(this->v_capacity,tmp);

      struct sd_pile* second = sd_pile_new();
      second->reserve(this->v_capacity,second);
      
      for(size_t i=0; i< (this->v_size); i++)
	{
	     sd_pile_push_back(sd_pile_back(this),tmp);
	     sd_pile_pop_back(this);
	}
      for(size_t i=0; i< (this->v_size); i++)
	{
	     sd_pile_push_back(sd_pile_back(tmp),this);
	     sd_pile_push_back(sd_pile_back(tmp),second);
	     sd_pile_pop_back(tmp);
	}
      
      sd_pile_delete(tmp);
      
      return second;
    }
}
 
