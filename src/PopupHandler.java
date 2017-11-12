import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupHandler implements ActionListener{
	//References to the front-end GUI
	private String _input;
	private Model _model;
	private int _score;
	private int _column;
	
	public PopupHandler(String input, Model model, int score, int column){
		_input = input;
		_model = model;
		_score = score;
		_column = column;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//making a Pop-up frame and passing the question inside
		@SuppressWarnings("unused")
		PopUp press = new PopUp(_input,_model,_score,_column);
	}

}
