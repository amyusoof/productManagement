package com.rakuten.productMgmt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.productMgmt.entities.Category;
import com.rakuten.productMgmt.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryService  {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category create(Category category) {
		return categoryRepository.save(category);
	}

	public Category findById(long id) {
		return categoryRepository.findOne(id);
	}

	public Category update(Category category) {
		return categoryRepository.save(category);
	}

	public void deleteCategory(long id) {
		categoryRepository.delete(id);
	}

}
