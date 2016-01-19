package de.htwg.se.tablut.dutil;

import de.htwg.se.tablut.dutil.CommandPattern;

public class Invoker {
	
	CommandPattern command;
	
	public void setCommand(CommandPattern cP){
		command = cP;
		invoke();
	}
	
	public void invoke(){
		command.execute();
	}
}
