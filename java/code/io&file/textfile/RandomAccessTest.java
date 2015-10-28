package io;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RandomAccessTest {

	public static void main(String[] args) throws IOException{
		Employee[] staff = new Employee[5];
		
		staff[0] = new Employee(6500,"Jing He",2013,4,3);
		staff[1] = new Employee(12500,"Meili Yan",2013,6,9);
		staff[2] = new Employee(15500,"Dong Li",2012,2,15);
		staff[3] = new Employee(8500,"Hui Zhang",2013,1,15);
		staff[4] = new Employee(11500,"Chunsong Zhao",2015,2,13);
		
		try(DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"))){
			for(Employee e:staff){
				writeData(out, e);
			}
		}
		
		try(RandomAccessFile in = new RandomAccessFile("employee.dat","r")){
			int n = (int)(in.length() / Employee.RECORD_SIZE);
			Employee[] newStaff = new Employee[n];
			
			for(int i = n-1;i>=0;i--){
				newStaff[i] = new Employee();
				in.seek(i*Employee.RECORD_SIZE);
				newStaff[i] = readData(in);
			}
			
			for(Employee e : newStaff){
				System.out.println(e);
			}
		}
	}
	
	public static void writeData(DataOutput out,Employee e) throws IOException{
		DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
		out.writeDouble(e.getSalary());
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(e.getHireDay());
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH)+1);
		out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	public static Employee readData(DataInput in) throws IOException{
		String name = DataIO.readFixedString(Employee.NAME_SIZE,in);
		double salary = in.readDouble();
		int y = in.readInt();
		int m = in.readInt();
		int d = in.readInt();
		return new Employee(salary,name,y,m-1,d);
	}
}
