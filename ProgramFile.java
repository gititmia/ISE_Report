import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ProgramFile {
   public static void main(String[] args) {
       // Declaration of variables to store birthdays
       String birthdayOne, birthdayTwo;

       // Creating a Scanner object to read input from the console
       Scanner scanner = new Scanner(System.in);

       // Getting today's date
       LocalDate today = LocalDate.now();

       // Formatting today's date to display later
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       String formattedDate = today.format(formatter);

       // Prompting the user to enter the birthday of the 1st person and validating it
       System.out.print("Enter the birthday of the 1st person in the format DD/MM/YYYY: ");
       birthdayOne = scanner.nextLine();
       while (!validateBirthday(birthdayOne)) {
           System.out.print("Invalid format. Please enter a valid birthday in the format DD/MM/YYYY from 01/01/1901 to " + formattedDate + ": ");
           birthdayOne = scanner.nextLine();
       }

       // Prompting the user to enter the birthday of the 2nd person and validating it
       System.out.print("Enter the birthday of the 2nd person in the format DD/MM/YYYY: ");
       birthdayTwo = scanner.nextLine();
       while (!validateBirthday(birthdayTwo)) {
           System.out.print("Invalid format. Please enter a valid birthday in the format DD/MM/YYYY from 01/01/1901 to " + formattedDate + ": ");
           birthdayTwo = scanner.nextLine();
       }

       // Displaying a confirmation message that both birthdays are valid
       System.out.println("Thank you for your input. Both birthdays are valid.");
       System.out.println("==============================");
       System.out.println("Here is your birthday analysis.");

       // Calculating life path numbers, lucky colors, and generations for both persons
       int lifePathNumberOne = calculateLifePathNumber(birthdayOne);
       int lifePathNumberTwo = calculateLifePathNumber(birthdayTwo);

       String luckyColourOne = getLuckyColour(lifePathNumberOne);
       String luckyColourTwo = getLuckyColour(lifePathNumberTwo);

       String generationOne = getGeneration(birthdayOne);
       String generationTwo = getGeneration(birthdayTwo);

       // Displaying analysis results for the 1st person
       System.out.println("The life path number of the 1st person is: " + lifePathNumberOne);
       System.out.println("The lucky colour for the 1st person is: " + luckyColourOne);
       System.out.println("The generation of the 1st person is: " + generationOne);
       System.out.println("==============================");

       // Displaying analysis results for the 2nd person
       System.out.println("The life path number of the 2nd person is: " + lifePathNumberTwo);
       System.out.println("The lucky colour for the 2nd person is: " + luckyColourTwo);
       System.out.println("The generation of the 2nd person is: " + generationTwo);
       System.out.println("==============================");

       // Closing the scanner to prevent resource leaks
       scanner.close();
   }

    // Function to validate the format and range of a birthday
    public static boolean validateBirthday(String pDay) {
       String format = "^\\d{2}/\\d{2}/\\d{4}$"; // Regular expression for DD/MM/YYYY format
       if (!pDay.matches(format)) { // Checking if the input matches the required format
           return false;
       }

       String[] parts = pDay.split("/");
       int day = Integer.parseInt(parts[0]);
       int month = Integer.parseInt(parts[1]);
       int year = Integer.parseInt(parts[2]);
  
       LocalDate today = LocalDate.now();
       int currentYear = today.getYear();
       int currentMonth = today.getMonthValue();
       int currentDay = today.getDayOfMonth();
  
       if (year < 1901 || year > currentYear) { // Checking if the year is within the valid range
           return false;
       }
  
       if (year == currentYear && month > currentMonth) { // Checking if the month is valid for the current year
           return false;
       }
  
       if (year == currentYear && month == currentMonth && day > currentDay) { // Checking if the day is valid for the current month and year
           return false;
       }
  
       if (month < 1 || month > 12) { // Checking if the month is within the valid range
           return false;
       }
  
        if (day < 1 || day > daysInMonth(month, year)) { // Checking if the day is within the valid range for the given month and year
           return false;
        }
        return true; // If all conditions are met, the birthday is considered valid
    }
  
        // Function to determine the number of days in a month for a given year
        public static int daysInMonth(int pMonth, int pYear) {
           switch (pMonth) {
               case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                   return 31; // January, March, May, July, August, October, December have 31 days
               case 4: case 6: case 9: case 11:
                   return 30; // April, June, September, November have 30 days
               case 2:
                   if (isLeapYear(pYear)) {
                       return 29; // February has 29 days in a leap year
                   } else {
                       return 28; // February has 28 days in a non-leap year
                   }
               default:
                   return 0; // Invalid month
           }
       }
  
       // Function to check if a given year is a leap year
       public static boolean isLeapYear(int pYear) {
           return (pYear % 4 == 0 && pYear % 100 != 0) || (pYear % 400 == 0); // A leap year is divisible by 4 but not by 100 unless it's also divisible by 400
       }
  
       // Function to calculate the life path number from a birthday
       public static int calculateLifePathNumber(String pDay) {
           // Extracting day, month, and year from the birthday
           String[] parts = pDay.split("/");
           int day = Integer.parseInt(parts[0]);
           int month = Integer.parseInt(parts[1]);
           int year = Integer.parseInt(parts[2]);
  
           // Calculating the sum of digits for each component
           int daySum = finalSum(day);
           int monthSum = finalSum(month);
           int yearSum = finalSum(sumOfDigits(year));
  
           // Calculating the life path number and ensuring it's not 11, 22, or 33
           int lifePathNumber = daySum + monthSum + yearSum;
  
           if (lifePathNumber == 11 || lifePathNumber == 22 || lifePathNumber == 33) {
               return lifePathNumber; // Return the number if it's a master number
           } else {
               return finalSum(lifePathNumber); // Reduce to a single-digit number if not a master number
           }
       }
  
       // Function to calculate the sum of digits of a number
       public static int sumOfDigits(int pNum) {
           int sum = 0;
           if (pNum % 11 == 0) {
               return pNum; // If the number is divisible by 11, return the number itself
           }
           while (pNum > 0 && pNum % 11 != 0) {
               sum += pNum % 10; // Add the last digit to the sum
               pNum /= 10; // Remove the last digit
           }
           return sum; // Return the sum of digits
       }
  
       // Function to ensure the life path number is a single-digit number
       public static int finalSum(int pNum) {
           if (pNum % 11 == 0) {
               return pNum; // If the number is divisible by 11, return the number itself
           }
           while (pNum >= 10) {
               pNum = sumOfDigits(pNum); // Reduce the number to a single-digit number
           }
           return pNum; // Return the final single-digit number
       }
  
       // Function to determine the lucky color based on the life path number
       public static String getLuckyColour(int pNum) {
           // Using a switch statement to assign a lucky color based on the life path number
           switch (pNum) {
               case 1: return "Red";
               case 2: return "Orange";
               case 3: return "Yellow";
               case 4: return "Green";
               case 5: return "Sky Blue";
               case 6: return "Indigo";
               case 7: return "Violet";
               case 8: return "Magenta";
               case 9: return "Gold";
               case 11: return "Silver";
               case 22: return "White";
               case 33: return "Crimson";
               default: return "Unknown";
           }
       }
  
       // Function to determine the generation based on the birth year
       public static String getGeneration(String pBirthday) {
           // Extracting the year from the birthday
           String[] parts = pBirthday.split("/");
           int pYear = Integer.parseInt(parts[2]);
  
           // Determining the generation based on the range
           if (pYear >= 1901 && pYear <= 1945 ) {
               return "Silent Generation";
           }
           else if (pYear >= 1946 && pYear <= 1964) {
               return "Baby Boomers";
           }
           else if (pYear >= 1965 && pYear <= 1979) {
               return "Generation X";
           }
           else if (pYear >= 1980 && pYear <= 1994) {
               return "Millennials";
           }
           else if (pYear >= 1995 && pYear <= 2009) {
               return "Generation Z";
           }
           else if (pYear >= 2010 && pYear <= 2024) {
               return "Generation Alpha";
           }
           else {
               return "Unknown Generation";
           }
       }
   }
  
