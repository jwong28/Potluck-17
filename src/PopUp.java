import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

//Pop-up menu that appears when the JButton in Main menu is clicked on  
public class PopUp implements ActionListener /*, KeyListener*/
{	
	JLabel _teamName;
	Model _model;
	JFrame _frame;
	int score;
	int column;
	Questions question;
	JButton questionButton;
	JButton add;
	JButton subtract;
	Adder adder;
	//Constructor for the Pop-up menu
	PopUp(Questions question, Model model, int score, int column)
	{
		//MenuBar and choices
		JMenuBar MenuBar = new JMenuBar();
		JMenu FileMenu = new JMenu("File");
		JMenuItem BackItem = new JMenuItem("Go Back");
		
		//Creates panels,labels, and buttons to put on the Pop-up
		_frame = new JFrame("A.S.I.A Jeopardy");
		JPanel panel = new JPanel(new FlowLayout());
		JPanel questionPanel = new JPanel(new GridBagLayout());
		
		
		questionButton = new JButton("<html>"+question.getQuestion()+"</html>");
		add = new JButton("Correct");
		subtract = new JButton ("Wrong");
		Font font = new Font("Arial",Font.BOLD,70);
		
		this._model = model;
		this.score = score;
		this.column = column;
		
		
		adder = new Adder(model,score,column,this);
  		Subtracter subtracter = new Subtracter(model,score,column,this);
  		Answer answer = new Answer(question.getAnswer());

  		//Sets the undo to control + z to go to previous team's turn
  		BackItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,Event.CTRL_MASK));
		BackItem.addActionListener(this);
  		
  		//Sets the Team Name
  		_teamName = new JLabel("Team "+model.getTeams().get(0).getName(),JLabel.CENTER);
  		_teamName.setPreferredSize(new Dimension(600,100));
  		_teamName.setFont(new Font("Arial",Font.BOLD,50));
  		_teamName.setForeground(Color.WHITE);
  		_teamName.setBackground(Color.BLUE);
  		
  		//Sets the size of the Pop-up menu
  		_frame.setSize(1300,850);
  		_frame.setLayout(new BorderLayout());
 		_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	_frame.setLocationRelativeTo(null);
    	
  		//Configures the add button 
		add.setBackground(Color.BLUE);
		add.setForeground(Color.WHITE);
		add.setOpaque(true);
		add.setPreferredSize(new Dimension(200,100));
		add.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		add.setFont(new Font("Arial",Font.BOLD,32));
		
		//Configures the subtract button
		subtract.setBackground(Color.BLUE);
		subtract.setForeground(Color.WHITE);
		subtract.setOpaque(true);
		subtract.setPreferredSize(new Dimension(200,100));
//  		subtract.addActionListener(subtracter);
		subtract.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		subtract.setFont(new Font("Arial",Font.BOLD,32));
  		
  		//Sets the font and size of the question
//		questionButton.addActionListener(answer);
		questionButton.setFont(font);
		questionButton.setOpaque(true);
		questionButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		questionButton.setPreferredSize(new Dimension(1200,700));
		questionButton.setForeground(Color.WHITE);
		questionButton.setBackground(Color.BLUE);
		
		//Sets the color of the question panel background
		questionPanel.setOpaque(true);
		questionPanel.setBackground(Color.BLUE);
  		
  		panel.setBackground(Color.BLUE);
  		panel.setPreferredSize(new Dimension(1300,100));
  		
  		//Add question and buttons to pop up
  		FileMenu.add(BackItem);
  		MenuBar.add(FileMenu);
  		panel.add(_teamName);
  		panel.add(add);
  		panel.add(subtract);
  		questionPanel.add(questionButton);
  		_frame.add(MenuBar);
  		_frame.add(questionPanel,BorderLayout.CENTER);
  		_frame.add(panel,BorderLayout.PAGE_END);
  		_frame.setJMenuBar(MenuBar);
  		_frame.setVisible(true);
  		Action addAction = new AbstractAction()
  		{
  			@Override
  			public void actionPerformed(ActionEvent e)
			   {
				  adder.actionPerformed(e); 
			   }
  		};
  		add.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
  		add.getActionMap().put("Enter", addAction);
  		add.addActionListener(addAction);

  		Action subAction = new AbstractAction()
  		{
  			@Override
  			public void actionPerformed(ActionEvent e)
			   {
				  subtracter.actionPerformed(e); 
			   }
  		};
  		subtract.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "Backspace");
  		subtract.getActionMap().put("Backspace", subAction);
  		subtract.addActionListener(subAction);
  		
  		Action questionAction = new AbstractAction()
  		{
  			@Override
  			public void actionPerformed(ActionEvent e)
			   {
				  answer.actionPerformed(e); 
			   }
  		};
  		questionButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "Space");
  		questionButton.getActionMap().put("Space", questionAction);
  		questionButton.addActionListener(questionAction);
	}
	
	//Updates the popup visually with the new team's name
	public void update(int index){
		_teamName.setText("Team "+ _model.getTeams().get(index).getName());
		_frame.revalidate();
		_frame.repaint();
	}
	
	//Returns the JFrame
	public JFrame getFrame(){
		return _frame;
	}
	
	//Goes back one turn
	public void undo(){
		_model.previousTurn();
		update(_model.getTurn());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
			case "Go Back":
				undo();
				break;
		}
	}

	
	
}