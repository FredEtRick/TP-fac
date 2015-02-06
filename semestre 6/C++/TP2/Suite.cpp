#include "Suite.h"
#include <iostream>

Suite::Suite()
virtual Suite::~Suite() {}
virtual float Suite::Somme(int n) const
{
	float s = U0;
	for (int i=0 ; i<n ; i++)
	{
		s+=raison;
	}
}
virtual ostream& Suite::affiche(ostream&) const
{
	
}
virtual istream& Suite::saisie(const istream&)
{
	
}
