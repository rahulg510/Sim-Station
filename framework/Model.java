package framework;

import java.util.*;
import java.io.*;

/**
 * Edit History
 *Code provide from lecture notes and hints
 */
public abstract class Model extends Observable implements Serializable {

	private String fileName;
	private boolean unsavedChanges;
	private static final long serialVersionUID = 1L;
	
	public Model(String fileName) {
		this.fileName = fileName;
		unsavedChanges = false;
	}
	
	public Model() { this(""); }
	
	public void copy(Model m) {
		fileName = m.getFileName();
		changed();
		unsavedChanges = false;
	}
	
	public void changed() {
		this.setUnsavedChanges(true);
		this.setChanged();
		this.notifyObservers();
	}
	public boolean hasUnsavedChanges() {
		return unsavedChanges;
	}
	public void setUnsavedChanges(boolean flag) {
		this.unsavedChanges = flag;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}

