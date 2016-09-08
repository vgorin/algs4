package lecture11;

/**
 * @author vgorin
 *         file created on 9/8/16 12:01 PM
 */


public class Fibonacci {
	private static long[] values = new long[100];

	public static long F(int N) {
		if(N == 0) {
			return 0;
		}
		if(N == 1) {
			return 1;
		}
		if(N < values.length && values[N] != 0) {
			return values[N];
		}
		long result = F(N - 1) + F(N - 2);
		if(N < values.length) {
			values[N] = result;
		}
		return result;
	}
}
