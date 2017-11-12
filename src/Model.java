import java.util.ArrayList;
import java.util.Random;

public class Model 
{
	//Array list for both teams and questions
	private ArrayList<Team> _teams;
	private ArrayList<Questions> _questions;
	//Checks which team's turn it is
	private int _turn;
	//Observer that updates the GUI whenever something here is changed
	private Observer _observer;
	//Created within the Main Menu
	public Model()
	{
		_teams = new ArrayList<Team>();
		_questions = new ArrayList<Questions>();
		_turn = 0;
		_observer = null;
	}
	
	//Sets the observer to notify when something is changed
	public void setObserver(Observer obs){
		_observer = obs;
	}
	
	//When something is changed, the update method gets called from observer a.k.a the GUI
	public void GameStateChanged(){
		if(_observer != null){
			_observer.update();
		}
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
		GameStateChanged();
	}
	
	//This is so we can keep track of who's turn it is
	public void nextTurn(){
		_turn++;
	}
	
	//returns the questions 
	public ArrayList<Questions> getQuestions()
	{
		return _questions;
	}
	
	//Removes a question in _questions by calling the remove function in question
	public void removeQuestion(int position){
		_questions.get(position).remove();
	}
	
	//Adding double jeopardy question
	public void addJeopardyQuestions(String s)
	{
		Random r = new Random();
		int x = r.nextInt(_questions.size());
		_questions.get(x).Jeopardy(s);
	}
	
	//returns the teams
	public ArrayList<Team> getTeams()
	{
		return _teams;
	}
	
	//returns the size of the questions
	public int size()
	{
		return _questions.size();
	}
}
