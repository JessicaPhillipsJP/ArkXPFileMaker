package writeengram;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WriteUI {
	JFrame frame;
	
	JPanel xpPanel;
	JPanel buttons;
	JPanel engramPanel;
	JPanel lvlPanel;
	JPanel mainPanel;
	
	JLabel playerXP;
	JComboBox<String> playerCB;
	JLabel engram;
	JCheckBox engramCB;
	JLabel level;
	JTextField levelTF;
	
	JButton ok;
	JButton cancel;

	public WriteUI(){
		
	}

	public void createUI(){
		frame = new JFrame("Make Server Settings for Ark");
		
		playerXP = new JLabel("Choose Who to Add Level Cap To");
		playerXP.setLayout(new FlowLayout(FlowLayout.CENTER));
		playerCB = new JComboBox<String>();
		playerCB.setSize(15,30);
		engram = new JLabel("Add an Override to Engrams?");
		
		engramCB = new JCheckBox();
		
		level = new JLabel("Enter Level Cap");
		
		levelTF = new JTextField();

		ok = new JButton("OK");
		
		cancel = new JButton("Cancel");

		xpPanel = new JPanel();
		xpPanel.setLayout(new BoxLayout(xpPanel, BoxLayout.X_AXIS));
		engramPanel = new JPanel();
		engramPanel.setLayout(new BoxLayout(engramPanel, BoxLayout.X_AXIS));
		lvlPanel = new JPanel();
		lvlPanel.setLayout(new BoxLayout(lvlPanel, BoxLayout.X_AXIS));
		buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		xpPanel.add(playerXP);
		xpPanel.add(playerCB);
		engramPanel.add(engram);
		engramPanel.add(engramCB);
		lvlPanel.add(level);
		lvlPanel.add(levelTF);

		buttons.add(ok);
		buttons.add(cancel);
		
		mainPanel.add(xpPanel);
		mainPanel.add(engramPanel);
		mainPanel.add(lvlPanel);
		mainPanel.add(buttons);
		
		frame.add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
	}

	public static void main(String[] args){
		WriteUI write = new WriteUI();
		write.createUI();
	}

}
