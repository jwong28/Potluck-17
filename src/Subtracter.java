import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Subtracter implements ActionListener{

	private Model _model;
	private int _team,_score;
	
	public Subtracter(Model model, int team, int score){
		_model = model;
		_team = team;
		_score = score;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_model.getTeams().get(_team).subtractScore(_score);
	}

}
