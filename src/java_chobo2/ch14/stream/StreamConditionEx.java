package java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamConditionEx {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 90));
		list.add(new Student("나자바", 3, 390));
		list.add(new Student("감자바", 3, 80));
		
		matchEx(list);
		findEx(list);
	}

	private static void findEx(List<Student> list) {
		Stream<Student> stdStream = list.stream();
		
		Optional<Student> result = stdStream.filter(s-> s.getTotalScore() <= 100).findFirst();
		System.out.println("opitonal 로 받는 findFirst : " + result);
		
		result = list.stream().filter(s-> s.getTotalScore()<= 100).findAny();
		System.out.println("finAny : " + result);
		
		
	}

	private static void matchEx(List<Student> list) {
		Stream<Student> stdStream = list.stream();
		
		boolean hasRes = stdStream.anyMatch(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				
				return t.getTotalScore() <= 100; // 한개씩 꺼내와서 검사해서 100 밑인 친구는 true가 된다
			}
		});
		System.out.printf("hasRes => %s%n", hasRes);
		
		stdStream = list.stream();
		hasRes = stdStream.allMatch(s-> s.getTotalScore() >= 80);
		System.out.printf("getTotalScore >= 80 : %s%n", hasRes);
	}

}// end class
