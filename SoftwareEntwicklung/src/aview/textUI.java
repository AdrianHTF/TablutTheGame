package aview;
import bcontroller.*;

public class textUI {
	private controller test;
	public textUI(){
		test = new controller(5);
	}
	
	public static void main(String [] args){
		textUI neu = new textUI();
		neu.test.printField();
	}	
}
