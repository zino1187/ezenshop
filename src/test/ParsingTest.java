package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParsingTest extends DefaultHandler{
	FileReader fis;
	BufferedReader buffr;
	StringBuilder sb = new StringBuilder();
	SAXParserFactory factory = SAXParserFactory.newInstance();
	
	boolean bname;
	boolean bprice;
	boolean bdescription;
	boolean bcalories;
	List<Food> foodList = new ArrayList();
	Food food;
	
	public ParsingTest() {
		try {
			fis = new FileReader("D:/final_workspace/Shopping/src/test/food.xml");
			buffr = new BufferedReader(fis);
			
			String data=null;
			
			while(true) {
				data=buffr.readLine();
				if(data==null)break;
				sb.append(data);
			}
			//System.out.println(sb.toString());
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse("D:/final_workspace/Shopping/src/test/food.xml", this);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}finally {
			if(buffr !=null) {
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equals("food")) {
			food = new Food();
		}else if(qName.equals("name")) {
			bname=true;
		}else if(qName.equals("price")) {
			bprice=true;
		}else if(qName.equals("description")) {
			bdescription=true;
		}else if(qName.equals("calories")) {
			bcalories=true;
		}
		System.out.print("<"+qName+">");
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data= new String(ch, start, length);
		System.out.print(data);
		
		if(bname) {
			bname=false;
			food.setName(data);
		}else if(bprice) {
			bprice=false;
			food.setPrice(data);
		}else if(bdescription) {
			bdescription=false;
			food.setDescription(data);
		}else if(bcalories) {
			bcalories=false;
			food.setCalories(data);
		}
		
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">");
		if(qName.equals("food")) {
			foodList.add(food);
		}
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("최종적인 결과 "+foodList.size());
		for(Food food : foodList) {
			System.out.println("name:"+food.getName());
			System.out.println("price:"+food.getPrice());
			System.out.println("description:"+food.getDescription());
			System.out.println("calories:"+food.getCalories());
		}
	}
	public static void main(String[] args) {
		new ParsingTest();
	}
}
