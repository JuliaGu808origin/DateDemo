/*
 * View send two dates array to this class
 * To use this class method to calculate and return the result
 * 
 */
package javacode;

/**
 *
 * @author Julia
 */
public class CalcResult {
    public int result(int[] array1, int[] array2){
        int year1 = array1[0];
        int year2 = array2[0];
        int month1 = array1[1];
        int month2 = array2[1];
        int day1 = array1[2];
        int day2 = array2[2];
        int days = 0;
        int startDays =0;
        int endDays =0;
        
        int[] endArray = new int[]{};
        int[] startArray = new int[]{};
        
        if(year1!=year2){
            if(year1>year2){
                endArray = array1;
                startArray = array2;              
            }
            else{
                endArray = array2;
                startArray = array1;
            }
            startDays = startArray[2] + calcDaysByYear(startArray, endArray);
            endDays = endArray[2];
            days = calcDaysByYear(startArray, endArray) - (startArray[2]-1);
        }
        else{
            if(month1!=month2){
                if(month1>month2){
                    endArray = array1;
                    startArray = array2;                    
                }
                else{
                    endArray = array2;
                    startArray = array1;
                }
                int monthDays = calcMonthDays(isLeapYear(year1), startArray[1], endArray);
                days = monthDays - (startArray[2]-1);   
            }
            else if(month1==month2){
                days = day1 - day2;
            }
        }
        return days;
    }
    
    public boolean isLeapYear(int year){
        if(year%4 == 0 && year%100 != 0){
            return true;
        }
        else if(year%100 == 0 && year%400 == 0){
            return true;
        }
        else{
            return false;
        }               
    }
  
    public int calcMonthDays(boolean isLeapYear, int startMonth, int[] endMonth){
        int days = 0;
        boolean isEndMonth = false;
        for(int i = startMonth; i <= endMonth[1]; i++){
            if(i == endMonth[1]) isEndMonth = true;
                if(!isEndMonth){
                    if(isLeapYear && i == 2) days += 29;
                    else if(!isLeapYear && i == 2) days += 28;
                    else if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12) days += 31;
                    else days += 30;                      
                }
                else{
                    days = days + endMonth[2] -1;
                }
        }        
        return days;        
    }   
    
    public int calcDaysByYear(int[] start, int[] end){
        boolean isStart = true;
        boolean isEnd = false;
        boolean isEndMonth = false;
        int days = 0;
        for(int i = start[0]; i <= end[0]; i++){
            if(i != start[0]) isStart = false;
            if(i == end[0]) isEnd = true;
            if(isStart){
                for(int j = start[1]; j <= 12; j++){
                    if(isLeapYear(i) && j == 2) days += 29;
                    else if(!isLeapYear(i) && j == 2) days += 28;
                    else if(j==1 || j==3 || j==5 || j==7 || j==8 || j==10 || j==12) days += 31;
                    else days += 30;                        
                }               
            }
            else if(isEnd){
                for(int j = 1; j <= end[1]; j++){
                    if(j == end[1]) isEndMonth = true;
                    if(!isEndMonth){
                        if(isLeapYear(i) && j == 2) days += 29;
                        else if(!isLeapYear(i) && j == 2) days += 28;
                        else if(j==1 || j==3 || j==5 || j==7 || j==8 || j==10 || j==12) days += 31;
                        else days += 30;                       
                    }
                    else{
                        days = days + end[2] -1;
                    }
                }                 
            }
            else{
                for(int j = 1; j <= 12; j++){
                    if(isLeapYear(i) && j == 2) days += 29;
                    else if(!isLeapYear(i) && j == 2) days += 28;
                    else if(j==1 || j==3 || j==5 || j==7 || j==8 || j==10 || j==12) days += 31;
                    else days += 30;
                } 
            }
        }
        return days;
    }
    
}
