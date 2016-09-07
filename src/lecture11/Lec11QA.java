package lecture11;

/**
 * @author vgorin
 *         file created on 9/7/16 11:44 AM
 */


public class Lec11QA {
	public static void main(String[] args) {
		int value = -23212;
		System.out.printf("Math.abs(%d) = %d\n", value, Math.abs(value));
		System.out.printf("-(%d) = %d\n", value, -value);

		// -(-2147483648) = -2147483648
		value = 1 << 31; // -2147483648
		System.out.printf("Math.abs(%d) = %d\n", value, Math.abs(value));
		System.out.printf("-(%d) = %d\n", value, -value);

		// Infinity?
		System.out.printf("1.0 / 0.0 = %f\n", 1.0 / 0.0);
		System.out.printf("1.0 / -0.0 = %f\n", 1.0 / -0.0);

		// ArithmeticException
		try{
			System.out.printf("1/0 = %d\n", 1/0);
		}
		catch(Exception e) {
			System.out.printf("1/0 caused an %s: %s\n", e.getClass().getSimpleName(), e.getMessage());
		}
	}
}
