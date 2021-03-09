package java_chobo2.ch14.stream;

public class Student2 {
	 String name;
	 boolean isMale; 	//성별
	 int hak;			//학년
	 int ban;			//반
	 int score;
	
	

	
	



	public Student2(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}





	




	public String getName() {
		return name;
	}










	public boolean isMale() {
		return isMale;
	}










	public int getHak() {
		return hak;
	}










	public int getBan() {
		return ban;
	}










	public int getScore() {
		return score;
	}










	@Override
	public String toString() {
		return String.format("Student2 [name=%s, isMale=%s, hak=%s, ban=%s, score=%s]", name, isMale, hak, ban, score);
	}

	
	
}
