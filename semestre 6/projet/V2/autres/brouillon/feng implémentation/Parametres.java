

public class Parametres
{
	private int travailHebdo;
	private int dureeMin;
	private int dureeMax;
	private int intervalle;
	public Parametres()
	{
		travailHebdo = 600;
		dureeMin = 60;
		dureeMax = 240;
		intervalle = 120;
	}
	public int getTravailHebdo()
	{
		return travailHebdo;
	}
	public void setTravailHebdo(int travailHebdo)
	{
		this.travailHebdo = travailHebdo;
	}
	public int getDureeMin()
	{
		return dureeMin;
	}
	public void setDureeMin(int dureeMin)
	{
		this.dureeMin = dureeMin;
	}
	public int getDureeMax()
	{
		return dureeMax;
	}
	public void setDureeMax(int dureeMax)
	{
		this.dureeMax = dureeMax;
	}
	public int getIntervalle()
	{
		return intervalle;
	}
	public void setIntervalle(int intervalle)
	{
		this.intervalle = intervalle;
	}
}