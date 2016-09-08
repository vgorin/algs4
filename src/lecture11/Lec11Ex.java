package lecture11;

/**
 * @author vgorin
 *         file created on 9/7/16 5:24 PM
 */


public class Lec11Ex {
	public static void main(String[] args) {
		System.out.printf("mystery1(2, 25) = %d\n", mystery1(2, 25));
		System.out.printf("mystery1(3, 11) = %d\n", mystery1(3, 11));
		System.out.printf("mystery2(2, 25) = %d\n", mystery2(2, 25));
		System.out.printf("mystery2(3, 11) = %d\n", mystery2(3, 11));

		System.out.println("\nFibonacci:");
		long ts0 = System.currentTimeMillis(), ts1;
		for (int N = 0; N < 40; N++) {
			long Fn = F(N);
			ts1 = System.currentTimeMillis();
			System.out.printf("%d:\t%d,\t%dms\n", N, Fn, ts1 - ts0);
			ts0 = ts1;
		}
		System.out.println("\nFibonacci Optimized:");
		for (int N = 0; N < 100; N++) {
			long Fn = Fibonacci.F(N);
			ts1 = System.currentTimeMillis();
			System.out.printf("%d:\t%d,\t%dms\n", N, Fn, ts1 - ts0);
			ts0 = ts1;
		}

	}

	// returns a * b
	public static int mystery1(int a, int b) {
		if(b == 0) {
			return 0;
		}
		if(b % 2 == 0) {
			return mystery1(a + a, b / 2);
		}
		return mystery1(a + a, b / 2) + a;
	}

	// returns a ^ b
	public static int mystery2(int a, int b) {
		if(b == 0) {
			return 1;
		}
		if(b % 2 == 0) {
			return mystery2(a * a, b / 2);
		}
		return mystery2(a * a, b / 2) * a;
	}

	public static long F(int N) {
		if(N == 0) {
			return 0;
		}
		if(N == 1) {
			return 1;
		}
		return F(N - 1) + F(N - 2);
	}

}
