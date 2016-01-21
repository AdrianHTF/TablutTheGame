package de.htwg.se.tablut;
import com.google.inject.AbstractModule;
import de.htwg.se.tablut.bcontroller.IController;

public class TablutModule extends AbstractModule{
	@Override
	protected void configure(){
		bind(IController.class).to(de.htwg.se.tablut.bcontroller.impl.Controller.class);
	}
}
