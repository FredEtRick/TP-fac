#include "graphe.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

graphe creer_graphe()
{
    srand(time(NULL));
    graphe g;
    printf("\nNombre de points ? ");
    scanf("%d", &(g.nbP));
    printf("\nNombre d'arêtes ? ");
    scanf("%d", &(g.nbA));
    g.coordP = malloc(g.nbP*sizeof(int*));
    g.kruskal = malloc(g.nbP*sizeof(int*));
    for(int i=0; i<g.nbP; i++)
    {
        g.kruskal[i]=malloc(2*sizeof(int));
        g.coordP[i]=malloc(2*sizeof(int));
        g.comp=malloc(g.nbP*sizeof(int));
    }
    for(int i=0; i<g.nbP; i++)
    {
        g.coordP[i][0]=(rand()%610)+1;
        g.coordP[i][1]=(rand()%790)+1;
    }

    g.aretes = malloc(g.nbA*sizeof(int*));
    for(int i=0; i<g.nbA; i++)
    {
        g.aretes[i] = malloc(3*sizeof(int));
    }
    for(int i=0; i<g.nbA; i++)
    {
        g.aretes[i][0]=rand()%g.nbP;
        g.aretes[i][1]=rand()%g.nbP;
    }
    g.voisins=malloc(g.nbP*sizeof(vector));
    for(int i=0; i<g.nbP; i++)
    {
        g.voisins[i]=creer_vector();
    }
    creer_voisins(g);
    return g;
}

void affichage(graphe g)
{
    for(int i=0; i<g.nbP; i++)
    {
        printf("Point %d : (%d, %d)\n", i, g.coordP[i][0], g.coordP[i][1]);
    }
    for (int i=0; i<g.nbA; i++)
    {
        printf("Arete %d : (%d, %d)\n", i, g.aretes[i][0], g.aretes[i][1]);
    }
}

void detruire_graphe(graphe g)
{
    for(int i=0; i<g.nbP; i++)
    {
        free(g.coordP[i]);
    }
    for(int i=0; i<g.nbA; i++)
    {
        free(g.aretes[i]);
    }
}

void creer_voisins(graphe g)
{
    printf("Distance max entre les voisins ? (0 pour un aléa complet) \n");
    scanf("%d", &(g.dmax));
    srand(time(NULL));
    int dist;
    //calcul de tous les voisins de dist <= dmax (lourd mais joli graphiquement)
    if(g.dmax>0)
    {
        for(int x=0; x<g.nbP; x++)
        {
            for(int y=x+1; y<g.nbP; y++)
            {
                dist = sqrt(pow((g.coordP[x][0]-g.coordP[y][0]),2)+pow((g.coordP[x][1]-g.coordP[y][1]),2));
                if(dist<=g.dmax)
                {
                    push(&g.voisins[x],y);
                    push(&g.voisins[y],x);
                }
            }
        }
        return;
    }
    //calcul des m paires de voisins si dmax<=0
    else
    {
        for(int i=0; i<g.nbA; i++)
        {
            int s = 0;
            int a;
            int b;
            {
                do
                {
                    s = 1;
                    a = rand()%g.nbP;
                    b = rand()%g.nbP;
                    for(int j=0; j<g.voisins[a].nbElem; j++)
                    {
                        if (g.voisins[a].elem[j]==b) s=0;
                    }
                }
                while(a==b || !s);
            }
            push(&g.voisins[a],b);
            push(&g.voisins[b],a);
        }
    }
}

void creer_composantes(graphe g)
{
    for (int i=0; i<g.nbP; i++)
    {
        g.comp[i]=i;
    }
    for (int i=0; i<g.nbA; i++)
    {
        int x = g.aretes[i][0];
        int y = g.aretes[i][1];
        if (g.comp[x]!=g.comp[y])
        {
            int aux = g.comp[x];
            for(int j=0; j<g.nbP; j++)
            {
                if (g.comp[j]==aux) g.comp[j]=g.comp[y];
            }
        }
    }
}

void afficheC(graphe g)
{
    for (int i=0; i<g.nbP; i++)
    {
        printf("Sommet %d - Composante %d\n", i, g.comp[i]);
    }
}

void tailleC(graphe g)
{
    int* T;
    T=malloc(g.nbP*sizeof(int));
    int* T2;
    T2=malloc(g.nbP*sizeof(int));
    for (int i=0; i<g.nbP; i++)
    {
        T[i]=T2[i]=0;
    }
    for (int i=0; i<g.nbP; i++)
    {
        T[g.comp[i]]++;
    }
    for (int i=0; i<g.nbP; i++)
    {
        T2[T[i]]++;
    }
    if (T2[1]!=0) printf("\nIl y a %d point(s) isolé(s).\n", T2[1]);
    for (int i=2; i<g.nbP; i++)
    {
        if (T2[i]!=0) printf("Il y a %d composante(s) de taille %d.\n", T2[i], i);
    }
}

void distances(graphe g)
{
    for (int k=0; k<g.nbA; k++)
    {
        int i=g.aretes[k][0];
        int j=g.aretes[k][1];
        g.aretes[k][2]=(int)pow((g.coordP[i][0]-g.coordP[j][0]),2)+pow((g.coordP[i][1]-g.coordP[j][1]),2);
    }
}

void afficheD(graphe g)
{
    for(int i=0; i<g.nbA; i++)
    {
        printf("Distance entre les points : (%d, %d) : %f\n", g.aretes[i][0], g.aretes[i][1], sqrt(g.aretes[i][2]));
    }
}

void tracage(graphe g, double nivmax, double* niveau, int* pere, FILE* in)
{
    fputs("\n", in);
    if(nivmax<6) nivmax=6; //anti division par 0
    //Affichage points
    fprintf(in, "%%!PS-Adobe-3.0\n");
    fprintf(in, "%%%%BoundingBox: 0 0 750 792\n");
    fprintf(in, "1.5 setlinewidth\n");
    for(int i=0; i<g.nbP; i++)
    {
        fprintf(in, "%d %d  3 0 360 arc\n",g.coordP[i][0], g.coordP[i][1]);
        fprintf(in, "0 setgray\n");
        fprintf(in, "fill\n");
    }
    //fin affichage points

    //tracage des arêtes selon le niveau
    for(int i=1; i<g.nbP; i++)
    {
        if(pere[i]!=-1)
        {
            if (niveau[i]<=nivmax/6) fprintf(in, "0 0 %f setrgbcolor\n", (niveau[i])/(nivmax/6)); //noir -> bleu
            else if (niveau[i]<=2*nivmax/6) fprintf(in,"%f 0 1 setrgbcolor\n", (niveau[i]-(nivmax/6))/(nivmax/6)); //bleu -> violet
            else if (niveau[i]<=3*nivmax/6) fprintf(in, "1 0 %f setrgbcolor\n",(niveau[i]-2*(nivmax/6))/(nivmax/6)); //violet -> rouge
            else if (niveau[i]<=4*nivmax/6) fprintf(in, "1 %f 0 setrgbcolor\n",(niveau[i]-3*(nivmax/6))/(nivmax/6)); //rouge -> jaune
            else if (niveau[i]<=5*nivmax/6) fprintf(in, "%f 1 0 setrgbcolor\n",(niveau[i]-4*(nivmax/6))/(nivmax/6)); //jaune -> vert
            else fprintf(in, "0 1 %f setrgbcolor\n", (niveau[i]-5*(nivmax/6))/(nivmax/6)); //vert -> cyan

            fprintf(in, "%d %d moveto\n", g.coordP[i][0],g.coordP[i][1]);
            fprintf(in, "%d %d lineto\n", g.coordP[pere[i]][0],g.coordP[pere[i]][1]);
            fprintf(in, "stroke\n\n");
        }
    }
    //fin tracage arêtes

    //affichage barre de dégradé
    //numérotation niveau
    fprintf(in, "0 0 0 setrgbcolor\n");
    fprintf(in, "/Times-Roman findfont\n");
    fprintf(in, "15 scalefont\n");
    fprintf(in, "setfont\n");
    fprintf(in, "655 725 moveto\n");
    fprintf(in, "(Niveau) show\n\n");

    fprintf(in, "0 0 0 setrgbcolor\n");
    fprintf(in, "/Times-Roman findfont\n");
    fprintf(in, "15 scalefont\n");
    fprintf(in, "setfont\n");
    fprintf(in, "675 700 moveto\n");
    fprintf(in, "(0) show\n");

    fprintf(in, "0 0 0 setrgbcolor\n");
    fprintf(in, "/Times-Roman findfont\n");
    fprintf(in, "15 scalefont\n");
    fprintf(in, "setfont\n");
    fprintf(in, "675 600 moveto\n");
    fprintf(in, "(%d) show\n",(int)(nivmax/6));

    fprintf(in, "0 0 0 setrgbcolor\n");
    fprintf(in, "/Times-Roman findfont\n");
    fprintf(in, "15 scalefont\n");
    fprintf(in, "setfont\n");
    fprintf(in, "675 500 moveto\n");
    fprintf(in, "(%d) show\n",(int)(2*nivmax/6));

    fprintf(in, "0 0 0 setrgbcolor\n");
    fprintf(in, "/Times-Roman findfont\n");
    fprintf(in, "15 scalefont\n");
    fprintf(in, "setfont\n");
    fprintf(in, "675 400 moveto\n");
    fprintf(in, "(%d) show\n",(int)(3*nivmax/6));

    fprintf(in, "0 0 0 setrgbcolor\n");
    fprintf(in, "/Times-Roman findfont\n");
    fprintf(in, "15 scalefont\n");
    fprintf(in, "setfont\n");
    fprintf(in, "675 300 moveto\n");
    fprintf(in, "(%d) show\n",(int)(4*nivmax/6));

    fprintf(in, "0 0 0 setrgbcolor\n");
    fprintf(in, "/Times-Roman findfont\n");
    fprintf(in, "15 scalefont\n");
    fprintf(in, "setfont\n");
    fprintf(in, "675 200 moveto\n");
    fprintf(in, "(%d) show\n",(int)(5*nivmax/6));

    fprintf(in, "0 0 0 setrgbcolor\n");
    fprintf(in, "/Times-Roman findfont\n");
    fprintf(in, "15 scalefont\n");
    fprintf(in, "setfont\n");
    fprintf(in, "675 100 moveto\n");
    fprintf(in, "(%d) show\n",(int)nivmax);

    //traçage de la barre
    for(double i=0; i<60; i++)
    {
        if 		(i<=10) fprintf(in, "0 0 %f setrgbcolor\n",(i)/10); //noir -> bleu
        else if (i<=20) fprintf(in, "%f 0 1 setrgbcolor\n",(i-10)/10); //bleu -> violet
        else if (i<=30) fprintf(in, "1 0 %f setrgbcolor\n",1-(i-20)/10); //violet -> rouge
        else if (i<=40) fprintf(in, "1 %f 0 setrgbcolor\n",(i-30)/10); //rouge -> jaune
        else if (i<=50) fprintf(in, "%f 1 0 setrgbcolor\n",1-(i-40)/10); //jaune -> vert
        else 			fprintf(in, "0 1 %f setrgbcolor\n",(i-50)/10); //vert -> cyan

        fprintf(in, "650 %f moveto\n",700-10*i);
        fprintf(in, "650 %f lineto\n",700-10*i+10);
        fprintf(in, "stroke\n\n");
    }
    //fin affichage barre
    fclose(in);
}

void kruskal(graphe g)
{
    g.comp=malloc(sizeof(int));
    int k = 0;
    for (int i=0; i<g.nbP; i++)
    {
        g.comp[i]=i;
    }
    for (int i=0; i<g.nbA; i++)
    {
        int x = g.aretes[i][0];
        int y = g.aretes[i][1];
        if (g.comp[x]!=g.comp[y])
        {
            int aux = g.comp[x];
            g.kruskal[k][0]=x;
            g.kruskal[k][1]=y;
            k++;
            for(int j=0; j<g.nbP; j++)
            {
                if (g.comp[j]==aux) g.comp[j]=g.comp[y];
            }
        }
    }

}

void dijkstra (graphe g)
{
    int* pere;
    double* distR;
    int* traite;
    pere=malloc(g.nbP*sizeof(int));
    traite=malloc((g.nbP+1)*sizeof(int));
    distR=malloc(g.nbP*sizeof(double));
    FILE* dijkstra;
    dijkstra = fopen("dijkstra.ps","w");

    for(int i=0; i<g.nbP; i++)
    {
        distR[i]=100000;
        traite[i]=0;
    }
    pere[0]=0;
    distR[0]=0;
    traite[g.nbP+1]=0;

    while (traite[g.nbP+1]!=g.nbP)
    {
        int max=100000;
        int AT;
        for(int i=0; i<g.nbP; i++)
        {
            if(distR[i]<=max && traite[i]==0)
            {
                AT=i;
                max=distR[i];
            }
        }
        traite[AT]=1;
        for(int i=0; i<(int)g.voisins[AT].nbElem; i++)
        {
            int l = sqrt(pow((g.coordP[AT][0]-g.coordP[g.voisins[AT].elem[i]][0]),2)+pow((g.coordP[AT][1]-g.coordP[g.voisins[AT].elem[i]][1]),2));

            if (traite[g.voisins[AT].elem[i]]==0 && distR[g.voisins[AT].elem[i]]>(distR[AT]+l))
            {
                distR[g.voisins[AT].elem[i]]=distR[AT]+l;
                pere[g.voisins[AT].elem[i]]=AT;
            }
        }
        traite[g.nbP+1]++;

    }
    double dmax=0;
    for(int i=1; i<g.nbP; i++)
    {
        if(distR[i]>dmax && distR[i]!=100000) dmax=distR[i];
    }
    tracage(g, dmax, distR, pere, dijkstra);

    system("convert dijkstra.ps dijkstra.pdf");
    free(pere);
    free(traite);
    free(distR);
}

void parcours_largeur(graphe g)
{
    int* ordre;
    int* pere;
    int* dv;
    double* niveau;
    ordre = malloc(g.nbP*sizeof(int));
    pere = malloc(g.nbP*sizeof(int));
    dv = malloc(g.nbP*sizeof(int));
    niveau = malloc(g.nbP*sizeof(double));
    FILE* dessin = fopen("Larg.ps", "w");
    srand(time(NULL));
    vector q=creer_vector();
    double nivmax=0;
    int t=2,k=0;
    for(int i=0; i<g.nbP; i++)
        dv[i]=0;
    for(int i=1; i<g.nbP; i++) //aucun pere
    {
        pere[i]=-1;
    }
    dv[0]=1;
    ordre[0]=1;
    pere[0]=0;
    niveau[0]=0;
    push(&q,0);
    while(q.nbElem!=0)
    {
        int x=q.elem[0];
        pop(&q);
        for(int j=0; j<g.voisins[x].nbElem; j++)
        {
            int v=g.voisins[x].elem[j];
            if(dv[v]==0)
            {
                dv[v]=1;
                push(&q,v);
                ordre[v]=t;
                t++;
                pere[v]=x;
                niveau[v]=niveau[x]+1;
                if (niveau[v]>nivmax) nivmax=niveau[v];
            }
        }
    }
    tracage(g, nivmax, niveau, pere, dessin);

    system("convert Larg.ps larg.pdf");
    free(pere);
    free(ordre);
    free(niveau);
    free(dv);
}

void parcours_profondeur(graphe g)
{
    FILE* dessin = fopen("Prof.ps", "w");
    int* pere;
    double* niveau;
    int* dv;
    pere=malloc(g.nbP*sizeof(int));
    niveau=malloc(g.nbP*sizeof(double));
    dv=malloc(g.nbP*sizeof(int));

    vector AT=creer_vector();
    for(int i=1; i<g.nbP; i++) //aucun point déjà vu
    {
        dv[i]=0;
    }
    dv[0]=1;
    int* debut;
    int* fin;
    debut=malloc(2*g.nbP*sizeof(int));
    fin=malloc(2*g.nbP*sizeof(int));
    debut[0]=1;
    pere[0]=0;
    for(int i=1; i<g.nbP; i++) //aucun pere
    {
        pere[i]=-1;
    }
    niveau[0]=0;
    push(&AT, 0);
    int t=2;
    double nivmax=0;
    while (AT.nbElem!=0)
    {
        int v=AT.elem[AT.nbElem-1];
        if(g.voisins[v].nbElem==0)
        {
            AT.nbElem--;
            fin[v]=t++;
        }
        else
        {
            int w=g.voisins[v].elem[g.voisins[v].nbElem-1];;
            g.voisins[v].nbElem--;
            if(dv[w]==0)
            {
                dv[w]=1;
                push(&AT, w);
                debut[w]=t++;
                pere[w]=v;
                niveau[w]=niveau[v]+1;
                if (niveau[w]>nivmax) nivmax=niveau[w];
            }
        }
    }
    tracage(g, nivmax, niveau, pere, dessin);

    system("convert Prof.ps prof.pdf");
    free(pere);
    free(niveau);
    free(dv);
}


vector creer_vector()
{
    vector v;
    v.elem = malloc(25*sizeof(int));
    v.taille = 25;
    v.nbElem = 0;

    return v;
}

void push(vector* q, int e)
{
    if(q->taille == q->nbElem)
    {
        q->taille *= 2;
        q->elem = realloc(q->elem, q->taille*sizeof(int));
    }
    q->elem[q->nbElem]=e;
    (q->nbElem)=(q->nbElem)+1;
}

void pop(vector* q)
{
    for(int i=0; i<q->nbElem; i++)
    {
        q->elem[i] = q->elem[i+1];
    }
    q->nbElem--;
}

