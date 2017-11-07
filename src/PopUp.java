import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PopUp extends JFrame 
{
	JLabel question = new JLabel();
	JButton add = new JButton("Correct");
	JButton subtract = new JButton ("Wrong");
	
	PopUp(String input)
	{
		//Setting the text of label to the question inputted
		question.setText(input);
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  		this.setLocationRelativeTo(null);
  		
  		//Add question and buttons to pop up
  		this.add(question);
  		this.add(add);
  		this.add(subtract);
  		
  		this.setVisible(true);
	}
	
//	public void show(){
//		System.out.println(question.getText());
//	}
}
