package java_chobo2.ch14;

@FunctionalInterface // Function 추상 메서드가 하나만 잇는것을 정의한다
interface MyFunction{
	void myMethod();
}

public class LambdaEx03 {

	public static void main(String[] args) {
		MyFunction f = () -> System.out.println("myMethod");
		aMethod(f);
		
		aMethod(() -> System.out.println("myMethod"));
		
	}
	
	public static void aMethod(MyFunction f) {
		f.myMethod();
	}

}
