package framework;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
/**
 * Code provide from lecture notes and hints
 */
public class View extends JComponent implements Observer {

	protected Model model;
	
	public View(Model model) { setModel(model);}
	  
	public View() { this(null); }
	
	public void update(Observable subject, Object msg) {repaint();}
	  
	public void setModel(Model model) 
	{
		if (this.model != null) this.model.deleteObserver(this);
	    this.model = model;
	    if (this.model != null) 
	    {    
	    	this.model.addObserver(this);
	        //this.update(model, null); // update myself
	    }
	}

}
