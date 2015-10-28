package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Employee[] staff = new Employee[5];
		
		staff[0] = new Employee(6500,"Jing He",2013,4,3);
		staff[1] = new Employee(12500,"Meili Yan",2013,6,9);
		Manager m1 = new Manager(15500,"Dong Li",2012,2,15);
		Manager m2 = new Manager(8500,"Hui Zhang",2013,1,15);
		Manager m3 = new Manager(11500,"Chunsong Zhao",2015,2,13);
		
		m1.setSecretary(staff[0]);
		m2.setSecretary(staff[1]);
		m3.setSecretary(staff[0]);
		staff[2] = m1;
		staff[3] = m2;
		staff[4] = m3;
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee1.dat"))){
			out.writeObject(staff);
		}
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee1.dat"))){
			Employee[] newStaff = (Employee[]) in.readObject();
			
			newStaff[0].rasieSalary(200);
			
			for(Employee e : newStaff){
				System.out.println(e);
			}
		}
	}
}
