#ifndef ARBRE_H
#define ARBRE_H
typedef struct tree tree;
typedef tree* TREE;
struct tree
{

  struct tree *child_node;
  struct tree *Br_node;
  int nombrePointeur;
  void* C;
  char* (chaine)(TREE this);
  int (*NbreElemTREE)(TREE this);
  int (*isSheet)(TREE this);
  int (*clearTree)(TREE this);
  void (*graft_tree)(TREE this,TREE T);
  void (*graftBr)(TREE this,TREE T);
  TREE (*addBr)(TREE this,void* cont);
  TREE (*addChild)(TREE this,void* cont);
  TREE (*getBr)(TREE this,int nb);
  TREE (*getChild)(TREE this,int nb);
  TREE (*cloneRacine)(TREE this);

};
TREE create_tree(void* cont);
TREE addBr(TREE this,void* cont);
TREE addChild(TREE this,void* cont);
TREE getBr(TREE this,int nb);
TREE getChild(TREE this,int nb);
int isSheet(TREE this);
int clearTree(TREE this);
int NbreElemTREE(TREE this);
char* chaine(TREE this);
TREE cloneRacine(TREE this);
void graft_tree(TREE this,TREE T);
void graftBr(TREE this,TREE T);

#endif // ARBRE_H
