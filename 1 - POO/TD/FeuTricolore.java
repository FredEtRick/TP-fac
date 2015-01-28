package Iterateurs;

import java.awt.Color;
import java.util.Iterator;

public class FeuTricolore implements Iterable<Color> {

	private Color[] couleurs = {Color.red, Color.orange, Color.green};
	// couleurs standards
	
	public FeuTricolore(){}
	public FeuTricolore(Color[] couleurs){this.couleurs=couleurs;}
	// on peut creer un feu tricolore avec 3 autres couleurs plus originales
	
	public Iterator<Color> iterator() {
		return new FeuTricoloreIterateur(couleurs);
	}

	public static void main(String[] arg)
	{
		FeuTricolore f = new FeuTricolore();
		Iterator<Color> ite = f.iterator();
		
		for (int step = 0; step < 12; step++)
			{
				System.out.println(ite.next());
			}
	}
}
