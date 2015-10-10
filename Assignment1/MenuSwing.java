package Assignment1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MenuSwing extends JPanel {
	String output;
	public MenuSwing(){
		this.setLayout(new GridLayout(6,1));
		row1();
		row2();
		row3();
		row4();
		row5();
		row6();
	}
	public void row1(){
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(1,3));
		JLabel jl = new JLabel("Assignment");
		jp.add(new JLabel());
		jp.add(jl);
		jp.add(new JLabel());
		add(jp);
	}
	public void row2(){
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(1,4));
		jp.add(new JLabel("Topic"));
		jp.add(new JLabel("Group 1"));
		jp.add(new JLabel("Group 2"));
		jp.add(new JLabel("Group 3"));
		add(jp);
	}
	public void row3(){
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(1,4));
		jp.add(new JLabel("BFS/DFS"));
		add(jp);
		
		//working on column 1
		JButton column1A = new JButton();
		column1A.setText("336");
		column1A.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva336(new File("336.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);
			}
		});
		JButton column1B = new JButton();
		column1B.setText("10305");
		column1B.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva10305(new File("10305.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);		
			}
		});
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		temp.add(column1A);
		temp.add(column1B);
		jp.add(temp);
		
		
		//working on column 2
		JButton column2A = new JButton();
		column2A.setText("439");
		column2A.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva439(new File("439.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);			
			}
		});
		JButton column2B = new JButton();
		column2B.setText("572");
		column2B.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva572(new File("572.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);			
			}
		});
		temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		temp.add(column2A);
		temp.add(column2B);
		jp.add(temp);
		
		//working on column 3
		JButton column3A = new JButton();
		column3A.setText("532");
		column3A.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva532(new File("532.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);			
			}
		});
		JButton column3B = new JButton();
		column3B.setText("11518");
		column3B.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva11518(new File("11518.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);			
			}
		});
		temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		temp.add(column3A);
		temp.add(column3B);
		jp.add(temp);
		
	}
	public void row4(){
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(1,4));
		jp.add(new JLabel("Arti ptr."));
		add(jp);
		
		
		//working on column 1
		JButton column1A = new JButton();
		column1A.setText("315");
		column1A.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva315(new File("315.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);		
			}
		});
		JButton column1B = new JButton();
		column1B.setText("10199");
		column1B.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva10199(new File("10199.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);		
			}
		});
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		temp.add(column1A);
		temp.add(column1B);
		jp.add(temp);
		
		
		//working on column 2
		JButton column2A = new JButton();
		column2A.setText("610");
		column2A.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva610(new File("610.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);			
			}
		});
		JButton column2B = new JButton();
		column2B.setText("796");
		column2B.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva796(new File("796.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);		
			}
		});
		temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		temp.add(column2A);
		temp.add(column2B);
		jp.add(temp);
		
		//working on column 3
		jp.add(new JLabel());
	}
	public void row5(){
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(1,4));
		jp.add(new JLabel("dijkstra/Bellman-Ford"));
		add(jp);
		
		
		//working on column 1
		JButton column1A = new JButton();
		column1A.setText("721");
		column1A.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva721(new File("721.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);		
			}
		});
		JButton column1B = new JButton();
		column1B.setText("423");
		column1B.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva423(new File("423.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);			
			}
		});
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		temp.add(column1A);
		temp.add(column1B);
		jp.add(temp);
		
		
		//working on column 2
		JButton column2A = new JButton();
		column2A.setText("10278");
		column2A.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva10278(new File("10278.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);			
			}
		});
		JButton column2B = new JButton();
		column2B.setText("11280");
		column2B.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva11280(new File("11280.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);			
			}
		});
		temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		temp.add(column2A);
		temp.add(column2B);
		jp.add(temp);
		
		//working on column 3
		JButton column3A = new JButton();
		column3A.setText("11721");
		column3A.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva11721(new File("11721.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);			
			}
		});
		JButton column3B = new JButton();
		column3B.setText("12047");
		column3B.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva12047(new File("12047.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);			
			}
		});
		temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		temp.add(column3A);
		temp.add(column3B);
		jp.add(temp);
	}
	public void row6(){
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(1,4));
		jp.add(new JLabel("SCC"));
		add(jp);
		
		
		//working on column 1
		JButton column1A = new JButton();
		column1A.setText("11709");
		column1A.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva11709(new File("11709.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);			
			}
		});
		
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		temp.add(column1A);
		jp.add(temp);
		
		
		//working on column 2
		
		temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		temp.add(new JLabel());
		temp.add(new JLabel());
		jp.add(temp);
		
		//working on column 3
		JButton column3A = new JButton();
		column3A.setText("11504");
		column3A.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva11504(new File("11504.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);		
			}
		});
		JButton column3B = new JButton();
		column3B.setText("11770");
		column3B.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				output = (new uva11770(new File("11770.txt"))).returnOutput();
				AssignmentMenu.jt.setText(output);
				AssignmentMenu.jt.setVisible(true);		
			}
		});
		temp = new JPanel();
		temp.setLayout(new GridLayout(1,2));
		temp.add(column3A);
		temp.add(column3B);
		jp.add(temp);
	}
	public String returnOutput(){
		return output;
	}
}
