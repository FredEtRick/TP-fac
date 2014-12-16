import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculatrice extends JFrame
{
	// variables de calcul pour affichage
	public int taille;
	public String texte;
	public double reserve;
	public String operateur;

	public JButton b1;
	public JButton b2;
	public JButton b3;
	public JButton b4;
	public JButton b5;
	public JButton b6;
	public JButton b7;
	public JButton b8;
	public JButton b9;
	public JButton b0;
	public JButton bPoint;
	public JButton bEgal;
	public JButton bC;
	public JButton bPlus;
	public JButton bMoins;
	public JButton bFois;
	public JButton bDiv;

	public JPanel conteneur;
	public JPanel chiffres;
	public JPanel operations;
	public JPanel affichage;

	public static void main (String[] args)
	{
		Calculatrice cal = new Calculatrice();
	}
	public Calculatrice()
	{
		// mise en place de la fenetre
		this.setTitle("calculatrice");
		this.setSize(360,480);
		this.setLocationRelativeTo(null);

		taille = 30;
		texte = "0";
		reserve = 0.d;
		operateur = "";

//============================================STRUCTURATION==============================================

		// panneaux structurant la calculatrice
		conteneur = new JPanel();
		chiffres = new JPanel();
		operations = new JPanel();
		affichage = new JPanel()
		{
			public void paintComponent (Graphics g)
			{
				Font police = new Font("Times New Roman", Font.BOLD, taille);
				g.setFont(police);
				g.setColor(Color.blue);
				g.drawString(texte, 20, 40);
				g.drawRect(4, 4, this.getWidth()-9, this.getHeight()-7);
			}
		};
		affichage.setPreferredSize(new Dimension(360,60));

		// placement des sous panneaux dans le panneau contenant les autres
		this.setContentPane(conteneur);
		conteneur.setLayout(new BorderLayout());
		conteneur.add(affichage, BorderLayout.NORTH);
		conteneur.add(chiffres, BorderLayout.CENTER);
		conteneur.add(operations, BorderLayout.EAST);

		// STRUCTURATION DU PANNEAU CHIFFRE ET DE SES BOUTONS

		// structuration en grille
		chiffres.setLayout(new GridLayout(4, 3));

		// création des boutons
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		bPoint = new JButton(".");
		bEgal = new JButton("=");

		// placement des boutons dans le panneau chiffres
		chiffres.add(b1);
		chiffres.add(b2);
		chiffres.add(b3);
		chiffres.add(b4);
		chiffres.add(b5);
		chiffres.add(b6);
		chiffres.add(b7);
		chiffres.add(b8);
		chiffres.add(b9);
		chiffres.add(b0);
		chiffres.add(bPoint);
		chiffres.add(bEgal);

		// STRUCTURATION DU PANNEAU OPERATIONS

		// structuration en grille d'une colonne
		operations.setLayout(new GridLayout(5, 1));

		// création des boutons
		bC = new JButton("C");
		bPlus = new JButton("+");
		bMoins = new JButton("-");
		bFois = new JButton("*");
		bDiv = new JButton("/");

		// placement des boutons dans le panneau operations
		operations.add(bC);
		operations.add(bPlus);
		operations.add(bMoins);
		operations.add(bFois);
		operations.add(bDiv);

//============================================INTERACTIONS==============================================

		b1.addActionListener(new b1Listener());
		b2.addActionListener(new b2Listener());
		b3.addActionListener(new b3Listener());
		b4.addActionListener(new b4Listener());
		b5.addActionListener(new b5Listener());
		b6.addActionListener(new b6Listener());
		b7.addActionListener(new b7Listener());
		b8.addActionListener(new b8Listener());
		b9.addActionListener(new b9Listener());
		b0.addActionListener(new b0Listener());
		bPoint.addActionListener(new bPointListener());
		bEgal.addActionListener(new bEgalListener());
		bC.addActionListener(new bCListener());
		bPlus.addActionListener(new bPlusListener());
		bMoins.addActionListener(new bMoinsListener());
		bFois.addActionListener(new bFoisListener());
		bDiv.addActionListener(new bDivListener());
	
		this.setVisible(true);
	}
	public void calculer()
	{
		switch (operateur)
		{
			case "" :
				reserve = Double.parseDouble(texte);
				break;
			case "+" :
				reserve += Double.parseDouble(texte);
				break;
			case "-" :
				reserve -= Double.parseDouble(texte);
				break;
			case "*" :
				reserve *= Double.parseDouble(texte);
				break;
			case "/" :
				reserve /= Double.parseDouble(texte);
				break;
		}
	}
	class b1Listener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			if (texte == "0")
			{
				texte = "1";
				affichage.repaint();
			}
			else
			{
				texte += "1";
				affichage.repaint();
			}
		}
	}
	class b2Listener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			if (texte == "0")
			{
				texte = "2";
				affichage.repaint();
			}
			else
			{
				texte += "2";
				affichage.repaint();
			}
		}
	}
	class b3Listener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			if (texte == "0")
			{
				texte = "3";
				affichage.repaint();
			}
			else
			{
				texte += "3";
				affichage.repaint();
			}
		}
	}
	class b4Listener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			if (texte == "0")
			{
				texte = "4";
				affichage.repaint();
			}
			else
			{
				texte += "4";
				affichage.repaint();
			}
		}
	}
	class b5Listener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			if (texte == "0")
			{
				texte = "5";
				affichage.repaint();
			}
			else
			{
				texte += "5";
				affichage.repaint();
			}
		}
	}
	class b6Listener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			if (texte == "0")
			{
				texte = "6";
				affichage.repaint();
			}
			else
			{
				texte += "6";
				affichage.repaint();
			}
		}
	}
	class b7Listener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			if (texte == "0")
			{
				texte = "7";
				affichage.repaint();
			}
			else
			{
				texte += "7";
				affichage.repaint();
			}
		}
	}
	class b8Listener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			if (texte == "0")
			{
				texte = "8";
				affichage.repaint();
			}
			else
			{
				texte += "8";
				affichage.repaint();
			}
		}
	}
	class b9Listener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			if (texte == "0")
			{
				texte = "9";
				affichage.repaint();
			}
			else
			{
				texte += "9";
				affichage.repaint();
			}
		}
	}
	class b0Listener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			if (texte != "0")
			{
				texte += "0";
				affichage.repaint();
			}
		}
	}
	class bPointListener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			if (texte.indexOf('.') == -1)
			{
				texte += ".";
				affichage.repaint();
			}
		}
	}
	class bEgalListener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			calculer();
			texte = String.valueOf(reserve);
			affichage.repaint();
			operateur = "";
		}
	}
	class bCListener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			texte = "0";
			affichage.repaint();
			operateur = "";
			reserve = 0.d;
		}
	}
	class bPlusListener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			calculer();
			texte = "0";
			affichage.repaint();
			operateur = "+";
		}
	}
	class bMoinsListener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			calculer();
			texte = "0";
			affichage.repaint();
			operateur = "-";
		}
	}
	class bFoisListener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			calculer();
			texte = "0";
			affichage.repaint();
			operateur = "*";
		}
	}
	class bDivListener implements ActionListener
	{
		public void actionPerformed (ActionEvent a)
		{
			calculer();
			texte = "0";
			affichage.repaint();
			operateur = "/";
		}
	}
}