/*
 * CS210 Chapter 9 - StudentAdvanceTicket
 * Jason Sy, 12/7/2020, Fall 2020
 *
 * Inherits from AdvanceTicket and sets it own price.
 */


public class StudentAdvanceTicket extends AdvanceTicket
{

   //Default constructor
   public StudentAdvanceTicket()
   {
      this(0, 0);
   }

   //Constructor with parameters
   public StudentAdvanceTicket(int number, int days)
   {
      super(number, days);
   }

   //return price of ticket, overrides the AdvanceTicket class
   public double getPrice()
   {
      return super.getPrice() / 2;
   }

   //toString method
   public String toString()
   {
      return super.toString() + " (Id required)";
   }

}
