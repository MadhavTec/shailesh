package TechChallenge;

import java.util.Scanner;

public class BuyingShowTickets {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter num of buyers for tickets");
		int numOfBuyers = scan.nextInt();

		int[] tickets = new int[numOfBuyers];
		System.out.println("Enter tickets for all " + numOfBuyers + " buyers");
		for (int i = 0; i < tickets.length; i++) {
			Scanner scan1 = new Scanner(System.in);
			tickets[i] = scan1.nextInt();
		}
		System.out.println("Enter position of jesse in a row");
		int position = scan.nextInt();
		long time = waitingTime(tickets, position);
		System.out.println(time);

	}

	private static long waitingTime(int[] tickets, int position) {
		int time = 0;
		int jesseTickets = tickets[position];
		/**
		 * I derived a way to get waiting time
		 * 
		 * Suppose tickets=[2,4,6,4,6] is a array of person and tickets and
		 * position of jesse is 2 means tickets[2] is 6;
		 * 
		 * and time=0
		 * 
		 * So in my way before position 2 if tickets count is less then or equal
		 * to 6 then add same num to time otherwise max num to add should be 6
		 * 
		 * and after position 2 if tickets count is less then to 6 then add same
		 * num to time otherwise if tickets count is equal and more then 6, then
		 * add 6-1 to time
		 * 
		 * 
		 */

		for (int i = 0; i < tickets.length; i++) {
			if (i <= position) {
				if (jesseTickets >= tickets[i]) {
					time += tickets[i];
				} else {
					time += jesseTickets;
				}
			} else {
				if (jesseTickets > tickets[i]) {
					time += tickets[i];
				} else {
					time += jesseTickets - 1;
				}
			}
		}
		return time;
	}

}
