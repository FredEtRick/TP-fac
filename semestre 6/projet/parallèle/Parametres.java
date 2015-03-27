

public abstract class Parametres // APPELER LES METHODES DIRECTEMENT SUR LA CLASSE, NE PAS INSTANCIER !!! Ex : Parametres.setIntervalle() pas p.setIntervalle, et pas de new Planificateur p.
{
	private static int travailHebdo = 40;
	private static int dureeMin = 1;
	private static int dureeMax = 5;
	private static int intervalle = 2;
	public static int getTravailHebdo()
	{
		return travailHebdo;
	}
	public static void setTravailHebdo(int travailHebdo)
	{
		Parametres.travailHebdo = travailHebdo;
	}
	public static int getDureeMin()
	{
		return dureeMin;
	}
	public static void setDureeMin(int dureeMin)
	{
		Parametres.dureeMin = dureeMin;
	}
	public static int getDureeMax()
	{
		return dureeMax;
	}
	public static void setDureeMax(int dureeMax)
	{
		Parametres.dureeMax = dureeMax;
	}
	public static int getIntervalle()
	{
		return intervalle;
	}
	public static void setIntervalle(int intervalle)
	{
		Parametres.intervalle = intervalle;
	}
}
