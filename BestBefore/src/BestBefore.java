//program designed to solve the first Spotify puzzle (work in progress, obscure error persists)
// Author: Jared Moore
import java.util.Scanner;

public class BestBefore {
	
	private String in;
	private String firstSet = "";
	private String secondSet = "";
	private String thirdSet = "";
	private int firstInt;
	private int secondInt;
	private int thirdInt;
	private int year = -1;
	private int month = -1;
	private int day = -1;
	private int counter = 0;
	

	private String[] getInfo() { // get input of date
		
		Scanner input = new Scanner(System.in);
						
		System.out.print(""); 
		in = input.next();
		
		char array[] = in.toCharArray();
		String straArray[] = new String[array.length];
		
		for (int i = 0; i < array.length; i++) { 
			// convert array of characters to array of single letter strings so can be made into ints			
			if (array[i] != '/')
				straArray[i] = Character.toString(array[i]);
			else if (array[i] == '/') {
				straArray[i] = "a"; // "check" value, will indicate when to go to next int
				counter++; // count /'s to make sure correctly formatted
			}
		}
		
		return straArray;
	}
	
	private void getSets(String[] strArray) { // split input into three sets
		
		int checker = 0; // to tell when to add to which set
		
		for (int i = 0; i < strArray.length; i++) {
			
			if ((strArray[i] != "a") && (checker == 0))
				firstSet += strArray[i];
			if ((strArray[i] != "a") && (checker == 1))
				secondSet += strArray[i];
			if ((strArray[i] != "a") && (checker == 2))
				thirdSet += strArray[i]; 
			
			if (strArray[i] == "a")
				checker++;
		}
	}
	
	private void makeInts() { // convert the strings into integers
		
		try {
			if (firstSet != null)
				firstInt = Integer.parseInt(firstSet);
			if (secondSet != null)
				secondInt = Integer.parseInt(secondSet);
			if (thirdSet != null)
				thirdInt = Integer.parseInt(thirdSet);
		}
		catch (Exception e) {
			System.out.println(in + " is illegal");
			System.exit(0);
		}
	}
	
	private boolean isLegal() { // make sure input is a legal date (before knowing month)
		
		if ((firstInt >= 1000) && (firstInt < 2000)) 
			return false;
		if ((secondInt >= 1000) && (secondInt < 2000)) 
			return false;
		if ((thirdInt >= 1000) && (thirdInt < 2000)) 
			return false;
		
		if (firstInt > 2000) {
			
			if ((secondInt > 31) || (thirdInt > 31))
				return false;
			
			if ((secondInt > 12) && (thirdInt > 12))
				return false;			
		}
			
		if (secondInt > 2000) {
			
			if ((firstInt > 31) || (thirdInt > 31)) 
				return false;
			
			if ((firstInt > 12) && (thirdInt > 12))
				return false;
		}
			
		if (thirdInt > 2000) {
			
			if ((firstInt > 31) || (secondInt > 31))
				return false;
			
			if ((secondInt > 12) && (firstInt > 12))
				return false;
		}
		
		if ((firstInt > 12) && (secondInt > 12) && (thirdInt > 12))
			return false;
		
		if ((firstInt <= 0) && (secondInt <= 0))
			return false;
		if ((secondInt <= 0) && (thirdInt <= 0))
			return false;
		if ((firstInt <= 0) && (thirdInt <= 0))
			return false;
		if ((firstInt <= 0) && (secondInt <= 0) && (thirdInt <= 0))
			return false;
		
		if (counter != 2) // if input was not in A/B/C format (counter counts /'s)
			return false;
			
		
		return true;
	}
	
	private void determineDate() {
		
		if (isLegal()) { // only perform action if input is in legal format 
			
			if (firstInt > 31) // neither day nor month can be over 31, so must be year
				year = firstInt;
			if (secondInt > 31)
				year = secondInt;
			if (thirdInt > 31)
				year = thirdInt;
			
			if ((firstInt == secondInt) || (secondInt == thirdInt) || (firstInt == thirdInt)) {
				if ((firstInt == secondInt) && (firstInt == thirdInt)) {
					year = firstInt;
					day = firstInt;
					month = firstInt;
					return;
				}
				if  (firstInt == secondInt) {
					if (firstInt == Math.min(firstInt, thirdInt)) {
						year = firstInt;
						month = firstInt;
						day = thirdInt;
					}
					else {
						year = thirdInt; 
						month = firstInt;
						day = firstInt;
					}
					return;
				}
				if  (firstInt == thirdInt) {
					if (firstInt == Math.min(firstInt, secondInt)) {
						year = firstInt;
						month = firstInt;
						day = secondInt;
					}
					else {
						year = secondInt; 
						month = firstInt;
						day = firstInt;
					}
					return;
				}
				if  (thirdInt == secondInt) {
					if (secondInt == Math.min(secondInt, firstInt)) {
						year = secondInt;
						month = secondInt;
						day = firstInt;
					}
					else {
						year = firstInt; 
						month = secondInt;
						day = secondInt;
					}
					return;
				}
			}
				
				
			if (year != -1) { 
			
				if ((firstInt > 12) && (firstInt <= 31)) 
					// year has been set so cannot be used again and month cannot be over 12
					day = firstInt;
				if ((secondInt > 12) && (secondInt <= 31))
					day = secondInt;
				if ((thirdInt > 12) && (thirdInt <= 31))
					day = thirdInt;
				else { // set month to lowest number making it the earliest date
					if (year == firstInt) {
						month = Math.min(secondInt, thirdInt);
						day = Math.max(secondInt, thirdInt);
					}
					if (year == secondInt) {
						month = Math.min(firstInt, thirdInt);
						day = Math.max(firstInt, thirdInt);
					}
					if (year == thirdInt) {
						month = Math.min(firstInt, secondInt);
						day = Math.max(firstInt, secondInt);
					}
				}
			}
			
			if ((year != -1) && (day != -1)) { // month becomes what isn't taken
				
				if (year == firstInt) {
					if (day == secondInt)
						month = thirdInt;
					else 
						month = secondInt;
				}
				if (year == secondInt) {
					if (day == firstInt)
						month = thirdInt;
					else 
						month = firstInt;
				}
				if (year == thirdInt) {
					if (day == firstInt)
						month = secondInt;
					else 
						month = firstInt;
				}					
			}
			
			else { // all ints between 1 and 31, set lowest to year, middle to month, and highest to day
				
				year = Math.min(firstInt, Math.min(secondInt, thirdInt));
				day = Math.max(firstInt, Math.max(secondInt, thirdInt));
				
				if (year == firstInt) {
					if (day == secondInt)
						month = thirdInt;
					else 
						month = secondInt;
				}
				if (year == secondInt) {
					if (day == firstInt)
						month = thirdInt;
					else 
						month = firstInt;
				}
				if (year == thirdInt) {
					if (day == firstInt)
						month = secondInt;
					else 
						month = firstInt;
				}
			}
		}
	}
	
	private boolean isDayOkWithMonth() {
		
		int normal[] = {4, 6, 9, 11};
		int tester = 0;
		
		if (month > 12) {
			int switcher;
			if (year < 13) {
				switcher = month;
				month = year;
				year = switcher;
			}
			else if (day < 13) {
				switcher = month;
				month = day;
				day = switcher;
			}
			else 
				return true;
		}
		
		if (month == -1) // return true if month has not been initialized, meaning isLegal() returned false
			return true;
		
		for (int i = 0; i < normal.length; i++) { // if the month has 30 days, make sure day != 31
		
			if (month == normal[i])
				if (day > 30)
					tester = 1;				
		}
		
		if (month == 2) { // determine if leap year and if day is not too big
			
			if ((isLeapYear(year)) && (day > 29))
				tester = 1;
			if ((!isLeapYear(year)) && (day > 28))
				tester = 1;
		}
		
		if (tester == 0)
			return false; // only return false if a valid format was used (false is used to exit loop)
			
		if (tester == 1) {
			
			crazyStuff();
			
			for (int i = 0; i < normal.length; i++) { // if the month has 30 days, make sure day != 31
				
				if (month == normal[i])
					if (day > 30)
						return true;		
			}
			
			if (month == 2) { // determine if leap year and if day is not too big
				
				if ((isLeapYear(year)) && (day > 29))
					return true;
				if ((!isLeapYear(year)) && (day > 28))
					return true;
			}
		}
		return false;
	}

	private boolean isLeapYear(int year) {
		
		if (year < 2000) {
			year += 2000;
		}
		if ((year % 4) == 0)
			if (((year % 400) == 0) && ((year % 100) != 0))
				return true;
		if (((year % 4) != 0) || (((year % 4) == 0) && ((year % 400) == 0) && 
				((year % 100) != 0)))
			if (day > 28)
				return false;
		return false;
	}

	private void crazyStuff() { // don't ask, I thought it accurately described what was being done
		
		int switcher;
		int normal[] = {4, 6, 9, 11};
		boolean b = false;
		boolean c = false;
		boolean d = false;
		boolean e = false;
		boolean f = false;
		boolean g = false;
		
		for (int i = 0; i < normal.length; i++) {
			if (month == normal[i])
				b = true;
			
			if (year == normal[i])
				e = true;
		}
		if (isLeapYear(month))
			c = true;
		else
			d = true;
				
		if (isLeapYear(day))
			f = true;			
		else
			g = true;
		
		if (month == Math.min(month, day)) { // if month is the smaller of the two
			if (day < 13) {
				switcher = day;
				day = month;
				month = switcher;
			}
			else if (year < 13) {
				
				if ((e) && (day < 31)) {
					switcher = year;
					year = month;
					month = switcher;
				}
				else if ((month == 2) && (c) && (day < 30)) {
					switcher = year;
					year = month;
					month = switcher;
				}
				else if ((month == 2) && (d) && (day < 29)) {
					switcher = year;
					year = month;
					month = switcher;
				}
				else if (day <= 31) {
					switcher = year;
					year = month;
					month = switcher;
				}
			}
			else if ((b) && (year <= 30)) {
				switcher = day;
				day = year;
				year = switcher;
			}
			else if ((f) ^ (g)) {
				if ((f) && (year < 30)) {
					switcher = year;
					year = day;
					day = switcher;
				}
				else if ((g) && (year < 29)) {
					switcher = year;
					year = day;
					day = switcher;
				}
			}
			else if (year <= 31) {
				switcher = year;
				year = day;
				day = switcher;
			}			
		}		
	}

	public static void main(String[] args) {
		
		BestBefore test = new BestBefore();
		boolean b;
		
		test.getSets(test.getInfo());
		test.makeInts();
		test.determineDate();
		b = test.isDayOkWithMonth();
			
		if (b) {
			System.out.println(test.in + " is illegal");
			System.exit(0);			
		}
		test.output(test.year, test.month, test.day);
	}

	private void output(int year, int month, int day) { // output data based on what was input
		
		if ((year < 2000) && (year >= 100)) {
			if (month < 10) { 
				if (day < 10)
					System.out.printf("2%d-0%d-0%d", year, month, day);
				else
					System.out.printf("2%d-0%d-%d", year, month, day);
				return;
			}
			else if (day < 10)
				System.out.printf("2%d-%d-0%d", year, month, day);
			else 
				System.out.printf("2%d-%d-%d", year, month, day);
			
			return;
		}
		if ((year < 2000) && (year < 100) && (year >= 10)) {
			if (month < 10) { 
				if (day < 10)
					System.out.printf("20%d-0%d-0%d", year, month, day);
				else
					System.out.printf("20%d-0%d-%d", year, month, day);
				return;
			}
			else if (day < 10)
				System.out.printf("20%d-%d-0%d", year, month, day);
			else 
				System.out.printf("20%d-%d-%d", year, month, day);
			
			return;
		}
		if (year < 10) {
			if (month < 10) { 
				if (day < 10)
					System.out.printf("200%d-0%d-0%d", year, month, day);
				else
					System.out.printf("200%d-0%d-%d", year, month, day);
				return;
			}
			else if (day < 10)
				System.out.printf("200%d-%d-0%d", year, month, day);
			else
				System.out.printf("200%d-%d-%d", year, month, day);
			
			return;
		}
		if (month < 10) { 
			if (day < 10)
				System.out.printf("%d-0%d-0%d", year, month, day);
			else
				System.out.printf("%d-0%d-%d", year, month, day);
			return;
		}
		if (day < 10) {
			System.out.printf("%d-%d-0%d", year, month, day);
			return;
		}	
		System.out.printf("%d-%d-%d", year, month, day);
	}
}
