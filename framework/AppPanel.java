package framework;

import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/**
 * Edit History
 * Code provide from lecture notes and hints
 */
public abstract class AppPanel extends JPanel implements Observer {

	protected Model model;
	protected ActionListener listener;
	private Set<View> views;
	
    /**
     * Default constructor
     */
    public AppPanel(Model m, ActionListener l) {
    	model = m;
    	model.addObserver(this);
    	listener = l;
    }

    public void setModel(Model model) 
    {
    	if (this.model != null) this.model.deleteObserver(this);
        this.model = model;
        if (this.model != null) this.model.addObserver(this);
        for(View view: views) view.setModel(model);
    }
    
    public void add(View view) {
        super.add(view);
        views.add(view);
     }
    
	@Override
	public void update(Observable o, Object arg) {

	}
}