package uidesign;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteOut {
	
	private int level;
	private PrintWriter writer;
	private boolean playerDino = false;
	private File file;
	private boolean comboBox;
	private boolean checkBox;
	
	public WriteOut(File file, boolean comboBox, boolean checkBox, int level) {
		this.file=file;
		this.level=level;
		this.comboBox=comboBox;
		this.checkBox=checkBox;
	}

	public void printIt() throws FileNotFoundException {
		writer = new PrintWriter(file);

		if(comboBox == true){
			printXP();
		}
		else{
			printXP();
			printXP();
		}
		if(checkBox == true){
			for(int i = 0; i<level+1; i++){
				writer.write("OverridePlayerLevelEngramPoints="+ i*10 +"\n");
			}
		}
		writer.close();
	}

	public void printXP(){
		writer.write("[/script/shootergame.shootergamemode]");
		writer.write("LevelExperienceRampOverrides=(");
		for(int i = 0; i<level+1; i++){
			if(i == 0){
				writer.write("ExperiencePointsForLevel["+i+"]="+2+",");
			}
			else if( i <level){
				writer.write("ExperiencePointsForLevel["+i+"]="+i*5+",");
			}
			else{
				writer.write("ExperiencePointsForLevel["+i+"]="+i*5+")");
			}

		}
	}

}
