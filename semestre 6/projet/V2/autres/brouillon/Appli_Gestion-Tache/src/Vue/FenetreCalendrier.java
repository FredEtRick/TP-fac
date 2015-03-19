package Vue;

import  javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
	public class FenetreCalendrier extends JFrame {
			
		JPanel panneau= new JPanel();
		CardLayout cl=new CardLayout();
		String[]listContent={"card1","card2","card3"}; 
	//type de  notre affichage
		String[] items={"Hebdomadaire","Mensuel"}; 
		JComboBox choixAffichage= new JComboBox(items);
		
		public FenetreCalendrier(){
	//detail  de la fenetre
			
			setLocationRelativeTo(null);  
			setTitle("Application  de gestion  de taches"); 
			setSize(600,450); 		
			setVisible(true);
	//Nos bouton  et  leur declaration		 
			
			 JButton Suivant= new JButton("Suivant"); 
			 JButton Precedent =new JButton("Précedent"); 
			
	//les 3 rideau  de notre fenetre
			
			JPanel card1=new JPanel(); 
			JPanel card2=new JPanel(); 
			JPanel card3=new JPanel(); 	
   //un menu  deroulant
			
			String[] items={"Hebdomadaire","Mensuel"}; 
			JComboBox choixAffichage= new JComboBox(items); 
			//choix  de type d'activité
			String[] items1={"Normal","Projet","Autre activité"}; 
			JComboBox choixType= new JComboBox(items1); 
			//choix de mois
			String[] items2={"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","octobre","Novembre","Decembre"}; 
			JComboBox choixMois= new JComboBox(items2); 
			//choix d'année
			String[] items3={"2015","2016","2017","2018"}; 
			JComboBox choixAnnée= new JComboBox(items3); 
			
						
			panneau.add(card1,listContent[0]); 
			panneau.add(card2,listContent[1]); 
			panneau.add(card3,listContent[2]); 
			
			
			JPanel boutonPan=new JPanel(); 
		
			boutonPan.add(Precedent); 
			boutonPan.add(choixAffichage);
			boutonPan.add(choixType);
			boutonPan.add(choixMois);
			boutonPan.add(choixAnnée);
			boutonPan.add(Suivant); 
			panneau.setLayout(cl); 
			panneau.setVisible(true);
		
		/*	JMenuBar menu=new  JMenuBar();
			JMenu menu1=new JMenu("Semaine Précedente"); 
			setJMenuBar(menu); 
			menu.add(menu1); 
			JMenu menu2=new JMenu("Semaine Suivante"); 
			menu.add(menu2); 
		*/
		//	JMenuItem hebdo=new JMenuItem(new CalculAction("Afficher la semaine")); 
			
	//creation  de notre  tableau 
			Object[][] donnee={
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
					{"","","","","","","",""}, 
			}; 
		
		String title[]={"Samedi","Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi"}; 
		JTable tableau=new JTable(donnee,title); 
		card3.add(tableau);

		getContentPane().add(new JScrollPane(tableau)) ;	

		//nos 4 boutons  pour la page  de  l'affichage mensuel
	
		JButton S1=new JButton("semaine 1"); 
		JButton S2=new JButton("semaine 2"); 
		JButton S3=new JButton("semaine 3"); 
		JButton S4=new JButton("semaine 4");
		
		card1.add(S1);
		card1.add(S2); 
		card1.add(S3);
		card1.add(S4);
		
	
		Suivant.addActionListener(new ActionListener()
		{
			public  void ActionPerformed(ActionEvent event){
				cl.show(panneau,listContent[0]);
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}
				
		);
	
		getContentPane().add(boutonPan,BorderLayout.NORTH); 
		getContentPane().add(panneau,BorderLayout.SOUTH);
		setVisible(true);
		
		
}
		
	public  static void main(String[]args){
	FenetreCalendrier fenetre = new FenetreCalendrier(); 	
	fenetre.setVisible(true);
}

}
