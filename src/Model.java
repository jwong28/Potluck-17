import java.util.ArrayList;

public class Model {
	private ArrayList<Team> _teams;
	private ArrayList<String> _questions;
	
	public Model(){
		_teams = new ArrayList<Team>();
		_questions = new ArrayList<String>();
	}
	
	public void addTeam(String t){
		_teams.add(new Team(t));
	}
	
	public int getTeamSize(){
		return _teams.size();
	}
	
	public ArrayList<String> getQuestions(){
		return _questions;
	}
	
	public ArrayList<Team> getTeams(){
		return _teams;
	}
}
