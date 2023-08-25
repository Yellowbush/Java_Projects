/*
 * CS210 Chapter 9 - AdvanceTicket
 * Jason Sy, 12/7/2020, Fall 2020
 *
 * Class will set up the price and days in advance for the ticket
 */


public class AdvanceTicket extends Ticket
{
   //Instance Variable
   private int days;

   //Default constructor
   public AdvanceTicket()
   {
      this (0, 0);
   }

   //Constructor with parameters
   public AdvanceTicket(int number, int days)
   {
      super(number);
      if(days < 0)
         throw new IllegalArgumentException("Days cannot be negative");
      this.days = days;
   }

   //return price of ticket, overrides base class Ticket.
   public double getPrice()
   {
         if(days >= 10)
         {
            return 30;
         }
         else
         {
            return 40;
         }
   }

   //return number of days
   public int getDays()
   {
         return days;
   }

}


