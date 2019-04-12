import java.util.*;
import java.io.*;

//Written by Tom Clare c1769261

public class DeletingPlayer{
	private int choice;
	Scanner scanner = new Scanner(System.in);

	public void playerDelete(){

		ShowPlayers find = new ShowPlayers();			//This causes an instace of the showplayers class in order to use on of its methods
		ArrayList<String> players = find.getPlayers();	//getPlayers this returns a list of all the players's data.
		for(int i =0; i < players.size(); i++){
			System.out.println("Posistion "+i+":"+players.get(i));	//It then prints that along with a posistion at the front to make the identified of the player to be deleted easier.
		}
		System.out.println("Delete which posistion? ");
		boolean found = false;
		int deleting = 0;
		while(found == false){										//This starts a loop that will keep checking for a valid entry from the user.
			try{													//It checks the users input each loop until it finds a valid entry 
				int choice = Integer.parseInt(scanner.nextLine());
				if (choice < players.size()){						
					found = true;
					deleting = choice;
				}
				else{
					System.out.println("Invlaid option try again");
				}
			}
			catch(NumberFormatException e){
				System.out.println("Invlaid option try again");
			}
		}
		ArrayList<String> outPlayerList = new ArrayList<String>(); 	//Once it has a valid entry it then runs another
		for(int i = 0;i < players.size(); i++){						//loop for each player loading in with the ShowPlayers
			if(i != deleting){										//method getPlayers(). In every loop it adds the item to
				outPlayerList.add(players.get(i));					//a new array except for the item to be deleted.
			}
		}
		try{
      		FileWriter fw = new FileWriter("players.txt", false);
      		PrintWriter pw = new PrintWriter(fw);					//Then it simple writes the player data of all the players in
      		for(int i = 0; i< outPlayerList.size(); i++){			//the new array meaning all the data except for the deleted player
        		pw.println(outPlayerList.get(i));					//to the file hence the selected player's data is no longer there.
      		}
      		pw.close();
      		System.out.println("Player deleted");
    	}
    	catch(IOException e){
      		System.out.println("Error deleting player");
    	}
	}
}