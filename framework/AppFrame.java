package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;


public class AppFrame extends JFrame implements ActionListener, Observer{
	
  protected AppFactory factory;
  private Model model;
  private AppPanel panel;
 
  public AppFrame(AppFactory factory) {
     this.factory = factory;
     model = factory.makeModel();
     setJMenuBar(createMenuBar());
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setTitle(factory.getTitle()); 
  }
 
  public Model getModel()
  {
	  return model;
  }
  public void display() { this.setVisible(true); }
 
  public void setModel(Model model) {
     // used by open and new, details below
	  this.model = model;
	  model.changed();
  }
 
  protected JMenuBar createMenuBar() {
     JMenuBar bar = new JMenuBar();
     
     JMenu fileMenu = new JMenu();
     JMenu helpMenu = new JMenu();
     JMenu editMenu = new JMenu();
     
     bar.add(fileMenu);
     bar.add(helpMenu);
     bar.add(editMenu);
     
     Utilities.makeMenu("File", factory.getEditCommands(), this);
     Utilities.makeMenu("Edit", factory.getEditCommands(), this);
     Utilities.makeMenu("Help", factory.getEditCommands(), this);
     // now add menus to bar
         
     return bar;
  }

  //Rewrite this to work for Maze Challenge, not brickCAD
  public void actionPerformed(ActionEvent ae) {
     String cmmd = ae.getActionCommand();
    
     if (cmmd == "Save") {
        Utilities.save(model, false);
     } else if (cmmd == "SaveAs") {
        Utilities.save(model, true);
     } else if (cmmd == "Open") {
        Model newModel = Utilities.open(model);
        setModel(newModel);
     } else if (cmmd == "New") {
        Utilities.saveChanges(model);
        setModel(factory.makeModel());
        // needed b/c setModel sets to true:
        model.setUnsavedChanges(false);
     } else if (cmmd == "Quit") {
        Utilities.saveChanges(model);
        System.exit(1);
     } else if (cmmd == "About") {
        Utilities.inform(factory.about());
     } else if (cmmd == "Help") {
        Utilities.inform(factory.getHelp());
     } else {
        Command command = factory.makeEditCommands(model, cmmd);
        CommandProcessor.execute(command);
     }
  }

@Override
public void update(Observable o, Object arg) {
	repaint();
	
}
  
} 