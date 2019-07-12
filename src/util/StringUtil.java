package util;

import java.text.DecimalFormat;

public class StringUtil {
	//넘겨받은 데이터를 통화로 변환하여 반환하는 메서드
	//n을 넘겨받아 원하는 패턴에서 , 쉼표 찍어서 반환하기!!
	public static String getCurrency(long n) {
		DecimalFormat df = new DecimalFormat("###,###");
		return "￦"+df.format(n);
	}
	public static void main(String[] args) {
		long n=1000000000;
		System.out.println(getCurrency(n));
	}
}





