/* 
 * CS210 Methods - Clementine
 * Jason Sy, 09/28/2020, Fall 2020 
 *
 * This program writes the lyrics to "Clementine"
 */

public class Clementine {
   //This is the main method that will call the other methods.
  public static void main(String[] args) {
      Clementine();
      Space();
      verse1();
      Space();
      chorus();
      Space();
      verse2();
      Space();
      chorus();
      Space();
      verse3();
      Space();
      chorus();
  }
  
  
   //"Clementine"
   public static void Clementine() {
      System.out.println("Clementine");
 }
      
   //Space in between verses and chorus
  public static void Space() {
        System.out.println();
 }
  
   //The first verse.
   public static void verse1() {
      System.out.println("In a cavern, in a canyon");
      System.out.println("Excavating for a mine");
      System.out.println("Lived a miner, forty-niner");
      System.out.println("And his daughter, Clementine");
}

   //The chorus. Will repeat two more times, after verse2 and verse3.
   public static void chorus() {
      System.out.println("Oh, my darling, oh, my darling");
      System.out.println("Oh, my darling Clementine");
      System.out.println("You are lost and gone forever");
      System.out.println("Dreadful sorry, Clementine");
}

   //The second verse.
   public static void verse2() {
      System.out.println("Light she was and like a fairy");
      System.out.println("And her shoes were number nine");
      System.out.println("Herring boxes without topses");
      System.out.println("Sandals were for Clementine");
}

   //The third verse.
   public static void verse3() {
      System.out.println("Drove she ducklings to the water");
      System.out.println("Every morning just at nine");
      System.out.println("Hit her foot against a splinter");
      System.out.println("Fell into the foaming brine");
   }
}