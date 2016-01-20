package de.htwg.se.tablut.dutil.impl;

import de.htwg.se.tablut.bcontroller.*;
import de.htwg.se.tablut.dutil.CommandPattern;

public class RedoManager implements CommandPattern{
	IController controller;
	public RedoManager(IController c){
		controller = c;
	}
	
	@Override
	public void execute() {
		controller.redo();
	}

}
