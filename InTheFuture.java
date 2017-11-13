import java.util.Scanner;

public class InTheFuture {

	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter asha's per day problem solving capacity");
		int ashaCapacity=scan.nextInt();
		System.out.println("Enter kelly's per day problem solving capacity");
		int kellyCapacity=scan.nextInt();
		System.out.println("How many problems Asha is ahead of kelly?");
		int ashaAheadOfKelly=scan.nextInt();
		int minDays=minNum(ashaCapacity, kellyCapacity, ashaAheadOfKelly);
		System.out.println(minDays);
		
	}
	static int minNum(int a,int k,int p){
		return  (a>k)?-1:(a==k && p>0)?-1:getMinDays(a,k,p);
	}
	private static int getMinDays(int a, int k, int p) {
		// formula I have derived for getting min num n
		/**
		 * n=(p/(k-a))+1 where P num of ahead problems
		 *  k kelly's problem solving capacity and a asha's capacity 
		 */
		return (p/(k-a))+1;
		
	}
}
