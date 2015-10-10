package Assignment1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class AssignmentMenu extends JFrame {
	String output;
	static JTextArea jt = new JTextArea();
	public AssignmentMenu(){
		setLayout(new BorderLayout());
		MenuSwing jp = new MenuSwing();
		add(jp,BorderLayout.NORTH);
		//output = jp.returnOutput();
		row7();
	}
	public void row7(){
		//jt.setText(output);
		
		add(jt,BorderLayout.CENTER);
		
	}
}
