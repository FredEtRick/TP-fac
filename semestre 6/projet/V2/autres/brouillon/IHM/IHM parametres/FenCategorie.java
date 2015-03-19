import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JColorChooser;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class FenCategorie extends JFrame implements ActionListener
{
	private JButton[] bouton = new JButton[4];
	private JPanel palette = new JPanel();
	public FenCategorie()
	{
		this.setTitle("Catéories");
		this.setSize(720, 480);
		this.setLocationRelativeTo(null); // centrage
		
		JPanel panneau = new JPanel();
		this.setContentPane(panneau);
		
		for (int i = 0 ; i < 4; i++)
			bouton[i] = new JButton("couleur");
		
		panneau.setLayout(new GridLayout(5, 3));
		panneau.add(new JLabel("categorie 1 : ", SwingConstants.CENTER));
		panneau.add(new TextField());
		panneau.add(bouton[0]);
		panneau.add(new JLabel("categorie 2 : ", SwingConstants.CENTER));
		panneau.add(new TextField());
		panneau.add(bouton[1]);
		panneau.add(new JLabel("categorie 3 : ", SwingConstants.CENTER));
		panneau.add(new TextField());
		panneau.add(bouton[2]);
		panneau.add(new JLabel("categorie 4 : ", SwingConstants.CENTER));
		panneau.add(new TextField());
		panneau.add(bouton[3]);
		panneau.add(new JButton("valider"));
		
		for (int i = 0 ; i < 4; i++)
			bouton[i].addActionListener(this);
		
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		Color couleur = JColorChooser.showDialog(null, "couleur catégorie", Color.WHITE);
		palette.setBackground(couleur);
	}
}