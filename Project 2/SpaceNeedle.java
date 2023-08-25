/* 
 * CS210 Coding Assignment #2 - SpaceNeedle
 * Jason Sy, 10/05/2020, Fall 2020 
 *
 * This program creates a space needle and allows you to adjust the size.
 */

public class SpaceNeedle {

   final static int SIZE = 5; //Class constant that controls the height

   public static void main(String[] args) { //Main Method
      tip();
      upperdome();
      middledome();
      bottomdome();
      tip();
      stem();
      upperdome();
      middledome();
   }
   

//Creates the tip and upper stem supporting the dome
   public static void tip() {
      for (int i = 1; i <= SIZE; i++) {
         for (int space = 1; space <= SIZE*3; space++) {
            System.out.print(" ");
         }
         System.out.println("||");
      }
   }
   

//Upper part of the dome and support at the bottom of the SpaceNeedle
   public static void upperdome(){
      for (int line = 1; line <= SIZE; line++) {
         for (int space = 1; space <= SIZE-line; space++) {
            System.out.print("   ");
         }  
         System.out.print("__/");
         for (int j = 1; j <= line-1; j++) {
            System.out.print(":::");
         }
         System.out.print("||");
         for (int j = 1; j <= line-1; j++) {
            System.out.print(":::");
         }
         System.out.println("\\__");
         }
   }
   

//Middle part of the dome and bottom
   public static void middledome() {
      System.out.print("|");
      for (int i = 1; i <= SIZE; i++) {
         System.out.print("\"\"\"\"\"\"");
      }
      System.out.println("|");
   }
   

//Bottom part of the dome
   public static void bottomdome(){
      for (int line = 1; line <= SIZE; line++) {
         for (int space = 1; space <= (line*2)-2; space++) {
            System.out.print(" ");
         }
         System.out.print("\\_");
         for (int j = 1; j <= (((SIZE*3)+1) - (line*2)); j++) {
            System.out.print("/\\");
         }
         System.out.println("_/");
      }
   }
   

//The stem of the SpaceNeedle
   public static void stem() {
      for (int line = 1; line <= SIZE * SIZE; line++) {
         for (int space = 1; space <= (SIZE*3)-3; space++) {
            System.out.print(" ");
         }
         System.out.println("|%%||%%|");
      }
   }
}