import java.util.*;
//Client program for the Dog class
// Instantiates two Dog objects and helps user interact with them.
public class DogMain {
   public static void main(String[] args) {
    
      Dog dog1 = new Dog();
      dog1.setName("Ginger");
      Dog dog2 = new Dog("Pepper", "Black",15);
   
      String sep = "***************************************************************";
      Scanner console = new Scanner(System.in);
      int choice = -1;
      Dog dogOfChoice;
      // Prompt the user for the choice of the dog
      System.out.print("Enter Dog Choice: 1 for "+ dog1.getName() + " 2 for "+dog2.getName() + " (0 to quit) ");
      choice = console.nextInt();      
      while ( choice != 0) {
      
         dogOfChoice = choice == 1 ? dog1 : dog2;
         System.out.println(sep);
         char cmd = 't';
         while (cmd != 'q'){
            // Prompt the user for the command
            System.out.print("Enter the command\n'S' to get Status,\t'F' to feed,\t'W' to walk, \t'Q' to quit: ");
            cmd = console.next().toLowerCase().charAt(0);
            System.out.println(sep); 
            // Take appropriate action           
            switch(cmd) {
               case 's':
                  System.out.println(dogOfChoice);
                  break;
               case 'f':
                  dogOfChoice.eat();
                  break;
               case 'w':
                  dogOfChoice.walk();
                  break;
               case 'q':
                  break;
               default:
                  System.out.println("Invalid command");
            }
            System.out.println(sep);
         }
         System.out.print("Enter Dog Choice: 1 for "+ dog1.getName() + " 2 for "+dog2.getName() + " (0 to quit) ");
         choice = console.nextInt();         
      }
   
      System.out.println("Good bye! Woof woof");
            
                
        
   }
}