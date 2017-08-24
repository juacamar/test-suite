/**
 * 
 */
package org.craftercms.studio.test.utils.datasourceslistxml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author luishernandez
 *
 */

@XmlType(propOrder = { "key", "value" })
@XmlRootElement(name = "item")
public class ItemsObject {

	private String key;
	private String value;

	@XmlElement(name = "key")
	public void setKey(String key) {
		this.key = key;
	}

	@XmlElement(name = "value")
	public void setValue(String value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

}
