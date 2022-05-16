// -----------------------------------------------------
// Assignment 1
// Question: LadderAndSnake Class
// Written by: Cristian Gasparesc 40209205 Amirhossein Tavakkoly 40203604
// Due Date: Due 11:59 PM � Friday, February 4, 2021
// -----------------------------------------------------
import java.util.Random;

/**
 * @author Cristian Gasparesc, Amirhossein Tavakkoly
 * @version 23/01/22
 */
public class Player 
	{
	 private String name;
	 private int diceScore;
	 
	 /**
	  * We no longer consider the position to be an integer, instead we see it as a Cell (or a CellContent)
	  *	We initilize the position at 0, because that's where a player is before the game starts
	  */
	 public CellContent position = new CellContent(false,false,0,0);
	 
	//methods
		/**
		 * flidice method sets the dice score to a random number between 1 and 6 basically representing the action of rolling a dice.
		 */
		public void flipdice() 
		{
			Random rand = new Random();
			
			int Dice = 1; //a dice cannot have an outcome less than 1
			int randomNumber = rand.nextInt(6); //generating a random number from 0 to 5 inclusive
			int Dice_Result = Dice + randomNumber; //the result will always give
			
			this.diceScore = Dice_Result;

		}
		/**
		 * Player Attributes/fields
		 */
		public Player() {
			this.name=null;
			this.diceScore=0;
			this.position.setCell_value(0);
		}
		
		/**
		 * 
		 * @param name is the name of the player so we can call a specific player when needed
		 */
		public Player(String name) //parametrized constructor
		{
			this.name = name;
			this.position.setCell_value(0);
		}
		
		/**
		 * 
		 * @return postion of player
		 */
		public CellContent getPosition() 
		{
			return position;
		}
		
		/**
		 * 
		 * @param test player is a copy of a player object
		 */
		public Player(Player test) 
		{
			this.diceScore=test.diceScore;
			this.name=test.name;
			this.position.setCell_value(0);
		}
		
		/**
		 * 
		 * @return dice Score
		 */
		public int getDiceScore() 
		{
			return diceScore;
		}
		
		/**
		 * 
		 * @return the name of a specific player
		 */
		public String getName() 
		{
			return this.name;
		}
		
		/**
		 * 
		 * @param name is the name of a specific player
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		/**
		 * 
		 * @param position of a player on the board
		 */
		public void setPosition(CellContent position) 
		{
			
			this.position=position;
		}
		
		/**
		 * 
		 * @param player is a player object
		 * @return the equality of specifically the DiceScores between 2 players
		 */
		public boolean equals(Player player) 
		{
			return (this.diceScore == player.getDiceScore());
		}

		
		
	
		
	}