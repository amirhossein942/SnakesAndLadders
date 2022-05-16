// -----------------------------------------------------
// Assignment 1
// Question: PlayLadderAndSnake Class
// Written by: Cristian Gasparesc 40209205 Amirhossein Tavakkoly 40203604
// Due Date: Due 11:59 PM � Monday, February 7, 2021
// -----------------------------------------------------
/**
 * @author Cristian Gasparesc, Amirhossein Tavakkoly
 * @version 23/01/22
 */
public class CellContent 
{
	//attributes
	private boolean snake;
	private boolean ladder;
	private int cell_value;
	private int new_cell_value;
	

	//constructor (parameterized)
	/**
	 * @param snake is the parameter showing if a snake is present or not in a cell
	 * @param ladder is the parameter showing if a ladder is present or not in a cell
	 * @param cell_value shows the value of a specific cell
	 * @param new_call_value is the new cell that a player who encountered a snake or ladder goes to
	 */
	public CellContent(boolean snake, boolean ladder, int cell_value, int new_call_value) 
	{
		this.snake = snake;
		this.ladder = ladder;
		this.cell_value = cell_value;
		this.new_cell_value = new_call_value;
	}

	//getters and setters
	/**
	 * 
	 * @return cell value
	 */
	public int getCell_value() 
	{
		return cell_value;
	}
	
	/**
	 * 
	 * @param cell_value is the cell value of a cell on the board
	 */
	public void setCell_value(int cell_value) 
	{
		this.cell_value = cell_value;
	}
	
	/**
	 * 
	 * @return new cell value that a player goes to
	 */
	public int getNew_call_value() 
	{
		return new_cell_value;
	}

	/**
	 * 
	 * @param new_call_value is the specific cell value that a player goes to
	 */
	public void setNew_call_value(int new_call_value) 
	{
		this.new_cell_value = new_call_value;
	}

	/**
	 * 
	 * @return the boolean value of this snake
	 */
	public boolean isSnake() {
		return snake;
	}
	/**
	 * 
	 * @param snake is the snake boolean (either a cell contains a snake: True or No snake:False)
	 */
	public void setSnake(boolean snake) {
		this.snake = snake;
	}
	/**
	 * 
	 * @return the boolean value of this ladder
	 */
	public boolean isLadder() {
		return ladder;
	}
	/**
	 * 
	 * @param ladder is the ladder boolean (either a cell contains a ladder: True or No ladder:False)
	 */
	public void setLadder(boolean ladder) {
		this.ladder = ladder;
	}
	
	



	
}