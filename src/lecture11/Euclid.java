package lecture11;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author vgorin
 *         file created on 9/8/16 6:41 PM
 */


public class Euclid {
	public static int gcd(int p, int q) {
		return gcd(p, q, 0);
	}

	public static int gcd(int p, int q, int depth) {
		StdOut.printf("%d%s gcd(%d,%d)\n", depth, indent(depth), p, q);
		if(q == 0) {
			return p;
		}
		int r = p % q;
		return gcd(q, r, depth + 1);
	}

	public static String indent(int depth) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < depth; i++) {
			sb.append('.');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		StdOut.printf("gcd(105,24) = %d\n", gcd(105, 24));
		StdOut.println();
		StdOut.printf("gcd(1111111,1234567) = %d\n", gcd(1111111, 1234567));
	}
}
