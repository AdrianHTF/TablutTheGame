package de.htwg.se.tablut.aview;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import de.htwg.se.tablut.bcontroller.*;
import de.htwg.se.tablut.dutil.*;

public class TextUI implements IObserver {
	private Controller controller;
	
	public TextUI(Controller c){
		this.controller = c;
		controller.addObserver(this);
	}
	
	public void funktion(String line){
		if(line.matches("[0-9]+[/. -][0-9]+[/. -][0-9]+[/. -][0-9]+")){
			System.out.println("bin drinne");
			int[] arg = readToArray(line);
			controller.move(arg[0], arg[2], arg[4], arg[6]);
		}
	}
	
	private int[] readToArray(String line){
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(line);
		int[] arg = new int[line.length()];
		for (int i = 0; i < 7; i+=2){
			m.find();
			arg[i] = Integer.parseInt(m.group());
			System.out.println(arg[i]+"");
		}
		System.out.println("bin fertig");
		return arg;
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
		System.out.println("");
	}
}
