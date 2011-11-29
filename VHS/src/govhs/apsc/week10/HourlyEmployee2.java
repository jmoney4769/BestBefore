package govhs.apsc.week10;

/*
 * Author: Jared Moore
 * School: Spaulding High School
 * Date: Thursday, November 10, 2011
 * Week 10 Programming Project
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;
import java.util.Scanner; // for text input
import java.util.StringTokenizer;
import java.util.ArrayList;

public class HourlyEmployee2 {

    private double empID; //employee ID number
    private double regular; //total regular hours
    private double overtime; //total overtime hours
    private double total; //total pay 
    private double wage; //regular pay rate
    private double regPay; //regular pay (dollars)
    private double overPay; //overtime pay (dollars)
    private double totalPay; //total pay (dollars)
    private double[] regularArray; //array of weekly regular hours
    private double[] overtimeArray; //array of weekly overtime hours
    private String name; //name of employee
    private static BufferedReader reader; //to read external files

    public HourlyEmployee2() { //Default constructor, empty object 
		setName(null);
		setRegular(0);
		setOvertime(0);
		setTotal(0, 0);
		setWage(0);
		setPay(0, 0);
		setEmpID(0);
	}
    
   public HourlyEmployee2(String name, double wage, double[] regHours, double[] overHours) {//Constructor
	   setName(name);
       setRegular(regHours);
       setOvertime(overHours);
       setTotal(regular, overtime);
       setWage(wage);
       setPay(getRegular(), getOvertime());
   }
    public HourlyEmployee2(String name, double employeeID,
     double wage, double regHours, double overHours) { // Alternate constructor with employee ID included
        setName(name);
        setEmpID(employeeID);
        setRegular(regHours);
        setOvertime(overHours);
        setTotal(overHours, regHours);
        setWage(wage);
        setPay(regHours, overHours);
    }
    @Override
    public String toString() { // called when an object is printed
        if (this.empID != -1) //called only if second constructor is used
        		return String.format("\n\nEmployee Name : %s\n" +
        		"Employee ID Number : %.0f\n" +
        		"Regular Hours Worked : %.2f\n" +
        		"Overtime Hours Worked : %.2f\n" +
        		"Total Hours Worked : %.2f\n\n" +
        		"Regular Pay : $%.2f\n" +
        		"Overtime Pay : $%.2f\n" +
        		"Total Pay : $%.2f"
        		, getName(), getEmpID(), getRegular(), getOvertime(), getTotal(), getRegPay(),
        		getOverPay(), getTotalPay());
        else //called if first constructor is called
        	return String.format("\n\nEmployee Name : %s\n" +
            		"Total Regular Hours Worked : %.2f\n" +
            		"Total Overtime Hours Worked : %.2f\n" +
            		"Total Hours Worked : %.2f\n\n" +
            		"Total Regular Pay : $%.2f\n" +
            		"Total Overtime Pay : $%.2f\n" +
            		"Total Pay : $%.2f\n\n"
            		, getName(),getRegular(), getOvertime(), getTotal(), getRegPay(),
            		getOverPay(), getTotalPay()
            		);
    }
	private void setName(String name) { // getters and setters
		this.name = name;
	}
	public String getName() {
		return name;
	}
    private double setPay(double regular, double overtime) {
		regPay = wage * regular;
		overPay = wage * 1.5 * overtime;
		totalPay = overPay + regPay;
		return totalPay;
	}
	public double getRegPay() {
		return regPay;
	}
	public double getOverPay() {
		return overPay;
	}
	public double getTotalPay() {
		return totalPay;
	}
    private void setWage(double wage) {
        this.wage = (wage > 0) ? wage : 0; // can't be negative
    }
    public double getWage() {
        return wage;
    }
    private void setEmpID(double employeeID) {
        this.empID = (employeeID > 0) ? employeeID : -1; // for data integrity
    }
    public double getEmpID() {
        return empID;
    }
    private void setRegular(double regular) {
        this.regular = (regular > 0) ? regular : 0;
    }
    private void setRegular(double[] regular) {
    	regularArray = regular;
    	for (int i = 0; i < regular.length; i++)
    		this.regular += regular[i];
    }
    public double getRegular() {
        return regular;
    }
    public double[] getRegularArray() {
    	return regularArray;
    }
    private void setOvertime(double overtime) {
        this.overtime = (overtime > 0) ? overtime : 0;
    }
    private void setOvertime(double[] overtime) {
    	overtimeArray = overtime;
    	for (int i = 0; i < overtime.length; i++)
    		this.overtime += overtime[i];
    }
    public double getOvertime() {
        return overtime;
    }
    public double[] getOvertimeArray() {
    	return overtimeArray;
    }
    private void setTotal(double over, double reg) {
        this.total = (reg + over);
    }
    public double getTotal() {
        return total;
    }

	public static HourlyEmployee2 setUpObjectFromInput() {// to get object from user-defined values
		Scanner input = new Scanner(System.in);
        int id;
        double reg;
        double over;
        double wage;
        String name;

        System.out.print("Employee Name: "); // get the info
        name = input.next();
        System.out.print("Employee ID: ");
        id = input.nextInt();
        System.out.print("Hourly Wage : ");
        wage = input.nextDouble();
        System.out.print("Regular Hours : ");
        reg = input.nextDouble();
        System.out.print("Overtime Hours : ");
        over = input.nextDouble();

        HourlyEmployee2 class1 = new HourlyEmployee2(name, id, wage, reg, over);
        return class1;
	}
	private static void initializeReader() { // initialize the file reader

		try {
			InputStreamReader inReader = new InputStreamReader(new FileInputStream(
					"res/VHSP35data.txt")); //file path will vary, I included in /res folder of project
			reader = new BufferedReader(inReader);
		}
		catch (FileNotFoundException e) { // properly handle exception
			System.err.println("File does not exist");
			System.exit(1);
		}

	}
	public static ArrayList<HourlyEmployee2> setUpObjectFromTextFile() { //.db files are so much more efficient for this
	//method will set up an object from an external .txt file
		ArrayList<HourlyEmployee2> array = new ArrayList<HourlyEmployee2>();//array with undefined length
		try {// in case of exception
			initializeReader();
			String line = reader.readLine();			
			while (line != null) {
				StringTokenizer tokenizer = new StringTokenizer(line);
				String name = tokenizer.nextToken() + " " + tokenizer.nextToken();//name will be two words
				double wage = Double.parseDouble(tokenizer.nextToken());
				double reg[] = new double[5]; //values in arrays
				double over[] = new double[5];
				for (int i = 0; i < 5; i++) { // loop five times to add up all hours
					reg[i] = Double.parseDouble(tokenizer.nextToken());
					over[i] = Double.parseDouble(tokenizer.nextToken());
				}
				HourlyEmployee2 class1 = new HourlyEmployee2(name, wage, reg, over);// build object from values
				array.add(class1);//make an array of objects, allowing for easy manipulation
				line = reader.readLine();
			}
		}
		catch (IOException e) { // handle possible exception
			System.err.println("File does not exist");
			System.exit(1);
		}
		if ((array.size() > 1) && (array.size() != 0)) // print number of employees, for reference
			System.out.printf("End of file.  There are %d employees", array.size());
		else
			System.out.print("End of file.  There is one employee");
		return array;
	}

	private String displayWeeklyData(double[] reg, double[] over) { //can be used if you want weekly data
		if ((reg.length != over.length) || (reg.length != 5)) //for data integrity
			return null;
		return String.format("Monday Regular Hours: %.2f\n" +
				"Monday Overtime Hours : %.2f\n" +
				"Monday Pay : %.2f\n\n" +
				"Tuesday Regular Hours: %.2f\n" +
				"Tuesday Overtime Hours : %.2f\n" +
				"Tuesday Pay : %.2f\n\n" +
				"Wednesday Regular Hours: %.2f\n" +
				"Wednesday Overtime Hours : %.2f\n" +
				"Wednesday Pay : %.2f\n\n" +
				"Thursday Regular Hours: %.2f\n" +
				"Thursday Overtime Hours : %.2f\n" +
				"Thursday Pay : %.2f\n\n" +
				"Friday Regular Hours: %.2f\n" +
				"Friday Overtime Hours : %.2f\n" +
				"Friday Pay : %.2f\n\n", reg[0], over[0], setPay(reg[0], over[0]),
						reg[1], over[1], setPay(reg[1], over[1]),
						reg[2], over[2], setPay(reg[2], over[2]),
						reg[3], over[3], setPay(reg[3], over[3]),
						reg[4], over[4], setPay(reg[4], over[4]));

	}
	
	public static void outputTextFile(ArrayList<HourlyEmployee2> array) { //just thought I'd put this here
		//outputs the ArrayList as a text file, similarly formatted to the input file		
		try {
			Formatter output = new Formatter("output.txt"); //to format the file
			String data = "";
			for (int i = 0; i < array.size(); i++)
				data += String.format("%s %.2f %.2f %.2f %.2f\n", array.get(i).getName(), 
						array.get(i).getEmpID(), array.get(i).getRegular(),
						array.get(i).getOvertime(), array.get(i).getWage());
			output.format(data);//add the string to the file
			output.close();//close the file, saving changes
		}
		catch (SecurityException e) {//if file is read-only
			System.err.println("You do not have write access to this file");
			System.exit(1);
		} 
		catch (FileNotFoundException e) {
			System.err.println("Error creating file");
			System.exit(1);
		}
	}
    public static void main(String[] args) {

      ArrayList<HourlyEmployee2> array = HourlyEmployee2.setUpObjectFromTextFile(); // make new array with desired info
      for (int i = 0; i < array.size(); i++) //iterate through the array, printing the objects
       	System.out.print(array.get(i));      
    }
}