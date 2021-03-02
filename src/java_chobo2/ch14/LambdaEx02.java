package java_chobo2.ch14;

import java.util.Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaEx02 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
		// 정렬 가즈아아아아앜엨읔엨 (abc : 사전순)
		System.out.println(list);
		
		Comparator<String> com = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				return o2.compareTo(o1);
			}
		};// comparaTO
		Collections.sort(list, com);
		System.out.println(list);
		
		Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
		System.out.println("이새" + list);
	}

}
