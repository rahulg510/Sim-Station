package presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

import framework.*;
import business.*;

public class SimulationPanel extends AppPanel{

	public JTextField clock;
    public SimulationController controller;
    private ArrayList<JPanel> jPanels = new ArrayList<>();
    private Simulation simulation;
    private static final long serialVersionUID = 1L;
	
	
	public SimulationPanel(Simulation maze, ActionListener listener) {
        super(maze, listener);
        setSize(400, 400);
        this.simulation = (Simulation)super.model;
        clock = new JTextField(String.valueOf(simulation.getClock()),5);
        addInfo(new JLabel("Clock"), clock);
        controller = new SimulationController(maze);
        
        AppFactory factory = new SimulationFactory();
        for (String str : factory.getEditCommands())
        {
            JButton button = new JButton(str);
            button.addActionListener(controller);
            addButton(button);
        }

        GridLayout layout = new GridLayout(jPanels.size(), 1);
        layout.preferredLayoutSize(this);
        layout.minimumLayoutSize(this);
        setLayout(layout);
        for (JPanel panel : jPanels) {
            add(panel);
        }
        
     }
	
    private void addInfo(JLabel label, JTextField field)
    {
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(field);
        jPanels.add(panel);
    }

    private void addButton(JButton button) {
        JPanel panel = new JPanel();
        panel.add(button);
        jPanels.add(panel);
    }
    
    @Override
    public void update(Observable o, Object arg) {
    	clock.setText(String.valueOf(simulation.getClock()));
  
    	repaint();

    }
  
}
