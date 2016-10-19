package de.htwg.se.tablut;
import de.htwg.se.tablut.aview.*;
import de.htwg.se.tablut.bcontroller.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Tablut {
	
	private static final Logger LOGGER = Logger.getLogger(Tablut.class.getName());
	protected IController controller;
	private TextUI textUI;
	private Gui gui;
	private static Tablut instance = null;
	
	public Tablut(){
		Injector injector = Guice.createInjector(new TablutModule());
		controller = injector.getInstance(IController.class);
		//gui = new Gui(controller);
		textUI = new TextUI(controller);
		textUI.funktion("9");
	}
	
	public static Tablut getInstance() {
		if (instance == null) {
			instance = new Tablut();
		}
		return instance;
	}
	
	public TextUI getTui() {
		return textUI;
	}
	
	public IController getController() {
		return controller;
	}
	
	public static void main(String[] args) {
		Tablut tablut = Tablut.getInstance();
		Scanner sc = new Scanner(System.in);
		LOGGER.setLevel(Level.FINEST);
		LOGGER.info("Geben Sie eine Feldgroesse an.");
		do {
			tablut.getTui().funktion(sc.next());
		}while (tablut.getController().winGameAttack() && tablut.getController().winGame());
	}

}
