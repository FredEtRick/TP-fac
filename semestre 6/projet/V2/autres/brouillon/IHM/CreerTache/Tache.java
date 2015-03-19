/*
 ** Feng
 */
import java.awt.*;
import javax.swing.*;
public class Tache extends JFrame {
    
    
    
    public Tache(){
        initGUI();
    }
    
    
    public void initGUI() {
        
        setTitle("Créer votre nouvelle tache ");
        
        
        JPanel panel = new JPanel(new GridBagLayout());
        this.getContentPane().add(panel);
        /*
        ImageIcon icon = new ImageIcon(getClass().getResource("image.gpeg"));
       ........
        */
        
        JLabel label = new JLabel("Nouvelle Tache : ");
        Font font = new Font("Arial",Font.BOLD,18);
        label.setFont(font);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton("Anuller"));
        buttonPanel.add(new JButton("Creer"));
        
        JPanel detailsPanel = new JPanel();
        detailsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(label, gbc);
        
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        
        panel.add(DetailsPanel(), gbc);
        
        this.pack();
        
        this.setVisible(true);
    }
    
    private JPanel DetailsPanel() {
        
        
        JPanel panel = new JPanel();
        
        JLabel NameLabel = new JLabel("Nom de la tache : ");
        JLabel DescriptionLabel = new JLabel("Description : ");
        JLabel dateDebutLabel = new JLabel("Date Debut : ");
        JLabel dateFinLabel = new JLabel("Date Fin : ");
        JLabel tempsLabel = new JLabel("Temps : ");
        /*
         ....
         */
        
        JTextField NameField = new JTextField("");
        JTextField DescriptionField = new JTextField("");
        JTextField dateDebutField = new JTextField("");
        JTextField dateFinField = new JTextField("");
        JTextField tempsField = new JTextField("",10);
        /*
         ....
         */
       //tempsField.setMinimumSize(tempsField.getPreferredSize());
        
        JLabel categoriLabel = new JLabel("Catégori :");
       
        JComboBox categ = new JComboBox();
        categ.addItem("cate1");
        categ.addItem("cate2");
        
        JCheckBox checkbox1 = new JCheckBox("A Planifier");
        
        
        panel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        int i=0;
        
        gbc.insets = new Insets(2,2,2,2);
        gbc.anchor = GridBagConstraints.NORTHEAST;
        //(0,0)
        gbc.gridx = 0;
        gbc.gridy = i;
        panel.add(NameLabel,  gbc);
        
        //(1,0)
        gbc.gridx = 1;
        gbc.gridy = i;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(NameField,  gbc);
        
        i++;
        //(0,1)
        gbc.gridx = 0;
        gbc.gridy = i;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(categoriLabel,  gbc);
        //(1,1)
        gbc.gridx = 1;
        gbc.gridy = i;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(categ,  gbc);
      
        i++;
        //(0,2)
        gbc.gridx = 0;
        gbc.gridy = i;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(DescriptionLabel,  gbc);
        //(1,2)
        gbc.gridx = 1;
        gbc.gridy = i;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(DescriptionField,  gbc);
        
        i++;
        //(0,3)
        gbc.gridx = 0;
        gbc.gridy = i;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(dateDebutLabel,  gbc);
        //(1,3)
        gbc.gridx = 1;
        gbc.gridy = i;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(dateDebutField,  gbc);
        
        i++;
        
        gbc.gridx = 0;
        gbc.gridy = i;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(dateFinLabel,  gbc);
        
        gbc.gridx = 1;
        gbc.gridy = i;				
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(dateFinField,  gbc);
        
       
        i++;
        gbc.gridx = 0;
        gbc.gridy = i;		
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(tempsLabel,  gbc);
        
        gbc.gridx = 1;
        gbc.gridy = i;				
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        panel.add(tempsField,  gbc);
        
        
        gbc.gridx = 2;
        gbc.gridy = i;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(checkbox1,  gbc);
        
        return panel;
    }
    
    
    public static void main(String[] args) {
        Tache frame = new Tache();
        
        
        frame.pack();
        frame.setVisible(true);
    }
}
