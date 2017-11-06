public class Questions {
	private String _question;
	private boolean _jeopardy;
	
	public Questions(String question){
		_question = question;
		_jeopardy = false;
	}
	
	public void Jeopardy(String question){
		_jeopardy = true;
		_question = question;
	}
	
	public String getQuestion(){
		return _question;
	}
	
	public boolean isJeopardy(){
		return _jeopardy;
	}
	
}
