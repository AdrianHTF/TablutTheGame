package de.htwg.se.tablut.aview;

import javax.swing.*;
import java.awt.event.*;


public class GuiMenuBar
        extends JMenuBar{

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
	
	
	public GuiMenuBar(JFrame j, JFrame i, JFrame x){
		//create MenueBar
		menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		
		//create Menu
		data = new JMenu("Datei");
		help = new JMenu("Hilfe");
		
		//create Items 
		undo = new JMenuItem("Ein Zug zurueck");
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		redo = new JMenuItem("Ein Zug vorwaerts");
		restart = new JMenuItem("Neustart");
		patt = new JMenuItem("Unentschieden?");
		exit = new JMenuItem("Beenden");
		
		rules = new JMenuItem("Spielregeln");
		controles = new JMenuItem("Bedienung");
		
		rules.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buildSpielanleitung();
			}
		});
		
		controles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buildHelp();
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				j.setVisible(false);
				x.setVisible(false);
				i.setVisible(false);
				j.dispose();
				x.dispose();
				i.dispose();
			}
		});
		
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
	
	public GuiSpielanleitung buildSpielanleitung(){
		GuiSpielanleitung howToPlay = new GuiSpielanleitung();
		return howToPlay;
	}
	
	public GuiHilfe buildHelp(){
		GuiHilfe help = new GuiHilfe();
		return help;
	}
}
