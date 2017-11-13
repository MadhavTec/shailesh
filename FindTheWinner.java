import java.io.IOException;
import java.util.Scanner;

public class FindTheWinner {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int[] andriaArray = getValues("Andria's");
		int[] mariaArray = getValues("Maria's");
		System.out.println("Enter game type ODD or EVEN");
		String gameType = scan.nextLine();
		String winner = winner(andriaArray, mariaArray, gameType);
		System.out.println(winner);
	}

	private static int[] getValues(String name) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many elements you want to put in " + name + " array ?");
		int arraySize = scan.nextInt();
		int[] arrayOfNum = new int[arraySize];
		System.out.println("Enter values"); 
		for (int i = 0; i < arraySize; i++) {
			Scanner scan1 = new Scanner(System.in);
			arrayOfNum[i] = scan1.nextInt();
		}
		return arrayOfNum;
	}

	static String winner(int[] andrea, int[] maria, String s) {
		int maxNumOfTurn = (andrea.length > maria.length) ? maria.length : andrea.length;
		String winner = (s.toUpperCase().equals("EVEN")) ? getWinner(0, maxNumOfTurn, andrea, maria)
				: getWinner(1, maxNumOfTurn, andrea, maria);
		return winner;
	}

	static String getWinner(int i, int maxNumOfTurn, int[] andrea, int[] maria) {
		int andriaPoints = 0;
		int mariaPoints = 0;
		for (int j = i; j < maxNumOfTurn; j += 2) {
			andriaPoints += andrea[j] - maria[j];
			mariaPoints += maria[j] - andrea[j];
		}
		return (andriaPoints==mariaPoints)? "Tie":(andriaPoints>mariaPoints?"Andria":"Maria");
	}

}
