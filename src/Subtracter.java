import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Subtracter implements ActionListener{

	private Model _model;
	private int _score;
	private JFrame _j;
	
	public Subtracter(Model model, int score, JFrame j){
		_model = model;
		_score = score;
		_j = j;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_model.getTeams().get(_model.getTurn()).subtractScore(_score);
		_model.nextTurn();
		if(_model.getTeamSize() == _model.getTurn()){
			_model.resetTurn();
			_j.dispose();
		}
	}

}
