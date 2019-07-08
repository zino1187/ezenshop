package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import product.domain.Product;

//�ڹٿ��� ���� �о�� ó���ϱ�!!! ( ���¼ҽ� apache poi �̿� )
public class ExcelManager {
	FileInputStream fis;
	
	//�ϳ��� ���������� ǥ���� ��ü
	HSSFWorkbook workbook;  
	
	public List parse(String path) {
		List<Product> list =new ArrayList();
		
		try {
			fis = new FileInputStream(path);
			workbook = new HSSFWorkbook(fis);
			
			//��Ʈ�� ����!!!
			HSSFSheet sheet = workbook.getSheet("product");
			
			int totalRow = sheet.getPhysicalNumberOfRows();
			System.out.println("�� row �� : "+totalRow);
			
			for(int i=1;i<totalRow;i++) {
				HSSFRow row=sheet.getRow(i);
				int totalCol=row.getPhysicalNumberOfCells();//���� ���� �� �Ѽ�!!
				//System.out.println(i+"��° row�� �� �÷����� "+totalCol);
				
				//row==record ������ ���� Product �ν��Ͻ� ����!!
				Product product = new Product();
				
				HSSFCell  cell0 = row.getCell(0);//subcategory_id
				double value=cell0.getNumericCellValue();
				product.getSubCategory().setSubcategory_id((int)cell0.getNumericCellValue());
				//System.out.print((int)value+"\t");
				
				HSSFCell cell1 = row.getCell(1);//product_name
				String value1=cell1.getStringCellValue();
				product.setProduct_name(cell1.getStringCellValue());
				//System.out.print(value1+"\t");
				
				HSSFCell cell2 = row.getCell(2);//brand
				String value2=cell2.getStringCellValue();
				product.setBrand(cell2.getStringCellValue());
				//System.out.print(value2+"\t");
				
				HSSFCell cell3 = row.getCell(3);//price
				double value3=cell3.getNumericCellValue();
				product.setPrice((int)value3);
				//System.out.print((int)value3+"\t");
				
				HSSFCell cell4 = row.getCell(4);//color
				String value4=cell4.getStringCellValue();
				product.setColor(value4);
				//System.out.print(value4+"\t");
				
				HSSFCell cell5 = row.getCell(5);//psize
				String value5=cell5.getStringCellValue();
				product.setPsize(value5);
				//System.out.print(value5+"\t");
				
				
				HSSFCell cell6 = row.getCell(6);//filename
				String value6=cell6.getStringCellValue();
				product.setFilename(value6);
				//System.out.print(value6+"\t");
				
				HSSFCell cell7 = row.getCell(7);//content
				String value7=cell7.getStringCellValue();
				product.setContent(value7);
				//System.out.print(value7+"\t");
				
				list.add(product);
				//System.out.println("");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(workbook!=null) {
				try {
					workbook.close();
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
		return list;
	}
	

	public static void main(String[] args) {
		String path="D:/final_workspace/Shopping/WebContent/sql/sample.xls";
		List<Product> list = new ExcelManager().parse(path);
		
		//improved for���� ���ʸ����� �Ǿ������� ��밡��
		for(Product dto : list) {
			System.out.print(dto.getSubCategory().getSubcategory_id());
			System.out.print(dto.getProduct_name());
			System.out.print(dto.getBrand());
			System.out.print(dto.getPrice());
			System.out.print(dto.getColor());
			System.out.print(dto.getPsize());
			System.out.print(dto.getFilename());
			System.out.print(dto.getContent());
			
			System.out.println("");
		}
 	
	}

}











