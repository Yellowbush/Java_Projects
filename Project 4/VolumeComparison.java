/* 
 * CS210 Chapter 4 - VolumeComparison
 * Jason Sy, 10/19/2020, Fall 2020 
 *
 * This program uses a method that prompts user to enter a desired shape type from "box, cone, or sphere" which it then uses methods to calculate the volumes of the sphere, cone and a box depending on what the user input as the shape type and the dimensions. User is allowed to enter two shapes.
 */
 
 import java.util.*;
 
 public class VolumeComparison
 {
 
   //This method gets the shape input from the user.
   public static String getShapeType(Scanner sc)
   {
      System.out.print("Please choose your shape (box, cone, or sphere): ");
      String shape = sc.nextLine();
      return shape;
   }
   
   
   //If a box is selected, method will ask for the dimensions of the box, calculates and reports it to the console and returns the volume.
   public static double promptCalculatePrintBoxVolume(Scanner sc)
   {
      double volume = 0;
      double width, depth, height;
      {
         System.out.print("Specify box width: ");
         width = sc.nextDouble();
         System.out.print("Specify box depth: ");
         depth = sc.nextDouble();
         System.out.print("Specify box height: ");
         height = sc.nextDouble();
         sc.nextLine();
      }
          
      volume = width * depth * height;
      return volume;
    }
    
    
    //If a cone is selected, method will ask for the dimensions of the cone, calculates and reports it to the console and returns the volume
    public static double promptCalculatePrintConeVolume(Scanner sc)
    {
      double volume = 0;
      double base, height;
      {
         System.out.print("Specify cone base:   ");
         base = sc.nextDouble();
         System.out.print("Specify cone height: ");
         height = sc.nextDouble();
         sc.nextLine();
      }
      
      volume = Math.PI * Math.pow(base, 2) * (height/3);
      return volume;
    }
    
    
    //If a sphere is selected, method will ask for the dimensions of the sphere, calculates and reports it to the console and returns the volume
    public static double promptCalculatePrintSphereVolume(Scanner sc)
    {
      double volume = 0;
      double radius;
      {
         System.out.print("Specify sphere radius:  ");
         radius = sc.nextDouble();
         sc.nextLine();
      }
      
      volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
      return volume;
    }
    
    
    //This method takes the shape name and decides which method to call.
    public static double promptCalculateVolume(String shape, Scanner sc)
    {
      if(shape.equals("box"))
      {
         return promptCalculatePrintBoxVolume(sc);
      }
      else if(shape.equals("cone"))
      {
         return promptCalculatePrintConeVolume(sc);
      }
      else if(shape.equals("sphere"))
      {
         return promptCalculatePrintSphereVolume(sc);
      }
      else
      {
         throw new IllegalArgumentException("Unknown shape");
      }
    }
    
    
    //Main method to get shape type and volume of two shapes that calls the methods getShapeType and promptCalculateVolume
    public static void main(String[] args)
    {
      //Scanner object to read user input.
      Scanner sc = new Scanner(System.in);
      
      //Get the first shape input and volume.
      String shape1 = getShapeType(sc);
      double volume1 = promptCalculateVolume(shape1, sc);
      System.out.printf("The volume of the %s is (%.3f) square units. \n\n", shape1, volume1);
      
      //Get the second shape input and volume.
      String shape2 = getShapeType(sc);     
      double volume2 = promptCalculateVolume(shape2, sc);
      System.out.printf("The volume of the %s is (%.3f) square units. \n\n", shape2, volume2);
      
      //Compares the volumes and prints the final report rounded to 3 decimal places.
      if(volume1 > volume2)
      {
         System.out.printf("The volume of the %s (%.3f square units) is greater than the volume of the %s (%.3f square units).\n", shape1, volume1, shape2, volume2);
      }
      else if (volume1 < volume2)
      {
         System.out.printf("The volume of the %s (%.3f square units) is less than the volume of the %s (%.3f square units).\n", shape1, volume1, shape2, volume2);
      }
      else
      {
         System.out.printf("The volume of the %s (%.3f square units) is equal to the volume of the %s (%.3f square units).\n", shape1, volume1, shape2, volume2);
      }
    }
 }