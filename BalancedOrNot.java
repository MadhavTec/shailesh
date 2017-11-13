package TechChallenge;

import java.util.Scanner;

public class BalancedOrNot {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many expressions you want to test ?");
		int numOfExpressions = scan.nextInt();
		String[] expressions = new String[numOfExpressions];
		int[] maxReplacements = new int[numOfExpressions];
		for (int i = 0; i < numOfExpressions; i++) {
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter " + (i + 1) + " Expression");
			expressions[i] = scan1.nextLine();
			System.out.println("Enter " + (i + 1) + " Expression's max replacement value");
			maxReplacements[i] = scan1.nextInt();
		}
		int[] balanceInfoArray = balancedOnNot(expressions, maxReplacements);
		for (int i : balanceInfoArray) {
			System.out.println(i);
		}
	}

	static int[] balancedOnNot(String[] expressions, int[] maxReplacements) {
		int[] expressionBalanceInfo = new int[maxReplacements.length];
		for (int i = 0; i < expressions.length; i++) {
			char[] exp = expressions[i].toCharArray();
			int countGT = 0;
			int countLT = 0;
			for (int j = 0; j < exp.length; j++) {
				if (exp[j]=='>') {
					countGT++;
				} else if (exp[j]=='<') {
					countLT++;
				}
			}
			if (countGT == countLT) {
				expressionBalanceInfo[i] = 1;
			} else if (countGT > countLT) {
				if ((countGT - countLT) > maxReplacements[i]) {
					expressionBalanceInfo[i] = 0;
				} else {
					expressionBalanceInfo[i] = 1;
				}
			} else {
				expressionBalanceInfo[i] = 0;
			}
		}
		return expressionBalanceInfo;
	}
}
