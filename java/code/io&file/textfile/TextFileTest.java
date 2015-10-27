package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TextFileTest {

	public static void main(String[] args) throws IOException{
		Employee[] staff = new Employee[5];
		
		staff[0] = new Employee(6500,"Jing He",2013,4,3);
		staff[1] = new Employee(12500,"Meili Yan",2013,6,9);
		staff[2] = new Employee(15500,"Dong Li",2012,2,15);
		staff[3] = new Employee(8500,"Hui Zhang",2013,1,15);
		staff[4] = new Employee(11500,"Chunsong Zhao",2015,2,13);
		
		//save all employee records to the file employee.dat
		try(PrintWriter out = new PrintWriter("employee.dat","UTF-8")){
			writeData(staff,out);
		}
		
		//retrieve all records into a new array
		try(Scanner in = new Scanner(new FileInputStream("employee.dat"),"UTF-8")){
			Employee[] newStaff = readData(in);
			
			for(Employee e:newStaff){
				System.out.println(e.toString());
			}
		}
		

	}
	/**
	 * Writes all employees in an array to a print writer.
	 * @param employees an array of employees,
	 * @param out a print writer
	 * @throws IOException
	 */
	private static void writeData(Employee[] employees,PrintWriter out) throws IOException{
		//write numbers of employees
		out.println(employees.length);
		for(Employee e : employees)
			writeEmployee(out,e);
	}
	
	private static Employee[] readData(Scanner in){
		int n = in.nextInt();
		in.nextLine();
		Employee[] employees = new Employee[n];
		for(int i=0;i<n;i++){
			employees[i] = readEmployee(in);
		}
		return employees;
	}
	
	/**
	 * Writes employee data to a print writer
	 * @param out the print writer
	 * @param e
	 */
	private static void writeEmployee(PrintWriter out,Employee e){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(e.getHireDay());
		out.println(e.getName() + "|" + e.getSalary() + "|"
				+ calendar.get(Calendar.YEAR) + "|"
				+ (calendar.get(Calendar.MONTH + 1)) + "|"
				+ calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * Reads employee data from bufferd reader.
	 * @param in the scanner
	 * @return
	 */
	private static Employee readEmployee(Scanner in){
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
		String name = tokens[0];
		double salary = Double.parseDouble(tokens[1]);
		int year = Integer.parseInt(tokens[2]);
		int month = Integer.parseInt(tokens[3]);
		int day  = Integer.parseInt(tokens[4]);
		return new Employee(salary,name,year,month,day);
	}
}
