import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.*;

public class domex{
	public static void main(String [] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("staff.xml"));
			doc.getDocumentElement().normalize();
			System.out.println("root element:"+ doc.getDocumentElement().getNodeName());
			System.out.println("------");
			NodeList list = doc.getElementsByTagName("staff");
			for(int temp=0; temp<list.getLength();temp++)
			{
				Node node = list.item(temp);
				if(node.getNodeType()== node.ELEMENT_NODE) {
					Element element =(Element) node;
					String id= element.getAttribute("id");
					String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
					String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();
					String nickname = element.getElementsByTagName("nickname").item(0).getTextContent();
					NodeList salaryNodeList = element.getElementsByTagName("salary");
					String salary = salaryNodeList.item(0).getTextContent();
					String currency = salaryNodeList.item(0).getAttributes().getNamedItem("currency").getTextContent();
					System.out.println("currency element:"+ node.getNodeName());
					System.out.println("staff id :" + id);
					System.out.println("first name :"+firstname);
					System.out.println("last name :"+lastname);
					System.out.println("nick name :"+nickname);
					System.out.printf("salary [currency] : %,.2f[%s]%n%n",Float.parseFloat(salary),currency);
				}
			}
		}
		catch(ParserConfigurationException | SAXException | IOException e)
		{
			e.printStackTrace();
		}
	}
}
