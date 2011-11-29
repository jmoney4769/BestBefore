/*
 * Author: Jared Moore
 * School: Spaulding High School
 * Date: Wednesday, October 12, 2011
 * Week 6 Programming Project 
 */
package govhs.apsc.week6;

import java.util.Scanner;

public class HourlyEmployee {

    private double empID;
    private double regular;
    private double overtime;
    private double total;
    private double wage;
    private double regPay;
    private double overPay;
    private double totalPay;
    
    public HourlyEmployee(double employeeID, double wage, double regHours, double overHours) {
        setEmpID(employeeID);
        setRegular(regHours);
        setOvertime(overHours);
        setTotal(overHours, regHours);
        setWage(wage);
        setPay();
    }

    private void setPay() {
		regPay = wage * regular;
		overPay = wage * 1.5 * overtime;
		totalPay = overPay + regPay;
	}
    @Override
    public String toString() {
        return String.format("Employee ID Number : %.0f\n" +
        		"Regular Hours Worked : %.2f\n" +
        		"Overtime Hours Worked : %.2f\n" +
        		"Total Hours Worked : %.2f\n\n" +
        		"Regular Pay : $%.2f\n" +
        		"Overtime Pay : $%.2f\n" +
        		" Total Pay : $%.2f"
        		, empID, regular, overtime, total, regPay,
        		overPay, totalPay);
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
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int id;
        double reg;
        double over;
        double wage;
        System.out.print("Employee ID: ");
        id = input.nextInt();
        System.out.print("Hourly Wage : ");
        wage = input.nextDouble();
        System.out.print("Regular Hours : ");
        reg = input.nextDouble();
        System.out.print("Overtime Hours : ");
        over = input.nextDouble();
        
        HourlyEmployee class1 = new HourlyEmployee(id, wage, reg, over);
        System.out.print(class1);
    }
}
