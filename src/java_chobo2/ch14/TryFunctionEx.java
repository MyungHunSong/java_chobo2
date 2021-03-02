package java_chobo2.ch14;

public class TryFunctionEx {

	public static void main(String[] args) {
		TryFunction<Integer, Integer, Integer, Integer> tri = new TryFunction<Integer, Integer, Integer, Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u, Integer v) {
				
				return t * u * v;
			}
		};
		System.out.println(tri.apply(10, 10, 10));
		
		TryFunction<Integer, Integer, Integer, Integer> tri01 = (a, b, c) -> a * b * c;
		System.out.println(tri01.apply(2, 2, 2));
	}

}
