package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.Color;

public class Fenetre extends JFrame
{
	Planificateur planif = new Planificateur();
	Calendrier cal = new Calendrier();
	public Fenetre()
	{
		this.setTitle("organisation tâches");
		this.setSize(1080, 720);
		this.setLocationRelativeTo(null); // centrage
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // faire en sorte que la croix rouge quitte l'appli
		this.setLayout(new GridLayout(1, 2));
		cal.setBorder(BorderFactory.createLineBorder(Color.black));
		planif.setBorder(BorderFactory.createLineBorder(Color.black));
		this.getContentPane().add(cal);
		this.getContentPane().add(planif);
	}
}