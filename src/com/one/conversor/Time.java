package com.one.conversor;

import javax.swing.JOptionPane;

public class Time extends Conversor{
	   @Override
	    protected void init() {
		   	name = "Convertidor de Tiempo";
			list.put("Segundos", 1.0);
			list.put("Minutos", 60.0);
			list.put("Horas", 3600.0); 
	    }	   

	   @Override	
	   public void convert() {

	       double amount = Double.parseDouble(amountInput);
           double sourceFactor = list.get(sourceUnit);
           double targetFactor = list.get(targetUnit);

           double convertedAmount = (amount * sourceFactor) / targetFactor;

           JOptionPane.showMessageDialog(null, amount + " " + sourceUnit + " equivale a " + convertedAmount + " " + targetUnit);

	   }

}
