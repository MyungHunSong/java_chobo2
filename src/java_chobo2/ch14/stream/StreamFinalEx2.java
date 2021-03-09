package java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;


public class StreamFinalEx2 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 200));
		list.add(new Student("나자바", 3, 390));
		list.add(new Student("감자바", 3, 180));
		
		//1. 스트림을 컬렉션으로 변환
		//extracted(list);
		
		//2. 스트림 통계정보
		//extracted2(list);
		
		
		
	}







	private static void extracted2(List<Student> list) {
		//스트림의 통계정보
		long cnt1 = list.stream().count();
		long cnt2 = list.stream().collect(Collectors.counting());
		System.out.printf("count1 %d : count2 : %d%n", cnt1, cnt2);  //2개
		
		
		// 토탈점수1
		int sum1 = list
			.parallelStream()
			.mapToInt(Student :: getTotalScore)
			.peek(System.out::println)
			.sum();
		
		// 토탈점수2
		int sum2 = list
			.parallelStream()
			.collect(Collectors.summingInt(Student :: getTotalScore));
		
		System.out.println("TotalScore : " +sum1 + " , " + sum2);
		
		//최대값 구하기
		OptionalInt max1 = list
			.parallelStream()
			.mapToInt(Student::getTotalScore)
			.peek(System.out::println)
			.max();
		
		System.out.printf("maxSocre %d%n", max1.getAsInt());
		
		
		// 이름 + 반 + 최대값 
		Optional<Student> maxStd1 = list
				.parallelStream()
				.max(Comparator
				.comparing(Student::getTotalScore));

		System.out.println( maxStd1.get() );
		
		Student std = maxStd1.get();
		System.out.println(std);
		
		Optional<Student> maxStd2 = list
				.parallelStream()
				.collect(
						Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));
		Student std1 = maxStd2.get();
		System.out.println(std1);
		
		//요까지가 	 *이름 + 반 + 최대값* 의 끝
		
		
		//요기에는 맥스 민 평균 다 가지고 있는 양아치쉨이다
		IntSummaryStatistics iss1 =list
									.parallelStream()
									.mapToInt(Student::getTotalScore)
									.summaryStatistics();
		
		System.out.println(iss1);
		
		IntSummaryStatistics iss2 = list
									.parallelStream()
									.collect(Collectors.summarizingInt(Student::getTotalScore));
		System.out.println(iss2);
		// *요기까지가 양아치쉨
	}

	
	
	
	
	
	
	private static void extracted(List<Student> list) {
		
		List<String> stdlist= list
			.stream()
			.map(Student::getName)
			.peek(System.out::println)
			.collect(Collectors.toList());
		
		System.out.println(stdlist);
		
		ArrayList<Student> arList = list.stream()
				.collect(Collectors.toCollection(ArrayList :: new));
		System.out.println(arList);
		
		// Mapl<이름, 학생>
		Map<String, Student> map = list.stream()
									.collect(Collectors.toMap(s->s.getName(), s->s));
		
		for(Entry<String, Student> e : map.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

}
