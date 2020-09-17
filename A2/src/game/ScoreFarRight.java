package game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ScoreFarRight {

	static Integer[] scoreArray;

	static int previousElement = 0;

	//main method for start the application
	public static void main(String args[]) {
		getInput();

	}

	//method for getting values from the user
	private static void getInput() {

		boolean isnotCorrectInput = false;
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Please enter positive Array Size ==> ");

			int size = sc.nextInt();

			if (size > 0) {

				scoreArray = new Integer[size];

				for (int i = 0; i < scoreArray.length; i++) {

					if (i == scoreArray.length - 1) {
						System.out.println("This is last square index you should enter 0");
						int last = sc.nextInt();
						if (last == 0) {
							scoreArray[i] = last;
						} else {
							System.out.println("Value should be 0");
							isnotCorrectInput = true;
							break;
						}
					} else {
						System.out.println("Please enter positive value at square ==> " + i);
						int value = sc.nextInt();
						if (value > 0) {
							scoreArray[i] = value;
						} else {
							System.out.println("Value should be >=1");
							isnotCorrectInput = true;
							break;

						}
					}

				}

			} else {
				System.out.println("Incorrect Value. ");
				isnotCorrectInput = true;
			}

			if (isnotCorrectInput) {
				getInput();
			} else {
				System.out.println("Below are your Input =>");
				List<Integer> list = Arrays.asList(scoreArray);
				System.out.println(list);
				System.out.println("Please provide index of the array element =>");
				int value = sc.nextInt();
				if (value >= 0 && value < scoreArray.length) {
					int index = getIndexfromElement(value);
					playgame(index);

				} else {
					int last = scoreArray.length - 1;
					System.out.println("Value shoud be from 0 to " + last + " Please start again.!");
					getInput();
				}

			}

		} catch (Exception e) {
			System.out.println("Incorrect Value. ");
			isnotCorrectInput = true;
			getInput();
		}

	}

	//main method - Recursion method
	private static void playgame(int index) {

		int element = scoreArray[index];

		if (element == 0) {

			System.out.println("True");

		} else if (element == previousElement) {
			System.out.println("False");
		} else {

			int sum = index + element;
			if (sum < scoreArray.length) {
				index = index + element;
				if (index >= 0 && index < scoreArray.length) {
					previousElement = element;
					playgame(index);
				} else {
					System.out.println("False");
				}
			} else if (index >= element) {
				index = index - element;
				if (index >= 0 && index < scoreArray.length) {
					previousElement = element;
					playgame(index);
				} else {
					System.out.println("False");
				}
			} else {
				System.out.println("False");
			}

		}

	}

	//method for get index value from array element
	private static int getIndexfromElement(int element) {
		int index = 0;
		for (int i = 0; i < scoreArray.length; i++) {
			if (element == scoreArray[i]) {
				index = i;
				break;
			}
		}
		return index;
	}

}
