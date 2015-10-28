package io;

public class SerialCloneTest {
	public static void main(String[] args){
		Employee h1 = new Employee(3000,"hejing",1993,2,3);
		Employee h2 = (Employee) h1.clone();
		h1.rasieSalary(10000);
		
		System.out.println(h1);
		System.out.println(h2);
	}
}
