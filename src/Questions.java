public class Questions 
{
	private String _question;
	private boolean _jeopardy;
	
	//Questions have their own class
	public Questions(String question)
	{
		_question = question;
		_jeopardy = false;
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
	
	//Return double jeopardy value
	public boolean isJeopardy()
	{
		return _jeopardy;
	}
	
}
