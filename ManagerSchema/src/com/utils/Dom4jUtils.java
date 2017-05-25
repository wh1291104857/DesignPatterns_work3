package com.utils;

import java.io.FileOutputStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtils {
	//获取document
	public static Document getDocument(String path)
	{
		try {
			SAXReader saxReader=new SAXReader();
			Document document=saxReader.read(path);
			return document;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void writeXML(String path,Document document)
	{
		XMLWriter xmlWriter;
		try {
			xmlWriter = new XMLWriter(new FileOutputStream(path),OutputFormat.createPrettyPrint());
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
