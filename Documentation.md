# Doan_Bao_Tram_Tran_21892327_ISE_Report

# Numerology Application Report

## Table of Contents
1. [Overview](#overview)
2. [Introduction](#introduction)
    - [Developer Information](#developer-information)
    - [Program Overview](#program-overview)
3. [Module Descriptions](#module-descriptions)
4. [Modularity](#modularity)
    - [Description of Module Usage](#description-of-module-usage)
    - [Functioning of the Program](#functioning-of-the-program)
    - [Cohesion](#cohesion)
    - [Redundancy](#redundancy)
    - [Coupling](#coupling)
    - [Control Flags](#control-flags)
    - [Screenshot of Production Code Running](#screenshot-of-production-code-running)
    - [Review Checklist](#review-checklist)
5. [Blackbox Testing](#blackbox-testing)
6. [Whitebox Testing](#whitebox-testing)
7. [Test Implementation and Test Execution](#test-implementation-and-test-execution)
8. [Summary of my Work](#summary-of-my-work)
9. [Discussion](#discussion)

## Overview
1. Cover Page
2. Introduction
3. Module Descriptions
4. Modularity
5. Blackbox Testing
6. Whitebox Testing
7. Test Implementation and Test Execution
8. Summary
9. Version Control
10. Discussion

## Introduction
### Developer Information
* Assessment name: DoanBaoTramTran_21892327_ISEReport
* Full name: Doan Bao Tram Tran
* Curtin Student ID: 21892327
* Practical class (date/time): Thursday, 2:00 PM - 4:00 PM 

### Program Overview
This report is based on the Numerology Application, a program that performs various numerology calculations and operations based on a person's date of birth, providing users with their Life Path Number (LPN), Lucky Colour, and the generation they belong to based on their date of birth.

The report covers module descriptions, modularity principles, black box and white box testing, test implementation, and test execution for both scenarios.

Version Control System (VCS) is applied to keep track of the project. Progress can be tracked in the .git file.

## Module Descriptions
**1. Submodule: validateBirthday** <br>
Imports: pDay (String) <br>
Exports: result (boolean)

This module takes pDay (String) as input and returns a result of true or false (boolean) based on whether pDay adheres to the "DD/MM/YYYY" format. The method works in the follwing steps: 
1. Receive pDay as a string.
2. Use regular expressions to check if pDay is in the format "DD/MM/YYYY".
3. Split pDay into day, month, and year, and check the accuracy of each part and range validity (01/01/1901 to current date). 
4. Return false if any of the conditional statements aren't met, and true if they all pass. 

**2. Submodule: daysInMonth** <br>
Imports: pMonth (int), pYear (int) <br>
Exports: result (int)

This module takes pMonth and pYear as input and returns the number of days in the given pMonth. It also uses pYear and isLeapYear() to account for leap year exception. The method works in the follwing steps: 
1. Receive pMonth (int) and pYear (int).
2. Use switch-case to return a number of days according to months: months with 31 days, months with 30 days, and 28 or 29 days in February (using isLeapYear() to check for leap year).
3. Return 0 in case of default.

**3. Submodule: isLeapYear** <br>
Imports: pYear (int) <br>
Exports: result (boolean)

This method takes pYear as input and returns true or false whether year is a leap year. A year is a leap year if it is divisible by 4 but not by 100, OR is divisible by 400. The method works in the follwing steps: 
1. Receive pYear (int).
2. Return a result of true or false (boolean) based on whether pYear is a leap year: TRUE if pYear is divisible by 4 but not by 100, OR TRUE is divisible by 400, and FALSE if else. 

**4. Submodule: calculateLifePathNumber** <br>
Imports: pDay (String) <br>
Exports: lifePathNumber (int)

This module takes pDay as input and calculates the Life Path Number (LPN) by splitting pDay into day, month, and year, then sum and reduces the sum to a single digit number, or leave as is if the sum is one of the master numbers: 11, 22, 33. The method works in the following steps:
1. Receive pDay as a string.
2. Split pDay into variables day (int), month (int), and year (int) using "/" as a separator.
3. Use finalSum() to calculate each of the values of day (int), month (int), and year, and store the values in daySum (int), monthSum (int), and yearSum (int) respectively.
4. Sum up daySum (int), monthSum (int), and yearSum (int), and store the value in lifePathNumber (int).
5. Return lifePathNumber if it is a master number (11, 22, 33). If not, use finalSum() to reduce it to a single-digit value, and return the final value. 

**5. Submodule: sumOfDigits** <br>
Imports: pNum (int) <br>
Exports: sum (int)

This method takes pNum as input and returns the sum of the digits in pNum. The method works in the following steps:
1. Receive pNum as an integer.
2. Initialise sum (int) with a value of 0.
3. Check pNum, if pNum is divisible by 11, return it directly.
4. Sum the digits of pNum while pNum is greater than 0 and not divisible by 11.
5. Use division to add the last digit of pNum to sum and it from pNum. Continue until there is no digits left
6. Return the computed sum of digits

**6. Submodule: finalSum** <br>
Imports: pNum (int) <br>
Exports: sum (int)

This method takes pNum as input and returns the final sum to determine the Life Path Number. The method works in the following steps:
1. Receive pNum as an integer. 
2. If pNum is divisible by 11, return it directly. If not, proceed to the next step.
3. Continuously sum the digits until pNum is reduced to a single-digit number.
4. Return the final single-digit number.

**7. Submodule: getLuckyColour** <br>
Imports: pNum (int) <br>
Exports: result (String)

This method takes pNum as input and returns a specific lucky colour based on pNum. The method works in the following steps:
1. Receive pNum as an integer.
2. Use switch-case to assign pNum values to their own colours and return them. 1 is Red, 2 is Orange, 3 is Yellow, 4 is Green, 5 is Sky Blue, 6 is Indigo, 7 is Violet, 8 is Magenta, 9 is Gold, 11 is Silver, 22 is White, and 33 is Crimson.
3. Return "Unknown" in case of default.

**8. Submodule: getGeneration** <br>
Imports: pBirthday (String) <br>
Exports: result (String)

This method takes pBirthday as a string and returns the generation a person was born in based on pBirthday. The method works in the following steps:
1. Receive pBirthday as a string.
2. Split pBirthday using "/" to get the day, month, and year parts.
3. Parse the year (the third element in the array) to an integer, stored in variable named *year*.
4. Determine the generation based on the year and return the corresponding generation name. If year is between these years (inclusive on both ends), return the corresponding value: 
* 1901 - 1945: "Silent Generation"
* 1946 - 1964: "Baby Boomers"
* 1965 - 1979: "Generation X"
* 1980 - 1994: "Millenials"
* 1995 - 2009: "Generation Z"
* 2010 - 2024: "Generation Alpha"
5. Return "Unknown Generation" if the year does not match any predefined ranges.

## Modularity
### Description of Module Usage
**1. validateBirthday()** is used to validate the format and accuracy of a birthday. <br>
**2. daysInMonth()** is used to check and the days in a month, with inclusion of leap year. <br>
**3. isLeapYear()** is used to check if a year is a leap year. <br>
**4. calculateLifePathNumber()** is used to calculate the Life Path Number based on a person's birthday. <br>
**5. sumOfDigits()** is used to calculate the sum of the digits in a number. <br>
**6. finalSum()** is used to calculate the final sum of a number, leading to the Life Path Number. <br>
**7. getLuckyColour()** is used to determine a person's lucky colour based on their Life Path Number. <br>
**8. getGeneration()** is used to determine the generation a person was born in based on their birth year.

NOTES:
- All inputs are entered using the keyboard, as I believe it would be the most convenient way for users to enter data.
- All outputs are showed through the terminal, as I believe it would be the most convenient way to show results to users.

### Functioning of the Program
To run the program, execute the following command:

git clone 
cd 
javac
java 

The program will ask questions on your birthday. Follow the prompts to enter the required inputs and view the results.

### Cohesion
Cohesion refers to how well the components within a module are related to each other. Higher cohesion means that the functions within the module are closely related to each other, performing a specific task or a set of related tasks. 

- The code demonstrates good cohesion as each method (function) performs a specific task related to the overall functionality of the program.
- For example, `validateBirthday`, `daysInMonth`, `isLeapYear`, `calculateLifePathNumber`, `sumOfDigits`, `finalSum`, `getLuckyColour`, and `getGeneration` all perform distinct and well-defined tasks related to date validation, numerology calculations, and generation determination. Each method performs a specific task related to the overall functionality of the program, contributing to its readability and maintainability.

### Redundancy
Redundancy refers to the repetition of code or the presence of duplicate functionality within the program. Redundancy should be minimised to improve maintainability and readability.

- The code demonstrates minimal redundancy. For instance, the date validation logic is centralised within the `validateBirthday` method, avoiding repetition.
- The code has avoided repeating code by encapsulating common operations within separate methods and reusing them when needed.

### Coupling
Coupling refers to the degree of interdependence between modules or components in a system. Low coupling is desirable as it promotes modularity and ease of maintenance.

- The code exhibits low coupling as each method encapsulates specific functionality without relying heavily on the implementation details of other methods.
- Methods communicate primarily through well-defined parameters and return values rather than direct manipulation of shared variables or global state.

### Control Flags
Control flags are variables or conditions used to control the flow of execution within a program. Excessive use of control flags can make code harder to understand and maintain.

The program utilises control flags to guide user input validation. For example, the `validateBirthday()` method employs control flags to ensure that users input birthdays within the specified format and range. By providing informative error messages and prompting users to re-enter invalid inputs, user experience is enhanced and error handling is implemented within the program.

### Screenshot of Production Code Running
[Screenshot 1: Production Code Running](Screenshot_1.png)

### Review checklist
**1. Submodule: validateBirthday()**

| Item | Review checklist related to modularity | Yes/No | Explanation on results |
|------|-------------------------------------------|--------|-----------------------------------------------|
| 1    | Is the validateBirthday() module correctly validating the format and accuracy of the birthday string? | Yes  | The validateBirthday() module is correctly validating the format and accuracy of the birthday string. |
| 2    | Are all possible edge cases considered during validation? | Yes | All possible edge cases are considered during validation. |
| 3    | Does the code contain control flags?     | Yes | There are a few control flags to control the flow of the module. |
| 4    | Does the module or perform a single, well-defined task? | Yes | The module is performing one single well-defined task. |
| 5    | Does the code contain global variables?  | No     | There is no global variables in the module, as they can lead to unintended side effects and decrease code maintenance. |
| 6    | Is there any redundant code?       | No | There is no redundant code, as it can lead to maintenance overhead and can lead to code inconsistency. |

**Refactoring decisions after review checklist:** None

**2. Submodule: daysInMonth()** 

| Item | Review checklist related to modularity | Yes/No | Explanation on results |
|------|-------------------------------------------|--------|-----------------------------------------------|
| 1    | Is the daysInMonth() module accurately returning the number of days in a given month and year? | Yes  | daysInMonth() is accurately returning the number of days in a given month and year |
| 2    | Are edge cases for February considered in daysInMonth()? | Yes | Edge cases for February are properly considered in daysInMonth() using isLeapYear().
| 3    | Does the code contain control flags?     | No | The logic is straightforward without the need for control flags. |
| 4    | Does the module or perform a single, well-defined task? | Yes | The module is performing one single well-defined task. |
| 5    | Does the code contain global variables?  | No     | There is no global variables in the module, as they can lead to unintended side effects and decrease code maintenance. |
| 6    | Is there any redundant code?       | No | There is no redundant code, as it can lead to maintenance overhead and can lead to code inconsistency. |

**Refactoring decisions after review checklist:** None

**3. Submodule: isLeapYear()**

| Item | Review checklist related to modularity | Yes/No | Explanation on results |
|------|-------------------------------------------|--------|-----------------------------------------------|
| 1    | Is the logic for determining a leap year clear and concise in the module? | Yes  | the logic for determining a leap year clear and concise in the module. |
| 2    | Are unit tests covering all different months, years, and leap years? | Yes | Unit tests are covering different months, years, and leap years.|
| 3    | Does the code contain control flags?     | No | The logic is straightforward without the need for control flags. |
| 4    | Does the module or perform a single, well-defined task? | Yes | The module is performing one single well-defined task. |
| 5    | Does the code contain global variables?  | No     | There is no global variables in the module, as they can lead to unintended side effects and decrease code maintenance. |
| 6    | Is there any redundant code?       | No | There is no redundant code, as it can lead to maintenance overhead and can lead to code inconsistency. |

**Refactoring decisions after review checklist:** None

**4. Submodule: calculateLifePathNumber()**

| Item | Review checklist related to modularity | Yes/No | Explanation on results |
|------|-------------------------------------------|--------|-----------------------------------------------|
| 1    | Do the sum of numbers lead to the correct life path number? | Yes  | The sum of numbers lead to the correct life path number. |
| 2    | Is the reduction of the final sum to a single digit with exceptions implemented correctly? | Yes | The reduction of the final sum to a single digit with exceptions are implemented correctly.|
| 3    | Does the code contain control flags?     | No | The logic is straightforward without the need for control flags. |
| 4    | Does the module or perform a single, well-defined task? | Yes | The module is performing one single well-defined task. |
| 5    | Does the code contain global variables?  | No     | There is no global variables in the module, as they can lead to unintended side effects and decrease code maintenance. |
| 6    | Is there any redundant code?       | No | There is no redundant code, as it can lead to maintenance overhead and can lead to code inconsistency. |

**Refactoring decisions after review checklist:** None

**5. Submodule: sumOfDigits()**

| Item | Review checklist related to modularity | Yes/No | Explanation on results |
|------|-------------------------------------------|--------|-----------------------------------------------|
| 1    | Are the digits summed in a clear and concise logic? | Yes  | The digits are summed in a clear and concise logic. |
| 2    | Is the reduction of the final sum to a single digit with exceptions implemented correctly? | Yes | The reduction of the final sum to a single digit with exceptions are implemented correctly.|
| 3    | Does the code contain control flags?     | No | The logic is straightforward without the need for control flags. |
| 4    | Does the module or perform a single, well-defined task? | Yes | The module is performing one single well-defined task. |
| 5    | Does the code contain global variables?  | No     | There is no global variables in the module, as they can lead to unintended side effects and decrease code maintenance. |
| 6    | Is there any redundant code?       | No | There is no redundant code, as it can lead to maintenance overhead and can lead to code inconsistency. |

**Refactoring decisions after review checklist:** As stated in the module below.

**6. Submodule: finalSum()**

| Item | Review checklist related to modularity | Yes/No | Explanation on results |
|------|-------------------------------------------|--------|-----------------------------------------------|
| 1    | Are the digits properly summed up? | Yes  | The digits are properly summed up. |
| 2    | Is the reduction of the final sum to a single digit with exceptions implemented correctly? | Yes | The reduction of the final sum to a single digit with exceptions are implemented correctly.|
| 3    | Does the code contain control flags?     | No | The logic is straightforward without the need for control flags. |
| 4    | Does the module or perform a single, well-defined task? | Yes | The module is performing one single well-defined task. |
| 5    | Does the code contain global variables?  | No     | There is no global variables in the module, as they can lead to unintended side effects and decrease code maintenance. |
| 6    | Is there any redundant code?       | No | There is no redundant code, as it can lead to maintenance overhead and can lead to code inconsistency. |

**Refactoring decisions after review checklist:** Decided to refactor the module after this checklist. The previous module was too complex and was a collaboration of sumOfDigits() and finalSum(), which led to difficulties in module calling and cohesion. Committed the change into a branch named "refactor-branch" and merged it into production code.

**7. Submodule: getLuckyColour()**

| Item | Review checklist related to modularity | Yes/No | Explanation on results |
|------|-------------------------------------------|--------|-----------------------------------------------|
| 1    | Is the getLuckyColour() method correctly assigning lucky colours based on life path numbers? | Yes  | The getLuckyColour() method is correctly assigning lucky colours based on life path numbers. |
| 2    | Are unit tests covering each life path number and its associated colour? | Yes | Unit tests are covering each life path number and its associated colour. |
| 3    | Does the code contain control flags?     | No | The logic is straightforward without the need for control flags. |
| 4    | Does the module or perform a single, well-defined task? | Yes | The module is performing one single well-defined task. |
| 5    | Does the code contain global variables?  | No     | There is no global variables in the module, as they can lead to unintended side effects and decrease code maintenance. |
| 6    | Is there any redundant code?       | No | There is no redundant code, as it can lead to maintenance overhead and can lead to code inconsistency. |

**Refactoring decisions after review checklist:** None

**8. Submodule: getGeneration()**

| Item | Review checklist related to modularity | Yes/No | Explanation on results |
|------|-------------------------------------------|--------|-----------------------------------------------|
| 1    | Is the getGeneration() module accurately determining the generation based on the birth year? | Yes  | The getGeneration() module is accurately determining the generation based on the birth year. |
| 2    | Are edge cases fully considered in this module? | Yes | Edge cases are fully considered in this module. |
| 3    | Does the code contain control flags?     | No | The logic is straightforward without the need for control flags. |
| 4    | Does the module or perform a single, well-defined task? | Yes | The module is performing one single well-defined task. |
| 5    | Does the code contain global variables?  | No     | There is no global variables in the module, as they can lead to unintended side effects and decrease code maintenance. |
| 6    | Is there any redundant code?       | No | There is no redundant code, as it can lead to maintenance overhead and can lead to code inconsistency. |

**Refactoring decisions after review checklist:** None

## Blackbox Testing
Black box testing techniques, such as Equivalence Partitioning (EP) and Boundary Value Analysis (BVA), have been applied to test the program’s functionality.

**1. Submodule: validateBirthday** <br>
Imports: pDay (String) <br>
Exports: result (boolean) 

- Module used: Equivalence Partitioning & Boundary Value Analysis
- Reason for choosing model(s): Equivalence Partitioning is suitable for complex input coverage, ensuring various scenarios are tested, while Boundary Value Analysis focuses on critical edge cases and may be more efficient for modules with specific boundaries or constraints. They both apply for this module.
- Test prompt: Validate the format and accuracy of the entered birthday string in the format DD/MM/YYYY. The day must be within 1 and 31 and be coherent with the corresponding month, including leap year cases. Month varies from 1 to 12. Year varies from 1901 to the current year - 2024 (inclusive). Include tests for leap years. Return "true" for valid inputs and "false" otherwise.

**Equivalence Partitioning**

| Category                 | Test Data       | Expected Result |
|--------------------------|-----------------|-----------------|
| pDay sample valid day              | `15/08/1995`    | true            |
| pDay as the first day of a year    | `01/01/2020`    | true            |
| pDay as the last day of a year     | `31/12/2023`    | true            |
| pDay as invalid input              | `Tran`               | false           |
| pDay format: DD-MM-YYYY   | `15-08-1995`   | false           |
| pDay format: DDMMYYYY     | `15081995`     | false           |
| pDay format: YYYY/MM/DD   | `1995/08/15`   | false           |
| pDay format: DD-MM-YYYY with insufficient digits in day | `5/08/1995`     | false           |
| pDay format: DD-MM-YYYY with insufficient digits in month  | `15/8/1995`     | false           |
| pDay format: DD-MM-YYYY with insufficient digits in year | `15/08/199`     | false           |
| pDay day: day > 31      | `32/01/2000`   | false           |
| pDay day for February: day ≠ 29  | `30/02/2000`    | false           |
| pDay day for months that have 30 days: day > 30  | `31/04/2000`    | false           |
| pDay month: month > 12       | `15/13/2000`    | false           |
| pDay month: month < 1        | `15/00/2000`    | false           |
| pDay year: year < 1901       | `15/08/1080`    | false           |
| pDay year: year > 2024       | `15/08/2025`    | false           |
| pDay day in leap year: 29 February   | `9/02/2000`    | true            |
| pDay day in non-leap year: 29 February | `29/02/2001` | false           |

NOTE: Last name as appeared in ID tested.

**Boundary Value Analysis**

| Category                 | Test Data       | Expected Result |
|--------------------------|-----------------|-----------------|
| false / true           | `31/12/1900 / 01/01/1901`    | false / true            |
| true / false           | `[today's date] / [day after today]`    | false / true     |

**2. Submodule: daysInMonth()** <br>
Imports: pMonth (int), pYear (int) <br>
Exports: result (int)

- Model used: Equivalence Partitioning
- Reason for choosing model(s): Equivalence Partitioning is suitable for complex input coverage, ensuring various scenarios are tested, so it applies for this module. There is no need for edge case testing in this module, so Boundary Value Analysis is not implemented.
- Test prompt: Return the number of days in a given month and year, varying for specific months. Months that have 31 days year-round: January, March, May, July, August, October, and December. Months that have 30 days year-round: April, June, September, November. Months that have different days depending on the year: February - 28 in non-leap years and 29 in leap years. 

**Equivalence Partitioning**

| Category                | Test Data (pMonth, pYear) | Expected Result |
|-------------------------|---------------------------|-----------------|
| pMonth months with 31 days: January    | `1, 2024`       | 31              |
| pMonth months with 31 days: March      | `3, 2024`       | 31              |
| pMonth months with 31 days: May        | `5, 2024`       | 31              |
| pMonth months with 31 days: July       | `7, 2024`       | 31              |
| pMonth months with 31 days: August     | `8, 2024`       | 31              |
| pMonth months with 31 days: October    | `10, 2024`      | 31              |
| pMonth months with 31 days: December   | `12, 2024`      | 31              |
| pMonth months with 30 days: April      | `4, 2024`       | 30              |
| pMonth months with 30 days: June       | `6, 2024`       | 30              |
| pMonth months with 30 days: September  | `9, 2024`       | 30              |
| pMonth months with 30 days: November   | `11, 2024`      | 30              |
| pMonth February in leap year           | `2, 2024`       | 29              |
| pMonth February in non-leap year       | `2, 2023`       | 28              |
| pMonth: month < , 1901 < year < 2024   | `0, 2024`       | 0               |
| pMonth: month > 12, 1901 < year < 2024 | `13, 2024`      | 0               |
| pMonth: month < , year < 1901          | `2, 1000`       | 0               |
| pMonth: month < , year > 2024          | `2, 1000`       | 0               |
| pMonth: month > 12, year < 1901        | `2, 1000`       | 0               |
| pMonth: month > 12, year > 2024        | `2, 1000`       | 0               |

**3. Submodule: isLeapYear()** <br>
Imports: pYear (int) <br>
Exports: result (boolean)

- Model used: Equivalence Partitioning
- Reason for choosing model(s): Equivalence Partitioning is suitable for complex input coverage, ensuring various scenarios are tested, so it applies for this module. There is no need for edge case testing in this module, so Boundary Value Analysis is not implemented.
- Test prompt: Check if a given year is a leap year. A year is a leap year if it is divisible by 4 but not by 100, or is divisible by 400.

| Category                           | Test Data | Expected Result |
|------------------------------------|-----------|-----------------|
| pYear is divisible by 4, not by 100 (leap year)       | `2012`      | True            |
| pYear is divisible by 400 (leap lear)                 | `1600`      | True            |
| pYear is divisible by 100, not by 400                 | `1700`      | False           |
| pYear is not divisible by 4                           | `2015`      | False           |

**4. Submodule: calculateLifePathNumber()** <br>
Imports: pDay (String) <br>
Exports: lifePathNumber (int)

- Model used: Equivalence Partitioning
- Reason for choosing model(s): Equivalence Partitioning is suitable for complex input coverage, ensuring various scenarios are tested, so it applies for this module. There is no need for edge case testing in this module, so Boundary Value Analysis is not implemented.
- Test prompt: Calculate the life path number from the given pDay. pDay has summed day, month, and year values stored in daySum (int), monthSum (int), and yearSum (int) respectively. Sum the digits of daySum, monthSum, and yearSum, then reduce the sum to a single-digit value (from 1 to 9), or keep as is if it is a master number (11, 22, 33). If each part of daySum, monthSum, and yearSum itself is a master number, keep it and don't do the sum. 

| Category                | Test Data      | Expected Result |
|-------------------------|----------------|-----------------|
| daySum, monthSum, yearSum in daySum sum up to 1     | `6 + 4 + 9`   | lifePathNumber = 1               |
| daySum, monthSum, yearSum in pDay sum up to 2     | `22 + 8 + 8`    | lifePathNumber = 2               |
| daySum, monthSum, yearSum in pDay sum up to 3     | `22 + 1 + 7`   | lifePathNumber = 3               |
| daySum, monthSum, yearSum in pDay sum up to 4     | `9 + 6 + 7`   | lifePathNumber = 4               |
| daySum, monthSum, yearSum in pDay sum up to 5     | `1 + 1 + 3`   | lifePathNumber = 5               |
| daySum, monthSum, yearSum in pDay sum up to 6     | `9 + 3 + 3`   | lifePathNumber = 6               |
| daySum, monthSum, yearSum in pDay sum up to 7     | `11 + 11 + 3`   | lifePathNumber = 7               |
| daySum, monthSum, yearSum in pDay sum up to 8     | `1 + 11 + 5`   | lifePathNumber = 8               |
| daySum, monthSum, yearSum in pDay sum up to 9     | `2 + 9 + 7`   | lifePathNumber = 9               |
| daySum, monthSum, yearSum in pDay sum up to master number (11)      | `2 + 8 + 1`  | lifePathNumber = 11              |
| daySum, monthSum, yearSum in pDay sum up to master number (22)      |`4 + 11 + 7`   | lifePathNumber = 22              |
| daySum, monthSum, yearSum in pDay sum up to master number (33)      |`11 + 11 + 11`   | lifePathNumber = 33              |

**5. Submodule: sumOfDigits** <br>
Imports: pNum (int) <br>
Exports: sum (int)

- Model used: Equivalence Partitioning
- Reason for choosing model(s): Equivalence Partitioning is suitable for complex input coverage, ensuring various scenarios are tested, so it applies for this module. There is no need for edge case testing in this module, so Boundary Value Analysis is not implemented.
- Test prompt: Sum a number into a single-digit sum or keep as master numbers (11, 22). Count 33 out of the master number exceptions because there is no value summing up to 33/staying as 33.

| Category                | Test Data      | Expected Result |
|-------------------------|----------------|-----------------|
| pNum sums up to 1     | `01`   | sum = 1               |
| pNum sums up to 2     | `2000`   | sum = 2               |
| pNum sums up to 3     | `12`   | sum = 3               |
| pNum sums up to 4     | `31`   | sum = 4               |
| pNum sums up to 5     | `2003`   | sum = 5               |
| pNum sums up to 6     | `24`   | sum = 6               |
| pNum sums up to 7     | `2005`   | sum = 7               |
| pNum sums up to 8     | `26`   | sum = 8               |
| pNum sums up to 9     | `1998`   | sum = 9               |
| pNum sums up to master number (11)      | `2009`  | sum = 11            |
| pNum sums up to master number (22)      | `22`   | sum = 22             |

**6. Submodule: finalSum()** <br>
Imports: pNum (int) <br>
Exports: sum (int)

- Model used: Equivalence Partitioning
- Reason for choosing model(s): Equivalence Partitioning is suitable for complex input coverage, ensuring various scenarios are tested, so it applies for this module. There is no need for edge case testing in this module, so Boundary Value Analysis is not implemented.
- Test prompt: Sum a number into a single-digit sum or keep as master numbers (11, 22). Count 33 out of the master number exceptions because there is no value summing up to 33/staying as 33.

| Category                | Test Data      | Expected Result |
|-------------------------|----------------|-----------------|
| pNum sums up to 1     | `10`   | sum = 1               |
| pNum sums up to 2     | `2000`   | sum = 2               |
| pNum sums up to 3     | `21`   | sum = 3               |
| pNum sums up to 4     | `13`   | sum = 4               |
| pNum sums up to 5     | `23`   | sum = 5               |
| pNum sums up to 6     | `2004`   | sum = 6               |
| pNum sums up to 7     | `25`   | sum = 7               |
| pNum sums up to 8     | `2006`   | sum = 8               |
| pNum sums up to 9     | `2007`   | sum = 9               |
| pNum sums up to master number (11)      | `2009`  | sum = 11            |
| pNum sums up to master number (22)      | `22`   | sum = 22             |

**7. Submodule: getLuckyColour()** <br>
Imports: pNum (int) <br>
Exports: result (String)

- Model used: Equivalence Partitioning
- Reason for choosing model(s): Equivalence Partitioning is suitable for complex input coverage, ensuring various scenarios are tested, so it applies for this module. There is no need for edge case testing in this module, so Boundary Value Analysis is not implemented.
- Test prompt: Return the lucky colour based on the provided life path number. Each life path number corresponds to a specific colour : "Red", 2: "Orange", 3: "Yellow", 4: "Green", 5: "Sky Blue", 6: "Indigo", 7: "Violet", 8: "Magenta", 9: "Gold", 11: "Silver", 22: "White", 33: "Crimson". If the provided number isn't any of the numbers above, return "Unknown".

| Category                | Test Data      | Expected Result |
|-------------------------|----------------|-----------------|
| pNum is 1     | `1`   |   "Red"          |
| pNum is 2     | `2`   |   "Orange"       |
| pNum is 3     | `3`   |   "Yellow"       |
| pNum is 4     | `4`   |   "Green"        |
| pNum is 5     | `5`   |   "Sky Blue"     |
| pNum is 6     | `6`   |   "Indigo"       |
| pNum is 7     | `7`   |   "Violet"       |
| pNum is 8     | `8`   |   "Magenta"      |
| pNum is 9     | `9`   |   "Gold"         |
| pNum is master number (11)      | `11`   |   "Silver"       |
| pNum is master number (22)      | `22`   |   "White"        |
| pNum is master number (33)      | `33`   |   "Crimson"      |
| pNum is none of the numbers     | `44`   |   "Unknown"      |

**8. Submodule: getGeneration()**
Imports: pBirthday (String)
Exports: result (String)

- Model used: Equivalence Partitioning & Boundary Value Analysis
- Reason for choosing model(s): Equivalence Partitioning is suitable for complex input coverage, ensuring various scenarios are tested, so it applies for this module. There is no need for edge case testing in this module, so Boundary Value Analysis is not implemented.
- Test prompt: pBirthday (String) is separated using "/" as a separator and has pYear (int) as the value analysed in this module. Return the generation a person was born in based on the provided pYear: If between 1901 and 1945, return "Silent Generation". If between 1946 and 1964, return "Baby Boomers". If between 1965 and 1979, return "Generation X". If between 1980 and 1994, return "Millenials". If between 1995 and 2009, return "Generation Z". If between 2010 and 2024, return "Generation Alpha". If the birth year doesn't belong to any of the generations above, return "Unknown Generation".

* Equivalence Partitioning

| Category                | Test Data      | Expected Result |
|-------------------------|----------------|-----------------|
| 1901 <= pYear <= 1945     | `1912`   |   "Silent Generation"          |
| 1946 <= pYear <= 1964     | `1950`   |   "Baby Boomers"       |
| 1965 <= pYear <= 1979  | `1972`   |   "Generation X"       |
| 1980 <= pYear <= 1994     | `1985`   |   "Millenials"        |
| 1995 <= pYear <= 2009     | `2005`   |   "Generation Z"     |
| 2010 <= pYear <= 2024    | `2012`   |   "Generation Alpha"       |
| pYear is none of the numbers     | `2327`   |   "Unknown Generation"      |

NOTE: Last 4 digits of Student ID tested.

* Boundary Value Analysis

| Boundary                | Test Data      | Expected Result |
|-------------------------|----------------|-----------------|
| Invalid / Silent Generation       | `1900 / 1901`     | "Unknown Generation" / "Silent Generation" |
| Silent Generation / Baby Boomers      | `1945 / 1946`  |   "Silent Generation" / "Baby Boomers"    |
| Baby Boomers / Generation X     | `1964 / 1965`  |   "Baby Boomers" / "Generation X"    |
| Generation X / Millenials    | `1979 / 1980`  |   "Generation X" / Millenials    |
| Millenials / Generation Z     | `1994 / 1995`  |   "Millenials" / "Generation Z"    |
| Generation Z / Generation Alpha     | `2009 / 2010`  |   "Generation Z" / "Generation Alpha"    |
| Generation Alpha / Invalid        | `2024 / 2025`    |   "Generation Alpha" / "Unknown Generation" |

## Whitebox Testing
**1. Submodule: validateBirthday()** <br>
   This method is used to validate whether a given input string represents a valid date in the format "DD/MM/YYYY". Since this method involves several conditional checks, including regex validation and range validation, white-box testing is particularly beneficial here.
 
| Path                | Test Data      | Expected Result |
|-------------------------|----------------|-----------------|
| Pass a value into the function and calculate Life Path Number for a valid date format     | `15/04/1990`     | true |
| Pass a value into the function and calculate Life Path Number for a valid date format     | `29/02/2000`     | true |
| Pass a value into the function and calculate Life Path Number for an invalid date format    | `2005-11-09`     | false |
| Pass a value into the function and calculate Life Path Number for an invalid date accuracy    | `35/05/2019`     | false |

**2. Submodule: sumOfDigits()** <br>
   This method is used to calculate the sum of the digits of a number and reduce it to a single-digit value. The method should keep the number as is if the number is a master number (11, 22, 33). Since this method involves several conditional checks, including divisibility validation, white-box testing is particularly beneficial here.

| Path                | Test Data      | Expected Result |
|-------------------------|----------------|-----------------|
| Pass a value into the function and reduce it to a valid single-digit value   | `20`     | 2 |
| Pass a value into the function and reduce it to a valid single-digit value   | `2007`     | 9 |
| Pass a value into the function and keep it as is for it is a master number   | `11`     | 11 |
| Pass a value into the function and keep it as is for it is a master number   | `22`     | 22 |

## Test Implementation & Test Execution
**Instruction on how to run the test code:**
After running the program locally as guided in [Functioning of the Program](#functioning-of-the-program), type in the following commands to test the code:

javac ProgramTestFile.java ProgramFile.java
java -ea ProgramTestFile

If the tests all pass, the terminal will not return anything. If any test doesn't pass, it will show the problem. 

## Summary of my Work

|    --------------        |  ------------------- Design of test cases ----------------------      | Test code implementation and execution |
|-------------------------|----------------|-----------------|

| Module name  | BB (EP) | BB (BVA) | WB | Data type/s | Form of input/output | EP | BVA | Whitebox|
|--------------|-----------|--------|--------|----|--------|-----|-----|----|
| validateBirthday() |Done |Done|Done|String, boolean|Input: keyboard input - Output: return value| Done |Done|Done|
| daysInMonth()     |Done|Not done|Not done|Integer|Input: parameter passing - Output: return value|Done|Not done| Not done|
| isLeapYear()      |Done|Not done|Not done|Boolean, integer|Input: parameter passing - Output: return value|Done|Not done|Not done|
| calculateLifePathNumber()|Done|Not done|Not done|Integer, string|Input: parameter passing - Output: return value|Done|Not done|Not done|
| sumOfDigits()     |Done|Not done|Done|Integer|Input: parameter passing - Output: return value|Done|Not done|Done|
| finalSum()        |Done|Not done|Not done|Integer|Input: parameter passing - Output: return value|Done|Not done|Not done|
| getLuckyColour()  |Done|Not done|Not done|String, integer|Input: parameter passing - Output: return value|Done|Not done|Not done|
| getGeneration()   |Done|Done|Not done|String, integer|Input: parameter passing - Output: return value|Done|Done|Not done|

## Discussion 
Reflect on your own work including summary of what you have achieved, challenges you have faced, limitations and ways to improve your work with other features you have not considered, and any other information you wish to present.

While creating this program, I have learnt a lot. In more details:
- Achievements: I have learnt to write a program from start to finish, including production code, test code, documentation, testing, and VCS log.
- Challenges I have faced: I have faced a lot of challenge during this project. The workload is truly enormous and I started later than I should have, which led to a stress to finish the project before the deadline hits. Fortunately, I got granted an assignment extension and could spend some more time finishing and tailoring my work. 
- Limitations: I think the main limitations I faced lies in the fact that I am not familiar with VCS and some foundational SWE concepts, especially white-box testing. I struggled for quite a long time to know if I had properly commented on the code, and to understand what white-box testing was and why I needed it. I also struggled to understand what the assignment was asking, as there were points in the document that did not clearly state what was being asked. This led to a lot of ambiguity when documenting my code. 
- Ways to improve my work: I think I could improve my work by spending more time on it. The main problem lies in my lack of self-discipline for time management, so I will work on that in future projects.
- Other information: None.

