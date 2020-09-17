import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class exponentialTetranacci {
	public static void main(String[] args) throws IOException {

		PrintWriter writer = new PrintWriter(
				new FileWriter("/Users/raffialanbezirjian/eclipse-workspace/COMP352_Fall_A1/ExpTetrancciOut.txt"));

		try {
			// n will hold the value
			BigInteger n;
			// First loop to calculate the value for every interval incremented by 5
			for (int i = 5; i <= 30; i = i + 5) {
				// String holds the value to be printed in output file
				String line = "----- Execution time for " + i + " elements -----";
				// String will be printed to output file
				writer.println(line);

				// String assigned new value
				line = "Number	Tetra. Value Execution time(in ns)";
				// String will be printed to output file
				writer.println(line);
				// Loop for iterating all the integer lesser than y
				for (int j = 1; j <= i; j++) {
					// Start time holds the start time of algorithm
					long StartTime = System.nanoTime();
					n = ExponentialTetranacci(j);
					// End time holds the end time of algorithm
					long EndTime = System.nanoTime();
					// Difference will give the run time of algorithm
					long timeElapsed = EndTime - StartTime;

					// printing tetranacci values along with runtime
					writer.println(j + "	" + n + "	" + timeElapsed);
					//	System.out.println(j + "	" + n + "	" + timeElapsed);

				}
				writer.println("\n");
			}
			writer.close();
		} catch (Exception e) {
			writer.close();
			e.printStackTrace();
		}
	}

	private static BigInteger ExponentialTetranacci(int n) {
		// base case
		if (n == 0 || n == 1 || n == 2)
			return BigInteger.ZERO;
		// base cases
		if (n == 3)
			return BigInteger.ONE;
		// base cases

		else
			// making recursive call
			return ExponentialTetranacci(n - 1).add(ExponentialTetranacci(n - 2)).add(ExponentialTetranacci(n - 3))
					.add(ExponentialTetranacci(n - 4));
	}

}