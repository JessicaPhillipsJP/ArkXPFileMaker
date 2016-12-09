package uidesign;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class WriteOut {
	
	private int getLevelCap = 0;
	PrintWriter writer;

	private boolean playerDino = false;
	TestUI ui;
	File file;
	
	public WriteOut(File file) {
		this.file=file;
	}

	public void printIt() throws FileNotFoundException {
		writer = new PrintWriter(file);
		getLevelCap = ui.getTextField();
		if(checkComboBox() == true){
			printXP();
		}
		else{
			printXP();
			printXP();
		}
		if(ui.getCheckBox() == true)
			for(int i = 0; i<getLevelCap+1; i++){
				writer.write("OverridePlayerLevelEngramPoints="+ i*10);
			}
	}


	public boolean checkComboBox(){
		if(ui.getComboBox().toString().trim().equals("Players Only")){
			playerDino = true;
		}
		return playerDino;
	}

	public void printXP(){
		writer.write("[/script/shootergame.shootergamemode]");
		writer.write("LevelExperienceRampOverrides=(");
		for(int i = 0; i<getLevelCap+1; i++){
			if(i == 0){
				writer.write("ExperiencePointsForLevel["+i+"]="+2+",");
			}
			else if( i <getLevelCap){
				writer.write("ExperiencePointsForLevel["+i+"]="+i*5+",");
			}
			else{
				writer.write("ExperiencePointsForLevel["+i+"]="+i*5+")");
			}

		}
	}

}
