package io;

import java.io.Serializable;
import java.util.Date;

public class Manager extends Employee implements Serializable {
	
	private Employee secretary;

	

	public Employee getSecretary() {
		return secretary;
	}



	public void setSecretary(Employee secretary) {
		this.secretary = secretary;
	}



	public Manager(double salary, String name, int year,int month,int day) {
		super(salary, name, year,month,day);
		//this.employee = employee;
	}



	@Override
	public String toString() {
		return "Manager [secretary=" + secretary + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
