package de.htwg.se.tablut.aview;
import javax.swing.*;

import java.io.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuiSpielanleitung {
	
	private static final Logger LOGGER = Logger.getLogger(GuiSpielanleitung.class.getName());
	private final JFrame howToPlayFrame;
	private final JTextArea howToPlay;
	
	public GuiSpielanleitung(){
		howToPlayFrame = new  JFrame("Spielregeln");
		howToPlay = new JTextArea();
		BufferedReader in = null;
		try{
			in = new BufferedReader(new FileReader("spielanleitung.txt"));
			String str;
			while ((str = in.readLine()) != null){
				howToPlay.append(str);
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
		
		howToPlayFrame.getContentPane().add( new JScrollPane(howToPlay), BorderLayout.CENTER);
		howToPlayFrame.setPreferredSize(new Dimension(800, 550));
		howToPlayFrame.pack();
		howToPlayFrame.setLocationRelativeTo( null );
		howToPlayFrame.setVisible(true);
	}	
}

