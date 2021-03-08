package java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStatEx {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 90));
		list.add(new Student("나자바", 3, 390));
		list.add(new Student("감자바", 3, 80));
		
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		long cnt1 = list.stream().count();
		long cnt2 = intList.stream().count();
		System.out.printf("list cnt = %d, intList cnt2 = %d%n", cnt1, cnt2);
		
		// max1 Fm
		Optional<Student> optStd = list.stream().max(new Comparator<Student>() { // <- 맥스에 다가 저걸 넣어서 비교하는것

			@Override
			public int compare(Student o1, Student o2) {
				
				return o1.getTotalScore() - o2.getTotalScore(); 
			}
		});
		// max2 람다 
		Optional<Student> optStd2 = list.stream().max((o1, o2) -> o1.getTotalScore() - o2.getTotalScore()); 
		System.out.println("max Total Score Student : " + optStd.get() + "| 람다 : "+ optStd2.get()); 
		
		// min
		Optional<Student> optStd3 = list.parallelStream().min((o1, o2) -> o1.getTotalScore() - o2.getTotalScore()); // 최소값을 람다로 이용한것
		System.out.println("min Total Socnre Student : " + optStd3.get());
		
		// 정식
		
		
		
		//sum
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		IntStream intStream = IntStream.of(arr);
		int sum = intStream.sum();
		
	
		OptionalDouble avg = IntStream.of(arr).average();
		

		OptionalInt max = IntStream.of(arr).max();
		
		
		OptionalInt min = IntStream.of(arr).min();
		
	
		
		
		System.out.printf("sum = %d, avg = %.2f, max = %d, min = %d%n", sum, avg.getAsDouble(), max.getAsInt(), min.getAsInt());
		
		IntSummaryStatistics summary = IntStream.of(arr).summaryStatistics();
		System.out.printf("count = %d, sum = %d, avg = %.2f, max = %d, min = %d%n",summary.getCount() ,sum, avg.getAsDouble(), max.getAsInt(), min.getAsInt());
		
			summary.getCount();
			summary.getSum();
			summary.getAverage();
			summary.getMax();
			summary.getMin();
			
	}

}
