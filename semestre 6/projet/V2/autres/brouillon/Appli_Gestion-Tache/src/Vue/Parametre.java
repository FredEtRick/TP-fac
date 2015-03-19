package Vue;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Parametre extends JPanel
{
	private JButton categorie, soumettre;
	public Parametre()
	{
		
		this.setLayout(new GridLayout(5, 2));
		this.add(new JLabel("travail hebdomadaire maximal (heures) : ", SwingConstants.CENTER));
		this.add(new JComboBox());
		this.add(new JLabel("temps minimal travail contigue (heures) : ", SwingConstants.CENTER));
		this.add(new JComboBox());
		this.add(new JLabel("temps maximal travail contigue (heures) : ", SwingConstants.CENTER));
		this.add(new JComboBox());
		this.add(new JLabel("intervalle minimale avant de retravailler une tache (heures) : ", SwingConstants.CENTER));
		this.add(new JComboBox());
		categorie = new JButton("categories");
		soumettre = new JButton("soumettre");
		this.add(categorie);
		this.add(soumettre);
		categorie.addActionListener(new CategorieListener());
		soumettre.addActionListener(new SoumettreListener());
	}
	
	class CategorieListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			FenCategorie fenCat = new FenCategorie();
		}
	}
	class SoumettreListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new Planificateur();
			// a implémenter plus tard
		}
	}
}