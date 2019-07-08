package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//파일과 관련된 정보 추출에 사용할 공통 클래스!!!
public class FileManager {
	
	//확장자 구하기 
	public static String getExt(String path) {
		int index=path.lastIndexOf(".");
		System.out.println(index);
		return path.substring(index+1, path.length()); //확장자 반환
	}
	
	//파일복사 ori 원본위치, dest 목적지 위치
	public static void copy(String ori, String dest) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis = new FileInputStream(ori);
			fos = new FileOutputStream(dest);
			
			byte[] buff = new byte[1024];
			int data=-1;
			while(true){
				data=fis.read(buff);//파일로부터 입력!!
				if(data==-1)break;
				fos.write(buff);//파일에 출력!!!
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	
	/*
	public static void main(String[] args) {
		System.out.println(getExt("dkdkd....kdkd.png"));
	}
	*/
}



