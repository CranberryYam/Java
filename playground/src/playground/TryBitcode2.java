package playground;

/* This file defines two function, one for factory, one for tail recursion */

public class TryBitcode2 {
	public static int fact(int n) {
		if(n == 0) {
			return 1;	
		}
		else {
			return n*fact(n-1);
		}
		
	}
	
	public static int tailfact(int n, int x) {
		if (n == 0) {
			return x;
		}else {
			return tailfact(n-1, n*x);
		}
	}
}
