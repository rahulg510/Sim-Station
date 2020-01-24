package presentation;

import business.*;
import framework.*;
import java.awt.event.ActionListener;

import aWorld.World;
/**
 * Edit History
 * Code generated from class diagrams
 * 11/12: EA: Fixed makeEditCommands()
 */
public class SimulationFactory implements AppFactory {

    /**
     * Default constructor
     */
    public SimulationFactory() {	
    }

    /**
     * 
     */
    public Model makeModel() {
    	return new World("");
    }
    
    /**
     * @param model 
     * @param listener
     */
    public	AppPanel makePanel(Model model, ActionListener listener) {
    	AppPanel panel = new SimulationPanel((Simulation)model,listener);
    	return panel;
    }

    /**
     * 
     */
    public String[] getEditCommands() {
    	return new String[] {"Start", "Suspend", "Resume", "Stop"}; 
    }
    
    public String[] getFileCommands()
    {
    	return new String[]{"New", "Open", "Save", "SaveAs", "Quit"};
    }

    /**
     * @param model 
     * @param type
     */
    public Command makeEditCommands(Model model, String type) {
    	Simulation m = (Simulation) model;
        if(type == "Start") return new Start(m);
        else if(type == "Suspend") return new Suspend(m);
        else if(type == "Resume") return new Resume(m);
        else if(type == "Stop") return new Stop(m);
   
        return null;
    }

    /**
     * 
     */
    public String getTitle() {
        return "Sim Station"; 
    }

    /**
     * 
     */
    public String[] getHelp() {
        return new String[]{"About" , "Contents"};
    }

    /**
     * 
     */
    public String about() {
        return "Sim Station implemented by Rahul Krishan";
    }
    
    public String contents()
    {
    	return "Models the behaviors of birds";
    }
    
}