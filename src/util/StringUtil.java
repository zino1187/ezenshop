package util;

import java.text.DecimalFormat;

public class StringUtil {
	//�Ѱܹ��� �����͸� ��ȭ�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼���
	//n�� �Ѱܹ޾� ���ϴ� ���Ͽ��� , ��ǥ �� ��ȯ�ϱ�!!
	public static String getCurrency(long n) {
		DecimalFormat df = new DecimalFormat("###,###");
		return "��"+df.format(n);
	}
	public static void main(String[] args) {
		long n=1000000000;
		System.out.println(getCurrency(n));
	}
}





