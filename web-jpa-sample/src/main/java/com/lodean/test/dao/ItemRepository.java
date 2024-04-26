package com.lodean.test.dao;

import org.springframework.data.repository.Repository;

import com.lodean.test.dao.entity.Item;
import com.lodean.test.dao.entity.key.ItemPK;

@org.springframework.stereotype.Repository
public interface ItemRepository extends Repository<Item, ItemPK> {
	
	Item save(Item item);
}
