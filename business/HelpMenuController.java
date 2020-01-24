package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import presentation.SimulationFactory;

/**
 * 11/12: RK: Implemented HelpMenu as its own class
 */

public class HelpMenuController implements ActionListener {
    private JFrame parentFrame;
    private SimulationFactory factory;

    public HelpMenuController(JFrame parent) {
        this.parentFrame = parent;
        factory = new SimulationFactory();
    }

    private void showInformationDialog(String str) {
        JOptionPane.showMessageDialog(parentFrame, str, "information", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        if (cmmd.equals("About")) {
            showInformationDialog(factory.about());
        } else if (cmmd.equals("Contents")) {
            showInformationDialog(factory.contents());
        }
    }
}

