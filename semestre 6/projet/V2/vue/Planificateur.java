package vue;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Planificateur extends JPanel
{
	CardLayout cl = new CardLayout();
	JPanel panneau = new JPanel(cl);
	JPanel boutons = new JPanel();
	
	JButton boutonTaches = new JButton("Tâches");
	JButton boutonCategories = new JButton("Catégories");
	
	JPanel cardTaches = new JPanel();
	JPanel cardCategories = new JPanel();
	panneau.add(cardTaches, "tâches");
	panneaud.add(cardCategories, "catégories");
	
	ListeTaches lt = new ListeTaches();
	ModificationTaches mt = new ModificationTaches();
	ListeCategories lc = new ListeCategories();
	ModificationCategories mc = new ModificationCategories();
	
	public Planificateur()
	{
		panneau.setBorder(BorderFactory.createLineBorder(Color.black));
		boutons.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new BorderLayout());
		this.add(panneau, BorderLayout.CENTER);
		this.add(boutons, BorderLayout.SOUTH);
		boutons.setLayout(new GridLayout(1, 2));
		boutons.add(boutonTaches);
		boutons.add(boutonCategories);
		cl.show(panneau, "tâches");
	}
}