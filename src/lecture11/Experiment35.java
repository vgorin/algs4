package lecture11;

import edu.princeton.cs.algs4.StdOut;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author vgorin
 *         file created on 9/9/16 4:42 PM
 */


public class Experiment35 {
	public static void main(String[] args) {
		int sides = 6;
		double[] dist = new double[sides * 2 + 1];
		for(int i = 1; i <= sides; i++) {
			for(int j = 1; j <= sides; j++) {
				dist[i + j] += 1.0;
			}
		}
		StdOut.println("Calculated distribution:");
		for(int k = 2; k <= 2 * sides; k++) {
			dist[k] /= 36.0;
			StdOut.printf("%d: %.2f%%\n", k, dist[k] * 100);
		}

		int mathRandomThrowings = 10_000_000;
		StdOut.printf("\nExperiment Math.random, %d throwings\n", mathRandomThrowings);

		double[] experiment = new double[sides * 2 + 1];
		for(int t = 0; t < mathRandomThrowings; t++) {
			experiment[throwDiceMathRandom() + throwDiceMathRandom()] += 1;
		}

		for(int k = 2; k <= 2 * sides; k++) {
			experiment[k] /= mathRandomThrowings;
			StdOut.printf("%d: %.2f%%\n", k, experiment[k] * 100);
		}

		int secureRandomThrowings = 10_000_000;
		StdOut.printf("\nExperiment SecureRandom, %d throwings\n", secureRandomThrowings);

		for(int t = 0; t < secureRandomThrowings; t++) {
			experiment[throwDiceSecureRandom() + throwDiceSecureRandom()] += 1;
		}

		for(int k = 2; k <= 2 * sides; k++) {
			experiment[k] /= secureRandomThrowings;
			StdOut.printf("%d: %.2f%%\n", k, experiment[k] * 100);
		}
	}

	public static int throwDiceMathRandom() {
		return (int) (Math.random() * 6 + 1);
	}

	public static int throwDiceSecureRandom() {
		try {
			return (int) (SecureRandom.getInstanceStrong().nextDouble() * 6 + 1);
		}
		catch(NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
