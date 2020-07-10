/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcode;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Random;
import javacode.CalcResult;
import org.junit.Test;
import junit.framework.TestCase; 

/**
 *
 * @author Julia
 */
public class CalcResultTest {
    CalcResult result = new CalcResult();
    Random ran = new Random(); 
    
    @Test
    public void testResult(){
        for(int i=0; i<100; i++){
            //year[1900,2500]
            int year1 = 1900 + (int)(Math.random() * ((2500 - 1900) + 1));
            int year2 = 1900 + (int)(Math.random() * ((2500 - 1900) + 1));
            //month[1,12]
            int month1 = ran.nextInt(12) + 1;
            int month2 = ran.nextInt(12) + 1;
            /*day 1.3.5.7.8.10.12 -> 31
            **    4.6.9.11 -> 30
            **    2 -> 28
            */
            int day1 = showDays(month1);
            int day2 = showDays(month2);
            int[] array1 = {year1,month1,day1};
            int[] array2 = {year2,month2,day2};

            LocalDate startDate = LocalDate.of(array1[0], array1[1], array1[2]);
            LocalDate endDate = LocalDate.of(array2[0], array2[1], array2[2]);
            long noOfDaysBetween = DAYS.between(startDate, endDate);
            
            TestCase.assertTrue(result.result(array1, array2)==Math.abs(noOfDaysBetween));

        }
    }
    
    public int showDays(int month){
        if(month == 2) return ran.nextInt(28) + 1;
        else if(month==4 || month==6 || month==9 || month==11) return ran.nextInt(30) + 1;
        else return ran.nextInt(31) + 1;
    }
    
    
}
