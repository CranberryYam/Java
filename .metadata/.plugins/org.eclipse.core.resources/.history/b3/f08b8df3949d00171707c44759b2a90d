package project1;
import java.util.Arrays;
import java.util.Random;

import project1.SortThread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
//		System.out.println("Hello World");
		Random r = new Random(System.currentTimeMillis());
		
	    int n = r.nextInt(101) + 50;
	    int[] a = new int[n];
	    for(int i = 0; i < n; i++)
	      a[i] = r.nextInt(100);
	    
	    n = r.nextInt(101) + 50;
	    int[] b = new int[n];
	    for(int i = 0; i < n; i++)
	      b[i] = r.nextInt(100);
	    
	    SortThread s1 = new SortThread(a);
	    SortThread s2 = new SortThread(b);
	    Thread t1 =new Thread(s1);
	    Thread t2 = new Thread(s2);
	    t1.start();
	    t2.start();
	    while (true) {
	    	        Boolean die = (!t1.isAlive() && !t2.isAlive());
//	    	        System.out.println(die);
			if (die) {
//				System.out.println("all died");
//				die = (!t1.isAlive() && !t2.isAlive());
//	    	        System.out.println(die);
				MergeThread m1 = new MergeThread(s1.get(), s2.get());
				Thread t3 = new Thread(m1);
				t3.start();
				t3.join();
				System.out.println(Arrays.toString(m1.get()));
		        break;
			}
		}

	}

}


