package java_chobo2.ch14.stream;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapEx {

	public static void main(String[] args) {// start class
		//extracted();
		//extracted2();
		
		IntStream intStream = new Random().ints(1, 46);
		Stream<Integer> integerStream = intStream.boxed();
		integerStream.limit(6).forEach(System.out::println);
		
		Stream<String> lottoStream = new Random().ints(1,46)
				.distinct()
				.limit(6)
				.sorted()
				.mapToObj(i -> i + " , "); // IntStream -> Stream<String>
		lottoStream.forEach(System.out::println);
								
		
		
	}// end of main

	private static void extracted2() {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 200));
		list.add(new Student("나자바", 3, 390));
		list.add(new Student("감자바", 3, 180));
		
		Stream<Student> stdStream = list.stream();
			
		//스트림을 기본 스트림으로 변환
		Stream<Integer> stdScoreStream = stdStream.map(Student::getTotalScore);
		//stdScoreStream.forEach(System.out::println);
		int total = stdScoreStream.reduce(0, (a,b) -> a+b); // identify 식별자라는 뜻
		System.out.println(total);
		
		stdStream = list.stream();
		IntStream stdScoreIntStream = stdStream.mapToInt(Student::getTotalScore);
		total= stdScoreIntStream.max().getAsInt(); // 최대값도 가능  
		System.out.println("IntStream : " + total);
	}

	
	private static void extracted() {
		List<File> list = new ArrayList<File>();
		list.add(new File("Ex1.java"));
		list.add(new File("Ex1.bak"));
		list.add(new File("Ex2.java"));
		list.add(new File("Ex1"));
		list.add(new File("Ex1.txt"));

		
		
		//map() 으로 Stream<File>을 Stream<String> 으로 변환
		Stream<File> fileStream = list.stream();
		Stream<String> fileNameStream = fileStream.map(File::getName);
		//fileNameStream.forEach(System.out :: println);
		
		System.out.println();
		 list.stream().map(File::getName) 
		 .filter(s -> s.indexOf('.') != -1)
		 .peek(System.out::println) // peek 으로 확인 하는법
		 .map(s -> s.substring(s.indexOf('.')+ 1))
		 .peek(s-> System.out.printf("extends : %s%n", s))
		 .map(String::toUpperCase)
		 .peek(s-> System.out.printf("upper : %s%n", s))
		 .distinct() 
		 .forEach(System.out::print);
		 
		 System.out.println();
		 
		 // 위에것을 Set로 하는 법.
		 /*
		 Set<String> s = new HashSet<String>(); 
		 for(File f : list) { // 포문으로 반복문 돌리기
			 String ext = f.getName(); // f.getName() 을 ext 에 저장
			 if(ext.indexOf('.') != -1) {
				 s.add(ext.substring(ext.indexOf('.')+1).toUpperCase());
			 }
			 
		 }
		 System.out.println(s);
		 
		 File file = new File("test.java");
		 String fileName = file.getName(); // "test.java 추출"
		 int idx = fileName.indexOf("."); // 4
		 System.out.println(fileName + " : " + idx);
		 System.out.println(fileName.substring(idx + 1)); // substring = idx 위치에서 부터 끝까지 를 다 출력해 돌라는 말이다 
		 */
	}

}
