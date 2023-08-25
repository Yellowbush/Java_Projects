/* 
 * CS210 Chapter 5 - RacquetBallMatch
 * Jason Sy, 10/27/2020, Fall 2020 
 *
 * Program simulates a Racquet Ball Match and acts as a score keeper.
 */



import java.util.*;

public class RacquetBallMatch
{

   //Method 1, repeatedly ask user who the winner of the next point is.
   public static char playGame(Scanner sc)
   {
      int apoint = 0;
      int bpoint = 0;
      char point;
      while (true)
      { 
         System.out.print("Winner of the next point (A for Allen/B for Bob): ");
         point = sc.next().charAt(0);
         System.out.println();
         point = Character.toLowerCase(point);
         if(point == 'a')
         {
            apoint++;
         }
         else
         {
            bpoint++;
         }
         if (apoint == 3 && bpoint == 0)
         {
            printGameScores(apoint, bpoint);
            return 'A';
         }
         else if (bpoint == 3 && apoint == 0)
         {
        	   printGameScores(apoint, bpoint);
            return 'B';
         }
         else if (apoint == 7)
         {
            printGameScores(apoint, bpoint);
            return 'A';
         }
         else if (bpoint == 7)
         {
            printGameScores(apoint, bpoint);
        	   return 'B';
         }
         printGameScores(apoint, bpoint);
       }
       
    }
    
    //Method 2, accepts points of two plays and prints the scores.
    public static void printGameScores(int apoint, int bpoint)
    {
    	System.out.println("Games Score  Allen Bob");
    	System.out.println("              " + apoint + "     " + bpoint);
    }
    
    //Method 3, accepts game counts of two players and prints the scores.
    public static void printMatchScores(int aScore, int bScore, int winner)
    {
    	int total = aScore + bScore;
    	String str1 = ("******************************************************************");
    	System.out.println("Game #" + total + " over!");
    	if(winner == 0) {
    		System.out.println("Allen won game #" + total);
    	}else {
    		System.out.println("Bob won game #" + total);
    	}
    	System.out.println(str1);
    	System.out.println("Match score (# of games won): Allen: " + aScore + " Bob  " + bScore);
    	System.out.println(str1);
    }
    
    //Main Method
    public static void main(String[] args)
    {
      Scanner sc = new Scanner(System.in);
      String str1 = ("******************************************************************");
      String str2 = ("Welcome to The All NorthWest Racquet Ball Tournament \nToday's Players: Allen and Bob");
      String str3 = (str1 + ("\n") + str2 + ("\n") + str1);
      System.out.println(str3);  
      char point;   
      String winner = "";
      int apoint = 0;
      int bpoint = 0;
      int aScore = 0;
      int bScore = 0;
      int matchWinner = 0;
      printGameScores(apoint, bpoint);      
      boolean result = false;
      while (!result)
      {
         point = playGame(sc);
         
         if (point == 'A')
         {
            apoint++;
            aScore++; 
        	   printMatchScores(aScore, bScore, matchWinner);
         }
         else
         {
            bpoint++;
            matchWinner = 1; 
        	   bScore++; 
        	   printMatchScores(aScore, bScore, matchWinner);
         }
         if(apoint == 2)
         {
            winner = "Allen";
            result = true;
         }
         else if(bpoint == 2)
         {
            winner = "Bob";
            result = true;
         }
       }     
       System.out.println("Congratulations! " + winner + " won the match!");
       System.out.println(str1);
      }
    }
