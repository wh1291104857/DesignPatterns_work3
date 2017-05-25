package com.wanghao;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/**
 * �޸�xml����
 * ���ӣ��ĵ�����ǩ ������
 * �޸ģ�����ֵ���ı�
 * ɾ������ǩ������
 * @author APPle
 *
 */
public class ManageXML {

	/**
	 * ���ӣ��ĵ�����ǩ ������
	 */
	@Test
	public void test1() throws Exception{
		/**
		 * 1.�����ĵ�
		 */
		Document doc = DocumentHelper.createDocument();
		/**
		 * 2.���ӱ�ǩ
		 */
		Element rootElem = doc.addElement("class");
		Element studentElem = rootElem.addElement("student");
		studentElem.addElement("name").addText("����");
		studentElem.addElement("sex").addText("��");
		studentElem.addElement("age").addText("21");
		/**
		 * 3.��������
		 */
		studentElem.addAttribute("id", "001");
		
		//���޸ĺ��Document����д����xml�ĵ���
		FileOutputStream out = new FileOutputStream("e:/student.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
	
	/**
	 * �޸ģ�����ֵ���ı�
	 * @throws Exception
	 */
	@Test
	public void test2()	throws Exception{
		Document doc = new SAXReader().read(new File("./src/student.xml"));
		
		/**
		 * ����һ�� �޸�����ֵ   1.�õ���ǩ���� 2.�õ����Զ��� 3.�޸�����ֵ
		 */
		//1.1  �õ���ǩ����
		/*
		Element contactElem = doc.getRootElement().element("student");
		//1.2 �õ����Զ���
		Attribute idAttr = contactElem.attribute("id");
		//1.3 �޸�����ֵ
		idAttr.setValue("003");
		*/
		/**
		 * �������� �޸�����ֵ
		 */
		//1.1  �õ���ǩ����
		/*
		Element contactElem = doc.getRootElement().element("student");
		//1.2 ͨ������ͬ�����Եķ������޸�����ֵ
		contactElem.addAttribute("id", "004");
		*/
		
		/**
		 * �޸��ı� 1.�õ���ǩ���� 2.�޸��ı�
		 */
		Element nameElem = doc.getRootElement().
			element("student").element("name");
		nameElem.setText("��Ԫ��");
		
		
		
		FileOutputStream out = new FileOutputStream("e:/student.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
	
	
	/**
	 * ɾ������ǩ������
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception{
		Document doc = new SAXReader().read(new File("./src/student.xml"));
		
		/**
		 * 1.ɾ����ǩ     1.1 �õ���ǩ����  1.2 ɾ����ǩ����    
		 */
		// 1.1 �õ���ǩ����
		/*
		Element ageElem = doc.getRootElement().element("student")
					.element("age");
		
		//1.2 ɾ����ǩ����
		ageElem.detach();
		//ageElem.getParent().remove(ageElem);
		*/
		/**
		 * 2.ɾ������   2.1�õ����Զ���  2.2 ɾ������
		 */
		//2.1�õ����Զ���
		//�õ��ڶ���student��ǩ
		Element studentElem = (Element)doc.getRootElement().
			elements().get(1);
		//2.2 �õ����Զ���
		Attribute idAttr = studentElem.attribute("id");
		//2.3 ɾ������
		idAttr.detach();
		//idAttr.getParent().remove(idAttr);
		
		FileOutputStream out = new FileOutputStream("e:/student.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}
}
