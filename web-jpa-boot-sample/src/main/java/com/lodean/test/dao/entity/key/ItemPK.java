package com.lodean.test.dao.entity.key;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ItemPK implements Serializable{
	
	private String comId;
	private String itemName;
	
	public ItemPK() {
		super();
	}
	
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "ItemPK [comId=" + comId + ", itemName=" + itemName + "]";
	}
	
}