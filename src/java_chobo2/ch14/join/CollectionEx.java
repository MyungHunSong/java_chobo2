package java_chobo2.ch14.join;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class CollectionEx {

	public static void main(String[] args) {
		ArrayList<Integer> arList = new ArrayList<Integer>();
		for(int i =0; i< 10 ; i++) {
			arList.add(i);
		}
		
		for(int i : arList) {
			System.out.println(i + " ");
		}
		System.out.println();
		
		Consumer<Integer> c = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println("t : " + t + " ");
				
			}
		};
		Consumer<Integer> d = i -> System.out.print(" to i : " + i);
		
		arList.forEach(c);
		System.out.println();
		
		arList.forEach(d);
		System.out.println(); 
		
		arList.forEach(i -> System.out.print(i + " "));
		
		// List에서 2또는 3의 배수를 제거
		arList.removeIf(x -> x % 2 == 0 || x%3 == 0);
		arList.forEach(i -> System.out.print("remove : "+ i + " "));
		System.out.println();
		System.out.println();
		Predicate<Integer> p1 = i -> i % 2 == 0;
		Predicate<Integer> p2 = i -> i % 3 == 0;
		Predicate<Integer> p3 = p1.or(p2);
		
		arList.remove(p3);
		arList.forEach(i -> System.out.print("Predicate  : " + i + " " ));
		System.out.println();
		
		
		
		UnaryOperator<Integer> v = new UnaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t) {
				
				return 10;
			}
			
		};
		arList.replaceAll(v);
		arList.forEach(i -> System.out.print("UnaryOperator1 : "+i + " "));
		System.out.println();
		System.out.println();
		
		UnaryOperator<Integer> u = i-> i*10;
		arList.replaceAll(u);
		arList.forEach(i -> System.out.print(" UnaryOperator2: " + i + " "));
		
	}

}
