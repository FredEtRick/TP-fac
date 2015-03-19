package Vue;

import javax.swing.JFrame;

public class Test extends JFrame
{
	
	public Test()
	{
		this.setTitle("Fenetre de test pour la partie paramètres");
		this.setSize(1080, 720);
		this.setLocationRelativeTo(null); // centrage
		this.setContentPane(new Parametre());
		this.setVisible(true);
	}
}