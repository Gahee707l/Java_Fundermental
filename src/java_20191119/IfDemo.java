package java_20191119;

public class IfDemo {
	public static void main(String[] args){
		int month = Integer.parseInt(args[0]);
		//run config 쪽에서 아규먼츠(매개변수)던져줄 수 있음,동적 할당이니까 더 들어올(args[1]수 있음)
		//							13
		
		String season = null;
		if(month==12 || month ==1 ||month ==2){
			season = "Winter";
		}else if(month==3 || month ==4 ||month ==5){
			season = "Spring";
		}else if(month==6 || month ==7 ||month ==8){
			season = "Summer";
		}else if(month==9 || month ==10 ||month ==11){
			season = "Autumn";
		}else{
			season = "Hidden";
		}
		
		System.out.println(month+" month is "+season+" season.");
	}

}
