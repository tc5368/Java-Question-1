import java.util.*;
import java.io.*;

public class AddingPlayer{
  private String playerID;
  private String playerName;
  private String careerTries;
  private String teamName;
  private String teamID;
  private String stadiumName;
  private String stadiumStreet;
  private String stadiumTown;
  private String stadiumPostcode;

Scanner scanner = new Scanner(System.in);

public void playerAdd(){
  System.out.println("Enter players name: ");
  playerName = scanner.nextLine();

  System.out.println("Enter players ID");
  playerID = scanner.nextLine();

  boolean found = false;
  while (found != true){
    System.out.println("Enter career tries scored");
    String inCareerTries = scanner.nextLine();
    if (inCareerTries.matches("[0-9]+")){
      careerTries = inCareerTries;
      found = true;
  }}

  System.out.println("Enter team name");
  teamName = scanner.nextLine();

  System.out.println("Enter team ID");
  teamID = scanner.nextLine();

  System.out.println("Enter stadium name");
  stadiumName = scanner.nextLine();

  System.out.println("Enter stadium street");
  stadiumStreet = scanner.nextLine();

  System.out.println("Enter stadium town");
  stadiumTown = scanner.nextLine();

  System.out.println("Enter stadium postcode");
  stadiumPostcode = scanner.nextLine();

  String[] feilds = {playerName,
                    playerID,
                    careerTries, 
                    teamName,teamID,
                    stadiumName,
                    stadiumStreet,
                    stadiumTown,
                    stadiumPostcode};

  String saveFormat = "";
  for (int i = 0; i < 9; i++){
    saveFormat += (feilds[i] + ' ');
  }
  try{
    FileWriter fw = new FileWriter("players.txt", true);
    PrintWriter pw = new PrintWriter(fw);

    pw.println(saveFormat);
    pw.close();
  }
  catch(IOException e){
    System.out.println("Error writing to file");
  }
}
}