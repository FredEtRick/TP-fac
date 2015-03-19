import javax.swing.JFrame;

public class Test extends JFrame
{
	public static void main (String[] args)
	{
		Test fenetre = new Test(); // création d'une fenêtre de test pour visualiser la partie paramètres
	}
	public Test()
	{
		this.setTitle("Fenetre de test pour la partie paramètres");
		this.setSize(1080, 720);
		this.setLocationRelativeTo(null); // centrage
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // faire en sorte que la croix rouge quitte l'appli
		this.setContentPane(new Parametres());
		this.setVisible(true);
	}
}