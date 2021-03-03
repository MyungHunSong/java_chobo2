package java_chobo2.ch14;

import java.util.Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaEx02 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa"); // 1빠따 정의
		// 정렬 (abc : 사전순)
		System.out.println(list);
		
		Comparator<String> com = new Comparator<String>() { // 2빠따 비교
			
			@Override
			public int compare(String o1, String o2) {
				
				return o2.compareTo(o1);
			}
		};// comparaTO
		
		
		//3빠따 정렬
		Collections.sort(list, com);
		System.out.println(list);
		
		Collections.sort(list, (o1, o2) -> o1.compareTo(o2)); // 위의 컴패어를 겁나 쉡게 풀어 쓴것이다.
		System.out.println("이새" + list);
	}

}


