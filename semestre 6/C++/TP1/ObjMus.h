#ifndef ObjMus
#define ObjMus
using namespace std;
#include <iostream>
#include <string>

class ObjMus
{
	protected :
		String descriptif;
		int référence const;
		static int cpt; // pour référence unique pour constructeur non paramétré, incrémenter si déjà pris par constructeur paramétré puis réincrémenter, le tout dans le corps du constructeur non paramétré
	public :
		ObjMus();
		ObjMus(String, int);
		//~ObjMus(); // si cpt == référence + 1, décrémenter cpt avant de détruire. Ou pas : pas utile.
		String getDescriptif() const;
		void setDescriptif(String);
		int getReference() const;
		void saisie(&istream const);
		void affiche(&osream) const;
}

#endif
