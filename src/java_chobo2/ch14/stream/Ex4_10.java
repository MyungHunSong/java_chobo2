package java_chobo2.ch14.stream;

import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
//static Collectors.*;
//static comparator.*;

public class Ex4_10 {

	public static void main(String[] args) {
// 					new Sutdent2(name, isMale, hek, ban, score)

		Student2[] stuArr = { new Student2("나자바", true, 1, 1, 300), new Student2("김지미", false, 1, 1, 250),
				new Student2("김자바", true, 1, 1, 200), new Student2("이지미", false, 1, 2, 150),
				new Student2("남자바", true, 1, 2, 100), new Student2("안지미", false, 1, 2, 50),
				new Student2("황지미", false, 1, 3, 100), new Student2("강지미", false, 1, 3, 150),
				new Student2("이자바", true, 1, 3, 200), new Student2("나자바", true, 2, 1, 300),
				new Student2("김지미", false, 2, 1, 250), new Student2("김자바", true, 2, 1, 200),
				new Student2("이지미", false, 2, 2, 150), new Student2("남자바", true, 2, 2, 100),
				new Student2("안지미", false, 2, 2, 50), new Student2("황지미", false, 2, 3, 100),
				new Student2("강지미", false, 2, 3, 150), new Student2("이자바", true, 2, 3, 200) };

		Map<Boolean, List<Student2>> stdBySex = Arrays.stream(stuArr).collect(partitioningBy(Student2::isMale)); // true인경우
																													// ,
																													// false인
																													// 2가지
																													// 경우로
																													// 나눠진다.

		List<Student2> maleStds = stdBySex.get(true);
		System.out.println("남학생 = " + maleStds); // 요렇게 쓰면 db에서는 과부화가 덜하다

		List<Student2> femaleStds = stdBySex.get(false);
		System.out.println("여학생 = " + femaleStds);

		// 통계 성별 구분을 카운트 하는법
		Map<Boolean, Long> stdNumSex = Arrays.stream(stuArr).collect(partitioningBy(Student2::isMale, counting()));

		System.out.printf("남학생 수 %d, 여학생 수 %d%n", stdNumSex.get(true), stdNumSex.get(false));
		
		// -----바로 스튜던트에서 받아 오는 방법이 다------

		Map<Boolean, Optional<Student2>> topScoreBySex = Arrays.stream(stuArr)
				.collect(partitioningBy(
						Student2::isMale, maxBy(
								comparingInt(Student2::getScore)
								)
							)
						);

		Map<Boolean, Object> topScoreBySex2 = Arrays.stream(stuArr)
			.collect(partitioningBy(
					Student2::isMale,
				collectingAndThen(
						maxBy(
								comparingInt(Student2::getScore)), Optional::get))

		);
		
		System.out.println("남자 탑 스코어 : " + topScoreBySex.get(true));
		System.out.println("여자 탑 스코어 : " + topScoreBySex2.get(true));
		
		// 성별로 분할 후 성적으로 분할(점수가 150점 기준)
		Map<Boolean, Map<Boolean, List<Student2>>>  failedStdBySex = 
					Arrays.stream(stuArr)
					.collect(
							partitioningBy(
									Student2::isMale, 
									partitioningBy(s-> s.getScore() < 150))
									);
		
		
		List<Student2> failedMaleStu = failedStdBySex.get(true).get(true);
		
		System.out.println("성별 불합격자 목록");
		System.out.println(failedMaleStu);
		System.out.println();
		
		
		
							
					
	}
}
