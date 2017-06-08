package fakeCAD;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


import fakeCAD.Manager;


public class Test {

	public static void main(String[] argv) {
	    
		SwingUtilities.invokeLater(new Runnable() {
	    	
			@Override
        
			public void run() {
	        
				constructUI();
	            
			}

	    });

	  }

	  private static void constructUI() {

			JFrame frame=new JFrame("fake CAD");
			Manager jpanel=new Manager();
			
		
			frame.add(jpanel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			frame.setSize(800, 600);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);


	  }


	}


