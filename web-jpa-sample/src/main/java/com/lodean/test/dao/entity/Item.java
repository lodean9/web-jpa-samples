package com.lodean.test.dao.entity;

import java.sql.Timestamp;

import com.lodean.test.dao.entity.key.ItemPK;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(ItemPK.class)
@Table(name = "meta_item")
public class Item {
	
	//@EmbeddedId ItemPK pk;
	@Id
	@Column(name = "com_id")
	private String comId;
	
	@Id
	@Column(name = "item_name")
	private String itemName;
	
	@Column
	private Timestamp creDate;

	public Timestamp getCreDate() {
		return creDate;
	}

	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
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
		return "Item [comId=" + comId + ", itemName=" + itemName + ", creDate=" + creDate + "]";
	}

}
