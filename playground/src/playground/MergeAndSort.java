package playground;

import java.util.Random;

public class MergeAndSort {

	public static void main(String[] args) {
		Random r = new Random(System.currentTimeMillis());
	    int n = r.nextInt(101) + 50;
	    int[] a = new int[n];
	    for(int i = 0; i < n; i++)
	      a[i] = r.nextInt(100);
	    n = r.nextInt(101) + 50;
	    int[] b = new int[n];
	    for(int i = 0; i < n; i++)
	      b[i] = r.nextInt(100);
	    a = sort(a);
	    b = sort(b);
	    int[] c = merge(a, b);
	    display(a);
	    display(b);
	    display(c);
	}

	public static int[] sort(int[] x){
	    for(int i = 0; i < x.length ; i++){
	      int indexOfSmallest = findIndexOfSmallest(x, i);
	      int t = x[i];
	      x[i] = x[indexOfSmallest];
	      x[indexOfSmallest] = t;
	    }
	    return x;
	  }
	  
	  private static int findIndexOfSmallest(int[] a, int from){
	    int indexOfSmallest = from;

	    for(int i = from; i < a.length; i++)
	      if(a[i] < a[indexOfSmallest])
	        indexOfSmallest = i;
	    return indexOfSmallest;
	  }
	  
	  public static int[] merge(int[]a, int[]b){
	    int aIndex = 0, bIndex = 0, cIndex = 0;
	    int[] c = new int[a.length + b.length];
	    while(aIndex < a.length && bIndex < b.length)
	      if(a[aIndex] < b[bIndex])
	        c[cIndex++] = a[aIndex++];
	      else
	        c[cIndex++] = b[bIndex++];

	    while(aIndex < a.length)
	      c[cIndex++] = a[aIndex++];
	    
	    while(bIndex < b.length)
	      c[cIndex++] = b[bIndex++];
	    return c;
	  }
	  
	  private static void display(int[] x) {
	    for(int i = 0; i < x.length; i++)
	      System.out.print(x[i] + ", ");
	      System.out.println("\n---------------------------------");
	  }

	
}
