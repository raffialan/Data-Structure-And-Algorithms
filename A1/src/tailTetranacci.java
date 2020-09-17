import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class tailTetranacci {
	public static void main(String[] args) throws IOException {
		PrintWriter writer = new PrintWriter(
				new FileWriter("/Users/raffialanbezirjian/eclipse-workspace/COMP352_Fall_A1/TailTetrancciOut.txt"));
		try {
			BigInteger n;

			for (int i = 5; i <= 100; i = i + 5) {
				// String holds the value to be printed in output file
				String line = "----- Execution time for " + i + " elements -----";
				// String will be printed to output file
				writer.println(line);

				// String assigned new value
				line = "Number	Tetranacci Value Execution time(in ns)";
				// String will be printed to output file
				writer.println(line);
				// Loop for iterating all the integer lesser than y
				for (int j = 1; j <= i; j++) {
					// Start time holds the start time of algorithm
					long StartTime = System.nanoTime();
					n = TRTetranacci(j);
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

	private static BigInteger TRTetranacci(int n) {
		if (n < 0)
			//can't find tetranacci of negative
			throw new IllegalArgumentException("Negative argument.");
		//initial values of tetranacci series A[] = {0,0,0,1}
		BigInteger[] A = { BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE };
		return tetranacciRecursive(n, A);
	}

	private static BigInteger tetranacciRecursive(int n, BigInteger[] a) {
		//base case
		if (n < 4)
			return a[n];
		//sum of 1st 4 values
		BigInteger sum = a[0].add(a[1]).add(a[2]).add(a[3]);
		for (int i = 0; i < 3; i++)
			//swapping index 1 step ahead every time
			a[i] = a[i + 1];
		//sum value become 4th index of the array
		a[3] = sum;
		//recursive call until we reach base case
		return tetranacciRecursive(n - 1, a);
	}
}