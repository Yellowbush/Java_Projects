/*
 * CS210 Chapter 6 - CountChange
 * Jason Sy, 11/09/2020, Fall 2020
 *
 *Program reads data from and writes data to file. Program will process lines of a file and save the total dollar value of all the lines together and the average per line.
 */


import java.io.*;
import java.util.*;

public class CountChange
{

    //Main Method
  public static void main(String[] args) throws FileNotFoundException
  {
      Scanner sc = new Scanner(System.in);
      System.out.print("Type a file name; ");
      String name = sc.next();
      Scanner input = new Scanner(new File(name));
      PrintStream output = new PrintStream(new File(name+"-out.txt"));
      countChange(input, output);
  }

    //Scanner for reading input file and one of the type PrintStream for writing output file.
    public static void countChange(Scanner input, PrintStream output)
    {
        double res;
        int i = 0;
        res = 0;
        double total = 0;

        {
            while (input.hasNextLine())
            {
                i++;
                String s = input.nextLine();
                total = processLine(input);
                res += total;
                output.println("Line " + i + " : $" + String.format("%.2f"));
            }
            output.println("Total : $" + String.format("%.2f", res));
            output.println("Average Change: $" + String.format("%.2f", res / (double)i));
        }
        output.close();
        input.close();

    }

    //Accepts string as a parameter representing one line from the input file.
  public static double processLine(Scanner input)
  {
      double totalCents = 0;

      while(input.hasNext())
      {
          int amount = input.nextInt();
          String total = input.next().toLowerCase();

          if(total.equals("penny"))
          {
              totalCents += amount;
          }
          else if(total.equals("1"))
          {
              totalCents += amount;
          }
          else if(total.equals("5"))
          {
              totalCents += 5 * amount;
          }
          else if(total.equals("nickle"))
          {
              totalCents += 5 * amount;
          }
          else if(total.equals("dime"))
          {
              totalCents += 10 * amount;
          }
          else if(total.equals("10"))
          {
              totalCents += 10 * amount;
          }
          else if (total.equals("quarter"))
          {
              totalCents += 25 * amount;
          }
          else if (total.equals("25"))
          {
              totalCents += 25 * amount;
          }
      }
       return totalCents;

  }

}