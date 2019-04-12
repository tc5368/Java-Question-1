import java.util.*;
import java.io.*;

//Written by Tom Clare c1769261

public class Menu{
	boolean exit = false;	//Assign a boolean value to exit so that the main function will keep running until exit becomes true.
	Scanner scanner = new Scanner(System.in);	//itilises the scanner to take input from the user.

	public static void main(String[] args){
		Menu menu = new Menu();				//This is where the program starts by running the start method
		menu.start();
	}
	public void start(){
		while(exit == false){
		System.out.println("(1) Create a new file");	//The start method prints all the options that are avaliable on the system and then runs the pick function.
		System.out.println("(2) Add a new player");
		System.out.println("(3) Show all players");
		System.out.println("(4) Search player by team");
		System.out.println("(5) Delete a player");
		System.out.println("(6) Search a stadium by address");
		System.out.println("(7) Display specific rugby players on the screen");
		System.out.println("(8) Exit\n");
		pick(); //runs the pick function.
	}
}
public void pick(){
	int choice = 0;
	try{
		System.out.println("Enter your choice: ");		//Takes the users input then 
		choice = Integer.parseInt(scanner.nextLine());	//runs it thourhg a parser to make it an interger
	}
	catch(NumberFormatException e){	
		System.out.println("Invlaid option, please enter a number between 1-8"); //If its not an interger then it causes on exception which causes the menu to run again.
	}
		switch(choice){
			case 1:
				System.out.println("Creating a new file\n");					//If the number is valid then it will run through a switch case statment to run your choice
				try{
					PrintWriter clearing = new PrintWriter("players.txt");
					clearing.print("");
					clearing.close();											//This is the reset file option, when selected it opens the player.txt file and erases it.
				}catch(IOException e){System.out.println("Something broke");}
			break;

			case 2:
				System.out.println("Add a new player\n");		//As with all of the other cases from this point. This will cause a new instance of the class to run
				AddingPlayer newPlayer = new AddingPlayer();	//then run the given method in the case to perform the selected action.
				newPlayer.playerAdd();
			break;

			case 3:
				System.out.println("Showing all players\n");	//see above
				ShowPlayers All = new ShowPlayers();
				All.showAllPlayers();
			break;

			case 4:
				System.out.println("Search players by team\n");	//see above
				ShowPlayers find = new ShowPlayers();
				find.teamSearch();
			break;

			case 5:
				System.out.println("Delete a player\n");
				DeletingPlayer deletePlayer = new DeletingPlayer();	//see above
				deletePlayer.playerDelete();
			break;

			case 6:
				System.out.println("Search a stadium by address\n");	//see above
				ShowPlayers stadiumSearch = new ShowPlayers();
				stadiumSearch.searchAddress();
			break;

			case 7:
				System.out.println("Display specific rugby players\n");	//see above
				ShowPlayers selection = new ShowPlayers();
				selection.showSomePlayers();
			break;

			case 8:
				System.out.print("Exit\n"); //If option 8 is selected it changes the exit variable meaning that the main function will stop running, ending the program.
				exit = true;
			break;

			default:
				System.out.println("Enter a number between 1-8\n"); //if the number entered wasn't a case then it will run the default case and ask you to try again with a valid number.
			break;
		}
	}
	}