	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension; 
	import java.awt.Event;
	import java.awt.FlowLayout;
	import java.awt.Font;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
	import java.util.Scanner;

	import javax.swing.BorderFactory;
	import javax.swing.BoxLayout;
	import javax.swing.JButton;
	import javax.swing.JFileChooser;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JTextPane;
	import javax.swing.KeyStroke;
	import javax.swing.border.Border;

	public class MainMenu implements ActionListener,Observer{
		
		JFileChooser jfc;
		private JButton[][] _questions; 
		private JPanel _boardPanel,_teamPanel;
		private JFrame jfrm;
		private Model _model;
		private static int teamNumber = 0;
		URL url = MainMenu.class.getResource("input.txt");
		
		public MainMenu(){
		//Back-end model where all the calculations are done
		_model = new Model();
		//Makes an observer for model which calls the update method every time turns is reset in the model 
		_model.setObserver(this);
		//Creates a 5x5 array of JButtons for the questions
		_questions = new JButton[5][5];
		// Create a frame
	    jfrm = new JFrame("A.S.I.A Jeopardy");
	    //FIle chooser
	    jfc = new JFileChooser();
	    //Set to exit
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Size of frame
	    jfrm.setSize(1440, 1080);
	    jfrm.setLocationRelativeTo(null);
	    //Sets layout to allow for adding panels on the top,bottom,left,right, and center
	    jfrm.setLayout(new BorderLayout());
	    
		//MenuBar and choices
		JMenuBar menuBar = new JMenuBar();
	    JMenu FileMenu = new JMenu("File");
	    JMenu Help = new JMenu("Help");
	    JMenuItem HelpItem =new JMenuItem("About");
	    JMenuItem QuitItem = new JMenuItem("Quit");

	    //Adding File and Help    
	    menuBar.add(FileMenu);
	    //Alt+F: File
	    FileMenu.setMnemonic(KeyEvent.VK_F);
	    menuBar.add(Help);
	    //Alt+H: Help
	    Help.setMnemonic(KeyEvent.VK_H);
	    jfrm.add(menuBar);
	    jfrm.setJMenuBar(menuBar);
	   
	    //Setting hotkeys to the items
	    FileMenu.add(QuitItem);
	    QuitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,Event.CTRL_MASK));
	    Help.add(HelpItem);
	    HelpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,Event.CTRL_MASK));
	    
	    //Calling Action Listener
	    QuitItem.addActionListener(this);
	    HelpItem.addActionListener(this);
	    try
		{
			File f = new File(url.toURI());
			Scanner data = new Scanner(f);
			createAndPopulate(data);
			data.close();
		}
		catch(Exception e){}
	    
	    // Display the frame
	    jfrm.setVisible(true);
	    
	    addTeam();
	    
	 }
	
	//About action listener
	protected void AboutEvent()
	{	
		JTextPane panel = new JTextPane();
		panel.setPreferredSize(new Dimension(300,150));
		panel.setText( "This is for A.S.I.A's potluck event.");
		panel.setEditable(false);
		JOptionPane.showMessageDialog(null, panel,"About this application",JOptionPane.INFORMATION_MESSAGE);	
	}
	
	//Happens after file is selected
	protected void createAndPopulate(Scanner data)
	{
		//Using JPanel and grid layout to create the game frame
		_boardPanel = new JPanel();
		_boardPanel.setLayout(new GridLayout(6,5));
		_boardPanel.setBackground(Color.BLUE);
		Border line = BorderFactory.createLineBorder(Color.BLACK, 4);
		//Category placement
		for(int category=0;category<5;category++)
		{ 
			JLabel temp = new JLabel(data.nextLine(),JLabel.CENTER);
			temp.setOpaque(true);
			temp.setForeground(Color.WHITE);
			temp.setBackground(Color.BLUE);
			temp.setBorder(line);
			temp.setFont(new Font("Arial",Font.BOLD,32));
			_boardPanel.add(temp);
		}
		//Placing row by column placement
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				//Point value text for button
				JButton temp = new JButton("$"+(i+1)+"00");
				temp.setOpaque(true);
				temp.setBackground(Color.BLUE);
				temp.setForeground(Color.YELLOW);
				temp.setBorder(line);
				temp.setFont(new Font("Arial",Font.BOLD,32));
				_questions[i][j] = temp;
				//Getting question from the file and adding it into Questions
				_model.getQuestions().add(new Questions(data.nextLine(),data.nextLine()));
				_boardPanel.add(_questions[i][j]);
				//Setting name of button equal to value for easier calling
				_questions[i][j].setName(Integer.toString(5*i+j));
				//Adding action listener for the buttons
				_questions[i][j].addActionListener(new PopupHandler(
				_model.getQuestions().get((i*5)+j),_model,i,j));	
			}
		}
		//adds the 5x5 board to the center of the frame
		jfrm.add(_boardPanel,BorderLayout.CENTER);
		//Makes a team panel to store the team names and score
		_teamPanel = new JPanel();
		//Sets the layout so that when teams are added, they are centered right away
		_teamPanel.setLayout(new GridBagLayout());
		//adds the teams to the bottom of the jfrm
		_teamPanel.setBackground(Color.BLUE);
		//Sets the prefered size of the team panel
		_teamPanel.setPreferredSize(new Dimension(jfrm.getWidth(),100));
		jfrm.add(_teamPanel,BorderLayout.PAGE_END);
		
		//updates visually the frame
		jfrm.revalidate();
		jfrm.repaint();
	}
	
	//Adds teams to the _teamPanel
	protected void addTeam(){
		try{
			String input = JOptionPane.showInputDialog(null,"Team "+ (teamNumber+1) +": What's your name?");
			if(input.equals("Q")) return;
			_model.addTeam(input);
			JLabel label = new JLabel("<html>"+input + "<br>Score: "+_model.getTeams().get(teamNumber).getScore()+"</html>",JLabel.CENTER);
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setBorder(BorderFactory.createMatteBorder(0,1,0,1,Color.BLACK));
			label.setFont(new Font("Arial",Font.BOLD,30));
			label.setForeground(Color.WHITE);
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = teamNumber;
			c.gridy = 0;
			_teamPanel.add(label,c);
			for(int i=0;i<_model.getTeamSize();i++){
				JLabel temp = (JLabel)_teamPanel.getComponent(i);
				temp.setPreferredSize(new Dimension(_teamPanel.getWidth()/_model.getTeamSize(),100));
			}
			teamNumber++;
			jfrm.revalidate();
			jfrm.repaint();
			addTeam();
		}
		catch(Exception e ){}
		}
	
	//Updates the board visually
	public void update(){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(_model.getQuestions().get((i*5)+j).isEmpty()){
					_questions[i][j].setText("");
					_questions[i][j].setEnabled(false);
				}
			}
		}
		
		for(int k=0;k<_model.getTeamSize();k++){
			JLabel temp = (JLabel)_teamPanel.getComponent(k);
			temp.setText("<html>"+_model.getTeams().get(k).getName()+"<br>Score: "+_model.getTeams().get(k).getScore()*100+"</html>");
		}
		jfrm.revalidate();
		jfrm.repaint();
		if(_model.isEnd()){
			endGame();
		}
	}
	
	//Shows the winners when game ends
	public void endGame(){
		jfrm.setVisible(false);
		
		JFrame end = new JFrame("Here's the winners!");
		JPanel winPanel = new JPanel();
		JPanel headingPanel = new JPanel();
		ArrayList<Team> winners = new ArrayList<Team>();
		winners = _model.highestScore();
		JLabel heading = new JLabel("Congratualtions to",JLabel.CENTER);
		
		winPanel.setBackground(Color.BLUE);
		winPanel.setLayout(new BoxLayout(winPanel,BoxLayout.PAGE_AXIS));
		
		headingPanel.setLayout(new FlowLayout());
		headingPanel.setBackground(Color.BLUE);
		
		end.setSize(1440,1080);
		end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		end.setLocationRelativeTo(jfrm);
		end.setLayout(new BorderLayout());
		
		heading.setFont(new Font("Arial",Font.BOLD,40));
		heading.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
		heading.setPreferredSize(new Dimension(1440,80));
		heading.setBackground(Color.BLUE);
		heading.setForeground(Color.WHITE);
		
		for(int i=0;i<winners.size();i++){
			JLabel win = new JLabel("<html>Team "+winners.get(i).getName()+"<br>Score: "+winners.get(i).getScore()*100+"</html>");
			win.setPreferredSize(new Dimension(720,1000/winners.size()));
			win.setFont(new Font("Arial",Font.BOLD,40));
			win.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
			win.setBackground(Color.BLUE);
			win.setForeground(Color.WHITE);
			winPanel.add(win);
		}
		headingPanel.add(heading);
		end.add(headingPanel,BorderLayout.PAGE_START);
		end.add(winPanel,BorderLayout.CENTER);
		end.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case "Quit":
				System.exit(0);
			break;
			case "About":
				AboutEvent();
			break; 
		}
	}		
}
