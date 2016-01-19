package de.htwg.se.tablut.aview;
import javax.swing.*;

import java.io.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuiHilfe {
	
	private static final Logger LOGGER = Logger.getLogger(GuiHilfe.class.getName());
	private final JFrame helpFrame;
	private final JTextArea help;
	
	public GuiHilfe(){
		helpFrame = new  JFrame("Bedienung");
		help = new JTextArea();
		BufferedReader in = null;
		try{
			in = new BufferedReader(new FileReader("hilfe.txt"));
			String str;
			while ((str = in.readLine()) != null){
				help.append(str);
			}
		} catch(IOException e){
			LOGGER.log(Level.SEVERE, e.toString(), e);
		} finally {
			try{
				in.close(); 
			} catch(Exception ex){
				LOGGER.log(Level.SEVERE, ex.toString(), ex);
			}
		}
		
		helpFrame.getContentPane().add( new JScrollPane(help), BorderLayout.CENTER);
		helpFrame.setPreferredSize(new Dimension(800, 550));
		helpFrame.pack();
		helpFrame.setLocationRelativeTo( null );
		helpFrame.setVisible(true);
	}	
}