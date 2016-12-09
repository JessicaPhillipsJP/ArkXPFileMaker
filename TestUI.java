package uidesign;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestUI {
	JFrame frame;
	JPanel buttons;
	JPanel mainPanel;
	JPanel labelFix;
	JPanel checkFix;

	JLabel playerXP;
	JComboBox<String> playerCB;
	JLabel engram;
	JCheckBox engramCB;
	JLabel level;
	JTextField levelTF;

	JButton ok;
	JButton cancel;

	boolean okSelected = false;
	private String comboBox = "";
	private boolean checkBox = false ;
	private String textField;


	public TestUI(){

	}

	public void createUI(){
		frame = new JFrame("Make Server Settings for Ark");

		playerXP = new JLabel("Choose Who to Add Level Cap To");
		playerXP.setMaximumSize(new Dimension(200, 15));
		playerCB = new JComboBox<String>(new String[] {"Players Only", "Players and Dinos"});

		engram = new JLabel("Add an Override to Engrams?");
		engramCB = new JCheckBox();

		level = new JLabel("Enter Level Cap");
		levelTF = new JTextField();
		levelTF.setText("300");
		levelTF.setPreferredSize(new Dimension(200, 10));

		ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				okSelected = true;
				onClose();
			}
		});
		cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				okSelected = false;
				onClose();
			}
		});

		JPanel e2 = new JPanel();
		JPanel e3 = new JPanel();
		JPanel e5 = new JPanel();
		JPanel e6 = new JPanel();
		JPanel e7 = new JPanel();
		JPanel e8 = new JPanel();
		JPanel e9 = new JPanel();
		JPanel e10 = new JPanel();

		buttons = new JPanel();
		mainPanel = new JPanel();
		labelFix = new JPanel();
		checkFix = new JPanel();

		buttons.setLayout(new GridLayout(1,4,40,10));
		mainPanel.setLayout(new BorderLayout());
		labelFix.setLayout(new GridLayout(6,1, 10, 10));
		checkFix.setLayout(new GridLayout(6,1, 10, 10));

		labelFix.add(playerXP);
		labelFix.add(e2);
		labelFix.add(engram);
		labelFix.add(e3);
		labelFix.add(level);

		checkFix.add(playerCB);
		checkFix.add(e5);
		checkFix.add(engramCB);
		checkFix.add(e6);
		checkFix.add(levelTF);

		buttons.add(e7);
		buttons.add(ok);
		buttons.add(cancel);
		buttons.add(e8);

		mainPanel.add(labelFix, BorderLayout.WEST);
		mainPanel.add(checkFix, BorderLayout.EAST);
		mainPanel.add(buttons, BorderLayout.PAGE_END);

		JPanel fix = new JPanel();
		fix.setLayout(new BorderLayout());
		fix.add(e9, BorderLayout.WEST);
		fix.add(mainPanel, BorderLayout.CENTER);
		fix.add(e10, BorderLayout.EAST);

		frame.add(fix);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,250);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	private void onClose(){
		if(okSelected == true){
			setComboBox();
			setCheckBox();
			setTextField();
			WriteOut writeit = new WriteOut(comboBox, checkBox, textField, frame);
			writeit.printIt();
		}
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
	
	private void setComboBox(){
		comboBox = playerCB.getSelectedItem().toString();
	}
	
	private void setCheckBox(){
		checkBox = engramCB.isSelected();
	}
	
	private void setTextField(){
		textField = levelTF.getText();
	}

	public static void main(String[] args){
		TestUI write = new TestUI();
		write.createUI();
	}
}