// -----------------------------------------------------
// Assignment 1
// Question: PlayLadderAndSnake Class
// Written by: Cristian Gasparesc 40209205 Amirhossein Tavakkoly 40203604
// Due Date: Due 11:59 PM � Monday, February 7, 2021
// -----------------------------------------------------

import java.util.Scanner;
import java.util.Arrays;

/**
 * @author Cristian Gasparesc, Amirhossein Tavakkoly
 * @version 23/01/22
 */
public class PlayLadderAndSnake 
{
	

	
	/**
	 * Main Method
	 * @param args runs the class
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);//initialize scanner
		
		
		System.out.println("|--------------- ++++ --------------|" +
				 			"\n~~~~~|-JAVA SNAKES AND LADDERS-|~~~~" +
				 			"\n|--------------- ++++ --------------|");
		
		System.out.println("\nWelcome To Snakes And Ladders (Java Edition)\n");
		System.out.println("This Game Was Created By: Amirhossein Tavakkoly and Cristian Gasparesc");
		System.out.println("***********************************************************************");
		System.out.println("\nEnter the # of players for your game � Number must be between 2 and 4 inclusively:");
		
		int nb_players;
		int failed_attempt = 1;
		nb_players = scan.nextInt();
		
		while(nb_players < 2 || nb_players > 4)
		{	
		if(failed_attempt == 4)
		{
		System.out.println("\nBad Attempt " + failed_attempt + "! You have exhausted all your chances. Program will terminate!");
		break;
		}
		else
		{
		System.out.print("\nBad Attempt " + failed_attempt + " - Invalid # of players. Please enter a # between 2 and 4 inclusively:");
		nb_players = scan.nextInt();
		}
		
		failed_attempt += 1;
		}   
		
		if(nb_players >= 2 && nb_players <= 4) {
		LadderAndSnake laddie = new LadderAndSnake(nb_players);
		laddie.play(); 
		}
	
	}
		

	}
