package Vue;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Planificateur extends JFrame
{
	private JButton organiser;
	private JCheckBox check1,check2,check3,check4;
	JPanel bouton = new JPanel();
	JPanel TacheList = new JPanel();
	
	public Planificateur(){
		
		this.setTitle("Planificateur");
		this.setSize(500, 800);
		this.setVisible(true);
		organiser=new JButton("Organiser");
		check1 = new JCheckBox("Tache 1");
		check2 = new JCheckBox("Tache 2");
		check3 = new JCheckBox("Tache 3");
		check4 = new JCheckBox("Tache 4");
		this.add(bouton,BorderLayout.SOUTH);	
		this.add(TacheList,BorderLayout.CENTER);
		bouton.add(organiser);
		TacheList.add(check1);
		TacheList.add(check2);
		TacheList.add(check3);
		TacheList.add(check4);
		
	}


/*public class Planificateur extends JFrame{


	public static void main (String[] args)
	{
		Planificateur fenetre = new Planificateur();
	}	
		public Planificateur()
		{
			this.setTitle("Fenetre de test pour la partie paramètres");
			this.setSize(500, 800);
			this.setVisible(true);
		}
	
	*/
}
