package java_chobo2.ch14.join;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;

public class Ex14_4 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		list.forEach(i -> System.out.println(i + " "));
		System.out.println();

		list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
		System.out.println(list);

		list.replaceAll(i -> i * 10);
		System.out.println(list);

		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");

		map.forEach((k, v) -> System.out.println("{" + k + "," + v + " },"));
		System.out.println();

		for (Entry<String, String> e : map.entrySet()) {
			System.out.printf("출력 1: {%s - > %s} %n", e.getKey(), e.getValue());
		}
		for (String key : map.keySet()) {
			System.out.printf("출력 2: {%s - > %s} %n", key, map.get(key));

		}
		
		BiConsumer<String, String> w = new BiConsumer<String, String>() {

			@Override
			public void accept(String t, String u) {
				System.out.printf(" {%s - > %s} %n", t,u);
				
			}
		};
		System.out.println("Map<key,value> 함수형 인터페이스 출력1");
		map.forEach(w);
		System.out.println();
		
		System.out.println("Map<key,value> 함수형 인터페이스 출력2");
		map.forEach((key,value) -> System.out.printf("{%s -> %s} %n"));
	}
}
