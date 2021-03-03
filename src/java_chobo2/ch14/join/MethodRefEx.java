package java_chobo2.ch14.join;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefEx {

	public static void main(String[] args) {
		Function<String, Integer> f = s -> Integer.parseInt(s);
		System.out.println(f.apply("16"));

		Function<String, Integer> f2 = Integer::parseInt; // 인티저 파스인트 클래스에 정의 되있는 것을 참조해서 변경하라
		System.out.println(f2.apply("16"));

		BiFunction<String, String, Boolean> g = (s1, s2) -> s1.equals(s2);
		System.out.println("정석 람다식: " + g.apply("abc", "abc"));

		BiFunction<String, String, Boolean> h = String::equals;
		System.out.println("쉽게 표현한것: " + h.apply("get", "set"));

		class MyClass {
			int x;
			int y;

			public MyClass() {

			}
			
			

			public MyClass(int x) {
				this.x = x;
			}



			public MyClass(int x, int y) {
				this.x = x;
				this.y = y;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + x;
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (obj instanceof MyClass) {
					MyClass other = (MyClass) obj;
					if (x != other.x) {

						return true;
					}

				}
				return false;
			}// end of equals



			@Override
			public String toString() {
				return String.format("MyClass [x=%s, y=%s]", x, y);
			}
			
			

		}// end of MyClass

		MyClass m1 = new MyClass(5, 2);
		MyClass m2 = new MyClass(4, 3);
		MyClass m3 = new MyClass(5, 3);

		Function<MyClass, Boolean> j = i -> m1.equals(i);
		System.out.println(j.apply(m2));
		System.out.println(j.apply(m3));

		Function<MyClass, Boolean> k = m1::equals;
		System.out.println(k.apply(m2));
		System.out.println(k.apply(m3));
		
		Supplier<MyClass> s = MyClass::new; // 기본 생성자 가 호출된다
		System.out.println(s.get());
		
		Function<Integer, MyClass> t = MyClass::new; // MyClass(int) 매게 변수 가 잇는 생성자
		System.out.println(t.apply(10));
		
		// MyClass(int, int)
		BiFunction<Integer, Integer, MyClass> t1 = MyClass::new;
		System.out.println(t1.apply(10, 10));
		
		// array
		Function<Integer, int[]> v = int[]::new;
		System.out.println(Arrays.toString(v.apply(5)));
	
	}// end of main

}// end of MethodRefEx
