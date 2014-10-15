#include <stdio.h>
#include <stdlib.h>

int** pascal(int n)
{
	int* T[n+1];
	int i, j;
	for (i=0 ; i<=n ; i++)
	{
		T[i] = malloc ((i+1) * (sizeof(int)));
		for (j=0 ; j<=i ; j++)
		{
			if ((j==0) || (j==i))
			{
				T[i][j] = 1;
			}
			else
			{
				T[i][j] = T[i-1][j-1] + T[i-1][j];
			}
		}
	}
	return T;
}

void cpn(int n, int p)
{
	int**T = pascal(n);
	int i, j;
	printf("\n");
	for (i=0 ; i<=n ; i++)
	{
		for (j=0 ; j<=i ; j++)
		{
			printf("%d ", T[i][j]);
		}
		printf("\n");
	}
	printf("\nC(%d,%d)=%d\n\n", n, p, T[n][p]);
}

int main()
{
	printf ("\nCombien de places voulez vous, puis combien d'éléments ? (nombre d'éléments");
	printf (" inférieur ou égal au nombre de places)\n\n");
	int n, p;
	do
	{
		scanf("%d%d", &n, &p);
	} while (p>n);
	cpn(n, p);
}
