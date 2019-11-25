package java_20191125;

public class VarArgDemo {
	
	public void m(int... test){
		//			인자가 몇개인가...로 보통 갈리고...
		int length=test.length;
		if(length==1){
			System.out.printf("인자가 1개 입니다. %d%n",test[0]);
		}else if(length==2){
			System.out.printf("인자가 2개 입니다. %d %d%n",test[0],test[1]);
		}else if(length==3){
			System.out.printf("인자가 3개 입니다. %d %d %d%n",test[0],test[1],test[2]);
		}
		
	}

	public static void main(String[] args) {
		VarArgDemo v=new VarArgDemo();
		v.m(1);
		v.m(1,2);
		v.m(1,2,3);
	}

}
