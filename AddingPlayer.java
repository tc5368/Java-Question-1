import java.util.*;
import java.io.*;

//Written by Tom Clare c1769261

public class AddingPlayer{
	private String playerID;
	private String playerName;			//Setting up the private attributes for the adding player method.
	private String careerTries;
	private String teamName;
	private String teamID;
	private String stadiumName;
	private String stadiumStreet;
	private String stadiumTown;
	private String stadiumPostcode;

Scanner scanner = new Scanner(System.in); //Initlises the scanner to take input.

public void playerAdd(){
	boolean found = false; //This is used to verify the inputs for each feild.

	while (found != true){
		System.out.println("Enter players name: ");
		String inPlayerName = scanner.nextLine();
		if (inPlayerName.matches("[A-Za-z]+\\s{1}[A-Za-z]+")){		//All of these work in a very similar way. They start by 
			playerName = inPlayerName;								//setting a boolean variable to false and then while that
			found = true;											//variable isnt true keep taking input until a valid one
		}else{														//is entered. Upon a sucsessful entry it will update the
			System.out.println("Invalid Name");						//class attribute and also set the found variable to true 
		}															//which will break the loop of taking inputl.
	}
																	//The system uses a regular expression to determine if an
	found = false;													//entry is valid according to the breif. 
	while (found != true){
		System.out.println("Enter players ID");						//Also if the data is invalid it will show an error message.
		String inPlayerID = scanner.nextLine();
		if (inPlayerID.matches("(RFU)\\d{5}")){
			playerID = inPlayerID;
			found = true;
		}else{
			System.out.println("Invalid Player ID");
		}
	}
	
	found = false;
	while (found != true){
		System.out.println("Enter career tries scored");			//see above
		String inCareerTries = scanner.nextLine();
		if (inCareerTries.matches("[0-9]+")){
			careerTries = inCareerTries;
			found = true;
		}else{
			System.out.println("Invalid Number of tries");
		}
	}

	found = false;
	while (found != true){
		System.out.println("Enter team name");						//see above
		String inTeamName = scanner.nextLine();
		if (inTeamName.matches("[A-Za-z\\s]+")){
			teamName = inTeamName;
			found = true;
		}else{
			System.out.println("Invalid Team name");
		}
	}

	found = false;
	while (found != true){
		System.out.println("Enter team ID");						//see above
		String inTeamID = scanner.nextLine();
		if (inTeamID.matches("[A-Z]{3}[0-9]{4}")){
			teamID = inTeamID;
			found = true;
		}else{
			System.out.println("Invalid Team ID");
		}
	}

	found = false;
	while (found != true){
		System.out.println("Enter stadium name");					//see above
		String inStadiumName = scanner.nextLine();
		if (inStadiumName.matches("[A-Za-z\\s]+")){
			stadiumName = inStadiumName;
			found = true;
		}else{
			System.out.println("Invalid Stadium name");
		}
	}

	found = false;
	while (found != true){
		System.out.println("Enter stadium street");					//see above
		String inStadiumStreet = scanner.nextLine();
		if (inStadiumStreet.matches("[A-Za-z0-9\\s]+")){
			stadiumStreet = inStadiumStreet;
			found = true;
		}else{
			System.out.println("Invalid Stadium Street");
		}
	}

	found = false;
	while (found != true){
		System.out.println("Enter stadium town");					//see above
		String inStadiumTown = scanner.nextLine();
		if (inStadiumTown.matches("[A-Za-z\\s]+")){
			stadiumTown = inStadiumTown;
			found = true;
		}else{
			System.out.println("Invalid Town");
		}
	}

	found = false;
	while (found != true){
		System.out.println("Enter stadium postcode");				//see above
		String inStadiumPostcode = scanner.nextLine();
		if (inStadiumPostcode.matches("[A-Z]\\d[A-Z]{3}")){
			stadiumPostcode = inStadiumPostcode ;
			found = true;
		}else{
			System.out.println("Invalid postcode Format");
		}
	}

	String[] feilds = {
		playerName,
		playerID,
		careerTries, 		//finally all of the valid attributes are added into an array of strings
		teamName,teamID,
		stadiumName,
		stadiumStreet,
		stadiumTown,
		stadiumPostcode};

	String saveFormat = "";
	for (String i: feilds){			//then the attributes are appending to an output string seperated by commas
		saveFormat += (i + ',');
	}
	try{
		FileWriter fw = new FileWriter("players.txt", true);	//this output string is then appended to the players.txt file.
		PrintWriter pw = new PrintWriter(fw);

		pw.println(saveFormat);
		pw.close();
	}
	catch(IOException e){
		System.out.println("Error writing to file");
	}
}
}