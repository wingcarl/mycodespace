package io;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private double salary;
	private String name;
	private Date hireDay ;
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getHireDay() {
		return hireDay;
	}
	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}
	public Employee(double salary, String name, Date calendar) {
		super();
		this.salary = salary;
		this.name = name;
		this.hireDay = calendar;
	}
	public Employee(double salary, String name, int year,int month,int day) {
		super();
		this.salary = salary;
		this.name = name;
		this.hireDay = new GregorianCalendar(year,month-1,day).getTime();
	}
	@Override
	public String toString() {
		return "Employee [工资=" + salary + ", 姓名=" + name + ", 雇佣日期="
				+ hireDay + "]";
	}
	
}
