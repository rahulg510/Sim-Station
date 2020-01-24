package framework;

import java.awt.event.ActionListener;

/**
 * Edit History
 * Code provide from lecture notes and hints
 */
public interface AppFactory {
    public Model makeModel();
    public AppPanel makePanel(Model model, ActionListener listener);
    public String[] getEditCommands();
    public String[] getFileCommands();
    public Command makeEditCommands(Model model, String type);
    public String getTitle();
    public String[] getHelp();
    public String about();
}