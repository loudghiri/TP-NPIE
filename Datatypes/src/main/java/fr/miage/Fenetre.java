
import javax.swing.*;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*; 

 class Fenetre extends JFrame implements ActionListener
     {
          private JPanel pan = new JPanel();
          private JComboBox l0 ;
          private JComboBox l1 ;
          private JComboBox l2 ;
          private JTextField depart  = new JTextField(30);
          private JTextField arrive = new JTextField(30);
          private JButton b1 = new JButton("convertir");
          

          
          public Fenetre()
          {
              setTitle("Convertisseur");
              setSize(400, 400);
              
              JMenu newconv = new JMenu("New");
              JMenuItem newc = new JMenuItem("New conversion");
      	      newconv.add(newc);
      		
      		newc.addActionListener(
      				new ActionListener(){
      					public void actionPerformed(ActionEvent e)
      					{
      						NewConversion nc = new NewConversion();
      						nc.setVisible(true);
      						dispose();
      					}
      				}
      			);
          
      		
      		
              JPanel top0 = new JPanel();
              JPanel top1 = new JPanel();
              JPanel top2 = new JPanel();
              JPanel top3 = new JPanel();
              JPanel top4 = new JPanel();
              


              arrive.setEditable(false);

            	
                
              
              final data file= new data();
              ArrayList <String> cat;
              final ArrayList <String> unit1;
              ArrayList <Float> coef;
              cat=file.getcat();
              unit1=file.getunit(cat.get(0));
              
             // System.out.println(cat.size());
              
              l0 = new JComboBox(cat.toArray());
              l1 = new JComboBox(unit1.toArray());
              l2 = new JComboBox(unit1.toArray());
              

              top0.add(l0);
              top1.add(l1);
              top1.add(l2);
              top2.add(depart);
              top3.add(b1);
              top4.add(arrive);
              
              
              pan.add(top0);
              pan.add(top1);
              pan.add(top2);
              pan.add(top3);
              pan.add(top4);
              
              JMenuBar bar = new JMenuBar();
      		setJMenuBar(bar);
      		bar.add(newconv);

      		getContentPane();
      		
      		setVisible(true);
            
              //              void b1_actionPerformed(ActionEvent e) { 
            	  //            	    System.out.println(l1.getSelectedItem()); 
            	    //           	  }

              setContentPane(pan);
              setVisible(true);
              b1.addActionListener(new java.awt.event.ActionListener() { 
                  public void actionPerformed(ActionEvent e) { 
                	  //  b1_actionPerformed(e); 
                    	  
                	  float r1 = file.getcoef(l0.getSelectedItem(),l1.getSelectedItem());
                	  float r2 = file.getcoef(l0.getSelectedItem(),l2.getSelectedItem());
                	 /* System.out.println(r1);
                	  System.out.println(r2);
                	  System.out.println(l1.getSelectedItem());
                      System.out.println(l2.getSelectedItem());
                      System.out.println(depart.getText()); */
                
                	  try {
                	        if (depart.getText().equals("")) {
                	        	JOptionPane.showMessageDialog(pan, "Veuillez entrer un nombre!");
                	        } else {
                	        	Float x = Float.parseFloat(depart.getText());
                          	  x = r2 * x / r1;
                          	  
                          	  String str = Float.toString(x);
                          	  arrive.setText(str);
                	        }
                	    } catch (Exception e1) {
                	    	JOptionPane.showMessageDialog(pan, "Veuillez entrer un nombre valide!");
                	    }
                	  
                    	  
                    	 

                  } 
                });

              l0.addActionListener (new java.awt.event.ActionListener() {
          	    public void actionPerformed(ActionEvent e) {
          	    	System.out.println(l0.getSelectedItem()); 
          	    	
          	    	l1.removeAllItems();
          	    	l2.removeAllItems();

          	    	unit1.clear();
          	    	unit1.addAll(file.getunit(l0.getSelectedItem()));
                    System.out.println(unit1.size());
          	    	
                	for (int i = 0 ; i <unit1.size() ; i++){
            			
                		l1.addItem(unit1.get(i));
                		l2.addItem(unit1.get(i));
            		}
                 
          	    }
          	});

              
              
        }



		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
       }
      