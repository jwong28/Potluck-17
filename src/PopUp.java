import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PopUp extends JFrame 
{
	private JLabel question;
	private JButton add;
	private JButton subtract;
	private Model _model;
	private int _score;
	
	PopUp(String input, Model model, int score)
	{
		JPanel panel = new JPanel(new FlowLayout());
		JPanel questionPanel = new JPanel(new GridBagLayout());
		_model = model;
		question = new JLabel();
		add = new JButton("Correct");
		add.setBackground(Color.BLUE);
		add.setOpaque(true);
		add.setPreferredSize(new Dimension(200,100));
		subtract = new JButton ("Wrong");
		subtract.setBackground(Color.BLUE);
		subtract.setOpaque(true);
		subtract.setPreferredSize(new Dimension(200,100));
		//Setting the text of label to the question inputed
		Font font = new Font("Times New Roman",Font.BOLD,70);
		question.setFont(font);
		question.setText("<html>"+input+"</html>");
		question.setPreferredSize(new Dimension(700,400));
		this.setSize(1300,800);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  		this.setLocationRelativeTo(null);
  		//Add question and buttons to pop up
  		panel.add(add);
  		panel.add(subtract);
  		questionPanel.add(question);
  		this.add(questionPanel,BorderLayout.CENTER);
  		this.add(panel,BorderLayout.PAGE_END);
  		this.setVisible(true);
  		//Gotta finish team number for later
  		Adder adder = new Adder(_model,_score,this);
  		add.addActionListener(adder);
  		Subtracter subtracter = new Subtracter(_model,_score,this);
  		subtract.addActionListener(subtracter);
	}
}