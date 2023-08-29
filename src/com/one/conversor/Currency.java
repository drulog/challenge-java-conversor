package com.one.conversor;


import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Currency extends Conversor {	
	
   @Override
    protected void init() {
	   	name = "Convertidor de Divisas";
		list.put("USD", 0.00024);
		list.put("COP", 1.0);
		list.put("EUR", 0.00022);
		list.put("GBP", 0.00019);
		list.put("JPY", 0.036);
		list.put("KRW", 0.32);	
    }	   

   @Override
   public void convert() {

       double amount = Double.parseDouble(amountInput);

       double sourceFactor = list.get(sourceUnit);	
       double targetFactor = list.get(targetUnit);

       double convertedAmount = (amount / sourceFactor) * targetFactor;

       DecimalFormat rateFormatter = new DecimalFormat("0.00000");    
 
       JOptionPane.showMessageDialog(null, amount + " " + sourceUnit + " equivale a " + rateFormatter.format(convertedAmount) + " " + targetUnit);

   }
		
}
