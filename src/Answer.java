import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Answer implements ActionListener{
	
	private JFrame _frame;
	
	public Answer(String answer){
		_frame = new JFrame("Answer");
		_frame.setLayout(new BorderLayout());
		_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		_frame.setSize(1300,850);
		_frame.setLocationRelativeTo(null);
		JPanel answerPanel = new JPanel();
		answerPanel.setLayout(new GridBagLayout());
		answerPanel.setBackground(Color.BLUE);
		JPanel donePanel = new JPanel();
		donePanel.setLayout(new FlowLayout());
		donePanel.setBackground(Color.BLUE);
		JLabel ans = new JLabel("<html>"+answer+"</html>",JLabel.CENTER);
		ans.setFont(new Font("Arial",Font.BOLD,70));
		ans.setBackground(Color.BLUE);
		ans.setForeground(Color.WHITE);
		ans.setPreferredSize(new Dimension(1300,750));
		JButton done = new JButton("Done");
		done.setFont(new Font("Arial",Font.BOLD,40));
		done.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		done.setBackground(Color.BLUE);
		done.setForeground(Color.WHITE);
		done.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						_frame.dispose();
					}
				});
		answerPanel.add(ans);
		donePanel.add(done);
		_frame.add(answerPanel,BorderLayout.CENTER);
		_frame.add(donePanel,BorderLayout.PAGE_END);
		_frame.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_frame.setVisible(true);
	}

}
