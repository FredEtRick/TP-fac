#ifndef suite
#define suite

#include <iostream>
#include "Suite.h"

using namespace std;

class SuiteConstante : virtual public Suite
{
	private :
		Vector<float> debut;
		int rang;
	public :
		SuiteConstante();
		virtual ~SuiteConstante();
		virtual float operator()(int) const;
		virtual float Somme(int) const;
		virtual ostream& affiche(ostream&) const;
		virtual istream& saisie(const istream&);
}

#endif
