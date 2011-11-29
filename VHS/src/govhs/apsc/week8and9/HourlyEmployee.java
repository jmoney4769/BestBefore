package govhs.apsc.week8and9;

/*
 * Author: Jared Moore
 * School: Spaulding High School
 * Date: Wednesday, October 12, 2011
 * Week 7 Programming Project
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; // for text input
import java.util.StringTokenizer;

public class HourlyEmployee {

    private double empID;
    private double regular;
    private double overtime;
    private double total;
    private double wage;
    private double regPay;
    private double overPay;
    private double totalPay;
    private String name;
    private static BufferedReader reader;

   public HourlyEmployee(String name, double wage, double regHours, double overHours) {
	   setName(name);
       setRegular(regHours);
       setOvertime(overHours);
       setTotal(overHours, regHours);
       setWage(wage);
       setPay();
   }
    public HourlyEmployee(String name, double employeeID,
     double wage, double regHours, double overHours) { // Constructor
        setName(name);
        setEmpID(employeeID);
        setRegular(regHours);
        setOvertime(overHours);
        setTotal(overHours, regHours);
        setWage(wage);
        setPay();
    }
	private void setName(String name) { // getters and setters
		this.name = name;
	}
	public String getName() {
		return name;
	}
    private void setPay() {
		regPay = wage * regular;
		overPay = wage * 1.5 * overtime;
		totalPay = overPay + regPay;
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
    @Override
    public String toString() { // called when an object is printed
        if (this.empID != 0)
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
            		"Regular Hours Worked : %.2f\n" +
            		"Overtime Hours Worked : %.2f\n" +
            		"Total Hours Worked : %.2f\n\n" +
            		"Regular Pay : $%.2f\n" +
            		"Overtime Pay : $%.2f\n" +
            		"Total Pay : $%.2f"
            		, getName(), getEmpID(), getRegular(), getOvertime(), getTotal(), getRegPay(),
            		getOverPay(), getTotalPay());
    }
    private void setWage(double wage) {
        this.wage = wage;
    }
    public double getWage() {
        return wage;
    }
    private void setEmpID(double employeeID) {
        this.empID = employeeID;
    }
    public double getEmpID() {
        return empID;
    }
    private void setRegular(double regular) {
        this.regular = regular;
    }
    public double getRegular() {
        return regular;
    }
    private void setOvertime(double overtime) {
        this.overtime = overtime;
    }
    public double getOvertime() {
        return overtime;
    }
    private void setTotal(double over, double reg) {
        this.total = (reg + over);
    }
    public double getTotal() {
        return total;
    }
	public static HourlyEmployee setUpObjectFromInput() {
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
	public static HourlyEmployee setUpObjectFromTextFile() { //.db files are so much more efficient for this
		
		try {
		initializeReader();
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		String name = tokenizer.nextToken() + tokenizer.nextToken();
		Double wage = Double.parseDouble(tokenizer.nextToken());
		double reg = 0, over = 0;
		for (int i = 0; i < 5; i++) { // loop five times to add up all hours
			reg += Double.parseDouble(tokenizer.nextToken()); 
			over += Double.parseDouble(tokenizer.nextToken());
		}
		HourlyEmployee class1 = new HourlyEmployee(name, wage, reg, over);
		return class1;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
    public static void main(String[] args) {

       HourlyEmployee class1 = HourlyEmployee.setUpObjectFromTextFile(); // make new object with desired info
       System.out.print(class1); // implicitly call the toString() method
    }
}