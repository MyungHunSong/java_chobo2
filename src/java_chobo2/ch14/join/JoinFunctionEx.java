package java_chobo2.ch14.join;

import java.util.function.Function;





public class JoinFunctionEx {

	public static void main(String[] args) {
		int res = Integer.parseInt("AE", 16); 
		System.out.println(res);
		Function<String, Integer> fun = new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				
				return Integer.parseInt(t, 16);
			}
		};
 
		System.out.println(fun.apply("AE"));
		
		Function<String, Integer> f = s-> Integer.parseInt(s, 16);
		
		System.out.println(f.apply("AE"));
		
		Function<Integer, String> g = i -> Integer.toBinaryString(i);
		System.out.println(g.apply(174));
		
		//andthen
		Function<String, String> h = f.andThen(g);
		System.out.println(h.apply("AE"));
		
		
		Function<Integer, String> j = i -> Integer.toBinaryString(i);
		System.out.println(j.apply(10));
		Function<String, Integer> k = i -> Integer.parseInt(i, 16);
		System.out.println(k.apply("10")); // 10을 16진수로 변경 하는것
		Function<Integer, Integer> l = k.compose(j); // j + k -> l
		System.out.println(l.apply(10)); // 10 을 2진수로 변경 -> 1010 -> 1*16^3 + 1*16 = 4096 + 16 = 4112
	}

}
