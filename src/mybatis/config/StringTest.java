package mybatis.config;

public class StringTest {

	public static void main(String[] args) {
		String a="korea";
		String b="korea";
		System.out.println(a==b); //true
		for(int i=0;i<100;i++) {
			a+="korea k"; //ºÒÆí
		}
		
		String x=new String("korea");
		String y=new String("korea");
		System.out.println(x==y);//false
		
		

	}

}
