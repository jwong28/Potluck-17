public class Questions 
{
	private String _question,_answer;
	private boolean _jeopardy,_isEmpty;
	
	//Questions have their own class
	public Questions(String question,String answer)
	{
		_answer = answer;
		_question = question;
		_jeopardy = false;
		_isEmpty = false;
	}
	
	//Double question jeopardy
	public void Jeopardy(String question)
	{
		_jeopardy = true;
		_question = question;
	}
	
	//Return question
	public String getQuestion()
	{
		return _question;
	}
	
	//Return answer
	public String getAnswer(){
		return _answer;
	}
	//When done with question, sets the question to " " for removal
	public void remove(){
		_isEmpty = true;
	}
	
	public boolean isEmpty(){
		return _isEmpty;
	}
	//Return double jeopardy value
	public boolean isJeopardy()
	{
		return _jeopardy;
	}
	
}
