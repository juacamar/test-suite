/**
 * 
 */
package org.craftercms.studio.test.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.testng.TestException;

/**
 * @author luishernandez
 *
 */
public class APIConnectionManager {

	/**
	 * 
	 */
private String protocol;
private String host;
private int port;
private String headerLocationBase;

	public APIConnectionManager() {
		final Properties runtimeProperties = new Properties();
		try {
			runtimeProperties.load(APIConnectionManager.class.getResourceAsStream("/runtime.properties"));
			String enviromentPropertiesPath = runtimeProperties.getProperty("crafter.test.location");
			final Properties envProperties = new Properties();
			try {
				envProperties.load(new FileInputStream(enviromentPropertiesPath));
				String baseURL = envProperties.getProperty("baseUrl");
				
				this.protocol = StringUtils.substringBefore(baseURL, ":");
				this.host = StringUtils.substring(StringUtils.substringBefore(StringUtils.substringAfter(baseURL, ":"),":"),2);
				this.port = Integer.parseInt(StringUtils.substringBefore(StringUtils.substringAfter(StringUtils.substringAfter(baseURL, ":"),":"),"/"));		
				this.headerLocationBase=this.protocol+"://"+this.host+":"+port;
				
			} catch (IOException ex) {
				throw new FileNotFoundException("Unable to read runtime properties file");
			}
		} catch (IOException ex) {
			throw new TestException("Require Files are not found.");
		}
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHeaderLocationBase() {
		return headerLocationBase;
	}

	public void setHeaderLocationBase(String headerLocationBase) {
		this.headerLocationBase = headerLocationBase;
	}
	
}
