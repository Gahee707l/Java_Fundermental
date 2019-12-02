package java_20191202;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileDemo {
	// files : binary(exe나 img) / txt
	// FileClass (중요) : 주로 경로 , 생성은 되지만 내용 넣기/수정/읽기 등등은 안됌.그건 다른것 에서....
	public static void main(String[] args) {
		File f1= new File("c:\\dev\\io\\2019\\12");
		//ctrl shif o
		boolean isSuccess = f1.mkdirs();
		//						복수 생성자
		System.out.println(isSuccess);
		
		File f2 = new File(f1,"data_ex.txt");
		//해당 경로랑 같으니까....아니면 전부 다 경로 넣으면 됨.아니면 앞의 ,에.
		long fileSize = f2.length()/1024;
		//파일 크기는 크니까...
		System.out.println(fileSize);
		long lastModified = f2.lastModified();
		
		Calendar c = Calendar.getInstance();
		//추상이라 new 안해줌,대신 getInstance가 자식 new해서 주는것.대신 new 그레고리언캘린더 가능
		c.setTimeInMillis(lastModified);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int date = c.get(Calendar.DATE);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E요일");
		String days = sdf.format(c.getTime());
		//cltr shift o
		
		//System.out.println(year+"년 "+month+"월 "+date+"일");
		System.out.println(days);
		
		File f3 = new File("c:\\");
		//list : "c 드라이브"에 있는 모든 파일과 디렉토리를 string[] 배열로 반환,숨김도 보임
		String[] list = f3.list();
		
		for(String temp : list){
			//또다른 파일 객체가 생성된다면,그건 디렉토리라는 거다.
			File f4 = new File(f3,temp);
			if(f4.isDirectory()){
				System.out.println("디렉토리 : "+temp);
			}else if(f4.isFile()){
				System.out.println("파일 : "+temp);
			}else{
				System.out.println("? : "+temp);
			}
			System.out.println(temp);
		}
		
		File f5 = new File(f1,"jdk.exe");
		f2.renameTo(f5);
		//알려는...주는데 별로 하지는 마라...읽기 쓰기도 못한다.
		
		File f6 = new File(f1,"a.txt");
		try {
			f6.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(f6.getName());
		//파일 이름
		System.out.println(f6.getPath());
		//전체경로(=패런트+파일이름)
		System.out.println(f6.getParent());
		//파일 부모 (디렉토리)경로
		

		String extention = f6.getName().substring(f6.getName().lastIndexOf("."));
		//														last : . 포함.
		//f6.renameTo(new File(f1,String.valueOf(System.currentTimeMillis())+".txt" ) );
		File f7 = new File(f1,System.currentTimeMillis()+extention);
		//반쪽,getName에서의 확정자까지 까져온것은...
		f6.renameTo(f7);
		f7.delete();
	}
}
