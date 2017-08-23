package org.craftercms.studio.test.utils.datasourceslistxml;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "items")
public class ValuesObject {
	private LinkedList<ItemsObject> items;

	@XmlElement(name = "item")
	public void setItems(LinkedList<ItemsObject> items) {
		this.items = items;
	}

	public LinkedList<ItemsObject> getItems() {
		return items;
	}

}
