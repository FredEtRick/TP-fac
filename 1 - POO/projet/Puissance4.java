import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Puissance4 extends JFrame
{
	private JPanel panneauConteneur = new JPanel();
	private JPanel panneauFleches = new JPanel();
	private Fond panneauJetons = new Fond();
	private Bouton bouton[] = new Bouton[7];
	private JPanel panneauCase[] = new JPanel[42];
	private boolean anime = false;
	private int[] h;
	private String[][] forme;
	private int col;
	private int y;
	private String couleur;
	private Thread t;
	private boolean[] plein;
	private boolean gagne;
	
	public static void main(String args[])
	{
		Puissance4 test = new Puissance4();
	}
	
	class Bouton extends JButton
	{
		private boolean active = true;
		public void desactiver() throws DesactiveException
		{
			if(active == true)
				active = false;
			else
				throw new DesactiveException("le bouton est déjà désactivé");
			assert (active == false) : "active ne vaut pas false";
		}
		public void activer() throws ActiveException
		{
			if (active == false)
				active = true;
			else
				throw new ActiveException("le bouton est déjà activé");
			assert (active == true) : "active ne vaut pas true";
		}
		public void paintComponent(Graphics g)
		{
			if (active)
				g.setColor(new Color(150, 50, 0));
			else
				g.setColor(Color.gray);
			int x[] = {35, 65, 65, 80, 50, 20, 35};
			int y[] = {5, 5, 50, 50, 95, 50, 50};
			g.fillPolygon(x, y, 7);
		}
	}
	
	class BoutonException extends Exception
	{
		public BoutonException()
		{
			super();
		}
		public BoutonException(String s)
		{
			super(s);
		}
	}
	
	class ActiveException extends BoutonException
	{
		public ActiveException()
		{
			super();
		}
		public ActiveException(String s)
		{
			super(s);
		}
	}
	
	class DesactiveException extends BoutonException
	{
		public DesactiveException()
		{
			super();
		}
		public DesactiveException(String s)
		{
			super(s);
		}
	}
	
	public Puissance4()
	{
		couleur = "rouge";
		gagne = false;
		
		this.setSize(720, 720);
		this.setTitle("Puissance 4");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.setContentPane(panneauConteneur);
		
		panneauConteneur.setLayout(new BorderLayout());
		panneauFleches.setLayout(new GridLayout(1, 7));
		panneauJetons.setLayout(new GridLayout(6, 7));
		panneauConteneur.add(panneauFleches, BorderLayout.NORTH);
		panneauConteneur.add(panneauJetons, BorderLayout.CENTER);
		panneauFleches.setPreferredSize(new Dimension(720, 100));
		
		for (int i = 0 ; i < 7 ; i++)
		{
			bouton[i] = new Bouton();
			panneauFleches.add(bouton[i]);
		}
		
		for (int i = 0 ; i < 42 ; i++)
		{
			panneauCase[i] = new JPanel();
			panneauCase[i].setOpaque(false);
			panneauJetons.add(panneauCase[i]);
			panneauCase[i].setBorder(BorderFactory.createLineBorder(Color.gray));
		}
		
		bouton[0].addActionListener(new Bouton0Listener());
		bouton[1].addActionListener(new Bouton1Listener());
		bouton[2].addActionListener(new Bouton2Listener());
		bouton[3].addActionListener(new Bouton3Listener());
		bouton[4].addActionListener(new Bouton4Listener());
		bouton[5].addActionListener(new Bouton5Listener());
		bouton[6].addActionListener(new Bouton6Listener());
		
		plein = new boolean[7];
		
		for (int i = 0 ; i < 7 ; i++)
		{
			plein[i] = false;
		}
		
		this.setVisible(true);
	}
	
	class Fond extends JPanel
	{		
		public Fond()
		{
			h = new int[7];
			for (int i = 0; i < 7; i++)
				h[i] = 5;
			col = 0;
			y = -103;
			couleur = "";
			forme = new String[7][6];
			for (String colonne[] : forme)
			{
				for (String uneCase : colonne)
				{
					uneCase = "";
				}
			}
		}
		
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			int numCol = 0, numCase = 0;
			for (String colonne[] : forme)
			{
				numCase = 0;
				for (String uneCase : colonne)
				{
					if (uneCase == "rond")
					{
						g.setColor(Color.red);
						g.fillOval(((numCol*103)+10), ((numCase*99)+10), 83, 83);
					}
					else if (uneCase == "carre")
					{
						g.setColor(Color.black);
						g.fillRect(((numCol*103)+10), ((numCase*99)+10), 83, 83);
					}
					numCase++;
				}
				numCol++;
			}
			if (couleur == "rouge")
			{
				g.setColor(Color.red);
				g.fillOval(((col*103)+10), y, 83, 83);
			}
			else if (couleur == "noir")
			{
				g.setColor(Color.black);
				g.fillRect(((col*103)+10), y, 83, 83);
			}
			if (gagne && (couleur == "rouge"))
			{
				g.setColor(Color.blue);
				g.drawString("Le joueur 2 (noir) a gagné !!!", 20, 20);
				boolean test = true;
				for (int i=0 ; i<7 ; i++)
					test = test && !bouton[i].isEnabled();
				assert (test) : "au moins une fleche est encore active";
			}
			if (gagne && (couleur == "noir"))
			{
				g.setColor(Color.blue);
				g.drawString("Le joueur 1 (rouge) a gagné !!!", 20, 20);
				boolean test = true;
				for (int i=0 ; i<7 ; i++)
					test = test && !bouton[i].isEnabled();
				assert (test) : "au moins une fleche est encore active";
			}
		}
	}
	
	public void animer()
	{
		anime = true;
		while (y < ((h[col]*103)-10))
		{
			y++;
			panneauJetons.repaint();
			try
			{
				Thread.sleep(2);
			}
			catch (InterruptedException e)
			{
	        	e.printStackTrace();
      		}
		}
		if (couleur == "rouge")
			forme[col][h[col]] = "rond";
		else
			forme[col][h[col]] = "carre";
		h[col]--;
		panneauJetons.repaint();
		y=-103;
		if (h[col] == -1)
			plein[col] = true;
		for (int i = 0 ; i < 7 ; i++)
		{
			try
			{
				if (plein[i])
					throw new ColonnePleineException("La colonne est pleine");
				else
				{
					bouton[i].setEnabled(true);
					try
					{
						bouton[i].activer();
					}
					catch (ActiveException e)
					{
						// System.out.println(e.getMessage()); message trop redondant
					}
				}
			}
			catch (ColonnePleineException e)
			{
				// e.printStackTrace();
			}
		}
		anime = false;
		if (couleur == "rouge")
			couleur = "noir";
		else
			couleur = "rouge";
		// vérifier si gagné !!!
		int horizontal = 1;
		int vertical = 1;
		int diagDesc = 1;
		int diagMont = 1;
		int colBis = col;
		int hautBis = h[col]+1;
		String formeBis = forme[colBis][hautBis];
		boolean continuer = true;
		while ((colBis > 0) && continuer) // vérification horizontale avant le jeton
		{
			if (forme[--colBis][hautBis] == formeBis)
				horizontal++;
			else
				continuer = false;
		}
		colBis = col;
		continuer = true;
		while ((colBis < 6) && continuer) // vérification horizontale après le jeton
		{
			if (forme[++colBis][hautBis] == formeBis)
				horizontal++;
			else
				continuer = false;
		}
		colBis = col;
		continuer = true;
		while ((hautBis > 0) && continuer) // vérification verticale au dessus du jeton
		{
			if (forme[colBis][--hautBis] == formeBis)
				vertical++;
			else
				continuer = false;
		}
		hautBis = h[col]+1;
		continuer = true;
		while ((hautBis < 5) && continuer) // vérification verticale sous le jeton
		{
			if (forme[colBis][++hautBis] == formeBis)
				vertical++;
			else
				continuer = false;
		}
		hautBis = h[col]+1;
		continuer = true;
		while ((hautBis > 0) && (colBis > 0) && continuer) // vérification diagDesc avant jeton
		{
			if (forme[--colBis][--hautBis] == formeBis)
				diagDesc++;
			else
				continuer = false;
		}
		hautBis = h[col]+1;
		colBis = col;
		continuer = true;
		while ((hautBis < 5) && (colBis < 6) && continuer) // vérification diagDesc après jeton
		{
			if (forme[++colBis][++hautBis] == formeBis)
				diagDesc++;
			else
				continuer = false;
		}
		hautBis = h[col]+1;
		colBis = col;
		continuer = true;
		while ((hautBis < 5) && (colBis > 0) && continuer) // vérification diagMont bas-gauche
		{
			if (forme[--colBis][++hautBis] == formeBis)
				diagMont++;
			else
				continuer = false;
		}
		hautBis = h[col]+1;
		colBis = col;
		continuer = true;
		while ((hautBis > 0) && (colBis < 6) && continuer) // vérification diagMont haut-droit
		{
			if (forme[++colBis][--hautBis] == formeBis)
				diagMont++;
			else
				continuer = false;
		}
		if ((horizontal > 3) || (vertical > 3) || (diagDesc > 3) || (diagMont > 3))
		{
			gagne = true;
			for (int i = 0 ; i < 7 ; i++)
			{
				bouton[i].setEnabled(false);
				try
				{
					bouton[i].desactiver();
				}
				catch (DesactiveException e)
				{
					// System.out.println(e.getMessage());
				}
			}
			panneauJetons.repaint();
		}
		boolean test = true;
		for (int i=0 ; i<7 ; i++)
			test = test && !bouton[i].isEnabled();
		assert ((test && gagne) || (!test && !gagne)) : "incohérence entre l'activation des colonnes et le gain de la partie";
	}
	
	class ColonnePleineException extends Exception
	{
		public ColonnePleineException()
		{
			super();
		}
		public ColonnePleineException(String s)
		{
			super(s);
		}
	}
	
	class LancerAnimation implements Runnable
	{
		public void run()
		{
			animer();
		}
	}
	
	class Bouton0Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			for (int i = 0 ; i < 7 ; i++)
			{
				bouton[i].setEnabled(false);
				try
				{
					bouton[i].desactiver();
				}
				catch (DesactiveException e)
				{
					// System.out.println(e.getMessage()); message trop redondant
				}
			}
			col = 0;
			t = new Thread(new LancerAnimation());
			t.start();
		}
	}
	
	class Bouton1Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			for (int i = 0 ; i < 7 ; i++)
			{
				bouton[i].setEnabled(false);
				try
				{
					bouton[i].desactiver();
				}
				catch (DesactiveException e)
				{
					// System.out.println(e.getMessage());
				}
			}
			col = 1;
			t = new Thread(new LancerAnimation());
			t.start();
		}
	}
	
	class Bouton2Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			for (int i = 0 ; i < 7 ; i++)
			{
				bouton[i].setEnabled(false);
				try
				{
					bouton[i].desactiver();
				}
				catch (DesactiveException e)
				{
					// System.out.println(e.getMessage());
				}
			}
			col = 2;
			t = new Thread(new LancerAnimation());
			t.start();
		}
	}
	
	class Bouton3Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			for (int i = 0 ; i < 7 ; i++)
			{
				bouton[i].setEnabled(false);
				try
				{
					bouton[i].desactiver();
				}
				catch (DesactiveException e)
				{
					// System.out.println(e.getMessage());
				}
			}
			col = 3;
			t = new Thread(new LancerAnimation());
			t.start();
		}
	}
	
	class Bouton4Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			for (int i = 0 ; i < 7 ; i++)
			{
				bouton[i].setEnabled(false);
				try
				{
					bouton[i].desactiver();
				}
				catch (DesactiveException e)
				{
					// System.out.println(e.getMessage());
				}
			}
			col = 4;
			t = new Thread(new LancerAnimation());
			t.start();
		}
	}
	
	class Bouton5Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			for (int i = 0 ; i < 7 ; i++)
			{
				bouton[i].setEnabled(false);
				try
				{
					bouton[i].desactiver();
				}
				catch (DesactiveException e)
				{
					// System.out.println(e.getMessage());
				}
			}
			col = 5;
			t = new Thread(new LancerAnimation());
			t.start();
		}
	}
	
	class Bouton6Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			for (int i = 0 ; i < 7 ; i++)
			{
				bouton[i].setEnabled(false);
				try
				{
					bouton[i].desactiver();
				}
				catch (DesactiveException e)
				{
					// System.out.println(e.getMessage());
				}
			}
			col = 6;
			t = new Thread(new LancerAnimation());
			t.start();
		}
	}
}