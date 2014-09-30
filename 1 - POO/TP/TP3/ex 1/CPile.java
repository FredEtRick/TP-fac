package TP3ex1;
Import java.util.*

public class CPile<A> implements IPile<A>
{
	private LinkedList<A> L;
	public boolean estVide()
	{
		return (L.peek == null);
	}
	public void empile (A a)
	{
		L.addFirst(a);
	}
	public A depile
	{
		return L.removeFirst();
	}
	public int nbElements()
	{
		return L.size();
	}
	public A sommet()
	{
		return L.peek();
	}
	public CPile()
	{
		L = new LinkedList<A>();
	}
	public String toString()
	{
		String str="";
		for (A a : list)
			str += a+"_";
		return str;
	}
}
