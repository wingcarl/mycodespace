package future;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter base directory:");
		String directory = in.nextLine();
		System.out.print("Enter keyword:");
		String keyword = in.nextLine();
		MatchCounter counter = new MatchCounter(new File(directory),keyword);
		FutureTask<Integer> task = new FutureTask<>(counter);
		new Thread(task).start();
		try{
			System.out.println(task.get() + "matching files.");
		}
		catch(ExecutionException e){
			e.printStackTrace();
		}catch(InterruptedException e){
			
		}
	}
}
