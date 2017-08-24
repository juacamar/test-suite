/**
 * 
 */
package org.craftercms.studio.test.utils.datasourceslistxml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author luishernandez
 *
 */

@XmlRootElement(name = "component")
public class ConfiguredListXml {

	private ValuesObject values;

	@XmlElement(name = "items")
	public void setValues(ValuesObject values) {
		this.values = values;
	}

	public ValuesObject getValues() {
		return values;
	}

}
