package lecture11;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author vgorin
 *         file created on 9/8/16 6:06 PM
 */


public class BinarySearch {
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		return rank(key, a, lo, hi, 0);
	}

	public static int rank(int key, int[] a, int lo, int hi, int depth) {
		StdOut.printf("%d%s %d/%d\n", depth, indent(depth), lo, hi);
		if(lo > hi) {
			return -1;
		}
		int mid = lo + (hi - lo) / 2;
		if(key < a[mid]) {
			return rank(key, a, lo, mid - 1, depth + 1);
		}
		else if(key > a[mid]) {
			return rank(key, a, mid + 1, hi, depth + 1);
		}
		else {
			return mid;
		}
	}

	public static String indent(int depth) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < depth; i++) {
			sb.append('.');
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		// read the integers from a file
		In in = new In(args[0]);
		int[] whitelist = in.readAllInts();

		// sort the array
		Arrays.sort(whitelist);

		// read integer key from standard input; print if not in whitelist
		while(!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			StdOut.println(BinarySearch.rank(key, whitelist));
		}
	}


}
