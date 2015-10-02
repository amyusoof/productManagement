package com.rakuten.productMgmt;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import com.rakuten.productMgmt.entities.Category;
import com.rakuten.productMgmt.repositories.CategoryRepository;
import com.rakuten.productMgmt.services.CategoryService;

@RunWith(PowerMockRunner.class)
public class CategoryServiceTest extends TestCase {

	@Mock
	private CategoryRepository categoryRepository;

	@InjectMocks
	private CategoryService categoryService;

	@Test
	public void testFindAll() throws Exception {
		MockitoAnnotations.initMocks(this);

		List<Category> categoryList = new ArrayList<Category>();
		categoryList.add(new Category());

		Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);

		List<Category> listProduct = categoryService.findAll();
		Assert.assertNotNull(listProduct);

	}

	@Test
	public void testCreate() throws Exception {
		MockitoAnnotations.initMocks(this);

		Category category = new Category();
		category.setAisleId(1);
		category.setDescription("sample");
		category.setName("sample");
		category.setId(1L);

		Mockito.when(categoryRepository.save(category)).thenReturn(category);

		Category categoryResult = categoryService.create(category);
		Assert.assertNotNull(categoryResult);
		Assert.assertEquals("sample", categoryResult.getName());

	}

	@Test
	public void testFindById() throws Exception {
		MockitoAnnotations.initMocks(this);

		Category category = new Category();
		category.setAisleId(1);
		category.setDescription("sample");
		category.setName("sample");
		category.setId(1L);

		Mockito.when(categoryRepository.findOne(1L)).thenReturn(category);

		Category categoryResult = categoryService.findById(1L);
		Assert.assertNotNull(categoryResult);
		Assert.assertEquals("sample", categoryResult.getName());

	}

	@Test
	public void testUpdate() throws Exception {
		MockitoAnnotations.initMocks(this);

		Category category = new Category();
		category.setAisleId(1);
		category.setDescription("sample");
		category.setName("sample");
		category.setId(1L);

		Mockito.when(categoryRepository.save(category)).thenReturn(category);

		Category categoryResult = categoryService.update(category);
		Assert.assertNotNull(categoryResult);
		Assert.assertEquals("sample", categoryResult.getName());

	}

	@Test
	public void testDelete() throws Exception {
		MockitoAnnotations.initMocks(this);

		Category category = new Category();
		category.setAisleId(1);
		category.setDescription("sample");
		category.setName("sample");
		category.setId(1L);

		Mockito.doNothing().when(categoryRepository).delete(category);

		categoryService.deleteCategory(1L);

		Mockito.verify(categoryRepository, Mockito.atLeastOnce()).delete(1L);
		Mockito.verify(categoryRepository, Mockito.never()).delete(2L);

	}

}
