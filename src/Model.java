import java.util.ArrayList;
import java.util.Random;

public class Model 
{
	//Array list for both teams and questions
	private ArrayList<Team> _teams;
	private ArrayList<Questions> _questions;
	
	//Created within the Main Menu
	public Model()
	{
		_teams = new ArrayList<Team>();
		_questions = new ArrayList<Questions>();
	}

	//Add tean
	public void addTeam(String t)
	{
		_teams.add(new Team(t));
	}
	
	//Return team size
	public int getTeamSize()
	{
		return _teams.size();
	}
	
	//
	public ArrayList<Questions> getQuestions()
	{
		return _questions;
	}
	
	//Adding douuble jeopardy question
	public void addJeopardyQuestions(String s)
	{
		Random r = new Random();
		int x = r.nextInt(_questions.size());
		_questions.get(x).Jeopardy(s);
	}
	
	public ArrayList<Team> getTeams()
	{
		return _teams;
	}
	
	public int size()
	{
		return _questions.size();
	}
}
