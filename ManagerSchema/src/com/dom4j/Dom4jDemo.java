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
	
	//��ѯ��i��p1Ԫ���е�nameԪ��ֵ
	private static void inquiryName(int i) throws Exception {
		//����������
		SAXReader saxReader=new SAXReader();
		//����xml�ļ�
		Document document=saxReader.read("src/student.xml");
		//��ȡ��Ԫ��
		Element root=document.getRootElement();
		//��ȡ���е�p1Ԫ��
		List<Element> list=root.elements("p1");
		//����p1Ԫ��
		for (Element element : list) {
			//��ӡp1Ԫ���е�nameԪ��ֵ
			System.out.println(element.element("name").getText());
		}
		//��ӡ��i��p1Ԫ���е�nameԪ��ֵ
		System.out.println(list.get(i-1).element("name").getText());
		
	}
	//�ڵ�i��p1Ԫ�������sexԪ��
	private static void appendSex(int i) throws Exception {
		//����������
		SAXReader saxReader=new SAXReader();
		//����xml�ļ�
		Document document=saxReader.read("src/student.xml");
		//��ȡ��Ԫ��
		Element root=document.getRootElement();
		//��ȡ���е�p1Ԫ��
		List<Element> list=root.elements("p1");
		//�ڵ�i��p1Ԫ�������sexԪ��
		list.get(i-1).addElement("sex").setText("��");
		//��дxml�ļ�
		XMLWriter xmlWriter=new XMLWriter(new FileOutputStream("src/student.xml"), OutputFormat.createPrettyPrint());
		xmlWriter.write(document);
		xmlWriter.close();
		
	}
	//�ڵ�1��p1Ԫ���е�ageԪ�غ����schoolԪ��
	private static void appendSchool() throws Exception {
		//����������
//		SAXReader saxReader=new SAXReader();
//		Document document=saxReader.read("src/student.xml");
		//����xml�ļ�
		Document document=Dom4jUtils.getDocument("src/student.xml");
		Element root=document.getRootElement();
		Element p1=root.element("p1");
		List<Element> list=p1.elements();
		Element school=DocumentHelper.createElement("school");
		school.setText("yangzte university");
		//�ڵ�1��p1Ԫ���е�ageԪ�غ����schoolԪ��
		list.add(1, school);
		//��дxml�ļ�
		Dom4jUtils.writeXML("src/student.xml", document);
//		XMLWriter xmlWriter=new XMLWriter(new FileOutputStream("src/sax.xml"),OutputFormat.createPrettyPrint());
//		xmlWriter.write(document);
//		xmlWriter.close();
		
	}
	//�޸ĵ�1��p1Ԫ���е�ageԪ��ֵ
	private static void modifyAge()
	{
		//����xml�ļ�
		Document document=Dom4jUtils.getDocument("src/student.xml");
		Element root=document.getRootElement();
		Element p1=root.element("p1");
		Element age=p1.element("age");
		//����ageԪ��ֵ
		age.setText("20");
		//��дxml�ļ�
		Dom4jUtils.writeXML("src/student.xml", document);
		

	}
	//ɾ��p1�е�ageԪ��
	private static void deleteAge()
	{
		//����xml�ļ�
		Document document=Dom4jUtils.getDocument("src/student.xml");
		Element root=document.getRootElement();
		Element p1=root.element("p1");
		Element age=p1.element("age");
		//ɾ��ageԪ��
		p1.remove(age);
		//��дxml�ļ�
		Dom4jUtils.writeXML("src/sax.xml", document);
		
	}
	//��ȡp1�е�id����ֵ
	private static void getId()
	{
		//����xml�ļ�
		Document document=Dom4jUtils.getDocument("src/student.xml");
		Element root=document.getRootElement();
		Element p1=root.element("p1");
		//������������ȡ����ֵ
		System.out.println(p1.attributeValue("id"));
	}
	
	

}
