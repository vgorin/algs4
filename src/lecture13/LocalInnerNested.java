package lecture13;

/**
 * @see <a href="http://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html">Local Classes</a>
 * @see <a href="http://docs.oracle.com/javase/tutorial/java/javaOO/nested.html">Nested Classes</a>
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/whentouse.html">When to use the Shit</a>
 *
 * @author vgorin
 *         file created on 5/2/17 10:44 AM
 */


public class LocalInnerNested {
	private static class Nested {
		@Override
		public String toString() {
			return "Nested{}";
		}

	}

	private class Inner {
		@Override
		public String toString() {
			return "Inner{}";
		}

	}

	@Override
	public String toString() {
		return "LocalInnerNested{}";
	}

	public static void main(String[] args) {
		class Local {
			@Override
			public String toString() {
				return "Local{}";
			}
		}

		LocalInnerNested localInnerNested = new LocalInnerNested();
		Nested nested = new LocalInnerNested.Nested();
		Inner inner = localInnerNested.new Inner();
		Local local = new Local();

		System.out.println(localInnerNested);
		System.out.println(nested);
		System.out.println(inner);
		System.out.println(local);
	}

}
