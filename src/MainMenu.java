
	import java.awt.BorderLayout;
import java.awt.Dimension; 
	import java.awt.Event;
	import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Scanner;

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

	public class MainMenu implements ActionListener{
		
		JFileChooser jfc;
		private JButton[][] _questions; 
		private JPanel _boardPanel;
		private JFrame jfrm;
		private Model _model;
		public MainMenu(){
		_model = new Model();
		_questions = new JButton[5][5];
		// Create a frame
	    jfrm = new JFrame("A.S.I.A Jeopardy");
	    //FIle chooser
	    jfc = new JFileChooser();
	    //Set to exit
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Size of frame
	    jfrm.setSize(1650, 1080);
	    jfrm.setLocationRelativeTo(null);
	    jfrm.setLayout(new BorderLayout());
	    
		//MenuBar and choices and declaring everything
		JMenuBar menuBar = new JMenuBar();
	    JMenu FileMenu = new JMenu("File");
	    JMenu Help = new JMenu("Help");
	    JMenuItem HelpItem =new JMenuItem("About");
	    JMenuItem QuitItem = new JMenuItem("Quit");
	    JMenuItem OpenItem = new JMenuItem("Open");

	  //Adding File and Help    
	    menuBar.add(FileMenu);
	    //Alt+F: File
	    FileMenu.setMnemonic(KeyEvent.VK_F);
	    menuBar.add(Help);
	    //Alt+H: Help
	    Help.setMnemonic(KeyEvent.VK_H);
	    jfrm.add(menuBar);
	    jfrm.setJMenuBar(menuBar);
	   
	    FileMenu.add(OpenItem);
	    OpenItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,Event.CTRL_MASK));
	    FileMenu.add(QuitItem);
	    QuitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,Event.CTRL_MASK));
	    Help.add(HelpItem);
	    HelpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,Event.CTRL_MASK));
	    
	    //Calling Action Listener

	    QuitItem.addActionListener(this);
	    HelpItem.addActionListener(this);
	    OpenItem.addActionListener(this);
	    
	    // Display the frame
	    jfrm.setVisible(true);		 
	 }

	protected void AboutEvent()
	{	
		JTextPane panel = new JTextPane();
		panel.setPreferredSize(new Dimension(300,150));
		panel.setText( "This is for A.S.I.A's potluck event.");
		panel.setEditable(false);
		JOptionPane.showMessageDialog(null, panel,"About this application",JOptionPane.INFORMATION_MESSAGE);	
	}
	
	protected void createAndPopulate(Scanner data){
		_boardPanel = new JPanel();
		_boardPanel.setLayout(new GridLayout(6,5));
		for(int category=0;category<5;category++){ 
			_boardPanel.add(new JLabel(data.next()));
		}
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
			_questions[i][j] = new JButton("$"+(i+1)+"00");
			_questions[i][j].addActionListener(this);
			_model.getQuestions().add(data.next());
			_boardPanel.add(_questions[i][j]);
			}
		}
//		for(int teams=0;teams<_model.getTeamSize();teams++){
//			jfrm.add(new JLabel(_model.getTeams().get(teams).getName()),BorderLayout.PAGE_START);
//		}
		jfrm.add(_boardPanel,BorderLayout.CENTER);
		jfrm.repaint();
	}
	
	protected void OpenEvent()
	{
		jfc.setDialogTitle("Choose a file to read: ");
		int jfcResult = jfc.showOpenDialog(null); //Pass null to center the dialog
		if(jfcResult == JFileChooser.APPROVE_OPTION)
		{
			try
			{			
				Scanner data = new Scanner(new FileReader(jfc.getSelectedFile()));
				createAndPopulate(data);
				data.close();
			}
			catch (FileNotFoundException ex)
			{
				JOptionPane.showMessageDialog(null,"File is not found.");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Text file not chosen.");
				e1.printStackTrace();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No file chosen.");
		}
			
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
				case "Open":
					OpenEvent();
				break;
			}
		}
	}
