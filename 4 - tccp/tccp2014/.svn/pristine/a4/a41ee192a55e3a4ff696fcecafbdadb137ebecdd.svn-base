#ifndef _SACALEATOIRE_
#define _SACALEATOIRE_

#include "typesBase/typeBase.h"

/**
 * 
 * \brief Strutures de BoiteAléa : 
 * Cette strutures va nous permettre de créer une structure permetant d'effectuer des tirages dans une "boite". 
 */
typedef struct BoiteAlea* BoiteAlea;

/**
 * \struct BoiteAlea
 * \brief Objet boite aléatoire.
 *
 * BoiteAlea est un objet permettant d'effectuer des tirages aléatoires sur des Type.Il contient un tableau de Type ainsi que sa taille.
 */
struct BoiteAlea
{
  Type* tableau;
  int tabTaille; 
};

BoiteAlea boiteAlea_creer();//Constructeur par défaut
BoiteAlea boiteAlea_creerParam(Type* tableau, int tabTaille);//Constructeur paramétré
void boiteAlea_detruire(BoiteAlea box);//Destructeur des allocations dans le tas
BoiteAlea boiteALea_cloner(BoiteAlea box);//Constructeur par copie
void  boiteAlea_afficher(BoiteAlea box);//Affichage de la BoiteAléa
void boiteAlea_ajouter(BoiteAlea box,Type t);//Ajout d'un Type dans une BoiteAléa
Type boiteAlea_piocher(BoiteAlea box);//Pioche sans remise un Type de la "boite"
Type* boiteAlea_tirage(BoiteAlea box,int nbPioche);//Effectue n tirage sans remise


#endif 
