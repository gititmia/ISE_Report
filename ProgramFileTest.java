public class ProgramFileTest {
    public static void testValidateBirthday() {
        assert ProgramFile.validateBirthday("29/02/2020") == true; // Valid birthday
        assert ProgramFile.validateBirthday("31/04/2021") == false; // Invalid month for day
        assert ProgramFile.validateBirthday("30/02/2022") == false; // Invalid day for month
        assert ProgramFile.validateBirthday("12/06/3000") == false; // Invalid year
    }
 
    public static void testDaysInMonth() {
        assert ProgramFile.daysInMonth(2, 2020) == 29; // Leap year
        assert ProgramFile.daysInMonth(2, 2021) == 28; // Non-leap year
        assert ProgramFile.daysInMonth(4, 2024) == 30; // April
        assert ProgramFile.daysInMonth(9, 2022) == 30; // September
        assert ProgramFile.daysInMonth(12, 2023) == 31; // December
    }
 
    public static void testIsLeapYear() {
        assert true == ProgramFile.isLeapYear(2000);
        assert false == ProgramFile.isLeapYear(2014);
        assert true == ProgramFile.isLeapYear(2024);
    }
 
    public static void testCalculateLifePathNumber() {
        assert ProgramFile.calculateLifePathNumber("01/01/1990") == 3;
        assert ProgramFile.calculateLifePathNumber("15/12/2005") == 7;
        assert ProgramFile.calculateLifePathNumber("29/02/2000") == 2;
    }

    public static void testSumOfDigits() {
        assert ProgramFile.sumOfDigits(11) == 6;
        assert ProgramFile.sumOfDigits(2005) == 9;
        assert ProgramFile.sumOfDigits(31) == 9;
    }
 
    public static void testFinalSum() {
        assert ProgramFile.finalSum(123) == 6;
        assert ProgramFile.finalSum(999) == 9;
        assert ProgramFile.finalSum(123456789) == 9;
    }
 
 
    public static void testGetLuckyColour() {
        assert ProgramFile.getLuckyColour(1).equals("Red");
        assert ProgramFile.getLuckyColour(11).equals("Silver");
        assert ProgramFile.getLuckyColour(33).equals("Crimson");
        assert ProgramFile.getLuckyColour(50).equals("Unknown");
    }
 
 
    public static void testGetGeneration() {
        assert ProgramFile.getGeneration("01/01/2015").equals("Generation Z");
        assert ProgramFile.getGeneration("15/12/1990").equals("Millennials");
        assert ProgramFile.getGeneration("29/02/1960").equals("Baby Boomers");
        assert ProgramFile.getGeneration("30/04/1945").equals("Silent Generation");
        assert ProgramFile.getGeneration("31/12/2025").equals("Unknown Generation");
    }
 
 
    public static void main(String[] args) {
        testValidateBirthday();
        testDaysInMonth();
        testIsLeapYear();
        testCalculateLifePathNumber();
        testFinalSum();
        testGetLuckyColour();
        testGetGeneration();
    }
 }
 
 
 
 