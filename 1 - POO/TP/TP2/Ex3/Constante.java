public class Constante extends Expression
{
	private float c;
	public Constante(int c)
	{
		this.c = c;
	}
	public float evaluer()
	{
		return this.c;
	}
}
