package day_7;
import java.util.HashMap;
import java.util.Scanner;

public class ScoreBoard {

	public static void main(String[] args)
	{
		
		
	    Scanner sc = new Scanner(System.in);
	    HashMap<String, Integer> scoreboard = new HashMap<>();
	    
	    
	    while (true) {
            System.out.println("\n--- Scoreboard Menu ---");
            System.out.println("1. Add Player");
            System.out.println("2. Update Score");
            System.out.println("3. Display Scoreboard");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice;
            
            try 
            {
                choice = Integer.parseInt(sc.nextLine());
            } 
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input! Please enter a number from 1 to 4.");
                continue;
            }
            if(choice==1)
            {
            	     
            		 System.out.print("Enter player name: ");
                 String player = sc.nextLine();
                 
                 if (scoreboard.containsKey(player))
                 {
                     System.out.println(" Player already exists!");
                 } 
                 else
                 {
                     scoreboard.put(player, 0);
                     System.out.println(" Player added with score 0.");
                 }
            }
            else if(choice==2)
            {
             	System.out.print("Enter player name: ");
                String updatePlayer = sc.nextLine();
                
                
                if (scoreboard.containsKey(updatePlayer)) {
                    System.out.print("Enter score to add: ");
                    
                    try {
                        int newScore = Integer.parseInt(sc.nextLine());
                        Integer currentScore = scoreboard.get(updatePlayer); 
                        scoreboard.put(updatePlayer, currentScore + newScore); 
                        System.out.println("Score updated.");
                        }
                    catch (NumberFormatException e)
                    {
                        System.out.println(" Invalid score! Please enter a valid number.");
                    }
                }
                 else 
                 {
                    System.out.println("Player not found.");
                 }
            }
             else if(choice==3)
             {
            	 	System.out.println("\n************* Scoreboard ****************");
                 if (scoreboard.isEmpty()) 
                 {
                     System.out.println("No players yet.");
                 } 
                 else 
                 {
                     for (String p : scoreboard.keySet())
                     {
                         System.out.println(p + ": " + scoreboard.get(p));
                     }
                 }
                 
            	 
              }
             else if(choice==4)
             {
                 System.out.println("Exiting...");
             }
             else
             {
            	 System.out.println("Invalid choice, Choose the input between 1 to 4");
             }
           }
	    
	    
                 
     }	

}
