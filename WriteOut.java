package uidesign;

import java.awt.Component;

import javax.swing.JOptionPane;

public class WriteOut {

	private String comboBox;
	private boolean checkBox;
	private String textField;
	private int getLevelCap = 0;
	Component frame;

	private boolean playerDino = false;

	public WriteOut(String comboBox, boolean checkBox, String textField, Component frame) {
		this.comboBox=comboBox;
		this.checkBox=checkBox;
		this.textField=textField;
		this.frame=frame;
	}

	public void printIt() {
		getLevelCap = Integer.parseInt(textField);
		if(checkComboBox() == true){
			printXP();
		}
		else{
			printXP();
			printXP();
		}
		if(checkBox == true)
			for(int i = 0; i<getLevelCap+1; i++){
				System.out.println("OverridePlayerLevelEngramPoints="+ i*10);
			}
	}


	public boolean checkComboBox(){
		if(comboBox.toString().trim().equals("Players Only")){
			playerDino = true;
		}
		return playerDino;
	}

	public void printXP(){
		System.out.println("[/script/shootergame.shootergamemode]");
		System.out.print("LevelExperienceRampOverrides=(");
		for(int i = 0; i<getLevelCap+1; i++){
			if(i == 0){
				System.out.print("ExperiencePointsForLevel["+i+"]="+2+",");
			}
			else if( i <getLevelCap){
				System.out.print("ExperiencePointsForLevel["+i+"]="+i*5+",");
			}
			else{
				System.out.print("ExperiencePointsForLevel["+i+"]="+i*5+")");
			}

		}
	}

}
