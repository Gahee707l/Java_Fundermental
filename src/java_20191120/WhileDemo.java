package java_20191120;

public class WhileDemo {
	public static void main(String[] args){
		
		int sum =0;
		int i =1;
		while(i<=100){
			sum += i;
			i++;
		}
		System.out.printf("1:100 sum = %d\n",sum);
		
		int fir = 2;
		while(fir<=9){
			int sec =1;
			while(sec<=9){
				System.out.printf("%d*%d = %d|",fir,sec,fir*sec);
				sec++;
			}
			fir++;
			System.out.println("");
		}
		
	}
	
	
}
