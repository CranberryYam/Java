package playground;

/* this file is for recPow and mergeSort */

public class TryRecursion {
	static int counter=1;

	public static void main(String[] args) {
		System.out.println("2^0 = "+recPow(0));
		System.out.println("2^-2 = "+recPow(-2));
		System.out.println("2^10 = "+recPow(10));
		
		int[] g = { 78, 9, 2, 102};
		int[] h = { 92, 25, 64, 4, 34};
        int[] i = mergeSort(g, h);
        	System.out.print("sort array = ");
		printArray(i);
	}

	public static Double recPow(int n) {
		if (n == 0) {
			return 1.0;
		}else if(n > 0){
			return 2*recPow(n-1);
		}else {
			return recPow(n+1)/2;
		}
	}
	
    public static void mergeSortedArray(int[] c,int[] a, int[] b){
       int currentA = 0, currentB = 0, currentC = 0;
       int aLength = a.length;
       int bLength = b.length;

       while(currentA<aLength && currentB <bLength){
          if (a[currentA] < b[currentB]) {
        	        c[currentC]=a[currentA];
        	        currentC++;
        	        currentA++;
          }else {
        	        c[currentC]=b[currentB];
        	        currentC++;
        	        currentB++;
          }   
          //System.out.println("first loop"+currentC+"a"+currentA+"b"+currentB);
       }  //this definitely gonna use up one of the list
       
       while(currentA < aLength) {
    	      //System.out.println("second loop"+currentC);
          c[currentC++] = a[currentA++];
       }
       while(currentB < bLength) {
    	      //System.out.println("third loop"+currentC);
    	      c[currentC++] = b[currentB++];
       }
      }
    
    public static void sort(int[] a) {   
    	
		if(a.length == 1) {
//			System.out.println("length=1   "+a[0]);
			return;
		}
	    int L[] = new int [a.length/2];
	    int R[] = new int [a.length-L.length];
	 
	    System.arraycopy(a, 0, L, 0, L.length);
        System.arraycopy(a, L.length,R, 0, R.length);
//        System.out.print("R=  ");
//        printArray(R);
//        System.out.print("L=  ");
//        printArray(L);
        sort(L);
        sort(R);

        mergeSortedArray(a, L, R);
	}
    
    public static int[] mergeSort(int[] a, int[] b) {
    	    sort(a);
    	    sort(b);
    	    int[] c = new int[a.length+b.length];
		mergeSortedArray(c, a, b);
		return c;
	}

    public static void printArray(int[] c) {
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]+" ");
		}
		System.out.println(" ");
	}
    public static void recurseCount() {
    	    counter++;
    	    System.out.println("the "+counter+" layer");
    }

}
