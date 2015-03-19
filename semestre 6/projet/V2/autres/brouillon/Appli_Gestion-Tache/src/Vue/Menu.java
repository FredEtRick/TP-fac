package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Menu extends JFrame {

	/**
	 * @param args
	s */
	private JButton CreerTache, Parametre, Planificateur, Agenda;
	JPanel Haut = new JPanel();
	JPanel Bas = new JPanel();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu menu=new Menu();
	}	
	
	public Menu() {
		
		this.setTitle("Menu de l'organisateur");
		this.setSize(450, 320);
		this.setLocationRelativeTo(null); // centre la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Pour que la fermeture de la fenêtre quitte l'appli
		this.setVisible(true);
		this.add(Haut,BorderLayout.NORTH);		
		this.add(Bas,BorderLayout.SOUTH);
		CreerTache = new JButton("CrŽer une tache");
		Parametre = new JButton("ParamŽtres");
		Planificateur = new JButton("Ouvrir le planificateur");
		Agenda = new JButton("Ouvrir l'agenda");
		Haut.add(CreerTache);
		Haut.add(Parametre);
		Bas.add(Planificateur);
		Bas.add(Agenda);
		CreerTache.setPreferredSize(new Dimension(300, 200));
		Parametre.setPreferredSize(new Dimension(300, 200));
		Planificateur.setPreferredSize(new Dimension(500, 200));
		Agenda.setPreferredSize(new Dimension(500,200));
		CreerTache.addActionListener(new CreerTacheListener());
		Parametre.addActionListener(new ParametreListener());
		Planificateur.addActionListener(new PlanificateurListener());
		Agenda.addActionListener(new AgendaListener());
	}
	
	class CreerTacheListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Tache fenTache = new Tache();
		}
	}
	
	class ParametreListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Test fenParam = new Test();
		}
	}
	
	class PlanificateurListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Planificateur fenPlan = new Planificateur();
		}
	}
	
	class AgendaListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			FenetreCalendrier fenCal = new FenetreCalendrier();
		}
	}
	

}