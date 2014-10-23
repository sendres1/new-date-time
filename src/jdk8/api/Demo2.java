package jdk8.api;

import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
                  
public class Demo2 {

    public static void main(String[] args) {
        // Get current date and time
        LocalDateTime date = LocalDateTime.now();
        System.out.println("Current date/time with built-in LocalDateTime class format: " + date);

        // Now use new DateTimeFormatter class
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
        String strDate = date.format(format);
        System.out.println("Current date/time with custom format provided by DateTimeFormatter: " + strDate);

        // Just get Dates without time values and calculate payday
        format = DateTimeFormatter.ofPattern("MMM d yyyy");
        LocalDate today = LocalDate.now();
        LocalDate payday1 = today.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate payday2 = today.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
        System.out.println("Pretend Payday is at the end of this month: " + payday1.format(format));
        System.out.println("Pretend Payday is at the end of this month, less two days: " + payday2.format(format));

        // What else can you do? Do some research and share with class. You have one hour!
    
        int dayInMonth = DateFormat.DAY_OF_WEEK_IN_MONTH_FIELD;  
        int dayOfWeek = DateFormat.DAY_OF_WEEK_FIELD;
        System.out.println("day " + dayInMonth);
        System.out.println("day " + dayOfWeek);
    
        LocalDate payday3 = today.with(TemporalAdjusters.lastInMonth(DayOfWeek.SATURDAY));
        LocalDate payday4 = today.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        
      // int  = today.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        
        LocalDate tryit = today.withMonth(12);  
        System.out.println("tryit " + tryit);
        
        // get last working day of month
        LocalDate today2 = LocalDate.now();
        
        LocalDate lastBusinessDay =
                today.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
        System.out.println("last business day of month " + lastBusinessDay.getDayOfMonth());
        
        System.out.println("last saturday" + payday3);
        System.out.println("last sunday" + payday4);
        
        LocalDate.of(2012, Month.DECEMBER, 12); // from values
        
       // LocalDate dow = LocalDate.of(dayOfWeek, LocalDate., dayInMonth);
        
        //System.out.println("DOW " + dow);
        
             
        
    
    }
    
    
//    // ----------------------------------------------------------------------
//private static DateTime LastDayOfMonth( int year, int month )
//{
//  return new DateTime( year, month, DateTimeFormatInfo.CurrentInfo.Calendar.GetDaysInMonth( year, month ) );
//} // LastDayOfMonth
//
//// ----------------------------------------------------------------------
//private static bool IsLastDayOfMonth( DateTime test )
//{
//  DateTime lastDayOfMonth = LastDayOfMonth( test.Year, test.Month );
//  return test.Day == lastDayOfMonth.Day;
//} // IsLastDayOfMonth
//
//// ----------------------------------------------------------------------
//private static bool IsLastWorkingDayOfMonth( DateTime test )
//{
//  DateTime lastWorkingDayOfMonth = LastDayOfMonth( test.Year, test.Month );
//  while ( lastWorkingDayOfMonth.DayOfWeek == DayOfWeek.Saturday || 
//    lastWorkingDayOfMonth.DayOfWeek == DayOfWeek.Sunday )
//  {
//    lastWorkingDayOfMonth = lastWorkingDayOfMonth.AddDays( -1 );
//  }
// 
//  return test.Day == lastWorkingDayOfMonth
//    
//    
//}

}
