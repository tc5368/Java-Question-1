import java.util.*;
import java.io.*;

public class DeletingPlayer{
	private int choice;
	Scanner scanner = new Scanner(System.in);
	public void playerDelete(){

		ShowPlayers find = new ShowPlayers();
		ArrayList<String> players = find.getPlayers();
		for(int i =0; i < players.size(); i++){
			System.out.println("Posistion "+i+":"+players.get(i));
		}
		System.out.println("Delete which posistion? ");
		boolean found = false;
		int deleting = 0;
		while(found == false){
			try{
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
		ArrayList<String> outPlayerList = new ArrayList<String>();
		for(int i = 0;i < players.size(); i++){
			if(i != deleting){
				outPlayerList.add(players.get(i));
			}
		}
		try{
      		FileWriter fw = new FileWriter("players.txt", false);
      		PrintWriter pw = new PrintWriter(fw);
      		for(int i = 0; i< outPlayerList.size(); i++){
        		pw.println(outPlayerList.get(i));
      		}
      		pw.close();
      		System.out.println("Player deleted");
    	}
    	catch(IOException e){
      		System.out.println("Error deleting player");
    	}
	}
}