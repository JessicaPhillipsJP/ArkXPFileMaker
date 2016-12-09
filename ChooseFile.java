package uidesign;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

public class ChooseFile {
	JFrame frame;
	
	public ChooseFile(JFrame frame){

	}
	public void chooseFile(){
		JFileChooser fc = new JFileChooser("Save Text File");
		fc.addChoosableFileFilter(new FileFilter() {
			public String getDescription() {
				return "Text Files (*.txt)";
			}
			public boolean accept(File f){
				if (f.isDirectory()) {
					return true;
				}
				else{
					String filename = f.getName().toLowerCase();
					return filename.endsWith(".txt");
				}
			}
		});
		fc.setAcceptAllFileFilterUsed(false);
		fc.setSelectedFile(new File("GameSettings.txt"));
		if(fc.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION){
			WriteOut wrout = new WriteOut(new File(fc.getSelectedFile().getAbsolutePath()));
			try {
				wrout.printIt();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
