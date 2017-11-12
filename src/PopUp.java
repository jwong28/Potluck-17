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

//Pop-up menu that appears when the JButton in Main menu is clicked on  
@SuppressWarnings("serial")
public class PopUp extends JFrame 
{	
	//Constructor for the Pop-up menu
	PopUp(String input, Model model, int score, int column)
	{
		//Creates panels,labels, and buttons to put on the Pop-up
		JPanel panel = new JPanel(new FlowLayout());
		JPanel questionPanel = new JPanel(new GridBagLayout());
		JLabel question = new JLabel("<html>"+input+"</html>");
		JButton add = new JButton("Correct");
		JButton subtract = new JButton ("Wrong");
		Font font = new Font("Times New Roman",Font.BOLD,70);
		Adder adder = new Adder(model,score,column,this);
  		Subtracter subtracter = new Subtracter(model,score,column,this);
  		
  		//Configures the add button 
		add.setBackground(Color.BLUE);
		add.setOpaque(true);
		add.setPreferredSize(new Dimension(200,100));
		add.addActionListener(adder);
		
		//Configures the subtract button
		subtract.setBackground(Color.BLUE);
		subtract.setOpaque(true);
		subtract.setPreferredSize(new Dimension(200,100));
  		subtract.addActionListener(subtracter);
  		
  		//Sets the font and size of the question
		question.setFont(font);
		question.setPreferredSize(new Dimension(700,400));

		//Sets the size of the Pop-up menu
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
	}
}