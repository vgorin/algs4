package lecture11;

import java.io.PrintWriter;

/**
 * @author vgorin
 *         file created on 9/8/16 6:16 PM
 */


public class IntArrayGenerator {
	public static void main(String[] args) throws Exception {
		int numbers = Integer.parseInt(args[0]);
		PrintWriter w = new PrintWriter(args[1]);

		for(int i = 0; i < numbers; i++) {
			w.println((int)(Math.random() * numbers));
		}
		w.close();
	}
}
