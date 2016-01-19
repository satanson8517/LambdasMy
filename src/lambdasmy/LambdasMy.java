package lambdasmy;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com>
 */
public class LambdasMy {

	public static void main(String[] args) {
//        List<String> words = Arrays.asList(new String[]{});
		List<String> words = Arrays.asList(new String[]{"first", "second", "", "fourth"});
		System.out.println(words.stream()
				//                .filter(s -> sout(s))
				//                .forEach(s -> sout(s));
				.map(s -> s.isEmpty() ? "EMPTY_STRING" : s)
				.reduce(joinOn("\n"))
				.orElse("EMPTY_RESULT")
		);

		System.out.println(plus().applyAsInt(2, 5));

		TernaryOperator plus = (a, b, c) -> 4 * a + 2 * b + c;
		TernaryOperator minus = (a, b, c) -> 4 * a - 2 * b - c;

		System.out.println(plus.apply(2, 5, 10));
		System.out.println(minus.apply(2, 5, 10));
		
	}

	private static BinaryOperator<String> joinOn(String joiner) {
		return (accumulator, newString) -> accumulator + joiner + newString;
	}

	private static IntBinaryOperator plus() {
		return (a, b) -> 4 * a + 2 * b;
	}
	
//	private static UnaryOperator<String> empty(){
//		return s -> s.isEmpty() ? "EMPTY_STRING" : s;
//	}

	@FunctionalInterface
	private interface TernaryOperator {

		int apply(int a, int b, int c);
	}

//    public static interface Printer {
//
//        static void print(Object o) {
//            System.out.println(o);
//        }
//    private static void sout(String s) {
//        System.out.println(s.isEmpty() ? "EMPTY_STRING" : s);
//    }
}
