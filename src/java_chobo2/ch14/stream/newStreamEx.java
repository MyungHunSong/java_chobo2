package java_chobo2.ch14.stream;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class newStreamEx {

	public static void main(String[] args) {
		IntStream.range(1, 10).forEach(System.out :: print);
		System.out.println();
		IntStream.rangeClosed(1, 10).forEach(System.out::print);
		
		System.out.println();
		// 난수를 요소로
		new Random().ints().limit(5).sorted().forEach(System.out::println);;
		System.out.printf("%d ~ %d%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		System.out.println();
		new Random(1234).ints(5).sorted().forEach(System.out::println);
		
		System.out.println();
		
	}

}
