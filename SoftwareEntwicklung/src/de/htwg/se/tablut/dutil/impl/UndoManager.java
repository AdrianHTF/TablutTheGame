package de.htwg.se.tablut.dutil.impl;

import de.htwg.se.tablut.bcontroller.*;
import de.htwg.se.tablut.dutil.CommandPattern;

public class UndoManager implements CommandPattern{
	IController controller;
	public UndoManager(IController c){
		controller = c;
	}
	
	@Override
	public void execute(){
		controller.undo();
	}
}