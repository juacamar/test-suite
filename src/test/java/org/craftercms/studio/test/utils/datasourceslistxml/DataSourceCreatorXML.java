/**
 * 
 */
package org.craftercms.studio.test.utils.datasourceslistxml;

import java.io.File;
import java.util.LinkedList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;

/**
 * @author luishernandez
 *
 */
public class DataSourceCreatorXML {
	ConfiguredListXml configuredListXml;
	ConstantsPropertiesManager constantsPropertiesManager;
	private String XMLFileLocation;
	private String fileName;

	public void createRandomTestDataSource(int numberOfRandomElements) {
		LinkedList<ItemsObject> itemsList = new LinkedList<ItemsObject>();

		for (int i = 0; i < numberOfRandomElements; i++) {
			String itemKeyAndValue = "testdata" + i;

			ItemsObject itemsObject = new ItemsObject();
			itemsObject.setKey(itemKeyAndValue);
			itemsObject.setValue(itemKeyAndValue);

			itemsList.add(itemsObject);

		}

		ValuesObject valuesObject = new ValuesObject();
		valuesObject.setItems(itemsList);

		configuredListXml = new ConfiguredListXml();
		configuredListXml.setValues(valuesObject);

	}

	public void generateTestXMLFileForDataSource() {
		
	 this.fileName = "test-dataSource.xml";
	 
		try {
			this.createRandomTestDataSource(3);

			JAXBContext jaxbContext = JAXBContext.newInstance(ConfiguredListXml.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			XMLFileLocation = FilesLocations.TESTDATASOURCEXMLPATH;
			
			File file = new File(XMLFileLocation+fileName);

			if (!file.exists()) {
				jaxbMarshaller.marshal(configuredListXml, file);
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
	}

	public String getXMLFileLocation() {
		return XMLFileLocation;
	}

	public void setXMLFileLocation(String xMLFileLocation) {
		XMLFileLocation = xMLFileLocation;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

}
