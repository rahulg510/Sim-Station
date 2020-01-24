package framework;

import java.awt.event.*;
import java.io.*;
import java.util.Random;

import javax.swing.*;

import aWorld.World;
import business.Simulation;

public class Utilities {

	public static boolean isExit(Model model) {
		if(model.hasUnsavedChanges() && ! Utilities.confirm("current model has unsaved changes, continue?")){
			return false;
		}
		return true;
	}
	
	// enables stack traces and diagnostics
	public static Boolean DEBUG = true;
	public static Random gen = new Random();

	// asks user a yes/no question
	public static boolean confirm(String query) {
		int result = JOptionPane.showConfirmDialog(null,
				query, "choose one", JOptionPane.YES_NO_OPTION);
		return result == 0;
	}

	// asks user for info
	public static String ask(String query) {
		return JOptionPane.showInputDialog(null, query);
	}

	// tells user some info
	public static void inform(String info) {
		JOptionPane.showMessageDialog(null,info);
	}

	// tells user lots of info
	public static void inform(String[] items) {
		String infoString = "";
		for(int i = 0; i < items.length; i++) {
			infoString = infoString + "\n" + items[i];
		}
		inform(infoString);
	}

	// tells user about an error
	public static void error(String gripe) {
		JOptionPane.showMessageDialog(null,
				gripe,
				"OOPS!",
				JOptionPane.ERROR_MESSAGE);
	}

	// tells user about an exception
	public static void error(Exception gripe) {
		if (DEBUG) gripe.printStackTrace();
		JOptionPane.showMessageDialog(null,
				gripe.getMessage(),
				"Information",
				JOptionPane.ERROR_MESSAGE);
	}

	// asks user save changes?
	public static void saveChanges(Model model) {
		if (model.hasUnsavedChanges() &&
		      Utilities.confirm("current model has unsaved changes, continue?"))
			Utilities.save(model, false);
	}

	// asks user for a file name
	public static String getFileName(String fName, Boolean open) {
		JFileChooser chooser = new JFileChooser();
		String result = null;
		if (fName != null) {
		// open chooser in directory of fName
		chooser.setCurrentDirectory(new File(fName));
		}
		if (open) {
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
		result= chooser.getSelectedFile().getPath();
		}
		} else {
		int returnVal = chooser.showSaveDialog(null);
		}
		return result;
		}

	// save model
	public static void save(Model model, Boolean saveAs) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		if(saveAs) {  //saveAs 
			if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				model.setFileName(file.getPath());
				writeFile(model);
			}
		}else {  // save or new
			String fName = model.getFileName();
			if (fName == null || "".equals(fName)) { //�½�
				if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					
					File file = chooser.getSelectedFile();
					model.setFileName(file.getPath());
					writeFile(model);
				}
			}else {
				writeFile(model);
			}
		}
	}

	// open model
	public static Model open(Model model) {
		if(model.hasUnsavedChanges() && !Utilities.confirm("current model has unsaved changes, continue?")) {
			return model;
		}
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//		chooser.setFileFilter(fileFilter);
		int option = chooser.showOpenDialog(null);
		if(option == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			return readFile(file);
		}
		return model;
		
	}

	// a simple menu maker
	public static JMenu makeMenu(String name, String[] items, ActionListener handler) {
		JMenu result = new JMenu(name);
		for(int i = 0; i < items.length; i++) {
			JMenuItem item = new JMenuItem(items[i]);
			item.addActionListener(handler);
			result.add(item);
		}
		return result;
	}

public static Model newSimulation(Model model) {
		
		if (model.hasUnsavedChanges() && !Utilities.confirm("current model has unsaved changes, continue?")) {
			return model;
		}
		
			Simulation newSimulation = new World("");

		return newSimulation;
			
	}

private static void writeFile(Model model) {
	try {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(model.getFileName()));
		oos.writeObject(model);
		oos.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
private static Model readFile(File file) {
	World simulation = null;
	try {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		simulation = (World)ois.readObject();
		ois.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return simulation;
}

	
	// etc.
}