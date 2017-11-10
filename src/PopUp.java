import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
		_model = model;
		question = new JLabel();
		add = new JButton("Correct");
		add.setBackground(Color.BLUE);
		add.setOpaque(true);
		add.setPreferredSize(new Dimension(400,400));
		subtract = new JButton ("Wrong");
		subtract.setBackground(Color.BLUE);
		subtract.setOpaque(true);
		subtract.setPreferredSize(new Dimension(400,400));
		//Setting the text of label to the question inputed
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
  		//Gotta finish team number for later
  		Adder adder = new Adder(_model,0,_score);
	}
	
//	public void show(){
//		System.out.println(question.getText());
//	}
}
