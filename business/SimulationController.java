package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import framework.AppFactory;
import framework.Command;
import framework.CommandProcessor;
import presentation.SimulationFactory;

public class SimulationController implements ActionListener
{
	private Simulation simulation;
	
	public SimulationController(Simulation model) 
	{
		simulation = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String cmnd = e.getActionCommand();
		
		SimulationFactory factory = new SimulationFactory();
		Command c = factory.makeEditCommands(simulation, cmnd);
		CommandProcessor.execute(c);			
		simulation.changed();
	}


	
}