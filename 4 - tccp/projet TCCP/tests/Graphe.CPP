#include <stdio.h>
#ifndef __cplus
#include <iostream.h>
#endif
#include <conio.h>
#include <string.h>
#include <fstream.h>
#include <stdlib.h>
#include <dos.h>

#define INFINI 10000
typedef struct ListeARC;
typedef struct Sommet;

typedef struct Element{

	char nom[200];
	

}Element;

typedef struct Sommet {

	Element *info; 
	Sommet *suivant;
	int marque;
	ListeARC *arcs;

};

typedef struct ListeARC {

	Sommet *noeud;
	int cout;
	ListeARC *suivant;

};

typedef struct Graphe{

	Sommet *noeuds;
	int nS;

}Graphe;

	
typedef struct Pile{
	Sommet * sommet;
	Sommet * suivant;
        int nb;

}Pile;

void saveFile(Graphe*,char*);
  //===================================================//
 //---------------Pile--------------------------------//
//===================================================//
Pile * creerFile(){

	Pile * file= new Pile;
	file->sommet=NULL;
	file->suivant=NULL;
        file->nb=0;
        return file;

}

int  estVide (Pile* file) {
  return file->nb <=0;
}

Sommet * deFiler(Pile * file){

	Sommet *s= file->sommet;
        
	if(!estVide(file))  {
	file->sommet=file->sommet->suivant;
        file->nb--;
	 }
	return s!=NULL ? s : NULL;


}
void emPiler(Pile * file, Sommet * s){

	file->suivant = file->sommet;
	file->sommet = s;
             file->nb++;
}
void enFiler(Pile * file, Sommet * s){

	Sommet * parcour=file->sommet;
	if(file->nb==0)
	{
	file->suivant = file->sommet;
	file->sommet = s;

	}
	else{
		for(int i=0;i<file->nb;i++){
		parcour=parcour->suivant;
		}
		parcour=s;
	     }
             file->nb++;
}

Element* creerElement(){

		 return(new Element);

}

  //===================================================//
 //---------------Remplir un element vide-------------//
//===================================================//
Element *remplirElement(char nom[200]){
	Element *element = creerElement();
	strcpy(element->nom,nom);
	return element;

}

  //===================================================//
 //---------------Creation graphe sans parametre------//
//===================================================//

Graphe* creerGraphe(){

	Graphe* graphe=new Graphe;
	graphe->noeuds=NULL;
	graphe->nS=0;
	return graphe;

}

  //===================================================//
 //---------------Comparer deux sommets---------------//
//===================================================//

int Scmp(Sommet * s1,Sommet * s2){

	return strcmp(s1->info->nom,s2->info->nom);

}
int Scmp(Sommet * s1,Element * info){

	return strcmp(s1->info->nom,info->nom);

}

int Scmp(Sommet * s1,char * info){

	return strcmp(s1->info->nom,info);

}

  //===================================================//
 //---------------Comparer deux arcs------------------//
//===================================================//

int Acmp(ListeARC * arc1,ListeARC * arc2){

	return Scmp(arc1->noeud,arc2->noeud);

}


  //===================================================//
 //---------------retourne le nom du sommet-----------//
//===================================================//
char * getNomSommet(Sommet *s){

	return s->info->nom;
}

  //===================================================//
 //------------retourne le nom d'un element-----------//
//===================================================//
char * getNomElement(Element *info){

	return info->nom;
}
  //===================================================//
 //---------------retourne le nombre des sommets------//
//===================================================//

int getNombreSommet(Graphe * g){

	return g->nS;

}


  //===================================================//
 //---------------retourne le sommet recherché--------//
//===================================================//

Sommet * getSommet(Graphe * g,Element * info){


	Sommet* parcour=g->noeuds;
	if(parcour==NULL)
		{
		delete parcour;
		return NULL;
		}
	else {

		if(!Scmp(parcour,info))
			return parcour;
		while(parcour->suivant!=NULL){
			 if(!Scmp(parcour->suivant,info)) return parcour->suivant;
			 else
			 parcour=parcour->suivant;

		}
	}
	return NULL;

}

Sommet * getSommet(Graphe * g,char * nom){

	return getSommet(g,remplirElement(nom));

	}


Sommet * getSommet(Graphe * g,int i){


	Sommet * parcour=g->noeuds;
	if(parcour==NULL)
		{
		delete parcour;
		return NULL;
		}
	else {

		for(int j=0;j<i;j++){
		parcour=parcour->suivant;
		}
		if(parcour) return parcour;
	}
	return NULL;
}
int getISommet(Graphe * g, Sommet * s){

 	for(int i=0; i<getNombreSommet(g);i++){
         	if(!Scmp(getSommet(g,i),s)) return i;
	}
	return -1;
}
  //===================================================//
 //--------retourne si le sommet est marqué ou non----//
//===================================================//

int estMarque(Graphe * g,Element * info){
	if(getSommet(g,info))	return getSommet(g,info)->marque;
	return 0;
}

int estMarque(Sommet * s){
	return s->marque;
	
}

  //===================================================//
 //--------retourne 1 si tous les sommets sont marqué--//
//===================================================//

int tousMarque(Graphe *g){
     	int i=0;
	while ( i < getNombreSommet(g) && estMarque(getSommet(g,i))) i++;
 	return i>=getNombreSommet(g);
}

  //===================================================//
 //--------retourne le premier sommet non marqué------//
//===================================================//

int nonMarque(Graphe *g){

 	for(int i=0;i<getNombreSommet(g)&& estMarque(getSommet(g,i));i++) ;
 	return i;
}
  //===================================================//
 //--------marqeuer/demarquer un sommetrqué ou non----//
//===================================================//
void marquer(Sommet * s,int val){
	 s->marque=val;
}
void marquer(Graphe * g,Element * info,int val){

	if(getSommet(g,info)) getSommet(g,info)->marque=val;
}

void marquer(Graphe * g,char * info,int val){

	if(getSommet(g,info)) getSommet(g,info)->marque=val;
}

void marquer(Graphe * g,int info,int val){

	if(getSommet(g,info)) getSommet(g,info)->marque=val;
}

  //===================================================//
 //--------demarquer tous les sommets-----------------//
//===================================================//

static void demarquer (Graphe* g,int val) {
  for (int i=0; i<getNombreSommet(g); getSommet(g,i)->marque = val,i++) ;
}


  //===================================================//
 //---------------Fonction ajout de sommet------------//
//===================================================//

int ajoutSommetDebut(Graphe * g,Element * info){
	Sommet * sommet = new Sommet;
	sommet->info=info;
	sommet->marque=0;
	sommet->arcs=NULL;
	sommet->suivant=g->noeuds;
	g->noeuds = sommet;
	g->nS++;
	return 1;
}
int ajoutSommetDebut(Graphe * g,Sommet * s){

	s->suivant=g->noeuds;
	g->noeuds=s;
	g->nS++;
        return 1;
}

int ajoutSommetFin(Graphe * g,Element * info){

	Sommet* parcour=g->noeuds;
	if(parcour==NULL) ajoutSommetDebut(g,info);
	else{
		Sommet * sommet = new Sommet;
		sommet->info=info;
		sommet->marque=0;
		sommet->arcs=NULL;
		sommet->suivant=NULL;
		if(!Scmp(sommet,parcour))
			{
			delete sommet;
			return 0;
			}
		while(parcour->suivant!=NULL){
			 if(!Scmp(sommet,parcour->suivant)) return 0; // pour tester si le sommet exist deja
			 else
			 parcour=parcour->suivant;

		}
		parcour->suivant = sommet;
		g->nS++;

	     }
	return 1;

}
int ajoutSommetFin(Graphe * g,Sommet * sommet){

	Sommet* parcour=g->noeuds;
	if(parcour==NULL) ajoutSommetDebut(g,sommet);
	else{
		if(!Scmp(sommet,parcour))
			{
			delete sommet;
			return 0;
			}
		while(parcour->suivant!=NULL){
			 if(!Scmp(sommet,parcour->suivant)) return 0; // pour tester si le sommet exist deja
			 else
			 parcour=parcour->suivant;

		}
		parcour->suivant = sommet;
		g->nS++;

	     }
	return 1;

}

int ajoutSommetFin(Graphe * g,char * info){
       return	ajoutSommetFin(g,remplirElement(info));


}

  //===================================================//
 //---------------Fonction ajout d'arc----------------//
//===================================================//

int ajoutArcDebut(Sommet * s1,Sommet * s2,int cout){
	
	ListeARC * arc= new ListeARC;
	arc->noeud=s2;
	arc->cout=cout;
	arc->suivant=s1->arcs;
	s1->arcs=arc;
	return 1;
}


int ajoutArcFin(Sommet * s1,Sommet * s2,int cout){
     if(s1&&s2){
	ListeARC * parcour=s1->arcs;
	if(parcour==NULL) ajoutArcDebut(s1,s2,cout);
	else{
		ListeARC * arc= new ListeARC;
		arc->noeud=s2;
		arc->cout=cout;
		arc->suivant=NULL;
		if(!Acmp(arc,parcour))
			{
			delete arc;
			return 0;
			}
	    
		while(parcour->suivant!=NULL){
			 if(!Acmp(arc,parcour->suivant)) return 0; // pour tester si l'arc exist deja
			 else
			
			 parcour=parcour->suivant;

		}
		parcour->suivant = arc;
		

	     }
	return 1;
	}
    else
    return 0;

}


  //===================================================//
 //---------------Suppression sommet------------------//
//===================================================//
int supprimerSommetDebut(Graphe *g){

	Sommet *sommet = g->noeuds;
        if(sommet->suivant)
	     {
		g->noeuds=sommet->suivant;
                g->nS--;
	        delete sommet;
        	return 1;
	      }
        else return 0;

}

int supprimerSommet(Graphe * g,Sommet * s){

	Sommet * parcour = g->noeuds;
	if(parcour==NULL) return 0;
	if(!Scmp(parcour,s)){
        	return supprimerSommetDebut(g);

	}

	while(parcour->suivant!=NULL && Scmp(parcour->suivant,s))
		parcour=parcour->suivant;
	if(parcour->suivant!=NULL){

		Sommet * buffer;
		buffer=parcour->suivant;
		parcour->suivant=parcour->suivant->suivant;
		g->nS--;
		delete buffer;
		return 1;
	}

      return 0;
}


  //===================================================//
 //---------------Suppression arc---------------------//
//===================================================//
int supprimerArc(Sommet * s1, Sommet * s2){

	ListeARC * arc =s1->arcs;
	ListeARC *precedent;
	int flag=1;
        
	while(arc)
	{
		if(Scmp(arc->noeud,s2)){
                	flag=0;
			precedent=arc;
                        arc=arc->suivant;
		}
		else break;
	}
	if (arc){
		if (flag == 1)
			 s1->arcs=arc->suivant;
		else
			 precedent->suivant=arc->suivant;
			 delete arc;
		}
	else
		{

		return 0;
		}
        return 1;


}
void supprimerArcs(Graphe * g, Sommet * s){

    for (int i=0; i<getNombreSommet(g);supprimerArc(getSommet(g,i),s), i++) ;

}


  //===================================================//
 //---------------Modifier Sommet---------------------//
//===================================================//

int modifierSommet(Graphe * g, Sommet * s, Element * info){

	Sommet * parcour = g->noeuds;
	if(parcour==NULL) return 0;
	if(!Scmp(parcour,s)){
                  parcour->info=info;
                  return 1;

	}

	while(parcour && Scmp(parcour,s))
		parcour=parcour->suivant;
	if(parcour){
		parcour->info=info;
		return 1;
	}

      return 0;
}

int modifierSommet(Graphe * g, Sommet * s, char * info){
       return	modifierSommet(g,s,remplirElement(info)) ;
}
int modifierSommet(Graphe * g, char * s, Element * info){
       Sommet * sommet=getSommet(g,s);
       if(sommet)
		{ 
		modifierSommet(g,sommet,info);
		return 1;
		}
       else return 0;

}
int modifierSommet(Graphe * g, char * s, char * info){
	return modifierSommet(g,s,remplirElement(info));

}

  //===================================================//
 //---------------Modifier cout d'arc-----------------//
//===================================================//

int modifierArc(Sommet * s1, Sommet * s2,int cout){

	ListeARC * arc =s1->arcs;
	ListeARC *precedent;
	int flag=1;
        
	while(arc)
	{
		if(Scmp(arc->noeud,s2)){
                	flag=0;
			precedent=arc;
                        arc=arc->suivant;
		}
		else break;
	}
	if (arc){
		if (flag == 1)
			 s1->arcs->cout=cout;
		else
			 precedent->suivant->cout=cout;
		}
	else
		{

		return 0;
		}
        return 1;


}

int modifierArc(Graphe * g,char* s1, char * s2,int cout){

	Sommet * sommet1=getSommet(g,s1);
	Sommet * sommet2=getSommet(g,s2);
       if(sommet2&&sommet1)
		{ 
		return modifierArc(sommet1,sommet2,cout);
		
		}
       else return 0;

}
  //===================================================//
 //---------------Parcour en profondeur---------------//
//===================================================//

void Profondeur (Graphe *g, Sommet* s){
	marquer(s,1);
	cout << getNomSommet(s) << "  ";
	ListeARC *listeArc=s->arcs;
	while(listeArc){
		Sommet * Successeur= listeArc->noeud;
		listeArc=listeArc->suivant;
		if(!estMarque(Successeur))
		Profondeur (g, Successeur);
	}
}

void parcoursProfondeur(Graphe *g){
if(g->noeuds){
 	demarquer(g,0);
	for(int i=0; i<getNombreSommet(g); i++)
        	if(!estMarque(getSommet(g,i)))
			Profondeur (g,getSommet(g,i));
}
else
	cout<<"Graphe vide";
}


  //===================================================//
 //---------------Parcour en largeur------------------//
//===================================================//

void AffichageLargeur(Graphe * g){


       
      /*	//Methode 1
	printf ("\nParcours en largeur\n");
 	demarquer(g,0);
  	Pile* file = creerFile();
	for (int i=0; i<getNombreSommet(g); i++) {
   		 Sommet* Depart = getSommet (g, i);
		 if (!estMarque(Depart)) {
			cout << getNomSommet(Depart)<<"  ";
      		 	enFiler(file, Depart);
     		 	while (!estVide (file)) {  
				Sommet* succes = deFiler(file);
				Depart = succes;
       				ListeARC* li = Depart->arcs;
			        while (li->noeud ) {
					succes =li->noeud;
					Sommet* Suc = succes;
					if (!estMarque(Suc)) {
						cout << getNomSommet(Suc)<< "  ";
						enFiler(file, Suc);
						marquer(Suc,1);
					 }
					 li=li->suivant;
        			}  
     			 }  
		    } 
 	} 
	delete file;
      */
         
     	//Methode 2
	Sommet *sommet,*s;
	demarquer(g,0);
	Pile* file=creerFile();
	for(int i=0; i<getNombreSommet(g); i++){
		sommet= getSommet(g,i); 
		if(!estMarque(sommet)){
			cout <<getNomSommet(sommet)<< "  "  ;
                        
                        enFiler(file,sommet);
			marquer(sommet,1);
			while(!estVide(file)){
				s =deFiler(file);
				ListeARC *li= s->arcs;
				while(li->noeud!=NULL){
					if(!estMarque(li->noeud)){
						cout  << getNomSommet(li->noeud) << "  ";
						if(!li->noeud) break;
						enFiler(file, li->noeud);
						marquer(li->noeud,1);
					}
					li=li->suivant;
				}
			}
		}
	}
	delete file;

}



  //===================================================//
 //---------------Ecrire graphe (shema)---------------//
//===================================================//

void ecrireGraphe (Graphe* g) {
if(g->noeuds){
	cout <<"/---------- Ecriture Graphe-----/ "<<endl;
	for (int i=0; i<getNombreSommet(g);cout<< getNomSommet(getSommet(g,i))<<"("<<i<<")\t", i++);
	cout <<endl<<endl;

		for (i=0; i<getNombreSommet(g); i++) {
			Sommet* sommet = getSommet (g,i);
			cout<< getNomSommet(sommet) <<": ";
			ListeARC* arc = sommet->arcs;

			while (arc) {
					cout <<"  ->  "<< getNomSommet(arc->noeud) <<" (" << arc->cout<<")";
					arc=arc->suivant;

			}
		cout <<" ;"<<endl;
	}
	}
else
	cout<<"Graphe vide";


}

  //===================================================//
 //---------------Detruire graphe---------------------//
//===================================================//

Graphe* detruireGraphe(Graphe * g){

	Sommet *sommet,*bufferSommet;
	ListeARC *arc,*bufferArc;
	sommet=g->noeuds;
	while (sommet)
		{
			arc=sommet->arcs;
			while (arc)
				{
					bufferArc=arc;
					arc=arc->suivant;
					delete bufferArc;
				}
			bufferSommet=sommet;
			sommet=sommet->suivant;
			delete bufferSommet;
		}
		 return creerGraphe();


}

  //===================================================//
 //---------------Load graphe-------------------------//
//===================================================//

int isNumber(char c){
	return (c<=57&&48<=c) ;

}
int contains(char chaine[200],char c[200]){
	for(int i=0;i<strlen(chaine);i++) {
		if(chaine[i]==c[0]){
			for(int k=1;k<strlen(c);k++) {
				if(chaine[i+k]==c[k]) return 1;
			}
		}
	}
	return 0;
}

int contains(char chaine[200],char c){
	for(int i=0;i<strlen(chaine);i++)
		if(chaine[i]==c) return 1;
	return 0;
}
char* extract(char chaine[200]){
	char retour[200];
	for(int i=0;i<strlen(chaine)-1;i++)
		retour[i]=chaine[i+1];
	retour[strlen(chaine)-2]='\0';
	return retour;
}
int extractNumber(char chaine[200]){
	char retour[200];
	int j=0;
	for(int i=0;i<strlen(chaine);i++) {
		if(isNumber(chaine[i])==1) {
			retour[j]=chaine[i];j++;
		}
	}
	retour[j]='\0';
	return atoi(retour);
}
void loadGraphe(Graphe* g, char file[200], char positionFile[200]){
	char s1[200],s2[200];
	int value;
	ifstream fic;
	ofstream pos;
	pos.open(positionFile,ios::out);
	fic.open(file,ios::in);
	char ligne[200],line[200];
	while(!fic.eof()&&ligne){
		fic>> ligne ;
		if(strcmp(ligne,"}")==0) {
			strcpy(s1," ");
			strcpy(s2," ");
			value=0;
		}
		if(contains(ligne,'"')==1){
			strcpy(s1,extract(ligne));
			fic>> ligne;
			if(contains(ligne,'=')==1){
				value=extractNumber(ligne);
			}
			else{
				fic>> ligne;
				strcpy(s2,extract(ligne));
			}
		}
		else if(contains(ligne,'=')==1){
			value=extractNumber(ligne);
			ajoutSommetFin(g,s1);
			ajoutSommetFin(g,s2);
			ajoutArcFin(getSommet(g,s1),getSommet(g,s2),value);
			//ajoutArcFin(getSommet(g,s2),getSommet(g,s1),value);  //pour doubler les transitions

		}

	}
	 fic.close();
	 fic.open(file,ios::in);
	 while(fic.getline(line,200)) {
	 if(contains(line,"pos")==1)
	 pos << line <<endl;

	 }

}


void loadGraphe(Graphe* g, char file[200]){
	char s1[200],s2[200];
	int value;
	ifstream fic;
	fic.open(file,ios::in);
	char ligne[200],line[200];
	while(!fic.eof()&&ligne){
		fic>> ligne ;
		if(strcmp(ligne,"}")==0) {
			strcpy(s1," ");
			strcpy(s2," ");
			value=0;
		}
		if(contains(ligne,'"')==1){
			strcpy(s1,extract(ligne));
			fic>> ligne;
			if(contains(ligne,'=')==1){
				value=extractNumber(ligne);
			}
			else{
				fic>> ligne;
				strcpy(s2,extract(ligne));
			}
		}
		else if(contains(ligne,'=')==1){
			value=extractNumber(ligne);
			ajoutSommetFin(g,s1);
			ajoutSommetFin(g,s2);
			ajoutArcFin(getSommet(g,s1),getSommet(g,s2),value);
			//ajoutArcFin(getSommet(g,s2),getSommet(g,s1),value);

		}

	}
	 fic.close();


}




  //===================================================//
 //----------Plus court chemin------------------------//
//===================================================//


// retourner l'indice de l'élément non marqué ayant le d[i] minimum
static int dMin (Graphe* g, int * d) {
	int min  = INFINI;
	int nMin = 0;
	for (int i=0; i<getNombreSommet(g); i++) {
			if (!estMarque (getSommet(g,i))) {
			if (d[i] <= min) { min = d[i]; nMin = i; }
			}
	}
  return nMin;
}

void saveImageFiles(Graphe *g){
	 FILE* file;
	 char target[100]="Court.dot";
	 char bat[100]="Court.bat";
	 saveFile(g,target);
	 file=fopen(bat,"w");
	 fprintf(file,"dot  -Tjpg  %s -o court.jpg",target);
	 fclose(file);
	 system(bat);


}

static void ecrireResultats (Graphe* g, int nsi, int* d, int* pr,int i) {
	demarquer(g,0);
	marquer(getSommet(g,i),1);
	printf("Plus court chemin entre les deux villes %s et %s est de %d Km ",getNomSommet(getSommet(g,nsi)),getNomSommet(getSommet(g,i)),d[i]);

	  if ( (i!=nsi) && (d[i] != INFINI ) ) {
			printf ("\t%s", getNomSommet(getSommet(g,i)));
			int j = i;
			while (pr [j] != nsi) {
				marquer(getSommet(g,pr[j]),1);
				printf (", %s", getNomSommet(getSommet(g, pr[j])));
				j = pr [j];
			}
			printf (", %s\n", getNomSommet(getSommet(g, pr[j])));
			marquer(getSommet(g,pr[j]),1);
			saveImageFiles(g);
		}
	printf ("\n\n Remarque:\n\tCliquer sur le fichier court.bat pour obtenir l'image ou bien appliquer cette fonction depuis le fichier executable de ce programme");

}

// plus court chemin en partant du sommet nsi
void plusCourt (Graphe* g, int nsi,int arrive) {
  // allocation dynamique des tableaux d et pr

	int* d  = (int*) malloc (sizeof (int) * getNombreSommet(g));
	int* pr = (int*) malloc (sizeof (int) * getNombreSommet(g));
	int help;

	if (nsi>arrive){
	help=nsi;nsi=arrive;arrive=help;
		  }
  // initialisation par défaut de d et pr
	demarquer(g,0);
	for (int i=0; i<getNombreSommet(g); i++) {
			d  [i] = INFINI;
		pr [i] = nsi;
	}
	d [nsi] = 0;

  // initialisation de d et pr en fonction de graphe
	ListeARC* li = getSommet(g,nsi)->arcs;
	while (li->noeud ) {
			Sommet* succes = li->noeud;
		int i = getISommet(g,succes);
		d [i] = li->cout;
		li=li->suivant;
	}

	marquer(getSommet(g,nsi),1); // marquer NSI
	while (!tousMarque (g)) {
		int m = dMin (g, d); // élément minimum non marqué de d
		marquer(getSommet(g, m),1);
		if (d [m] != INFINI) {

			ListeARC *li = getSommet(g,m)->arcs;
			while (li->noeud ) {
				Sommet* succes =li->noeud;
				int k = getISommet(g,succes);

				if (!estMarque (getSommet(g,k))) {
					int v = d [m] + li->cout;
							if (v < d [k]) {
									d [k]  = v;
							  pr [k] = m;
							 }
						}
				li=li->suivant;
			 }
		}
	}
	ecrireResultats (g, nsi, d, pr,arrive);
}



  //===================================================//
 //---------------Etats bloquants---------------------//
//===================================================//

void etatsBloquants (Graphe* g) {
if(g->noeuds){
	cout <<"/---------- Etats bloquants-----/ "<<endl<<"<< ";

	for (int i=0; i<getNombreSommet(g); i++) {
			Sommet* sommet = getSommet (g,i);

			ListeARC* arc = sommet->arcs;
		if (!arc) cout<< getNomSommet(sommet) <<" ";

	}
	cout <<" >>"<<endl;
	}
else
	cout<<"Graphe vide";


}


  //===================================================//
 //---------------Detection Cycle---------------------//
//===================================================//

Sommet* Visit (Sommet* s){
	Sommet *v;
	if(s->marque==1){
		cout <<endl<<"Cycle : "<<getNomSommet(s);
		return s;
	}
	if(s->marque==2){
		cout << "    Fin Cycle";
		return 0;
	}
	marquer(s,1);
	ListeARC *listeArc=s->arcs;
	while(listeArc){
		Sommet * Successeur= listeArc->noeud;
		listeArc=listeArc->suivant;
		v=Visit (Successeur);
		if(v!=0){
			cout <<" - "<<getNomSommet(s) ;
			if(Scmp(v,s)==0){
					cout <<endl;
					return 0;
			}


			return v;
		}
	}
	s->marque=2;
	return 0;
}

void detectionCycle(Graphe *g){
if(g->noeuds){
	demarquer(g,0);
	int i=0;
	for(;i<getNombreSommet(g); i++)
		if(!estMarque(getSommet(g,i)))
			Visit (getSommet(g,i));
}
else
	cout<<"Graphe vide";
}


  //===================================================//
 //---------------Composante connexes-----------------//
//===================================================//


void DFS (Graphe *g, Sommet* s){
	marquer(s,1);
	cout <<  " " <<getNomSommet(s) << " ";
	ListeARC *listeArc=s->arcs;
	while(listeArc){
		Sommet * Successeur= listeArc->noeud;
		listeArc=listeArc->suivant;
		if(!estMarque(Successeur))
		DFS (g, Successeur);
	}
}

void Connexe(Graphe *g){
if(g->noeuds){
	demarquer(g,0);

	for(int i=getNombreSommet(g); i>=0; i--)
		if(!estMarque(getSommet(g,i))){
			cout << " {";
			DFS (g,getSommet(g,i));
			cout << "} ";
		}
}
else
	cout<<"Graphe vide";
}



  //===================================================//
 //------Fichier dot qui marque  plus court chemin----//
//===================================================//

void saveFile (Graphe* g,char target[100]) {
if(g->noeuds){
	FILE *file=fopen(target,"w");
	fprintf(file,"Digraph G{\n");
    	for (int i=0; i<getNombreSommet(g); i++) {
		Sommet* sommet = getSommet (g,i);
		ListeARC* arc = sommet->arcs;
		while (arc) {
			fprintf(file,"%s -> %s [label=%d]\n",getNomSommet(sommet),getNomSommet(arc->noeud),arc->cout);
      			arc=arc->suivant;
    		}
	}

	for(i=0;i<getNombreSommet(g);i++){
		Sommet* sommet = getSommet (g,i);

		if (estMarque(sommet))
		{ fprintf(file,"%s [color=red style=filled] \n",getNomSommet(sommet));
		}
	}

	ifstream filePos;
	filePos.open("position.txt",ios::in);
        char  line[200];
	while(filePos.getline(line,200))
		fprintf(file,"%s\n",line);
	filePos.close();

	fprintf(file,"}");
	fclose(file);
	}
else
	cout<<"Graphe vide";


}

  //===================================================//
 //----------Produit synchronisé----------------------//
//===================================================//

void takeFirst(char  first[30],char * chaine){
   int i=0;
   for ( ; *chaine; chaine++)
      if (*chaine!='_'){
	  first[i] = *chaine;
          i++;
          }
      else
	  break;
      first[i]='\0';

}

void takeSecond(char  second[15],char * chaine){
   int trouve=0,i=0;
   for ( ; *chaine; chaine++) {
	  if(*chaine=='_') {trouve=1;chaine++;}
	  if(trouve)
	  	{second[i] = *chaine;
		i++;
                }
   }
      second[i]='\0';

}

void produitSyn(Graphe *g1,Graphe *g2,Graphe *g){
	char separator[2]="_";
	for(int i=0;i<getNombreSommet(g1);i++){
        	Sommet * sommet1=getSommet(g1,i);
		for(int j=0;j<getNombreSommet(g2);j++){
			Sommet * sommet2=getSommet(g2,j);
			char container[40]="";
			strcat(container,getNomSommet(sommet1));
			strcat(container,separator);
			strcat(container,getNomSommet(sommet2));
                        ajoutSommetFin(g,container);
                }
	}
       
	for (i=0; i<getNombreSommet(g1); i++) {
   		Sommet* sommet = getSommet (g1,i);
    		ListeARC* arc = sommet->arcs;
    
		while (arc) {

			for(int k=0;k<getNombreSommet(g);k++){
				Sommet * s1=getSommet(g,k);
				char  first[30];
				takeFirst(first,getNomSommet(s1));
				for(int l=0;l<getNombreSommet(g);l++){
					Sommet * s2=getSommet(g,l);
					char second[30];
					takeFirst(second,getNomSommet(s2));
					if(strcmp(first,getNomSommet(sommet))==0&&strcmp( getNomSommet(arc->noeud),second)==0)
						ajoutArcFin(s1,s2,arc->cout);

				} 

			}
      			arc=arc->suivant;
      
    		}
	}
        
	for (i=0; i<getNombreSommet(g2); i++) {
   		Sommet* sommet = getSommet (g2,i);
    		ListeARC* arc = sommet->arcs;
    
		while (arc) {

			for(int k=0;k<getNombreSommet(g);k++){
				Sommet * s1=getSommet(g,k);
				char  first[30];
				takeSecond(first,getNomSommet(s1));
				for(int l=0;l<getNombreSommet(g);l++){
					Sommet * s2=getSommet(g,l);
					char second[30];
					takeSecond(second,getNomSommet(s2));
					if(strcmp(first,getNomSommet(sommet))==0&&strcmp( getNomSommet(arc->noeud),second)==0)
						ajoutArcFin(s1,s2,arc->cout);

				} 

			}
      			arc=arc->suivant;
      
    		}
	}  

}
void Produit(){

	Graphe *g1 = creerGraphe();
	Graphe *g2 = creerGraphe();
	Graphe *g3 = creerGraphe();

	loadGraphe(g1,"g1.dot");
	loadGraphe(g2,"g2.dot");

	produitSyn(g1,g2,g3);
	ecrireGraphe(g3);
	saveFile(g3,"g3.dot");

}


  //===================================================//
 //----------Procedure de remplissage des donnees-----//
//===================================================//

void menu(){

	clrscr();

cout << "###################Gestion de Graphe#########################" << endl;
cout << "#                                                           #" << endl;
cout << "#0--Sortir                                                  #" << endl;
cout << "#1--Ajouter sommet                                          #" << endl;
cout << "#2--Modifier sommet                                         #" << endl;
cout << "#3--Supprimer sommet                                        #" << endl;
cout << "#4--Ajouter arc                                             #" << endl;
cout << "#5--Modifier arc                                            #" << endl;
cout << "#6--Supprimer arc                                           #" << endl;
cout << "#7--Affichage graphe par detail                             #" << endl;
cout << "#8--Affichage graphe en largeur                             #" << endl;
cout << "#9--Affichage graphe en profondeur                          #" << endl;
cout << "#10--Plus court chemin entre deux sommets                   #" << endl;
cout << "#11--Afficher les etats bloquants                           #" << endl;
cout << "#12--Detection des cycles                                   #" << endl;
cout << "#13--Composantes connexes                                   #" << endl;
cout << "#14--Creation fichier dot qui marque le  plus court chemin  #" << endl;
cout << "#15--Produit synchronize                                    #" << endl;

cout << "#20--Chargement du graphe                                   #" << endl;
cout << "#21--Sauvegarde du graphe                                   #" << endl;
cout << "#22--Destruction du graphe                                  #" << endl;
cout << "#                                                           #" << endl;
cout << "#############################################################" << endl;

}

void AjouterSommet(Graphe * g){
      char info[200];
      cout <<endl<<"Entrer l'element a entrer: ";
      gets(info);
      int i = ajoutSommetFin(g,remplirElement(info));
      if(!i) cout << "sommet exist deja"<<endl;
      else cout << "enregistrement terminé" << endl;
}

void ModifierSommet(Graphe * g){
if(g->noeuds){
	char info[200],nouveau[200];
      	cout <<endl<<"Entrer l'element a modifier: ";
	gets(info);
      	cout <<endl<<"Entrer sa nouvelle valeur: ";
      	gets(nouveau);
      	int i = modifierSommet(g,info,nouveau);
      	if(!i) cout << "sommet non existant"<<endl;
      	else cout << "enregistrement terminé" << endl;
      }
else
	cout<<"Graphe vide";


}

void SupprimerSommet(Graphe *g){
if(g->noeuds){
        Sommet *s1;
	char  sommet1[200];
       	cout << "entrer le premier sommet ";
       	gets(sommet1);
	s1=getSommet(g,sommet1);
	if(s1){
		supprimerArcs(g,s1);
		supprimerSommet(g,s1);
                cout<<"suppresion avec succés"<<endl;

		}
	else
		cout <<"Sommet n'existe pas"<<endl;
	}
else
	cout<<"Graphe vide";
}

void AjouterARC(Graphe * g){
if(g->noeuds){
       Sommet * s1,*s2;
		 int Cout;
       char  sommet1[200];
       char sommet2[200];
       cout << "Entrer le premier sommet ";
       gets(sommet1);
       s1=getSommet(g,sommet1);
       if(s1){

       		cout << "Entrer le deuxieme sommet ";
       		gets(sommet2);

       		s2=getSommet(g,sommet2);
       		if(s2){
		 	cout << "Entrer le cout ";
		 	cin >> Cout;
		 	if(cout>0)
                 		ajoutArcFin(s1,s2,Cout);
		 	else
                  		cout<< "Cout inferieure a 0"<<endl;
       	     	      }
				else
        		cout << "Sommet "<< sommet2<<" n'existe pas"<<endl;

            }
	else
        	cout << "Sommet "<<sommet1 <<" n'existe pas"<<endl;
       }
else
	cout<<"Graphe vide";

}

void ModifierARC(Graphe * g){
if(g->noeuds){
	int Cout,i;
	char  sommet1[200];
       	char sommet2[200];
       	cout << "Entrer le premier sommet ";
       	gets(sommet1);
       	cout << "Entrer le deuxieme sommet ";
	gets(sommet2);
	cout << "Enter le cout ";
        cin >> Cout;
	if(cout>0)
        	{
		i=modifierArc(g,sommet1,sommet2,Cout);
		if(!i) cout << "Sommets n'existent pas" <<endl;
		else	cout << "Modification terminé"<<endl;
                }
	else
		cout << "cout inferieure a 0"<<endl;
	}
else
	cout<<"Graphe vide";

}

void SupprimerARC(Graphe *g){
if(g->noeuds){
	char  sommet1[200];
	char sommet2[200];
	cout << "entrer le premier sommet ";
       	gets(sommet1);
       	cout << "Entrer le deuxieme sommet ";
	gets(sommet2);
	Sommet *s1,*s2;
	s1=getSommet(g,sommet1);
	s2=getSommet(g,sommet2);
	if(s1&&s2)
        	{
		supprimerArc(s1,s2);
		cout << "Suppresion avec succes"<<endl;
                }
	else
		cout << "Sommets n'existent pas"<<endl;
    }
else
	cout<<"Graphe vide";


}

void main(){
	clrscr();
	Graphe* graphe=creerGraphe();
	char city1[30],city2[30];
	int n;
	loadGraphe(graphe,"graphe.dot","positions.txt");
	demarquer(graphe,0);
	menu:menu();
	
	cout << "Votre choix ? ";
	cin>>n;
	switch (n) {
	case 0 :
		graphe=detruireGraphe(graphe);
		delete graphe;
		goto end;

	case 1 :
		AjouterSommet(graphe);
                getch();
		break;
	case 2 :
		ModifierSommet(graphe);
                getch();
		break;
	case 3 :
		SupprimerSommet(graphe);
                getch();
		break;
	case 4 :
        	AjouterARC(graphe);
                getch();
		break;
	case 5 :
		ModifierARC(graphe);
                getch();
		break;
	case 6 :
		SupprimerARC(graphe);
                getch();
		break;
	case 7 :
		ecrireGraphe(graphe);
                getch();
		break;
	case 8 :
		AffichageLargeur(graphe);
                getch();
		break;
	case 9 :
		parcoursProfondeur(graphe);
                getch();
		break;
	case 10 :
		cout<< "Entrer la ville de depart ";
		gets(city1);
		cout <<"Entrer la ville d'arrive ";
		gets(city2);
		plusCourt(graphe,getISommet(graphe,getSommet(graphe,city1)),getISommet(graphe,getSommet(graphe,city2)));
		getch();
		break;
	case 11 :
		etatsBloquants(graphe);
		getch();
		break;
	case 12:
		detectionCycle(graphe);
		getch();
		break;

	case 13:

		Connexe(graphe);
		getch();
		break;


	case 14:
		saveFile(graphe,"court_chemin.dot");
		getch();
		break;

	case 15:

		Produit();
					 getch();
					 break;
	case 20:
		graphe=detruireGraphe(graphe);
		loadGraphe(graphe,"graphe.dot");
					 getch();
		break;
	case 22 :
			graphe=detruireGraphe(graphe);
		break;
	default :
		cout << "Entrer un nombre valide! " ;
		getch();
	}
		  goto menu;


	end:getch();
}