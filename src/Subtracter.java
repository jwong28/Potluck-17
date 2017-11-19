import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Subtracter implements ActionListener{
	//References to the front-end GUI
	private Model _model;
	private int _score,_column;
	private PopUp _j;
	
	public Subtracter(Model model, int score, int column, PopUp j){
		_model = model;
		_score = score;
		_j = j;
		_column = column;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Subtracts the score to the corresponding team
		_model.getTeams().get(_model.getTurn()).subtractScore(_score+1);
		//the next team is now allowed to go
		if(_model.getTeamSize() != _model.getTurn()+1){
		_j.update(_model.getTurn()+1);
		}
		_model.nextTurn();
		//if the turn is equal to the team size, the frame exits out and goes back to the GUI frame
		if(_model.getTeamSize() == _model.getTurn()){
			_model.removeQuestion((_score*5)+_column);
			_model.resetTurn();
			_j.dispose();
		}
	}

}
