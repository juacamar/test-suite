package org.craftercms.studio.test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConstantsPropertiesManager {
	private Properties sharedExecutionConstants;

	public ConstantsPropertiesManager(String filePath) {

		this.sharedExecutionConstants = new Properties();
		
		try {
			
			sharedExecutionConstants.load(new FileInputStream(filePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Properties getSharedExecutionConstants() {
		return sharedExecutionConstants;
	}

	public void setSharedExecutionConstants(Properties sharedExecutionConstants) {
		this.sharedExecutionConstants = sharedExecutionConstants;
	}
}
