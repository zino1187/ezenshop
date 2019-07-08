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

//자바에서 엑셀 읽어와 처리하기!!! ( 오픈소스 apache poi 이용 )
public class MyPOITest {
	FileInputStream fis;

	//하나의 엑셀파일을 표현한 객체
	HSSFWorkbook workbook;  
	
	public List save(String path) {
		List<Product> list = new ArrayList();
		
		try {
			fis = new FileInputStream(path);
			workbook = new HSSFWorkbook(fis);
			//System.out.println(workbook);
			//쉬트에 접근 
			HSSFSheet sheet=workbook.getSheet("product");
			
			int totalRecord = sheet.getPhysicalNumberOfRows();
			System.out.println("총 row 수는 "+totalRecord);
			
			for(int i=1; i<totalRecord;i++) {
				HSSFRow row=sheet.getRow(i);
				int cols = row.getPhysicalNumberOfCells();//셀의 수
				//DTO 1개 생성 
				Product product = new Product();
				
				HSSFCell cell0 = row.getCell(0);//subcategory_id
				HSSFCell cell1 = row.getCell(1);//subcategory_id
				HSSFCell cell2 = row.getCell(2);//subcategory_id
				HSSFCell cell3 = row.getCell(3);//subcategory_id
				HSSFCell cell4 = row.getCell(4);//subcategory_id
				HSSFCell cell5 = row.getCell(5);//subcategory_id
				HSSFCell cell6 = row.getCell(6);//subcategory_id
				HSSFCell cell7 = row.getCell(7);//subcategory_id
				
				product.getSubCategory().setSubcategory_id((int)cell0.getNumericCellValue());
				product.setProduct_name(cell1.getStringCellValue());
				product.setBrand(cell2.getStringCellValue());
				product.setPrice((int)cell3.getNumericCellValue());
				product.setColor(cell4.getStringCellValue());
				product.setPsize(cell5.getStringCellValue());
				product.setFilename(cell6.getStringCellValue());
				product.setContent(cell7.getStringCellValue());
				
				list.add(product);
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
		MyPOITest test= new MyPOITest();
		List<Product> list = test.save(path);
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
