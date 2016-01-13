package de.htwg.se.tablut.aview;
import java.util.Scanner;
import de.htwg.se.tablut.bcontroller.*;
import de.htwg.se.tablut.dutil.*;

public class TextUI implements IObserver {
	private Controller controller;
	
	public TextUI(Controller c){
		this.controller = c;
		controller.addObserver(this);
	}

	@Override
	public void update(Event e) {
		for (int i = 0; i < controller.getGamefield().getSizeOfGameField(); i++){
			for (int j = 0; j< controller.getGamefield().getSizeOfGameField(); j++){
				if((j % controller.getGamefield().getSizeOfGameField()) == 0)
					System.out.println("\n");
				System.out.print(controller.getGamefield().getField(j, i));
			}
		}
	}
}
