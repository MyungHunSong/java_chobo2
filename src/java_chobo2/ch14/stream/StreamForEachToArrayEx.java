package java_chobo2.ch14.stream;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamForEachToArrayEx {

	public static void main(String[] args) {
		IntStream.range(1, 10).sequential().forEach(new IntConsumer() {

			@Override
			public void accept(int value) {
				System.out.print(value + ", ");

			}
		});
		System.out.println();

		IntStream.range(1, 10).parallel().forEach(e -> System.out.print(e)); // 바로 참조 하라는 예기이다. parallel : 병렬로 수행
		System.out.println();

		IntStream.range(1, 10).parallel().forEachOrdered(System.out::print); // forEachOrdered : 를 쓰면 수선를정해준다.
		System.out.println();

		Student[] stdArr = { new Student("김인환", 1, 200),
				new Student("이태훈", 1, 270),
				new Student("전수린", 2, 250), };
		Stream<Student> studentStream = Arrays.stream(stdArr);

		Student[] tempArr = studentStream.toArray(Student[]::new); // int Function 생성해 주는것을 의미
		System.out.println("temArr : "+Arrays.toString(tempArr));

		studentStream = Arrays.stream(stdArr);
		Object[] objArr = studentStream.toArray();
		System.out.println("objArr : " + Arrays.toString(objArr));

	}

}
