#include <cstdlib>
#include <iostream>
#include <vector>

void grapherandom(int n, int m, int edge[][2]); // tire arrêtes au pif
void afficherArretes(int m, int edge[][2]); // afficher les arrêtes
void composantes(int n, int m, int edge[][2], int comp[]); // associe un num de comp a chaque sommet
void afficherComp(int n, int edge[][2], int comp[]); // affiche le num de comp de chaque sommet
void ecritureTailles(int n, int m, int comp[]); // indique combien de composantes contient combien de sommets en O(n)
void ecritureTaillesComplexe(int n, int m, int comp[]); // premier test en O(n²)

using namespace std;

int main()
{ 
	int n;     // Nombre de sommets.	
	int m;     // Nombre d'aretes.	
	cout << "Entrer le nombre de sommets:";
	cin >> n;
	cout << "Entrer le nombre d'aretes:";
	cin >> m;
	int edge[m][2];    // Tableau des aretes.
	int comp[n];       // comp[i] est le numero de la composante contenant i.
	grapherandom(n, m, edge);
	afficherArretes(m, edge);
	composantes(n, m, edge, comp);
	afficherComp(n, edge, comp);
	ecritureTailles(n, m, comp);

	return 0;
}

void afficherArretes(int m, int edge[][2])
{
	int i;
	for(i=0;i<m;i++)
	{
		cout << "la " << i+1 << "eme arrete est : " << edge[i][0] << "-" << edge[i][1] << endl;
	}
}

void grapherandom(int n, int m, int edge[][2]) // tire des arrêtes au hasard dans edge
{
	int i, j;
	srand(time(NULL));
	for(i=0;i<m;i++)
	{
		for(j=0;j<2;j++)
		{
			edge[i][j]=rand()%n; // edge[numéro de l'arrête][numéro du sommet de l'arrête(premier, deuxième)]=sommet. ex : edge[4][0]=1 edge[4][1]=7 pour l'arrête
		}
	}
}

void composantes(int n, int m, int edge[][2], int comp[])
{
	int i, j;
	for (i=0 ; i<n ; i++)
	{
		comp[i]=i;
	}
	for (i=0 ; i<m ; i++)
	{
		if (comp[edge[i][0]] != comp[edge[i][1]])
		{
			int aux = comp[edge[i][0]];
			for (j=0 ; j<n ; j++)
			{
				if (comp[j] == aux)
				{
					comp[j] = comp[edge[i][1]];
				}
			}
		}
	}
}

void afficherComp(int n, int edge[][2], int comp[])
{
	int i;
	for (i=0 ; i<n ; i++)
	{
		cout << "comp(" << i << ")=" << comp[i] << endl;
	}
}

void ecritureTaillesComplexe(int n, int m, int comp[])
{
	int nbComp[n+1];
	int i, j, taille;
	for (i=0 ; i<=n; i++)
	{
		nbComp[i]=0;
	}
	for (i=0 ; i<n; i++)
	{
		taille=0;
		for (j=0 ; j<n ; j++)
		{
			if (comp[j]==i)
			taille++;
		}
		nbComp[taille]++;
	}
	for (i=1 ; i<=n ; i++)
	{
		if (nbComp[i]>0)
		{
			cout << "Il y a " << nbComp[i] << " composantes";
			cout << " de taille " << i << endl;
		}
	}
}

void ecritureTailles(int n, int m, int comp[])
{
	int taille[n];
	int nbTaille[n+1];
	int i;
	for (i=0 ; i<n ; i++)
	{
		taille[i]=0;
	}
	for (i=0 ; i<n ; i++)
	{
		taille[comp[i]]++;
	}
	for (i=0 ; i<=n ; i++)
	{
		nbTaille[i]=0;
	}
	for (i=0 ; i<n ; i++)
	{
		nbTaille[taille[comp[i]]]++;
	}
	for (i=1 ; i<=n ; i++)
	{
		if (nbTaille[i]>0)
		{
			cout << "Il y a " << nbTaille[i] << " composantes";
			cout << " de taille " << i << endl;
		}
	}
}
