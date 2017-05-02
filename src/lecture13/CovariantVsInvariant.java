package lecture13;

import java.math.BigDecimal;
import java.util.*;

/**
 * @see <a href="http://www.programmr.com/blogs/two-things-every-java-developer-should-know-about-arrays">covariant vs invariant</a>
 *
 * @author vgorin
 *         file created on 5/2/17 10:07 AM
 */


public class CovariantVsInvariant {
	public static void main(String[] args) {
		List[] lists = new List[5];
		List<Integer>[] integers = (List<Integer>[]) lists;
		List<Long>[] longs = (List<Long>[]) lists;
		List<Float>[] floats = (List<Float>[]) lists;
		List<Double>[] doubles = (List<Double>[]) lists;
		List<BigDecimal>[] decimals = (List<BigDecimal>[]) lists;

		integers[0] = new LinkedList<>();
		integers[0].add(1);

		longs[1] = new LinkedList<>();
		longs[1].add(2L);

		floats[2] = new LinkedList<>();
		floats[2].add(3.01f);

		doubles[3] = new LinkedList<>();
		doubles[3].add(4.02);

		decimals[4] = new LinkedList<>();
		decimals[4].add(BigDecimal.valueOf(5.03));

		System.out.println(Arrays.toString(lists));
	}
}
