public class Team {
	
	private String _name;
	private int _score;
	private static int _teamNumber = 0;
	
	public Team(String name){
		_name = name;
		_score = 0;
		_teamNumber++;
	}
	
	public void addScore(){
		_score++;
	}
	
	public int getScore(){
		return _score;
	}
	
	public String getName(){
		return _name;
	}
	
	public int getPlayerNumber(){
		return _teamNumber;
	}
	
	public void setName(String name){
		_name = name;
	}
}