public class Team {
	
	private String _name;
	private static int _score;
	
	public Team(String name){
		_name = name;
		_score = 0;
	}
	
	public void addScore(){
		_score++;
	}
	
}
