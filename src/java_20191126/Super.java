package java_20191126;

public class Super {
	int money;
	public void makeMoney(){
		System.out.println("Super makeMoney()");
	}
	public Super(){
		//super();
	}
	
	public Super(int money){
		//super();
		this.money=money;
	}
	public void play(String omok){
		System.out.println("Super play()");
	}

}
