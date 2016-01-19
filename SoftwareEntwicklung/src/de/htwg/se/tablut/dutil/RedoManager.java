package de.htwg.se.tablut.dutil;

import de.htwg.se.tablut.bcontroller.Controller;

public class RedoManager implements CommandPattern{
	Controller controller;
	public RedoManager(Controller c){
		controller = c;
	}
	
	@Override
	public void execute() {
		controller.redo();
	}

}
