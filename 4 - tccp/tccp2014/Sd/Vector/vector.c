#include"vector.h"

struct sd_vector* sd_vector_new()
{

  struct sd_vector *this = malloc(sizeof(struct sd_vector)); 
  this->v_size=0;
  this->v_capacity = 1;
  
  this->content = malloc((this->v_capacity) * (sizeof(void*)));

  this->is_null = sd_vector_is_null;
  this->size=sd_vector_size;
  this->resize=sd_vector_resize;
  this->capacity=sd_vector_capacity;
  this->is_empty=sd_vector_is_empty;
  this->reserve=sd_vector_reserve;
  this->shrink_to_fit=sd_vector_shrink_to_fit;
  this->at=sd_vector_at;
  this->front=sd_vector_front;
  this->back=sd_vector_back;
  this->push_back=sd_vector_push_back;
  this->pop_back=sd_vector_pop_back;
  this->insert=sd_vector_insert;
  this->erase=sd_vector_erase;
  this->swap=sd_vector_swap;
  this->clear=sd_vector_clear;
  this->emplace=sd_vector_emplace;
  this->shiftr=sd_vector_shiftr;
  this->shiftl=sd_vector_shiftl;
  this->info=sd_vector_info;
  this->replicate=sd_vector_replicate;
  
  return this;
}

int sd_vector_is_null(struct sd_vector* this)
{
  if(this == NULL)
    return 1;
  else
    return 0;
}

void sd_vector_delete(struct sd_vector* this)
{
  
  if(!sd_vector_is_null(this))
    {
      free(this->content);
      free(this);
      }
}

size_t sd_vector_size(struct sd_vector* this)
{
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "size() - Error: vector is NULL");
      exit(1) ;
    }
  else
    return this->v_size;
}

size_t sd_vector_max_size(){
  return SD_VECTOR_MAX_SIZE;
}


void sd_vector_resize(size_t size, void* value, struct sd_vector* this)
{
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "resize() - Error: vector is NULL");
      exit(1) ;
    }
  else
    {
      // Increase v_capacity if needeed and put value (default : NULL) into new cases
      if(size <= this->v_size){
	this->v_size = size;
      }
      else{
	for(size_t i = this->v_size; i<size; i++)
	{
     	  sd_vector_push_back(value, this);
	}
	
      }
    } 
}


size_t sd_vector_capacity(struct sd_vector *this)
{

  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "capacity() - Error: vector is NULL");
      exit(1) ;
    }
  
  return this->v_capacity;
}

int sd_vector_is_empty(struct sd_vector *this)
{
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "empty() - Error: vector is NULL");
      exit(1) ;
    }
  
  return this->v_size==0;
}


void sd_vector_reserve(size_t new_capacity, struct sd_vector *this){
  if(new_capacity<0){
     fprintf(stderr, "reserve() - Error: new_capacity is negative");
     exit(1);
  }
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "reserve() - Error: vector is NULL");
      exit(1) ;
    }


  if(new_capacity < SD_VECTOR_MAX_SIZE)
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

    
void sd_vector_shrink_to_fit(struct sd_vector *this)
{
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "shrink_to_fit() - Error: vector is NULL");
      exit(1) ;
    }
  sd_vector_reserve(this->v_size,this);
}



// Element access : 

void* sd_vector_at(size_t i, struct sd_vector *this)
{
  if( i < (this->v_size))
    {
      return this->content[i];
    }
  else
    {
      fprintf(stderr,"at() - Error: element is out of range");
      exit(1);
    }
}


void* sd_vector_front(struct sd_vector *this)
{
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "front() - Error: vector is NULL");
      exit(1);
    }

  void* tmp;
  if(sd_vector_is_empty(this))
    tmp = NULL;
  else
    tmp =  sd_vector_at(0,this);

  return tmp;
}


void* sd_vector_back(struct sd_vector *this)
{
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "back() - Error: vector is NULL");
      exit(1) ;
    }
  if(sd_vector_is_empty(this))
    return NULL;
  else 
    return sd_vector_at(this->v_size -1, this);
}



//Modifiers:

void sd_vector_push_back(void* element, struct sd_vector * this){
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "push_back() - Error: vector is NULL");
      exit(1) ;
    }
  
  // On s'assure d'avoir la capacité de stockage, et on la double dans le cas contraire :

  if( (this->v_size +1) > (this->v_capacity) ) 
      sd_vector_reserve(2 * this->v_capacity, this);

  // On accepte l'element :
  sd_vector_emplace(this->v_size, element, this);

  // On augmente la taille.
  this->v_size++; 
}

void sd_vector_pop_back(struct sd_vector * this)
{
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "pop_back() - Error: vector is NULL");
      exit(1) ;
    }
  if(this->v_size > 0)
    this->v_size--;
}


void sd_vector_insert(size_t begin, void* value, size_t repeater, struct sd_vector *this)
{
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "insert() - Error: vector is NULL");
      exit(1) ;
    }
  
  sd_vector_shiftr(begin, repeater, this);
  for(int i = 0; i<repeater; i++)
    {
      sd_vector_emplace(begin+i, value, this);
    }
}

void sd_vector_erase(size_t begin, size_t end, struct sd_vector *this)
{
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "erase() - Error: vector is NULL");
      exit(1) ;
    }
  if(end >= begin)
    {
      sd_vector_shiftl(begin, end - begin, this);
    }
}

void sd_vector_swap(struct sd_vector *other, struct sd_vector * this){
  if(sd_vector_is_null(other))
    {
      fprintf(stderr, "swap() - Error: first argument is NULL");
      exit(1) ;
    }
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "swap() - Error: second argument is NULL");
      exit(1) ;
    }

  size_t tmp = this->v_size;
  this->v_size = other->v_size;
  other->v_size = tmp;

  size_t tmp2 = this->v_capacity;
  this->v_capacity = other->v_capacity;
  other->v_capacity = tmp2;

  void** tmp3 = this->content;
  this->content = other->content;
  other->content = tmp3;
}

void sd_vector_clear(struct sd_vector *this)
{
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "clear() - Error: vector is NULL");
      exit(1) ;
    }
  sd_vector_resize(0,NULL, this);
}

void sd_vector_emplace(size_t position, void* value, struct sd_vector *this){
  if(sd_vector_is_null(this)){
      fprintf(stderr, "emplace() - Error: vector is NULL");
      exit(1) ;
    } 

  if( (position >= 0) && (position < (this->v_size+1)))  {
    this->content[position] = value;
  }
  else{
      fprintf(stderr,"emplace() - Error: element is out of range\n");
      exit(1);
  }
}

void sd_vector_shiftr(size_t begin, size_t space, struct sd_vector *this){
  if(sd_vector_is_null(this)){
      fprintf(stderr, "shiftr() - Error: vector is NULL");
      exit(1) ;
    }
  if(begin >= this->v_size){
      fprintf(stderr, "shiftr() - Error: first argument is superior to v_size \n");
      exit(1);
    }

  while( (this->v_size + space) > this->v_capacity ){
      sd_vector_reserve(2*this->v_capacity, this);
    }
  
  int i; 
  int last_size = this->v_size;
  this->v_size += space;
  for(i = last_size; i > begin; i--)
    {
       sd_vector_emplace(i+space, sd_vector_at(i,this), this);
    }
  
  int stop = begin + space;
  for(i = begin; i < stop; i++)
    {
      sd_vector_emplace(i, NULL, this);
    }
}

  
void sd_vector_shiftl(size_t begin, size_t space, struct sd_vector *this)
{
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "shiftl() - Error: vector is NULL");
      exit(1) ;
    }
  if( begin >= (this->v_size) )
    {
      fprintf(stderr,"shiftr() - Error: first argument is superior to v_size \n");
      exit(1);
    }
   
  if( (begin - space) > 0)
    {    
      int i;
      for(i = begin; i < (this->v_size - space); i++)
	{
	  sd_vector_emplace(i,sd_vector_at(i+space,this),this);
	}
      this->v_size -= space;
    }
  else
    {
      fprintf(stderr,"shiftl() - Error: elements are moved out of range \n");
      exit(1);
    }
}

void sd_vector_info(char* info, struct sd_vector *this)
{
  if(sd_vector_is_null(this))
    {
      fprintf(stderr, "info() - Error: vector is NULL");
      exit(1) ;
    }
  sprintf(info,"Le vecteur à une taille de: %d élément(s)\npour une capacité de: %d élément(s)\n", (int)this->v_size, (int)this->v_capacity);
}

struct sd_vector* sd_vector_replicate(struct sd_vector *this)
{
  if(this == NULL)
    return NULL;
  else
    {
      struct sd_vector* second = sd_vector_new();
      second->reserve(this->v_capacity,second);
    
      for(size_t i=0; i< (this->v_size); i++)
	{
	  sd_vector_push_back(sd_vector_at(i,this),second);
	}
      return second;
    }
}
 
