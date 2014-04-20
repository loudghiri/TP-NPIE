import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NewConversion extends JDialog{
	
	 private JPanel pan ;
	 private JLabel type;
	 private JTextField typeField;
	 private JLabel unite;
	 private JTextField uniteField;
	 private JLabel coef;
	 private JTextField coefField;
	 private JButton ajouter;
	 
	public NewConversion() {
	    setTitle("New conversion");
	   
	    pan = new JPanel();
	    type = new JLabel("Type");
	   
	    add(type);
	    typeField = new JTextField(20);
	    add(typeField);
	    unite = new JLabel("Unité");
	   
	    add(unite);
	    uniteField = new JTextField(20);
	    add(uniteField);
	    coef = new JLabel("coef");
	  
	    add(coef);
	    coefField = new JTextField(20);
	    add(coefField);
	    
	    ajouter = new JButton("Ajouter");
	    ajouter.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent event) {
	    	  try{
	    	  if(typeField.getText().isEmpty() || uniteField.getText().isEmpty() || coefField.getText().isEmpty()){
	    		  JOptionPane.showMessageDialog(pan, "il faut renseigné tout les champs");
	    	  }else{
	    		  Float x = Float.parseFloat(coefField.getText());
	        new data(typeField.getText(),uniteField.getText() ,x.toString());
	        JOptionPane.showMessageDialog(pan, "Conversion bien ajoutée");
	        typeField.setText("");
	        uniteField.setText("");
	        coefField.setText("");
	    	  }
	    	  }catch (Exception e1) {
      	    	JOptionPane.showMessageDialog(pan, "Veuillez entrer un nombre valide!");
      	    }
	      }
	    });
	    JButton close = new JButton("Close");
	    close.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent event) {
	    	  Fenetre f = new Fenetre();
	        dispose();
	      }
	    });
	    JPanel panType = new JPanel();
        JPanel panUnit = new JPanel();
        JPanel panCoef = new JPanel();
        JPanel panButton = new JPanel();
        
	    panType.add(type);
	    panType.add(typeField);
	    panUnit.add(unite);
	    panUnit.add(uniteField);
	    panCoef.add(coef);
	    panCoef.add(coefField);
	    panButton.add(ajouter);
	    panButton.add(close);
	    
	    pan.add(panType);
	    pan.add(panUnit);
	    pan.add(panCoef);
	    pan.add(panButton);
	    add(pan);
	    setModalityType(ModalityType.APPLICATION_MODAL);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setSize(400, 200);
	  }
}
