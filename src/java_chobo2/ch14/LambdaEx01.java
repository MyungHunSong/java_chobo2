package java_chobo2.ch14;



interface LambdaInter {
	int max(int a, int b);
}




class LambdaInterClass implements LambdaInter {

	@Override
	public int max(int a, int b) {

		return a > b ? a : b;
	}
}



interface LambdaInter1{
	void printVar(String name, int i);
	
}



interface LambdaInter2{
	int square(int x);
}




interface LambdaInter3{
	int roll();
}




interface LambdaInter4{
	int sumArr(int [] arr);
}






public class LambdaEx01 {

	public static void main(String[] args) {
		LambdaEx01 ex = new LambdaEx01();

		int a = max(5, 3);
		System.out.println("max = " + a);

		LambdaInterClass lic = new LambdaInterClass();
		int c = lic.max(5, 4);
		System.out.println("c.max = " + c);
		
		LambdaInter lib0 = new LambdaInter() {
			
			@Override
			public int max(int a, int b) {
				
				return a > b ? a: b;
			}
		};
		// 첫번째 LambdaInter
		System.out.println("max = " + lib0.max(1, 3));

		LambdaInter lbi = (i, j) -> i > j ? i : j;
		int b = lbi.max(5, 3);
		System.out.println("b.max = " + b);
		
		// LambdaInter1
		LambdaInter1 lbi1 = (String name, int i)->{System.out.println(name + " : " + i);};
		lbi1.printVar("김상곤", 5);
		
		LambdaInter1 lbi2 = (name, i) -> {System.out.println(name + " : " + i);};
		lbi2.printVar("이나연", 15);
		
		LambdaInter1 lbi3 = (name, i) -> System.out.println(name + " : " + i);
		lbi3.printVar("신범건", 25);
		
		// LambdaInter2
		LambdaInter2 lbi4 = (int x) -> x * x;
		LambdaInter2 lbi5 =  x -> x * x;
		System.out.println("square : " + lbi4.square(5));
		System.out.println("square : " + lbi5.square(5));
		
		// LambdaInter3
		LambdaInter3 lbi6 = () -> {return (int)(Math.random()*6);};
		LambdaInter3 lbi7 = () -> (int)(Math.random()*6);
		System.out.println("roll() : " + lbi6.roll());
		System.out.println("roll() : " + lbi7.roll());
		
		
		// LambdaInter4
		LambdaInter4 lbi8 = (int[] arr)->{
			int sum = 0;
			for(int i : arr) sum += i;
			return sum;
		};
		System.out.println(lbi8.sumArr(new int[]{1,2,3,4,5,6,7,8,9,10}));
		
	}

	private static int max(int i, int j) {

		return i > j ? i : j;
	}

}
