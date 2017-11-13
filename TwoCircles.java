package TechChallenge;

import java.util.Scanner;

public class TwoCircles {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter num of test cases");
		int testCases = scan.nextInt();
		// int[][] circlesCoordinates=new int[testCases][6];
		String[] circlesCoordinates = new String[testCases];
		System.out.println("Enter " + circlesCoordinates.length + " values");
		for (int i = 0; i < circlesCoordinates.length; i++) {
			Scanner scan1 = new Scanner(System.in);
			circlesCoordinates[i] = scan1.nextLine();
		}
		String[] result = circles(circlesCoordinates);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	static String[] circles(String[] info) {
		String[] circle;
		//System.err.println("info "+info.length);
		String[] result = new String[info.length];
		for (int i = 0; i < info.length; i++) {
			circle = info[i].split(" ");
			result[i] = getResultBasedOnCoordinates(circle);
		}
		// System.out.println("result "+result.length);
		return result;
	}

	static String getResultBasedOnCoordinates(String[] circle) {
		double distanceBetweenCenters = Math
				.sqrt((Math.pow((Integer.parseInt(circle[0]) - Integer.parseInt(circle[3])), 2))
						+ (Math.pow((Integer.parseInt(circle[1]) - Integer.parseInt(circle[4])), 2)));
		int r1 = Integer.parseInt(circle[2]);
		int r2 = Integer.parseInt(circle[5]);
		return calculateResult(distanceBetweenCenters, r1, r2);
	}

	private static String calculateResult(double distanceBetweenCenters, int r1, int r2) {
		int bigRadius;
		int smallRadius;
		if (r1 >= r2) {
			bigRadius = r1;
			smallRadius = r2;
		} else {
			bigRadius = r2;
			smallRadius = r1;
		}
//		System.out.println("Distance "+distanceBetweenCenters);
//		System.out.println("r1 "+bigRadius);
//		System.out.println("r2 "+smallRadius);
		return (distanceBetweenCenters == 0) ? "Concentric"
				: distanceBetweenCenters == (bigRadius + smallRadius) || bigRadius == (distanceBetweenCenters + smallRadius) ? "Touching"
						: distanceBetweenCenters > (bigRadius + smallRadius) ? "Disjoint-Outside"
								: bigRadius > (distanceBetweenCenters + smallRadius) ? "Disjoint-Inside"
										: bigRadius < (distanceBetweenCenters + smallRadius) ? "Intersecting" : "";

	}

}
