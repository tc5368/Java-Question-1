import java.util.*;
import java.io.*;

public class ShowPlayers{
	Scanner scanner = new Scanner(System.in);

	public ArrayList<String> getPlayers(){
	try{
		FileReader fr = new FileReader("players.txt");
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> players = new ArrayList<String>();
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
  		ArrayList<String> load = getPlayers();
		for (String i : load){
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
				System.out.println("Start of the subset: ");
				int start = Integer.parseInt(scanner.nextLine());
				System.out.println("End of the subset: ");
				int end = Integer.parseInt(scanner.nextLine());
				if (start < end){
					found = true;
					startPos = start;
					endPos = end;
				}else{System.out.println("Invlaid option try again");}
			}
			catch(NumberFormatException e){
				System.out.println("Invlaid option try again");
			}
		}
  		ArrayList<String> load = getPlayers();

		for (int i = startPos; i < endPos+1; i++){
			System.out.println(load.get(i));
			}
		System.out.println("\n");
  	}

  	public void teamSearch(){
  		ArrayList<String> load = getPlayers();

  		System.out.println("Enter Search term below: ");
  		String searchingFor = scanner.nextLine();
  		System.out.println("Searching for: " + searchingFor);

		for(String i : load){
			String[] playerData = i.split(",");
			if(playerData[3].contains(searchingFor)){
				System.out.println(i);}
		}
		System.out.println("\n");
  	}



	public void searchAddress(){
		ArrayList<String> load = getPlayers();
		System.out.println("Enter Search term below: ");
  		String searchingFor = scanner.nextLine();
		System.out.println("Searching for: " + searchingFor);

		for(String i : load){
			String[] playerData = i.split(",");
			for(int ix = 5; ix < 9; ix++){
				if (playerData[ix].toLowerCase().contains(searchingFor.toLowerCase())){
					System.out.println(i);
				}
			}
		}  	
	}


}








































