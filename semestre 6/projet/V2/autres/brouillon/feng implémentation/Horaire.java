

public class Horaire
{
	private Date heureDebut;
	private Date heureFin;
	public Horaire()
	{
		heureDebut = new Date();
		heureFin = new Date();
	}
	public Horaire(Date A, Date B)
	{
		heureDebut = A;
		heureFin = B;
	}
	public Horaire(Horaire h)
	{
		this.heureDebut = h.heureDebut;
		this.heureFin = h.heureFin;
	}
	public Date getHeureDebut()
	{
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut)
	{
		this.heureDebut = heureDebut;
	}
	public Date getHeureFin()
	{
		return heureFin;
	}
	public void setHeureFin(Date heureFin)
	{
		this.heureFin = heureFin;
	}
	public String toString()
	{
		return "heure de debut : " + heureDebut + "\nheure de fin : " + heureFin;
	}
}