package com.lodean.test.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.lodean.test.dao.entity.Test;

@org.springframework.stereotype.Repository
public interface TestRepository extends Repository<Test, String> {
	Page<Test> findAll(Pageable pageable);
	
	Test save(Test entity);
}
