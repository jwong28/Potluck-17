import java.util.ArrayList;
import java.util.Random;

public class Model 
{
	//Array list for both teams and questions
	private ArrayList<Team> _teams;
	private ArrayList<Questions> _questions;
	private int _turn;
	//Created within the Main Menu
	public Model()
	{
		_teams = new ArrayList<Team>();
		_questions = new ArrayList<Questions>();
		_turn = 0;
	}

	//Add team
	public void addTeam(String t)
	{
		_teams.add(new Team(t));
	}
	
	//Return team size
	public int getTeamSize()
	{
		return _teams.size();
	}
	
	//Returns the current player's turn
	public int getTurn(){
		return _turn;
	}
	//This method is used to when all the teams have went, the turn resets so a new button can be pressed
	public void resetTurn(){
		_turn = 0;
	}
	//This is so we can keep track of who's turn it is
	public void nextTurn(){
		_turn++;
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
