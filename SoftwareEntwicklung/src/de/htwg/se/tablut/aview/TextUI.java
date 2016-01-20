package de.htwg.se.tablut.aview;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import de.htwg.se.tablut.bcontroller.*;
import de.htwg.se.tablut.dutil.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextUI implements IObserver {
	
	private IController controller;
	private static final Logger LOGGER = Logger.getLogger(TextUI.class.getName());
	
	public TextUI(IController c){
		this.controller = c;
		controller.addObserver(this);
	}
	
	public void funktion(String line){
		if(line.matches("[0-9]+[/. -][0-9]+[/. -][0-9]+[/. -][0-9]+")){
			moveEingabe(line);
		} else if(line.matches("[0-9]+")){
			matrixSizeEingabe(line);
		}
	}
	
	private void moveEingabe(String line){
		int[] arg = readToArray(line);
		int xStart = arg[0];
		int yStart = arg[2];
		int xZiel = arg[4];
		int yZiel = arg[6];
		int size = controller.getMatrixSize();
		if(xStart < size && yStart < size &&
				xZiel < size && yZiel < size){
			controller.move(arg[0], arg[2], arg[4], arg[6]);
		}else{
			LOGGER.setLevel(Level.INFO);
			LOGGER.info("Eingabe geht uebers Spielfeld");
		}
	}
	
	private void matrixSizeEingabe(String line){
		if(controller.getMatrixSize() < 0){
			return;
		}
		int[] arg = readToArray(line);
		int matrixSize = arg[0];
		if(matrixSize == 9
				|| matrixSize == 11
				|| matrixSize == 13){
			controller.setMatrixSize(matrixSize);
		}
	}
	
	private int[] readToArray(String line){
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(line);
		int[] arg = new int[line.length()];
		for (int i = 0; i < arg.length && i < 7; i+=2){
			m.find();
			arg[i] = Integer.parseInt(m.group());
		}
		return arg;
	}

	@Override
	public void update(Event e) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < controller.getGamefield().getSizeOfGameField(); i++){
			for (int j = 0; j< controller.getGamefield().getSizeOfGameField(); j++){
				if((j % controller.getGamefield().getSizeOfGameField()) == 0)
					sb.append("\n");
				sb.append(controller.getGamefield().getField(j, i).toString());
			}
		}
		
		for(int i = 0; i < 5; i++){
			sb.append("");
		}
		LOGGER.info(sb.toString());
	}
}
