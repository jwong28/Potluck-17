public class Team 
{
	
	private String _name;
	private int _score,_previousScore;
	private static int _teamNumber = 0;
	
	//Declaring class and declarations
	public Team(String name)
	{
		_name = name;
		_score = 0;
		_teamNumber++;
		_previousScore = 0;
	}
	
	//Increasing score
	public void addScore(int score)
	{
		_previousScore = _score;
		_score = _score + score;
	}
	
	//Decreasing score
	public void subtractScore(int score){
		_previousScore = _score;
		_score = _score - score;
	}
	
	//Return score
	public int getScore()
	{
		return _score;
	}
	//Return previous score
	public int getPreviousScore(){
		return _previousScore;
	}
	//Return team name
	public String getName()
	{
		return _name;
	}
	
	//Return players on team
	public int getPlayerNumber()
	{
		return _teamNumber;
	}
	
	//Set name of team
	public void setName(String name)
	{
		_name = name;
	}
	
	//Set score of team
	public void setScore(int score){
		_score = score;
	}
}