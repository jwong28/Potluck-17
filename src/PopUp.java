import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
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
		JLabel question = new JLabel("<html>"+input+"</html>",JLabel.CENTER);
		JButton add = new JButton("Correct");
		JButton subtract = new JButton ("Wrong");
		Font font = new Font("Arial",Font.BOLD,70);
		Adder adder = new Adder(model,score,column,this);
  		Subtracter subtracter = new Subtracter(model,score,column,this);
  		
  		//Sets the size of the Pop-up menu
  		this.setSize(1300,850);
  		this.setLayout(new BorderLayout());
 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setLocationRelativeTo(null);
    	
  		//Configures the add button 
		add.setBackground(Color.BLUE);
		add.setForeground(Color.WHITE);
		add.setOpaque(true);
		add.setPreferredSize(new Dimension(200,100));
		add.addActionListener(adder);
		add.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		add.setFont(new Font("Arial",Font.BOLD,32));
		
		//Configures the subtract button
		subtract.setBackground(Color.BLUE);
		subtract.setForeground(Color.WHITE);
		subtract.setOpaque(true);
		subtract.setPreferredSize(new Dimension(200,100));
  		subtract.addActionListener(subtracter);
		subtract.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		subtract.setFont(new Font("Arial",Font.BOLD,32));
  		
  		//Sets the font and size of the question
		question.setFont(font);
		question.setOpaque(true);
		question.setPreferredSize(new Dimension(1200,700));
		question.setForeground(Color.WHITE);
		question.setBackground(Color.BLUE);
		
		//Sets the color of the question panel background
		questionPanel.setOpaque(true);
		questionPanel.setBackground(Color.BLUE);
  		
  		panel.setBackground(Color.BLUE);
  		panel.setPreferredSize(new Dimension(1300,100));
  		
  		//Add question and buttons to pop up
  		panel.add(add);
  		panel.add(subtract);
  		questionPanel.add(question);
  		this.add(questionPanel,BorderLayout.CENTER);
  		this.add(panel,BorderLayout.PAGE_END);
  		
  		this.setVisible(true);
	}
}