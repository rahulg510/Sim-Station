package presentation;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import aWorld.SimulationView;
import aWorld.World;
import business.*;
import framework.*;

public class SimulationFrame extends AppFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private Simulation model;
	private SimulationView sView = null;
	private AppPanel panel;

	public SimulationFrame(AppFactory factory) {
		super(factory);
    	setBackground(Color.DARK_GRAY);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	model = (Simulation) factory.makeModel();
    	panel = factory.makePanel(model, this);
    	add(panel);
    	JMenuBar menuBar = createMenuBar();
    	setJMenuBar(menuBar);
    	setSize(800,445);
    	model.addObserver(this);
		GridLayout layout = new GridLayout(1, 2); 
   	 	layout.preferredLayoutSize(this);
    	setLayout(layout); 
    	setSize(1025,World.SIZE+48);
    	sView = new SimulationView(model);
    	add(sView);
    
 	
	}

	protected JMenuBar createMenuBar() 
	{
    	FileMenuController fileMenuController = new FileMenuController(model);
    	JMenuBar result = new JMenuBar();
    	result.add(Utilities.makeMenu("File", factory.getFileCommands(), fileMenuController));
    	result.add(Utilities.makeMenu("Edit", factory.getEditCommands(), new SimulationController(model)));
    	result.add(Utilities.makeMenu("Help", factory.getHelp() , new HelpMenuController(this)));
    	return result;
    }
	
	@Override
	public void update(Observable o, Object arg)
	{
		repaint();
	}
	
	
}
