// CS210 BC
public class TicketTester {
// testing code for Ticket Classes
// BJP text Exercises, Chapter 9
   public static void main(String[] args) {
      Ticket[] scam = new Ticket[15]; // an array of Tickets that don't exist
      for (Ticket tick: scam) {
         tick = new WalkupTicket(); // actually calls a constructor for each
      }
   
   //ticket number 10 is attempted, purchased 20 days in advance
      AdvanceTicket one = new AdvanceTicket(10, 20); 
   
   // one.setNumber(17); // not allowed, no such method, keeps # unique
      System.out.println(one); // with above, Number: 15, Price: 30.0
      System.out.println("Number of days: " + one.getDays());
   
   // calls this(0,0);This will have number = 16
      System.out.println(new AdvanceTicket()); //output should be Number: 16, Price: 40.0
   
   
   // #2 attempted, but number 2 not available, ticket number set to next available number (17)
      WalkupTicket two = new WalkupTicket(2); 
      System.out.println(two); // output should be Number: 17, Price: 50.0
      //System.out.println("Number of days: " + two.getDays());// should not compile no getDays method on WalkupTicket class
      System.out.println(new WalkupTicket()); // calls this(0); This will get number = 18

      StudentAdvanceTicket three = new StudentAdvanceTicket(99,9); // 99 is availalbe, number= 99
      System.out.println(three); // Number: 99, (use toString from Ticket) add (ID Required)
      System.out.println("Number of days: " + three.getDays()); // should print 9
      System.out.println(new StudentAdvanceTicket()); // must call this(0,0); Number will be set to 19
   
      try {
                StudentAdvanceTicket trouble = new StudentAdvanceTicket(123,-5);
                System.out.println("Expected IllegalArgumentException not seen?");
      }
      catch (IllegalArgumentException e) {
                System.out.println("Exception: " + e);
      }
      StudentAdvanceTicket last = new StudentAdvanceTicket(99, 15); // 99 already used? Number set to 100
      System.out.println(last); // with above, Number: 100, Price: 15.0 (Id required)
   }
}
