package com.lodean.main.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lodean.test.dao.ItemRepository;
import com.lodean.test.dao.TestRepository;
import com.lodean.test.dao.entity.Item;
import com.lodean.test.dao.entity.Test;
import com.lodean.test.dao.entity.key.ItemPK;

@Controller
public class MainController {
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("/main")
	public String main() {
		System.out.println("Welcome");
		Test test = new Test();
		test.setName("111");
		//test.setEmail("spectxp@hanmail.net");
		testRepository.save(test);
		return "templates/main";
	}
	
	@GetMapping("/addCo")
	@ResponseBody
	public String cor(ItemPK itemPK, Model model) {
		System.out.println("addCo");
		Item item = new Item();
		//item.setPk(itemPK);
		item.setComId(itemPK.getComId());
		item.setItemName(itemPK.getItemName());
		item.setCreDate(new Timestamp(System.currentTimeMillis()));
		System.out.println(itemPK.toString());
		//test.setEmail("spectxp@hanmail.net");
		//itemRepository.save(item);
		return itemRepository.save(item).toString();
	}
	
	@PostMapping("/addCo")
	@ResponseBody
	public String corPost(ItemPK itemPK, Model model) {
		System.out.println("addCo");
		Item item = new Item();
		//item.setPk(itemPK);
		item.setComId(itemPK.getComId());
		item.setItemName(itemPK.getItemName());
		item.setCreDate(new Timestamp(System.currentTimeMillis()));
		System.out.println(itemPK.toString());
		//test.setEmail("spectxp@hanmail.net");
		//itemRepository.save(item);
		return itemRepository.save(item).toString();
	}
}
