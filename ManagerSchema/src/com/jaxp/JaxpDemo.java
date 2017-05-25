package com.jaxp;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class JaxpDemo {
	public static void main(String[] args) throws Exception {
		//创建解析器工�?
		SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
		//创建解析�?
		SAXParser saxParser=saxParserFactory.newSAXParser();
		//parse
		saxParser.parse("./src/student.xml", new MyDefaultHandler());
		System.out.println();
		saxParser.parse("./src/student.xml", new YourDefaultHandler());
		
	}

}

//重写DefaultHandler的方�?
//打印xml
class MyDefaultHandler  extends DefaultHandler
{

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.print("<"+qName+">");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.print("</"+qName+">");
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.print(new String(ch, start, length));
	}
	
}
//打印第n个name
class YourDefaultHandler extends DefaultHandler
{
	boolean flag=false;
	int index=1;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if ("name".equals(qName)) {
			flag=true;
		}
		
	} 

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if ("name".equals(qName)) {
			flag=false;
		}
		
	}

	@Override
	public void characters(char[] ch, int start, int length) 
			throws SAXException {
		if (flag&&index++==1) {
			System.out.println(new String(ch, start, length));
		}
		
	}
	


}

