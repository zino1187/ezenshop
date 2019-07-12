package gui;

import java.text.DecimalFormat;

public class Test {

	public static void main(String[] args) {
		
		long n = 1253427856;
		DecimalFormat df=new DecimalFormat("###,###");
		System.out.println(df.format(n)+"¿ø");
	}

}
