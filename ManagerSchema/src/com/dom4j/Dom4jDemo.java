package com.dom4j;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.utils.Dom4jUtils;

@SuppressWarnings({ "unused", "unchecked" })
public class Dom4jDemo {
	public static void main(String[] args) throws Exception {
//		inquiryName(1);
//		appendSex(1);
//		appendSchool();
//		modifyAge();
//		deleteAge();
		getId();
	}
	
	//查询第i个p1元素中的name元素值
	private static void inquiryName(int i) throws Exception {
		//创建解析器
		SAXReader saxReader=new SAXReader();
		//解析xml文件
		Document document=saxReader.read("src/student.xml");
		//获取根元素
		Element root=document.getRootElement();
		//获取所有的p1元素
		List<Element> list=root.elements("p1");
		//遍历p1元素
		for (Element element : list) {
			//打印p1元素中的name元素值
			System.out.println(element.element("name").getText());
		}
		//打印第i个p1元素中的name元素值
		System.out.println(list.get(i-1).element("name").getText());
		
	}
	//在第i个p1元素中添加sex元素
	private static void appendSex(int i) throws Exception {
		//创建解析器
		SAXReader saxReader=new SAXReader();
		//解析xml文件
		Document document=saxReader.read("src/student.xml");
		//获取根元素
		Element root=document.getRootElement();
		//获取所有的p1元素
		List<Element> list=root.elements("p1");
		//在第i个p1元素中添加sex元素
		list.get(i-1).addElement("sex").setText("男");
		//回写xml文件
		XMLWriter xmlWriter=new XMLWriter(new FileOutputStream("src/student.xml"), OutputFormat.createPrettyPrint());
		xmlWriter.write(document);
		xmlWriter.close();
		
	}
	//在第1个p1元素中的age元素后添加school元素
	private static void appendSchool() throws Exception {
		//创建解析器
//		SAXReader saxReader=new SAXReader();
//		Document document=saxReader.read("src/student.xml");
		//解析xml文件
		Document document=Dom4jUtils.getDocument("src/student.xml");
		Element root=document.getRootElement();
		Element p1=root.element("p1");
		List<Element> list=p1.elements();
		Element school=DocumentHelper.createElement("school");
		school.setText("yangzte university");
		//在第1个p1元素中的age元素后添加school元素
		list.add(1, school);
		//回写xml文件
		Dom4jUtils.writeXML("src/student.xml", document);
//		XMLWriter xmlWriter=new XMLWriter(new FileOutputStream("src/sax.xml"),OutputFormat.createPrettyPrint());
//		xmlWriter.write(document);
//		xmlWriter.close();
		
	}
	//修改第1个p1元素中的age元素值
	private static void modifyAge()
	{
		//解析xml文件
		Document document=Dom4jUtils.getDocument("src/student.xml");
		Element root=document.getRootElement();
		Element p1=root.element("p1");
		Element age=p1.element("age");
		//设置age元素值
		age.setText("20");
		//回写xml文件
		Dom4jUtils.writeXML("src/student.xml", document);
		

	}
	//删除p1中的age元素
	private static void deleteAge()
	{
		//解析xml文件
		Document document=Dom4jUtils.getDocument("src/student.xml");
		Element root=document.getRootElement();
		Element p1=root.element("p1");
		Element age=p1.element("age");
		//删除age元素
		p1.remove(age);
		//回写xml文件
		Dom4jUtils.writeXML("src/sax.xml", document);
		
	}
	//获取p1中的id属性值
	private static void getId()
	{
		//解析xml文件
		Document document=Dom4jUtils.getDocument("src/student.xml");
		Element root=document.getRootElement();
		Element p1=root.element("p1");
		//根据属性名获取属性值
		System.out.println(p1.attributeValue("id"));
	}
	
	

}
