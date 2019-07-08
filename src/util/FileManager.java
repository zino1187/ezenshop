package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//���ϰ� ���õ� ���� ���⿡ ����� ���� Ŭ����!!!
public class FileManager {
	
	//Ȯ���� ���ϱ� 
	public static String getExt(String path) {
		int index=path.lastIndexOf(".");
		System.out.println(index);
		return path.substring(index+1, path.length()); //Ȯ���� ��ȯ
	}
	
	//���Ϻ��� ori ������ġ, dest ������ ��ġ
	public static void copy(String ori, String dest) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis = new FileInputStream(ori);
			fos = new FileOutputStream(dest);
			
			byte[] buff = new byte[1024];
			int data=-1;
			while(true){
				data=fis.read(buff);//���Ϸκ��� �Է�!!
				if(data==-1)break;
				fos.write(buff);//���Ͽ� ���!!!
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



