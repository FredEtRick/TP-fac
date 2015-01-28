#include "Arbre.h"
#include "string.h"
TREE create_tree(void* cont)
{
	TREE T=malloc(sizeof(tree));
	T->C=cont;
	T->child_node=NULL;
	T->Br_node=NULL;
	T->nombrePointeur=0;
	T->addBr=addBr;
	T->addChild=addChild;
	T->getBr=getBr;
	T->getChild=getChild;
	T->NbreElemTREE=NbreElemTREE;
	T->isSheet=isSheet;
	T->clearTree=clearTree;
	T->cloneRacine=cloneRacine;
	T->graft_tree=graft_tree;
	T->graftBr=graftBr;
	T->chaine=chaine;

	return T;
};

TREE addChild(TREE this,void* cont)
{
	if(this->child_node==NULL)
	{
		this->child_node=create_tree(cont);
		this->child_node->nombrePointeur++;
		return this->child_node;
	}
	else
		return this->Br_node->addBr(this->Br_node,cont);
}

TREE addBr(TREE this,void* cont)
{
	if(this->Br_node==NULL)
	{
		this->Br_node=create_tree(cont);
		return this->Br_node;
	}
	else
		return this->Br_node->addBr(this->Br_node,cont);
}

TREE getChild(TREE this,int nb)
{   if(this->child_node ==NULL)
		return NULL;
	else
		return this->child_node->getChild(this->child_node,nb-1);
}
TREE getBr(TREE this,int nb)
{
	if(nb==0)
		return this;
	if(this->Br_node==NULL)
		return NULL;
	else
		return this->Br_node->getBr(this->Br_node,nb-1);
}

int isSheet(TREE this)
{
	if(this->child_node==NULL)
		return 1;
	else
		return 0;
}
int NbreElemTREE(TREE this)
{
	if((this->Br_node==NULL)&&(this->Br_node==NULL))
		return 1;
	else if(this->Br_node==NULL)
		return this->Br_node->NbreElemTREE(this->Br_node)+1;
	else if(this->Br_node==NULL)
		return this->child_node->NbreElemTREE(this->child_node)+1;
	else
		return this->child_node->NbreElemTREE(this->child_node)+this->Br_node->NbreElemTREE(this->Br_node)+1;
}
int clearTree(TREE this)
{
	if(this->nombrePointeur<=1)
	{
		if((this->child_node==NULL)&&(this->Br_node==NULL))
		{
			free(this);
			this=NULL;
			return 0;
		}
		else if(this->child_node==NULL)
		{
			if((this->Br_node->clearTree(this->Br_node)==0))
			{
				this->Br_node=NULL;
				return this->clearTree(this);
				this=NULL;
			}
			else
				return 1;
		}
		else if(this->Br_node==NULL) {
			if((this->child_node->clearTree(this->child_node)==0))
			{
				this->child_node=NULL;
				return this->clearTree(this);
				this=NULL;
			}
			else
				return 1;
		}
		else
		{
			if((this->Br_node->clearTree(this->Br_node)==0)&&(this->child_node->clearTree(this->child_node)==0))
			{
				this->child_node=NULL;
				this->Br_node=NULL;
				return this->clearTree(this);
				this=NULL;
			}
			else
				return 1;
		}
	}
	else
	{
		this->nombrePointeur--;
		return 0;
	}
}

TREE cloneRacine(TREE this)
{
	TREE T=create_tree(this->C);
	T->child_node=this->child_node;
	if(this->child_node!=NULL)
		this->child_node->nombrePointeur++;
	return T;
}

void graft_tree(TREE this,TREE T)
{
	if(this->child_node==NULL)
	{
		this->child_node=T;
		this->child_node->nombrePointeur++;
		return;
	}
	else
		return this->child_node->graftBr(this->child_node,T);
}

void graftBr(TREE this,TREE T)
{
	if(this->Br_node==NULL)
	{
		this->Br_node=T;
		return;
	}
	else
		return this->Br_node->graftBr(this->Br_node,T);
}
char* chaine(TREE this)
{
	char* toString=malloc(1024);
	sprintf(toString, " Node value addresse : ");
	char tmp[20];
	sprintf(tmp,"%p", &this->C);
	strcat(toString, tmp);
	strcat(toString, " (pointed by ");
	sprintf(tmp, "%d", this->nombrePointeur);
	strcat(toString, tmp);
	strcat(toString, " pointeur)");
	if(this->Br_node!=NULL)
	{
		strcat(toString,", Br (direct) : ");
		sprintf(tmp, "%p", this->Br_node);
		strcat(toString, tmp);
	}
	if(this->child_node!=NULL)
	{
		strcat(toString,", child_node (direct) : ");
		sprintf(tmp, "%p", this->child_node);
		strcat(toString, tmp);
	}
	return toString;
}

