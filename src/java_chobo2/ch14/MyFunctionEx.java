package java_chobo2.ch14;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class MyFunctionEx { // 3/02 오늘 한것 BiConsumer 이다

	public static void main(String[] args) {
		BiConsumer<String, Integer> bic = new BiConsumer<String, Integer>() {

			@Override
			public void accept(String t, Integer u) {
				if (t.length() == u) {
					System.out.println("같은. 잦알 했어요");
				} else {
					System.out.println("다름. 다시하거라");
				}

			}
		};
		bic.accept("abc", 2);
		bic.accept("abc", 3);

		BiConsumer<String, Integer> bic01 = (t, u) -> {
			if (t.length() == u) {
				System.out.println("같음");
			} else {
				System.out.println("다음");
			}
		};
		bic01.accept("abc", 2);
		bic01.accept("abc", 3);

		String str = "abc".length() == 3 ? "같음" : "다음";

		BiPredicate<String, String> bip = new BiPredicate<String, String>() {

			@Override
			public boolean test(String t, String u) {

				return t.equals(u);
			}
		};

		System.out.println(bip.test("abc", "ab"));
		System.out.println(bip.test("abc", "abc"));

		BiPredicate<String, String> bip2 = (t, u) -> t.equals(u); // 캐 간단. 머고? 쉽다잇.
		System.out.println(bip2.test("abc", "ab"));
		System.out.println(bip2.test("abc", "abc"));

		BiFunction<Integer, Integer, String> bif = new BiFunction<Integer, Integer, String>() {

			@Override
			public String apply(Integer t, Integer u) {
				if (t == u) {
					return "맞음";
				} else {
					return "틀림";
				}

			}
		};
		System.out.println(bif.apply(5, 7));
		System.out.println(bif.apply(7, 7));
		
		BiFunction<Integer, Integer, String> bif2 = (t, u) -> t == u ? "true":"false";
		System.out.println("bif man : " + bif.apply(10, 5));
		System.out.println("bif girl : " + bif.apply(7, 7));
	}

}
