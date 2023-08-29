package com.one.conversor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class Conversor {	
	 protected String name;
	 protected JPanel panel;
	 protected JComboBox<String> sourceUnitComboBox;
	 protected JComboBox<String> targetUnitComboBox;
	 protected JTextField amountField; 	
	 protected Map<String, Double> list;
	 protected String[] units;
	 
	 protected String sourceUnit;
	 protected String targetUnit;
	 protected String amountInput;
	
	public Conversor() {
		this.list = new HashMap<>();		
		init();	

		initComponents();
	}	
		
	 protected abstract void init();	
	 
	 private void initComponents() {
		units = list.keySet().toArray(new String[0]);		 
		panel = new JPanel(new GridLayout(3, 2));
		sourceUnitComboBox = new JComboBox<>(units);
		targetUnitComboBox = new JComboBox<>(removeUnit(units, (String) sourceUnitComboBox.getSelectedItem()));
		
        
		amountField = new JTextField(10);

		JLabel sourceLabel = new JLabel("Origen:");
		JLabel amountLabel = new JLabel("Cantidad:");
		JLabel targetLabel = new JLabel("Destino:");
		
		panel.add(sourceLabel);
	    panel.add(sourceUnitComboBox);
	    panel.add(amountLabel);
	    panel.add(amountField);
	    panel.add(targetLabel);
	    panel.add(targetUnitComboBox);
	    
	    sourceUnitComboBox.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSourceUnit = (String) sourceUnitComboBox.getSelectedItem();
                updateTargetUnits(targetUnitComboBox, units, selectedSourceUnit);
            }
        });
	 }
	 
	 private void updateTargetUnits(JComboBox<String> targetUnitComboBox, String[] unitsArray, String unitToRemove) {
	        String[] updatedUnits = removeUnit(unitsArray, unitToRemove);
	        targetUnitComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(updatedUnits));
	    }
	  
	  private String[] removeUnit(String[] unitsArray, String unitToRemove) {
	        String[] newArray = new String[unitsArray.length - 1];
	        int newIndex = 0;
	        for (String unit : unitsArray) {
	            if (!unit.equals(unitToRemove)) {
	                newArray[newIndex++] = unit;
	            }	
	        }
	        return newArray;
	   }

	  public  void run() {
		  int result;
	       do {
	           result = JOptionPane.showConfirmDialog(null, panel, name, JOptionPane.OK_CANCEL_OPTION);

	           if (result == JOptionPane.OK_OPTION) {
	               sourceUnit = (String) sourceUnitComboBox.getSelectedItem();
	               amountInput = (String) amountField.getText();
	               targetUnit = (String) targetUnitComboBox.getSelectedItem();

	               if (amountInput != null && !amountInput.isEmpty()) {
	            	   convert();	               
	               } else {
	                   JOptionPane.showMessageDialog(null, "Por favor, ingresa una cantidad válida.");
	               }
	           }
	       } while (result == JOptionPane.OK_OPTION);
	  }
	  
	   public abstract void convert();	

}
