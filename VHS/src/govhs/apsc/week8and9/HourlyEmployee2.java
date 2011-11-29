package govhs.apsc.week8and9;

/*
 * Author: Jared Moore
 * School: Spaulding High School
 * Date: Monday, October 31, 2011
 * Week 8 and 9 Programming Project
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; // for text input
import java.util.StringTokenizer;

public class HourlyEmployee2 {

    private double empID;
    private double regular;
    private double overtime;
    private double total;
    private double wage;
    private double regPay;
    private double overPay;
    private double totalPay;
    private double[] regularArray;
    private double[] overtimeArray;
    private String name;
    private static BufferedReader reader;

   public HourlyEmployee2(String name, double wage, double[] regHours, double[] overHours) {
	   setName(name);
       setRegular(regHours);
       setOvertime(overHours);
       setTotal(regular, overtime);
       setWage(wage);
       setPay(regHours, overHours);
   }
    public HourlyEmployee2(String name, double employeeID,
     double wage, double regHours, double overHours) { // Constructor
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
        if (this.empID != 0) //called only if second constructor is used
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
        else 
        	return String.format("\n\nEmployee Name : %s\n" +
            		"\n%sTotal Regular Hours Worked : %.2f\n" +
            		"Total Overtime Hours Worked : %.2f\n" +
            		"Total Hours Worked : %.2f\n\n" +
            		"Regular Pay : $%.2f\n" +
            		"Overtime Pay : $%.2f\n" +
            		"Total Pay : $%.2f"
            		, getName(), displayWeeklyData(getRegularArray(), getOvertimeArray()), 
            		getRegular(), getOvertime(), getTotal(), getRegPay(),
            		getOverPay(), getTotalPay());
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
    private double setPay(double[] regular, double[] overtime) {
    	double totalReg = 0, totalOver = 0;
    	if ((regular.length != overtime.length) || (regular.length != 5)) {
    		System.out.println("Erroneous data, try again");
    		return 0;
    	}    	
    	for (int i = 0; i < 5; i++) {
    		totalReg += regular[i];
    		totalOver += overtime[i];
    	}
    	regPay = wage * totalReg;
		overPay = wage * 1.5 * totalOver;
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
        this.empID = (employeeID > 0) ? employeeID : 0; // for data integrity
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
    
	public static HourlyEmployee setUpObjectFromInput() {// to get object from user-defined values
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

        HourlyEmployee class1 = new HourlyEmployee(name, id, wage, reg, over);
        return class1;
	}
	private static void initializeReader() { // initialize the file reader

		try {
			InputStreamReader inReader = new InputStreamReader(new FileInputStream(
					"res/VHSP35data1_1.txt")); //filepath will vary, I included in /res folder of project
			reader = new BufferedReader(inReader);
		}
		catch (FileNotFoundException e) { // properly handle exception
			e.printStackTrace();
		}

	}
	public static HourlyEmployee2 setUpObjectFromTextFile() { //.db files are so much more efficient for this
	//method will set up an object from an external .txt file
		try {
		initializeReader();
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		String name = tokenizer.nextToken() + " " + tokenizer.nextToken();//name will be two words
		double wage = Double.parseDouble(tokenizer.nextToken());
		double reg[] = new double[5]; //values in arrays
		double over[] = new double[5];
		for (int i = 0; i < 5; i++) { // loop five times to add up all hours
			reg[i] = Double.parseDouble(tokenizer.nextToken());
			over[i] = Double.parseDouble(tokenizer.nextToken());
		}
		HourlyEmployee2 class1 = new HourlyEmployee2(name, wage, reg, over);// build object from values
		return class1;
		}
		catch (IOException e) { // handle possible exception
			e.printStackTrace(); //print out where error occurred
			return null; // return with nothing, allowing continuation of program
		}

	}

	private String displayWeeklyData(double[] reg, double[] over) {
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
    public static void main(String[] args) {
    	
       HourlyEmployee2 class1 = HourlyEmployee2.setUpObjectFromTextFile(); // make new object with desired info
       System.out.print(class1); // implicitly call the toString() method
    }
}