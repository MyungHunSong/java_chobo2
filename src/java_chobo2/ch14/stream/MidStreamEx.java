package java_chobo2.ch14.stream;

import java.util.Comparator;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MidStreamEx {

	public static void main(String[] args) {
//		extracted01(); // skip, limit, filter, distinct
		
		//sorted
//		  extracted2();
		
		
//		extracted3();
	
		
	}

	private static void extracted3() {
		Stream<Student> std = Stream.of(
				new Student("이자바", 3, 300),
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100),
				new Student("박자바", 2, 150),
				new Student("소자바", 1, 200),
				new Student("나자바", 3, 390),
				new Student("감자바", 3, 180)
				);
		
		std.sorted(Comparator.comparing(Student::getBan) // 콤패레이터 콤패얼링에서 스튜던트를 반으로 정렬,
				.thenComparing(Comparator.naturalOrder()))// 위에꺼 정렬한다음 밑에꺼 또 정렬해라
				.forEach(System.out::println);
	}

	private static void extracted2() {
		Stream<String> strStream = Stream.of("dd","aaa","CC", "cc", "b");
		strStream.sorted().forEach(s->System.out.println(s+ " "));
		
		System.out.println();
		
		Stream.of("dd","aaa","CC", "cc", "b")
		.sorted(Comparator.naturalOrder())
		.forEach(s->System.out.println(s+ " "));
		System.out.println();
		
		Stream.of("dd","aaa","CC", "cc", "b")
		.sorted((s1, s2) -> s1.compareTo(s2))
		.forEach(s->System.out.println(s + " "));
		System.out.println();
		
		// 위에꺼 2개와 동일
		Stream.of("dd","aaa","CC", "cc", "b")
		.sorted(String::compareTo)
		.forEach(s->System.out.println(s + " "));
		System.out.println();	
		
		//역순 정렬
		Stream.of("dd","aaa","CC", "cc", "b")
		.sorted(Comparator.reverseOrder())
		.forEach(s->System.out.println(s + " "));
		System.out.println();
		
		// 대소문자 구분 x 정렬
		Stream.of("dd","aaa","CC", "cc", "b")
		.sorted(String.CASE_INSENSITIVE_ORDER)
		.forEach(s->System.out.println(s + " "));
		System.out.println();
		
		// 대소문자 구분 x 역순 정렬
		Stream.of("dd","aaa","CC", "cc", "b")
		.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
		.forEach(s->System.out.println(s + " "));
		System.out.println();
	}

	private static void extracted01() {
		//중간연산
		System.out.println("중간 연산 -skip(), limit ()");
		IntStream.rangeClosed(1, 10)
		.skip(3)
		.limit(5)
		.forEach(s->System.out.print(s+ " "));
		System.out.println();
		
		//2. filter, distinct()
		System.out.println("중간 연산 -filter(), distinct()");
		
		IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 6)
		.distinct()
		.forEach(System.out :: print);
		System.out.println();
		
		IntStream.rangeClosed(1, 20)
		.filter(i -> i%2 ==0)
		.forEach(s -> System.out.print(s + " "));
		
		System.out.println();
		
		IntStream.rangeClosed(1, 20)
		.filter(i -> i%2 ==0)
		.filter(i -> i%3 ==0)
		.forEach(s -> System.out.print(s + " "));
		
		IntPredicate p = t -> t%2 == 0;
		IntStream.rangeClosed(1, 20)
		.filter(p)
		.forEach(s -> System.out.print(s + " "));
	}

}
