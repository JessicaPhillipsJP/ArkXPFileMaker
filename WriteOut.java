package uidesign;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteOut {

	private int level;
	private FileWriter writer;
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

	public void printIt() throws IOException {
		writer = new FileWriter(file,false);

		if(comboBox == true){
			printXP();
		}
		else{
			printXP();
			printXP2();
		}
		if(checkBox == true){
			for(int i = 0; i<level+1; i++){
				writer.write("OverridePlayerLevelEngramPoints="+ i*10 +"\r\n");
			}
		}
		writer.close();
	}

	public void printXP(){
		try {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public void printXP2(){
		try {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
