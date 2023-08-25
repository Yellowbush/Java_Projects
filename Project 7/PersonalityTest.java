/*
 * CS210 Chapter 7 - PersonalityTest
 * Jason Sy, 11/16/2020, Fall 2020
 *
 * Program will process input and output results of a Personality test
 */


import java.io.*;
import java.util.*;


public class PersonalityTest
{
    //Class constant used
    public static final int DIMENSIONS = 4;


    //Main Method
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter your file location: ");
        String inputFile = console.nextLine();
        String nameFinalOutput = inputFile.split("\\.")[0];
        String txt = inputFile.split("\\.")[1];
        Scanner input = new Scanner(new File(inputFile));
        PrintStream output = new PrintStream(nameFinalOutput + "-out." + txt);
        processPerson(input, output);
    }

    //Accepts two objects as parameters, Scanner to read input and PrintStream to write the output, will print the report for person.
    public static void processPerson(Scanner input, PrintStream output)
    {
        String name;
        String response;
        int ab = 0;
        int i;
        int[] a = new int[DIMENSIONS];
        int[] b = new int[DIMENSIONS];
        int[] percent = new int[DIMENSIONS];
        while (input.hasNextLine())
        {
            for (i = 0; i < DIMENSIONS; i++)
            {
                a[i] = 0;
                b[i] = 0;
                ab = 0;

            }
            name = input.nextLine();
            response = input.nextLine();
            output.println(name + ": ");
            computeTally(response, a, b, output);
            computePercentage(a, b, percent, output);
            computePercentage2(percent, output);
            ab++;
        }
    }

    //Accepts String response as a parameter representing As and Bs and return array for both A and B e.g for Betty Boop A:[1, 17, 18, 18] B:[9,3,2,2].
    public static void computeTally(String response,int[] a,int[] b,PrintStream output)
    {
        int i;
        int num;
        char let;
        for (i = 0; i < response.length(); i++)
        {
            let = Character.toUpperCase(response.charAt(i));
            if(let != '-')
            {
                num = (i % 7 +1)/2;
                if(let == 'A')
                    a[num]++;
                else
                    b[num]++;
            }
        }
        output.print("");
        for(i = 0; i < DIMENSIONS; i++)
            output.print(a[i] + "A-" + b[i] + "B ");
        output.println();
    }

    //Accepts output of computeTally method return the array percentage for B responses e.g Betty Boop: [90, 15, 10, 10].
    public static void computePercentage(int[] a, int[] b, int percent[], PrintStream output)
    {
        int i;
        double sum;
        for (i = 0; i < DIMENSIONS; i++)
        {
            sum = a[i] + b[i];
            percent[i] = (int) Math.round(100 * b[i] / sum);
        }
        output.print("[" + percent[0] + "%");
        for (i = 1; i < DIMENSIONS; i++)
            output.print(", " + percent[i] + "%");
        output.print("]");
    }

    //Method will determine the personality type based on the return array from computerPercentage method. e.g Betty Boop B percentages = [90, 15, 10, 10] ---> "ISTJ" personality type
    public static void computePercentage2(int[] percent,PrintStream output)
    {
        int i;
        int j = 50;
        output.print(" = ");
        for(i = 0; i < DIMENSIONS; i++)
            if(percent[i] < j)
                output.print("ESTJ".charAt(i));
            else if(percent[i] == j)
                output.print("X");
            else
                output.print("INFP".charAt(i));
            output.println();

    }


}
