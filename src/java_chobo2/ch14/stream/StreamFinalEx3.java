package java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;


public class StreamFinalEx3 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 200));
		list.add(new Student("나자바", 3, 390));
		list.add(new Student("감자바", 3, 180));
		
		//extracted();
			
		
		
	// 애들은 멀까?
		int grandTotal1 = list.parallelStream()
							.map(Student::getTotalScore)
							.reduce(0, Integer::sum);
		System.out.println("grandTotal1 : " + grandTotal1);
		
		int grandTotal2 = list
			.parallelStream()
			.collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
		System.out.println("grandTotal2 : " + grandTotal2);
		
		
		
		
		//문자열스트림을 모두 연결(Joinning)
		String names1 = list.parallelStream().map(Student::getName).collect(Collectors.joining());
		String names2 = list.parallelStream().map(Student::getName).collect(Collectors.joining(","));
		String names3 = list.parallelStream().map(Student::getName).collect(Collectors.joining("," , "[", "]"));
		
		
		System.out.println(names1);
		System.out.println(names2);
		System.out.println(names3);
	}

	private static void extracted() {
		//스트림 리듀싱
		OptionalInt maxValue = new Random(1234)
				.ints(1, 46)
				.distinct()
				.limit(6)
				.peek(s->System.out.print(s + ","))
				.reduce(Integer::max);
		
		System.out.println();
		
		System.out.println("max = " + maxValue.getAsInt());
		
		Optional<Integer> maxValue2 = new Random(1234)
				.ints(1, 46) // StreamInt
				.distinct()  
				.limit(6)
				.boxed() // Stream<Integer> 박스에 의해 위에께 이렇게 변한다.
				.collect(Collectors.reducing(Integer::max));
		
		System.out.println("max2 = " + maxValue2);
		
		int sum1 = new Random(123)
				.ints(1, 46)
				.distinct()
				.limit(6)
				.reduce(0, (a, b) -> a + b);
		
		int sum2 = new Random(123)
				.ints(1, 46)
				.distinct()
				.limit(6)
				.boxed()
				.collect(Collectors.reducing(0, (a,b) -> a+b));
		
		System.out.printf("sum1 :%d , sum2 : %d%n", sum1, sum2);
	}
}






	
