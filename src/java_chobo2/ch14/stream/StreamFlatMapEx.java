package java_chobo2.ch14.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFlatMapEx {

	public static void main(String[] args) {
		Stream<String[]> strArrStrm = Stream.of(
				new String[]{"abc", "def", "jkl"},
				new String[]{"ABC", "DEF", "JKL"}
				);
		
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
		
		strStrm.map(String::toLowerCase)
		.distinct()
		.sorted()
		.forEach(System.out::println);
		System.out.println();		

		String[] lineArr = {
				"Belive or not It it true",
				"Do or do not there is to try",
		};
		
		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" + ")))
		.map(String::toLowerCase)
		.distinct()
		.sorted()
		.forEach(System.out::println);
		System.out.println();
	}

}
