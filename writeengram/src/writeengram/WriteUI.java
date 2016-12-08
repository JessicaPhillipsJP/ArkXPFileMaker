package writeengram;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WriteUI {

	public WriteUI(){

	}

	public void createUI(){
		JFrame frame = new JFrame("Make Server Settings for Ark");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel xpPanel = new JPanel();
		xpPanel.setLayout(new BoxLayout(xpPanel, BoxLayout.X_AXIS));
		JPanel engPanel = new JPanel();
		engPanel.setLayout(new BoxLayout(engPanel, BoxLayout.X_AXIS));
		JPanel levelPanel = new JPanel();
		levelPanel.setLayout(new BoxLayout(levelPanel, BoxLayout.X_AXIS));
		JPanel buttonPanel = new JPanel();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

		JLabel playerXP = new JLabel();
		playerXP.setText("Choose Player or Player and Dino XP");
		JComboBox<String> playerCB = new JComboBox<String>();
		//label asking player or player and dinos
		//combo box for player or player and dinos
		JLabel engram = new JLabel();
		engram.setText("Override engrams?");
		JCheckBox engramCB = new JCheckBox();
		//label asking for engram override
		//checkbox for engrams 
		JLabel level = new JLabel();
		level.setText("Enter Level Cap");
		JTextField levelTF = new JTextField();
		//label for level to go to
		//text field asking for level to go to
		JButton ok = new JButton();
		ok.setText("OK");
		JButton cancel = new JButton();
		cancel.setText("Cancel");
		//ok button
		//cancel button
		xpPanel.add(playerXP);
		xpPanel.add(playerCB);
		engPanel.add(engram);
		engPanel.add(engramCB);
		levelPanel.add(level);
		levelPanel.add(levelTF);

		buttonPanel.add(ok);
		buttonPanel.add(cancel);

		mainPanel.add(xpPanel);
		mainPanel.add(engPanel);
		mainPanel.add(levelPanel);
		mainPanel.add(buttonPanel);
		frame.add(mainPanel);
		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args){
		WriteUI write = new WriteUI();
		write.createUI();
	}

}
