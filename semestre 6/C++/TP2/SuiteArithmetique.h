#ifndef suite
#define suite

#include <iostream>
#include "Suite.h"

using namespace std;

class SuiteArithmetique : virtual public Suite
{
	private :
		float U0;
		float raison;
	public :
		SuiteArithmetique();
		virtual ~SuiteArithmetique();
		virtual float operator()(int) const;
		virtual float Somme(int) const;
		virtual ostream& affiche(ostream&) const;
		virtual istream& saisie(const istream&);
}

#endif
