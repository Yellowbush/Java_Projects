/*
 * CS210 Chapter 8 - Dog class
 * Jason Sy, 11/23/2020, Fall 2020
 *
 * Dog class that a DogMain client program can use to interact with a Dog.
 */


public class Dog
{
    //Private fields
    private String name;
    private String color;
    private boolean isHungry;
    private double weight;

    //Default constructor
    public Dog()
    {
        name = "Tommy";
        color = "Brown";
        isHungry = true;
        weight = Double.parseDouble("10.0");

    }

    //Constructor with three arguments
    public Dog(String name, String color, double weight)
    {
        this.name = name;
        this.color = color;
        this.isHungry = true;
        this.weight = weight;
    }

    //Accessor for private field name
    public String getName()
    {
        return name;
    }

    //Accessor for private field color
    public String getColor()
    {
        return color;
    }

    //Accessor for private field weight
    public double getWeight()
    {
        return weight;
    }

    //Accessor for private field isHungry
    public String getIsHungry()
    {
        if (this.isHungry == true)
            return "is hungry.";
        else
            return "is not hungry.";
    }

    //setName mutator for name field.
    public void setName(String getName)
    {
        this.name = getName;
    }

    //bark method
    public void bark()
    {
        String b = this.name + ": Woof Woof";
        System.out.println(b);
    }

    //eat method
    public void eat()
    {
        String e = this.name + ": Chomp Chomp";
        double z = 0.1;
        this.isHungry = false;
        this.weight += z;
        System.out.println(e);
    }

    //walk method
    public void walk()
    {
        String f = this.name + ": Step Step";
        double z = 0.1;
        if (this.isHungry != true) {
            this.weight -= z;
            this.isHungry = true;
            System.out.println(f);
        }
        else {
            bark();
        }

    }

    //toString method
    public String toString()
    {
        return (getName() + ": " + getColor() + " in color weighs " + getWeight() + " kgs and " + getIsHungry());
    }


}
