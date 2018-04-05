package Tencent;

import java.sql.Struct;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
class Machine implements Comparable<Machine>{
	int max_time;
	int level;
	@Override
	public 	int compareTo(Machine m){
		return this.level==m.level? this.max_time-m.max_time:this.level-m.level;
	}
}
class Job{
	int max_time;
	int level;
}
public class MachineJob {

	/**
	 * @param args
	 */
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        while (in.hasNextInt()) {//注意while处理多个case
	            int n = in.nextInt();
	            int m = in.nextInt();
	            Machine[] machine = new Machine[n];
	            Job[] job = new Job[m];
	            for(int i = 0;i<n;i++){
	            		machine[i] = new Machine();
	            		machine[i].max_time = in.nextInt() ;
	            		machine[i].level = in.nextInt();
	            	
	            }
	            for(int i = 0;i<m;i++){
	            		job[i] = new Job();
	            		job[i].max_time = in.nextInt();
	            		job[i].level = in.nextInt();
	            	
	            }
	            
	            Arrays.sort(machine);
	            for(Machine ma : machine)
	            	System.out.println(ma.level+"   "+ma.max_time + " ");
	            
	            Arrays.sort(job,new Comparator<Job>() {

					@Override
					public int compare(Job o1, Job o2) {
						// TODO Auto-generated method stub
						
						return o1.level==o2.level?o1.max_time-o2.max_time:o1.level-o2.level;
					}
	            	
				});
	            
	            for(Job ma : job)
	            	System.out.println(ma.level+"   "+ma.max_time + " ");
	        }
	}

	

}
