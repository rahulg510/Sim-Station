package aWorld;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.geom.Ellipse2D;

import business.*;
import framework.*;

public class SimulationView extends View{

private static final long serialVersionUID = 6L;
	public SimulationView(Simulation simulation) { 
		super(simulation);
		simulation.addObserver(this);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if(model != null && model instanceof World) {
			for(Agent a : ((World)model).getAgents())
			{
				int x = a.getxCoor();
				int y = a.getyCoor();
				Graphics2D g2 = (Graphics2D) g;
				Ellipse2D circle = new Ellipse2D.Double(x,y,4,4);
				g2.setColor(Color.red);
				g2.fill(circle);
				g2.draw(circle);
				
			
			}
			
		}
	}

	public void update(Observable subject, Object msg) 
	{
		
		repaint();
	}

}

