package de.htwg.se.tablut.aview;

import javax.management.JMException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.awt.event.*;


public class GuiMenuBar
        extends JMenuBar implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JMenuBar menuBar;
	
	private final JMenu data;
	private final JMenu help;
	
	private final JMenuItem undo;
	private final JMenuItem redo;
	private final JMenuItem restart;
	private final JMenuItem patt;
	private final JMenuItem exit;
	
	private final JMenuItem rules;
	private final JMenuItem controles;
	
	
	public GuiMenuBar(){
		//create MenueBar
		menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		
		//create Menu
		data = new JMenu("Datei");
		help = new JMenu("Hilfe");
		
		//create Items 
		undo = new JMenuItem("Ein Zug zurück");
		redo = new JMenuItem("Ein Zug vorwärts");
		restart = new JMenuItem("Neustart");
		patt = new JMenuItem("Unentschieden?");
		exit = new JMenuItem("Beenden");
		
		rules = new JMenuItem("Spielregeln");
		controles = new JMenuItem("Bedienung");
		
		//generate ActionListner
		undo.addActionListener(this);
		redo.addActionListener(this);
		restart.addActionListener(this);
		patt.addActionListener(this);
		exit.addActionListener(this);
		
		rules.addActionListener(this);
		controles.addActionListener(this);
		
		//add Items to Menu
		menuBar.add(data);
		menuBar.add(help);
		
		data.add(undo);
		data.add(redo);
		data.addSeparator();
		data.add(restart);
		data.add(patt);
		data.addSeparator();
		data.add(exit);
		
		help.add(rules);
		help.add(controles);
				
	}
	
	public JMenuBar getMenuBar(){
		return menuBar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
	}
	
	
	
}
