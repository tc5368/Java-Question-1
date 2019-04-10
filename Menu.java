import java.util.Scanner;
import java.io.*;
public class Menu{
	boolean exit = false;
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
		Menu menu = new Menu();
		menu.start();
	}
	public void start(){
		while(exit == false){
		System.out.println("(1) Create a new file");
		System.out.println("(2) Add a new player");
		System.out.println("(3) Show all players");
		System.out.println("(4) Search player by team");
		System.out.println("(5) Delete a player");
		System.out.println("(6) Search a stadium by address");
		System.out.println("(7) Display specific rugby players on the screen");
		System.out.println("(8) Exit\n");
		PickMenu();
	}
}
public void PickMenu(){
	int choice = 0;
	try{
		System.out.println("Enter your choice: ");
		choice = Integer.parseInt(scanner.nextLine());
	}
	catch(NumberFormatException e){
		System.out.println("Invlaid option, please enter a number between 1-8");
	}
		switch(choice){
			case 1:
				System.out.println("Creating a new file\n");
			break;

			case 2:
				System.out.println("Add a new player\n");
				AddingPlayer newPlayer = new AddingPlayer();
				newPlayer.playerAdd();
			break;

			case 3:
				System.out.println("Showing all players\n");
				ShowPlayers All = new ShowPlayers();
				All.showAllPlayers();
			break;

			case 4:
				System.out.println("Search players\n");
				ShowPlayers find = new ShowPlayers();
				find.playerSearch();
			break;

			case 5:
				System.out.println("Delete a player\n");
				// DeletePlayer deletePlayer = new DeletePlayer();
				// deletePlayer.delete();
			break;

			case 6:
				System.out.println("Search a stadium by address\n");
				// DisplayDetails searchStadium = new DisplayDetails();
				// searchStadium.searchStadium();
			break;

			case 7:
				System.out.println("Display specific rugby players\n");
				// DisplayDetails specificPlayer = new DisplayDetails();
				// specificPlayer.loadPlayer();
			break;

			case 8:
				System.out.print("Exit\n");
				exit = true;
			break;

			default:
				System.out.println("Enter a number between 1-8\n");
			break;
		}
	}
	}