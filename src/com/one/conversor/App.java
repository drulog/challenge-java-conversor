package com.one.conversor;

import javax.swing.JOptionPane;
	
public class App {
	
	public static void main(String[] args) {
		
	    int opcion = 0;
	    
	    do {	    	
	    	Object[] options = {"Convertidor de Divisas", "Convertidor de Tiempo"};
		
			String selector = (String) JOptionPane.showInputDialog(
					null,
					"¿Qué operación desea realizar?",
					"Conversor One",
					JOptionPane.PLAIN_MESSAGE,
					null,
					options,
					options[0]	
					);    		
		 
	      	int selected = 0;
	      	
	        for (int i = 0; i < options.length; i++) {
	            if (options[i].equals(selector)) {
	            	selected = i;
	                break;
	            }
	        }     
	    	
		   	switch(selected) {
		   		case 0:
		   			 new Currency().run();
			 		break;
			 	case 1:
			 		new Time().run();
			 		break;			 
			 }	  
		   	 
		   	 opcion = JOptionPane.showConfirmDialog(null,"¿Deseas continuar?");				
	    	
	    } while (opcion == JOptionPane.YES_OPTION);	
	        
	
		opcion = JOptionPane.NO_OPTION; 	
		JOptionPane.showMessageDialog(null, "Programa terminado"); 
	}

}
