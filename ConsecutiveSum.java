package TechChallenge;

import java.util.Scanner;

public class ConsecutiveSum {

	public static void main(String[] args) {
		System.out.println("Enter a value");
		Scanner scan = new Scanner(System.in);
		long num = scan.nextLong();
		int ways = consecutive(num);
		System.out.println(ways);
	}

	static int consecutive(long num) {
		int ways = 0;
		/**
		 * N=a+(a+1)+(a+2)+(a+3)+.......+(a+n)
		 * 
		 * N=(a+an) + n(n+1)/2 
		 * 
		 * N= a(1+n) + n(n+1)/2
		 * 
		 * a= (N - n(n+1)/2)(1+n) 
		 * 
		 * where 
		 * a= num of ways
		 * N = num for test
		 * n= num of consecutive numbers 
		 * 
		 */
		
		for (int i = 1; i*(i+1)/2 < num; i++) {
			double a=(1.0 * num-(i * (i + 1)) / 2) / (i + 1);
	           if(a-(int)a==0){
	        	   ways++;
	           }
	                       
		}
		return ways;
	}

}
