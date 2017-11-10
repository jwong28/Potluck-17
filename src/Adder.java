import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Adder implements ActionListener{

	private Model _model;
	private int _team,_score;
	
	public Adder(Model model, int team, int score){
		_model = model;
		_team = team;
		_score = score;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_model.getTeams().get(_team).addScore(_score);
	}

}
