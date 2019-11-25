package java_20191119;

public class SsnDemo {
	public static void main(String[] args){
		int sum = 0;
		/*
		
		int a1 = 1;
		int a2 = 1;
		int a3 = 1;
		int a4 = 1;
		int a5 = 1;
		int a6 = 1;
		
		int b1 = 1;
		int b2 = 1;
		int b3 = 1;
		int b4 = 1;
		int b5 = 1;
		int b6 = 1;
		int b7 = 8;
		
		
		//1. 각 자리수 2~9까지 곱 그리고 2~5까지 곱해서 합,아직은 sum 안배움
		
		sum = a1*2+a2*3+a3*4+a4*5+a5*6+a6*7+b1*8+b2*9+b3*2+b4*3+b5*4+b6*5;
		*/
		//int[] first = {1,1,1,1,1,1,1};
		//int[] sec = {1,1,1,1,1,1,1};
		String ssn = "111111-1111118";
		int j=2;
		
		char a = 'a';
		int lastIdx = ssn.length()-1 ;
		
		for(int i = 0;i<=lastIdx-1;i++){
			//최대수가 고정이니까 ,사실 인덱스에 집착 할 필요가 없음!
			a = ssn.charAt(i);
			
			//이게 마지막 i로 들어가지가 않음.	해결!
			
			if(a=='-'){
				i++;
			}
			else{
				if(i == 10){
					j=2;
					//이거 말고 카운팅 변수 하나 더 쓸것
					sum += (j)*Character.getNumericValue(a);
					j++;
					//최대수 고정시 별로 필요 없음.
					}
				sum += (j)*Character.getNumericValue(a);
				j++;
			}
			
		}
		
		sum = sum%11;
		sum = 11 - sum;
		

		if((sum)%10 == Character.getNumericValue(ssn.charAt(lastIdx))){
			//	b7 / ssn.charAt(ssn.length()-1)
			System.out.println("Valid nums");
		}else{
			System.out.println("Invalid nums");
		}
		
		
	}

}
