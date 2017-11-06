import java.util.ArrayList;
import java.util.Random;

public class Model {
	private ArrayList<Team> _teams;
	private ArrayList<Questions> _questions;
	
	public Model(){
		_teams = new ArrayList<Team>();
		_questions = new ArrayList<Questions>();
	}

	public void addTeam(String t){
		_teams.add(new Team(t));
	}
	
	public int getTeamSize(){
		return _teams.size();
	}
	
	public ArrayList<Questions> getQuestions(){
		return _questions;
	}
	
	public void addJeopardyQuestions(String s){
		Random r = new Random();
		int x = r.nextInt(_questions.size());
		_questions.get(x).Jeopardy(s);
	}
	
	public ArrayList<Team> getTeams(){
		return _teams;
	}
}
