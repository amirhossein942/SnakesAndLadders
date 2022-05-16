// -----------------------------------------------------
// Assignment 1
// Question: LadderAndSnake Class
// Written by: Cristian Gasparesc 40209205 Amirhossein Tavakkoly 40203604
// Due Date: Due 11:59 PM � Monday, February 7, 2021
// -----------------------------------------------------

//imports
import java.util.Random;
import java.util.*;

/**
 * @author Cristian Gasparesc, Amirhossein Tavakkoly
 * @version 23/01/22
 */
public class LadderAndSnake 
{

	//fields/attributes
	private CellContent[] board = new CellContent[100]; //board 1d array (100 elements)
	private int Number_player;	
	private Player[] listPlayer; //in this first line we create an array of the player object that takes the inputed Number of player as the length of the array

	//constructors
	/**
	 * Default Constructor 
	 */
	public LadderAndSnake() 
	{
		Number_player = 2;
		listPlayer = new Player[Number_player]; 
	}
	
	/**
	 * Parameterized constructor
	 * @param num_of_players is the number of players the will play the game.
	 */
	public LadderAndSnake(int num_of_players) 
	{
		Number_player = num_of_players;
		listPlayer = new Player[Number_player]; 
	}
	
	/**
	 * Copy Constructor
	 * @param copy_num_of_players will be a deep copy of the number of players initialized in the game
	 */
	LadderAndSnake(LadderAndSnake copy_num_of_players) 
	{
		this.Number_player = copy_num_of_players.Number_player;
		listPlayer = new Player[Number_player]; 
	}
	
	/**
	 * mutators (setters)
	 * @param Number_Player is being set using setters in case we need to set it.
	 */
	public void setNumber_player(int Number_Player) 
	{
			this.Number_player = Number_Player;
	}
	
	/**
	 * accessor (getters)
	 * @param Number_Player is the number of players the will play the game.
	 * @return the Number of Players that are in the Ladder and Snake Game
	 */
	public int getNumber_player(int Number_Player) 
	{
		return Number_Player;
	}
	
	/**
	 * In this method we initiate the core game by first sorting who starts first and then playing through the board until one player wins !
	 */
	public void play() 
	{
		 
		//methods stored at the end of class
		//the 4 first methods initialize the players and the board,
		//firstly we initialize the default players by just rolling the dice once each and see what they each get.
		initializePlayers();
		//initializing the board basically goes through every cell and sets whether it has a snake or ladder and then establishes where the player has to go.
		initializeBoard();
		//so checking if there are equalities and then sorting the players from their diceScores from biggest to smallest.
		checkForEqualities(listPlayer);
		sortPlayers(listPlayer);
			        
			        //outprints of sorting
			        System.out.println();
			        System.out.println("Loading Order of Players...");
			        System.out.println();

			        for (int i =0 ; i < Number_player ; i++) {
			        	System.out.print(listPlayer[i].getName() + " rolled a " + listPlayer[i].getDiceScore() + ", ");
			        }
			        
			        System.out.println();
			        System.out.println();
			        System.out.println("The Players will play in this order:\n");
			        
			        for (int i =0 ; i < Number_player ; i++) {
			        	System.out.print(listPlayer[i].getName() + ", \n");
			        }
			        
			        System.out.println("\nThe Game May Begin:");
	
	
		  //boolean win represents if someone won the game (at the start no one wins so by default false)
		  boolean win=false;
		  
	        while(!win) 
	        {
	        	
	        for (int i=0; i < Number_player; i++) 
	        {
	        	
	        	listPlayer[i].flipdice(); //players flip dice
	        	System.out.println("\n" + listPlayer[i].getName() + " was at " + listPlayer[i].position.getCell_value() + " and rolled " + listPlayer[i].getDiceScore());
	        	
	        	int newPosition = listPlayer[i].getDiceScore()+listPlayer[i].position.getCell_value(); //setting the new position of the player by adding the diceScore to the old position
	        	
	        	newPosition = limit(newPosition); //checking if the player exceeds the max value 100. If so, he must go back by the exceeding amount.
	        	
	        	CellContent newCell = board[newPosition-1]; //new cell will be the the new position player in the 1D array. -1 because the index of the array starts at 0 but the board starts at 1.
	        	
	        	listPlayer[i].setPosition(newCell); //setting the player's position to the new cell
	        	 
	            System.out.println(listPlayer[i].getName()+" is now at the position "+listPlayer[i].getPosition().getCell_value());
	             
	              
	              //HERE WE ADD CONDITIONS TO VERIFY IF IT'S A LADDER/SNAKE
	            
	              //Ladder
	              if (listPlayer[i].position.isLadder()){
	            	  int topLadder = listPlayer[i].position.getNew_call_value(); //getting the value at the top of the ladder
	            	  
	            	  newCell = board[topLadder-1]; // -1 because index of array starts at 0 but cells start at 1
	            	  listPlayer[i].setPosition(newCell);//moving player to new cell
	            	  
	            	  System.out.println(listPlayer[i].getName() + " found a ladder and he is now at the position " + topLadder);
	            	  
	              }
	              
	              //Snake
	              if (listPlayer[i].position.isSnake()) {
	            	  int bottomSnake = listPlayer[i].position.getNew_call_value();  //getting the value at the bottom of the snake
	            	  
	            	  newCell = board[bottomSnake - 1]; // -1 because index of array starts at 0 but cells start at 1
	            	  listPlayer[i].setPosition(newCell); //moving player to new cell
	            	  
	            	  System.out.println(listPlayer[i].getName() + " found a snake and he is now at the position " + bottomSnake);
	            	  
	              }
	              
	              if (listPlayer[i].getPosition().getCell_value()==100) 
	              {
	            	 System.out.println(listPlayer[i].getName()+ " IS THE WINNER !!!"); 
	            	 System.out.println("\nTHANK YOU FOR PLAYING AND WE HOPE YOU WILL PLAY AGAIN SOON !"); 
	            	 win=true; 
	            	 break;
	              }
	              
	              
	        }
	        
	        }
	        System.out.println();
	        System.out.println("The Final Positions on the board:\n");
	     displayFinalResults();
	}
	
	//Displaying Final Results Board
	private void displayFinalResults() {
		int cellValue;
		String playerNumber;
		
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				//even
				if (i%2==0) {
					cellValue = 100 - 10*i - j;
					playerNumber = "   "+ cellValue +"   ";
				} 
				//odd
				else {
					cellValue = 100 - 10*(i+1) + j + 1;
					playerNumber = "   "+ cellValue +"   ";
					if (cellValue >= 1 && cellValue <=9) {
						playerNumber = "   "+ "0"+cellValue +"   ";
					}
				}
				
				//playerNumber = "[   "+ cellValue +"   ]";
				
				for (int p=0; p<listPlayer.length;p++) {
					listPlayer[p].setName(listPlayer[p].getName());
					
					if(listPlayer[p].position.getCell_value()==cellValue) {
						playerNumber = listPlayer[p].getName();
					}		
				}
				System.out.print("["+playerNumber+"]");
			}
			System.out.println();
		}
		
}

	//Exceeding the final cell and going back by the exceeding amount
	private int limit(int newPosition) {
		if (newPosition>100) 
		{
			int limitNum = newPosition -100; //new position will exceed 100 so substracting will give us the exceeding ammount.
			newPosition = 100-limitNum;
			System.out.print("Player Going over 100, He is going back by the exceeding ammount. ");
		}
		return newPosition;
	}

	/**
	 * in this method we initialize the playing board including the snakes and ladders
	 */
	private void initializeBoard() {
		
		//Here we initialize all the cells of the board to a default value 
		for(int i=0;i<100;i++) {
			board[i] = new CellContent(false,false,i+1,i+1);
		}
		
		//Now we're putting ladders and snakes into the simple board
		
		//ladders
		board[0] = new CellContent(false,true,1,38);
		board[3] = new CellContent(false,true,4,14);
		board[8] = new CellContent(false,true,9,31);
		board[20] = new CellContent(false,true,21,42);
		board[27] = new CellContent(false,true,28,84);
		board[35] = new CellContent(false,true,36,44);
		board[50] = new CellContent(false,true,51,67);
		board[70] = new CellContent(false,true,71,91);
		board[79] = new CellContent(false,true,80,100);
		
		//snakes
		board[15] = new CellContent(true,false,16,6);
		board[47] = new CellContent(true,false,48,30);
		board[63] = new CellContent(true,false,64,60);
		board[78] = new CellContent(true,false,79,29);
		board[92] = new CellContent(true,false,93,68);
		board[94] = new CellContent(true,false,95,24);
		board[96] = new CellContent(true,false,97,76);
		board[97] = new CellContent(true,false,98,78);
		
	}

	private void initializePlayers() {
		for (int i = 0; i < Number_player;i++) //generating the players and their initial dice roll
		{
			String playerName = "Player " + (i + 1);
			Player player = new Player(playerName);
			player.flipdice();
			
			listPlayer[i] = player;
		}
	}

	
    // Selection sort algorithm
    // Here we want to sort the biggest number as the first player and then second biggest as second player and so on...
    // List = 1, 5, 3, 6
    // First step: 5, 1, 3, 6
    // Second step : 5, 1, 3, 6
    // Third step: 6, 1, 3, 5
    // Fourth step: 6, 3, 1, 5
    // 6, 5, 1, 3
    // 6, 5, 3, 1
	private void sortPlayers(Player[] listPlayer) {
		for (int i = 0; i < Number_player-1 ; i++) 
		{
		    Player maxPlayer = listPlayer[i]; //player variable
		    int maxScore = maxPlayer.getDiceScore(); //setting maxScore variable as the first for the moment
		    int indexMax = i;
		    
		    for (int j=i+1; j<Number_player ; j++) //going through the whole list of players
		    {
		    	if (listPlayer[j].getDiceScore() > maxScore) //if one is bigger than the previous setting new maxPlayer
		    	{
		    		maxPlayer = listPlayer[j];
		    		maxScore = maxPlayer.getDiceScore();
		    		indexMax = j;
		    	}
		    }
		    
			listPlayer[indexMax] = listPlayer[i];
			listPlayer[i] = maxPlayer; //switching position with the biggest score player
		    
			//getting the next biggest player
			if (listPlayer[i].getDiceScore() > maxScore) 
			{
				maxScore = listPlayer[i].getDiceScore();
				maxPlayer = listPlayer[i];		
			}
		}
	}
	
	
	//in this first algorithm we check for any equalities in the rolls
	// Initial list: 1,1,2,2
	// First step: 1,3,2,2 (3 is the result of player 2 flipping his dice, so it's a random value)
	// Second step: 1,3,2,2 (we go back to comparing 1 & 3)
	// Third step: 1,3,2,2 (we compare 1 to 2)
	// Fourth step: 1,3,2,2 (we compare 1 to 2)
	// 5th step: 1,3,2,2 (we compare 3 to 2)
	// 6th step: 1,3,2,2 (we compare 3 to 2)
	// 7th step: 1,3,2,1 (we compare 2 to 2, flip the second 2)
	// 8th step: 1,3,2,1 (we go back to the beginning, we compare 1 to 3)
	// and repeat
	private void checkForEqualities(Player[] listPlayer) {
		int a =0;
		  int b;
		  boolean flipped = false;
		  
		  while ( a < Number_player -  1 ) 
		  {
			  b = a+1;
			  while ( b < Number_player ) 
			  {
				  while (listPlayer[b].equals(listPlayer[a])) 
				  {
					  System.out.print(listPlayer[b].getName() +" rolled a " + listPlayer[b].getDiceScore() + " and has the same dice score as " + listPlayer[a].getName() + " who rolled a " + listPlayer[a].getDiceScore() +".");
					  System.out.println(" Since it is a tie, "+ listPlayer[b].getName() +" and " +listPlayer[a].getName() + " have to flip again\n");
					  listPlayer[b].flipdice();
					  listPlayer[a].flipdice();
					  flipped = true;
				  }		    		  
				  if (flipped) 
				  {
					  a =0;
					  b= a+1;
		    		  flipped = false;
				  } 
				  else 
				  {
		    		  b = b + 1;			    			  
				  }
			  }			    	  
			  a= a+1;
		  }		  
	}
}