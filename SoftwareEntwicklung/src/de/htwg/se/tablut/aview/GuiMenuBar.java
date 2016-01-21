package de.htwg.se.tablut.aview;

import javax.swing.*;
import java.awt.event.*;
import de.htwg.se.tablut.bcontroller.*;
import de.htwg.se.tablut.dutil.*;
import de.htwg.se.tablut.dutil.impl.Invoker;
import de.htwg.se.tablut.dutil.impl.RedoManager;
import de.htwg.se.tablut.dutil.impl.UndoManager;


public class GuiMenuBar
        extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IController controller;
	private CommandPattern undoCommand;
	private CommandPattern redoCommand;
	private Invoker invoker;

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
	
	
	public GuiMenuBar(JFrame j, JFrame i, JFrame x, IController c){
		controller = c;
		undoCommand = new UndoManager(controller);
		redoCommand = new RedoManager(controller);
		invoker = new Invoker();
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
				invoker.setCommand(undoCommand);
			}
		});
		redo = new JMenuItem("Ein Zug vorwaerts");
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				invoker.setCommand(redoCommand);
			}
		});
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
	
	public void buildSpielanleitung(){
		GuiSpielanleitung howToPlay = new GuiSpielanleitung();
	}
	
	public void buildHelp(){
		GuiHilfe helpTxt = new GuiHilfe();
	}
}
