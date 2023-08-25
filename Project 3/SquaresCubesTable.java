/* 
 * CS210 Chapter 3 - SquareCubesTable
 * Jason Sy, 10/12/2020, Fall 2020 
 *
 * This program creates a table with number and calculates that numbers square and cube. User is asked to input number of desired table, along with starting number and ending number.
 */

import java.util.*;

public class SquaresCubesTable
{

//Class constant that's declared and initialized
   static final int COL_WIDTH = 15;

//padString method that takes two parameters; a String "s" and a integer that represents length "l". Method will pad the parameter string with spaces until its length is given length.
   public static String padString(String s, int l) 
   {
      String r = "";
      for(int i = 0; i < (l - s.length()); i++)
      {
         r = r + " "; 
      }
      r = r + s;
      return r;
   }


//repeatString method that accepts two parameters a String "s" and a integer that represents repeat count "rc". Creates and return a String that has the input string repeated a given number of times.
   public static String repeatString(String s, int rc)
   {
      String r = "";
      for(int i = 1; i <= rc; i++)
      {
         r = r + s;
      }
      return r;
   }

//printSquaresCubes method that accepts two integers as parameters "start" & "end". This method calculates and print the square and cubes of all numbers between the starting and ending numbers.
   public static void printSquaresCubes(int start, int end)
   {
      String str1 = (repeatString("=", COL_WIDTH) + " " + repeatString("=", COL_WIDTH) + " " + repeatString("=", COL_WIDTH));
      String str2 = (padString("Number", COL_WIDTH) + " " + padString("Squared", COL_WIDTH) + " " + padString("Cubed", COL_WIDTH));
      String str3 = str1 + ("\n") + (str2) + ("\n") + (str1);
      System.out.println(str3);
      for(int i = start; i <= end; i++)
      {
         System.out.println(padString((i + ""), COL_WIDTH) + " " + padString((i * i+ ""), COL_WIDTH) + " " + padString((i * i * i + ""), COL_WIDTH));
      }
    }


//This is the main method which prompts the user to enter the number of desired tables.
   public static void main(String[] args)
   {
      //This creates an object of the Scanner class.
      Scanner sc = new Scanner(System.in);
      //This prompts and takes the users input for desired number of tables.
      System.out.print("Enter the number of tables: ");
      int num_tables = sc.nextInt();
      int startingNum, endingNum;
      for(int i = 1; i <= num_tables; i++)
      {
         //line of stars seperators using the repeartString with COL_WIDTH class constant.
         System.out.println(repeatString("*", (COL_WIDTH*3)+2));
         System.out.println("Printing table " + "#" + i);
         //This prompts the user to enter desired start and end number for the table.
         System.out.print("Enter the starting number: ");
         startingNum = sc.nextInt();
         System.out.print("Enter the ending number: ");
         endingNum = sc.nextInt();
         printSquaresCubes(startingNum, endingNum);
       }
     }
}