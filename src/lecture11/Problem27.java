package lecture11;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author vgorin
 *         file created on 9/9/16 3:14 PM
 */


public class Problem27 {
	private static int counter;

	public static double binomial(int N, int k, double p) {
		if(N == 0 && k == 0) {
			return 1.0;
		}
		if(N < 0 || k < 0) {
			return 0.0;
		}
		counter++;
		return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
	}

	public static void main(String[] args) {
		StdOut.println(binomial(2, 1, 0.25));
		StdOut.println(counter);
	}
}
