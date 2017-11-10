public class Team 
{
	
	private String _name;
	private int _score;
	private static int _teamNumber = 0;
	
	//Declaring class and declarations
	public Team(String name)
	{
		_name = name;
		_score = 0;
		_teamNumber++;
	}
	
	//Increasing score
	public void addScore(int score)
	{
		_score = _score + score;
	}
	
	//Decreasing score
	public void subtractScore(int score){
		_score = _score - score;
	}
	
	//Return score
	public int getScore()
	{
		return _score;
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
}