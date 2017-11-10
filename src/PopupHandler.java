import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupHandler implements ActionListener{

	private String _input;
	private Model _model;
	private int _score;
	
	public PopupHandler(String input, Model model, int score){
		_input = input;
		_model = model;
		_score = score;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//making pop-up and passing the question inside
		PopUp press = new PopUp(_input,_model,_score);
	}

}
