package de.htwg.se.tablut.aview;
import javax.swing.*;

import java.io.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class GuiSpielanleitung {
	
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
			
		} finally {
			try{in.close(); } catch(Exception ex){}
		}
		
		howToPlayFrame.getContentPane().add( new JScrollPane(howToPlay), BorderLayout.CENTER);
		howToPlayFrame.setPreferredSize(new Dimension(800, 550));
		howToPlayFrame.pack();
		howToPlayFrame.setLocationRelativeTo( null );
		howToPlayFrame.setVisible(true);
	}	
}

