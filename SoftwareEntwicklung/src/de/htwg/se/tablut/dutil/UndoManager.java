package de.htwg.se.tablut.dutil;

import de.htwg.se.tablut.bcontroller.Controller;

public class UndoManager implements CommandPattern{
	Controller controller;
	public UndoManager(Controller c){
		controller = c;
	}
	
	@Override
	public void execute(){
		controller.undo();
	}
}
