/*
 * CS210 Chapter 9 - WalkupTicket
 * Jason Sy, 12/7/2020, Fall 2020
 *
 * Will try to set up its own value
 */


public class WalkupTicket extends Ticket
{

   //Default constructor
   public WalkupTicket()
   {
      this(0);
   }

   //Constructor with parameters
   public WalkupTicket(int number)
   {
      super(number);
   }

   //returns the price of ticket, overrides base class Ticket.
   public double getPrice()
   {
      return 50;
   }

}
