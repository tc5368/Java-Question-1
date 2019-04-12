import java.util.*;
import java.io.*;

//Written by Tom Clare c1769261

public class ShowPlayers{
	Scanner scanner = new Scanner(System.in);

	public ArrayList<String> getPlayers(){
	try{														//This is the get players method.
		FileReader fr = new FileReader("players.txt");			//It reads all the player data from file into 
		BufferedReader br = new BufferedReader(fr);				//an ArrayList then returns it.
		ArrayList<String> players = new ArrayList<String>();	//It's how all the other methods import the data 
		String line;
		while((line = br.readLine()) != null)
		{
	  		players.add(line);
		}
		br.close();
		return(players);
  		}
  	catch(IOException e){
		System.out.println("File not found");
		ArrayList<String> Empty = new ArrayList<String>();
		return (Empty);
		}
	}

  	public void showAllPlayers(){
  		ArrayList<String> load = getPlayers();	//this simply jsut uses getPlayers to find the strings
		for (String i : load){					//the prints the whole list out.
			System.out.println(i);
			}
		System.out.println("\n");
  	}

  	public void showSomePlayers(){
  		int startPos = 0;
		int endPos = 0;
		boolean found = false;
		while(found == false){
			try{
				System.out.println("Start of the subset: ");			//this is where you chose a slice of the players to show.
				int start = Integer.parseInt(scanner.nextLine());		//it starts a loop that continues until a valid input has been given
				System.out.println("End of the subset: ");				//once found it imports the player list from the getPlayers method and
				int end = Integer.parseInt(scanner.nextLine());			//then it just start a loop to print them at the given start posistion
				if (start < end){										//and finishes at the end posistion.
					found = true;
					startPos = start;
					endPos = end;
				}else{System.out.println("Invalid option try again");}
			}
			catch(NumberFormatException e){
				System.out.println("Invlaid option try again");
			}
		}
  		ArrayList<String> load = getPlayers();
  		try{
			for (int i = startPos; i < endPos+1; i++){
				System.out.println(load.get(i));
				}
			System.out.println("\n");
		}	
		catch(IndexOutOfBoundsException e){									//if the end posisition is too large or the start posistion to small then it wont run
			System.out.println("Selection was invalid please try again.");	//and return the error messagew that the input was invalid.
		}
  	}

  	public void teamSearch(){
  		ArrayList<String> load = getPlayers();

  		boolean found = false;
  		String searchingFor = "";
		while (found != true){									//This starts a loop until it gets a valid input 
			System.out.println("Enter Search term below:");	
			String inSearchingFor = scanner.nextLine();
			if (inSearchingFor.matches("[A-Za-z\\s]+")){
				searchingFor = inSearchingFor;
				found = true;
			}else{
				System.out.println("Invalid Town");
			}
		}
		for(String i : load){
			String[] playerData = i.split(",");				//Then the uses the list of player data from the getPlayers method to 
			if(playerData[3].contains(searchingFor)){		//then iterate through the data and check the team feild until it
				System.out.println(i);}						//find one that contains the search term. Then it prints that one.
		}													
		System.out.println("\n");
  	}

	public void searchAddress(){
		ArrayList<String> load = getPlayers();
		boolean found = false;
  		String searchingFor = "";
		while (found != true){									//function is almost exactly the same as the one above.
			System.out.println("Enter Search term below:");		//it starts the same way to get a vlaid search term.
			String inSearchingFor = scanner.nextLine();
			if (inSearchingFor.matches("[A-Za-z0-9\\s]+")){
				searchingFor = inSearchingFor;
				found = true;
			}else{
				System.out.println("Invalid Search");
			}
		}
		for(String i : load){						//The only difference is that this uses a nested for loop to check
			String[] playerData = i.split(",");		//all the possible feilds and also does.toLowerCase() to make it 
			for(int ix = 5; ix < 9; ix++){			//work irrespective of capitilisation. When it finds a match in any feild it prints out.
				if (playerData[ix].toLowerCase().contains(searchingFor.toLowerCase())){
					System.out.println(i);
				}
			}
		}  	
	}
}