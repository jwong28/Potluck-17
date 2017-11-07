import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PopUp extends JFrame 
{
	JLabel question;
	JButton add;
	JButton subtract;
	Model _model;
	
	PopUp(String input, Model model)
	{
		JPanel panel = new JPanel(new FlowLayout());
		_model = model;
		question = new JLabel();
		add = new JButton("Correct");
		add.setPreferredSize(new Dimension(400,400));
		subtract = new JButton ("Wrong");
		subtract.setPreferredSize(new Dimension(400,400));
		//Setting the text of label to the question inputted
		Font font = new Font("Times New Roman",Font.BOLD,24);
		question.setFont(font);
		question.setText(input);
		this.setSize(1300,500);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  		this.setLocationRelativeTo(null);
  		//Add question and buttons to pop up
  		panel.add(add);
  		panel.add(subtract);
  		this.add(question,BorderLayout.PAGE_START);
  		this.add(panel,BorderLayout.CENTER);
  		this.setVisible(true);
	}
	
//	public void show(){
//		System.out.println(question.getText());
//	}
}
