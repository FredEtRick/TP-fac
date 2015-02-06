#ifndef suite
#define suite

#include <iostream>

using namespace std;

class Suite
{
	public :
		Suite();
		virtual ~Suite();
		virtual float operator()(int) const = 0;
		virtual float Somme(int) const;
		virtual ostream& affiche(ostream&) const;
		virtual istream& saisie(const istream&);
}

#endif
