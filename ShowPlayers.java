import java.util.*;
import java.io.*;

public class ShowPlayers{

	Scanner scanner = new Scanner(System.in);


	public List<String> getPlayers(){
	try{
		FileReader fr = new FileReader("players.txt");
		BufferedReader br = new BufferedReader(fr);
		List<String> players = new ArrayList<String>();
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
		List<String> Empty = new ArrayList<String>();
		return (Empty);
		}}



  	public void showAllPlayers(){
  		List<String> load = getPlayers();
		for (String i : load){
			System.out.println(i);
		}
		System.out.println("\n");
  	}



  	public void playerSearch(){
  		List<String> load = getPlayers();
  		String[] array = list.toArray();

  		System.out.println("Enter Search term below: ");
  		String searchingFor = scanner.nextLine();
  		System.out.println("Searching for: " + searchingFor);

		System.out.println("This is where the loop starts");
		for(int i = 0; i < load.length; i++){
			System.out.println(load[i]);
		}

  		List<String> load = getPlayers();
  	}

}