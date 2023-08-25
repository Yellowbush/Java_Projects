/*
 * CS210 Chapter 8b - Date
 * Jason Sy, 12/1/2020, Fall 2020
 *
 * Class to read day, month and year.
 */


public class Date
{
    //Private fields
    private int day;
    private int month;
    private int year;

    //private static final int for days of month Jan - Dec, and string to hold names of months given the number of month
    private static final int[] DaysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] MonthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    //Default constructor
    public Date()
    {
        this(1970, 1, 1);
    }

    //Constructor with parameters representing year/month/day
    public Date(int year, int month, int day)
    {
        setDate(year, month, day);
    }

    //addDays method can subtract days or weeks for negative parameters passed.
    public void addDays(int days)
    {
        for(int i=0; i<days; i++)
        {
            if(this.day < DaysOfMonth[this.month - 1])
            {
                this.day++;
            }
            else
            {
                this.day = 1;
                if(this.month == 12)
                {
                    this.month = 1;
                    this.year++;
                }
                else
                {
                    this.month++;
                }
            }
        }
        for(int i = days; i < 0; i++)
        {
            if(this.day > 1)
            {
                this.day--;
            }
            else
            {
                if(this.month == 1)
                {
                    this.month = 12;
                    this.year--;
                }
                else
                {
                    this.month--;
                }
                this.day = DaysOfMonth[this.month - 1];
            }
        }

    }

    //addWeeks method can subtract days or weeks for negative parameters passed by calling addDays method
    public void addWeeks(int weeks)
    {
        int days = weeks * 7;
        addDays(days);
    }

    //mutator checks if input is valid
    public void setDate(int year, int month, int day)
    {
        isDateValid(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //helper method that checks if the date is valid
    public void isDateValid(int year, int month, int day)
    {
        if(year < 1)
        {
            throw new IllegalArgumentException();
        }
        if(month < 1 || month > 12)
        {
            throw new IllegalArgumentException();
        }
        if(isLeapYear(year) && month == 2)
        {
            if(day < 1 || day > 29)
            {
                throw new IllegalArgumentException();
            }
        }
        else
        {
            if(day < 1 || day > DaysOfMonth[month - 1])
            {
                throw new IllegalArgumentException();
            }
        }
    }

    // longDate method
    public String longDate()
    {
        return MonthNames[month - 1] + " " + day + ", " + year;
    }

    //Static version of daysTo
    public static int daysTo(Date one, Date two)
    {
        return one.daysTo(two);
    }

    //daysTo method
    public int daysTo(Date d)
    {
        int days = calculate(d);
        days = days - calculate(this);
        if(days < 0)
        {
            days++;
        }
        return days;
    }

    //Calculates total days passed till 1200/01/01, because 1200 is a leapyear and is divisible by 400 which allows for calculation of days for years and leap year days.
    private int calculate(Date d) {
        int days = 0;
        days = days + ((d.year - 1200) * 365);
        days = days + ((d.year - 1200) / 4) + ((d.year - 1200) / 400);
        days = days - ((d.year - 1200) / 100);
        for(int i = 1; i < d.month; i++) {
            days = days + DaysOfMonth[i];
        }
        days = days + d.day;
        return days;
    }

    //Accessors
    public int getDay()
    {
        return day;
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }

    //LeapYear method
    public boolean isLeapYear()
    {
        return isLeapYear(this.year);
    }

    private boolean isLeapYear(int year)
    {
        if(year % 400 == 0)
        {
            return true;
        }
        else if(year % 100 == 0)
        {
            return false;
        }
        else if(year % 4 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //toString method
    public String toString()
    {
        return "" + year + "/" + month + "/" + day;
    }


}
