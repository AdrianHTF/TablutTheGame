package de.htwg.se.tablut.aview;
import de.htwg.se.tablut.bcontroller.GameStatus;
import java.util.*;

public class StatusMessage {
	
	public static final Map<GameStatus, String> text = new HashMap<>();
	
	private StatusMessage(){
		
	}
	
	static {
		text.put(GameStatus.WELCOME, "Welcome to TablutTheGame");
		text.put(GameStatus.CREATE, "Created a new Gamefield in choosen size");
		text.put(GameStatus.MOVE_SUCCESS, "Successfull move");
		text.put(GameStatus.MOVE_FAILE, "Failed move");
		text.put(GameStatus.WINGAME_ATTACK, "Attack wins");
		text.put(GameStatus.WINGAME_DEFENSE, "Defense wins");
		text.put(GameStatus.HIT, "Hit Successfull");
	}
	
}
