package com.rakuten.productMgmt;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.ui.Model;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.rakuten.productMgmt.entities.Category;
import com.rakuten.productMgmt.entities.Product;
import com.rakuten.productMgmt.model.ProductModel;
import com.rakuten.productMgmt.services.CategoryService;
import com.rakuten.productMgmt.services.ProductService;
import com.rakuten.productMgmt.web.controllers.ProductController;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RequestContextUtils.class })
public class ProductControllerTest extends TestCase {

	@Mock
	private ProductService productService;

	@Mock
	private CategoryService categoryService;

	@Mock
	private Model model;

	@InjectMocks
	private ProductController controller;

	@Test
	public void testAddProduct() throws Exception {
		MockitoAnnotations.initMocks(this);

		ProductModel productModel = new ProductModel();
		productModel.setName("sample");
		productModel.setAvailable(true);
		productModel.setCategoryId(1L);
		productModel.setDesc("sample");
		productModel.setPrice(100L);

		Category category = new Category();

		Mockito.when(categoryService.findById(1L)).thenReturn(category);

		String redirct = controller.addProduct(productModel);
		assertEquals("redirect:" + "/product", redirct);

	}

	@Test
	public void testEditProduct() throws Exception {

		Category cat = new Category();
		cat.setId(1L);

		Product product = new Product();
		product.setId(1L);
		product.setName("sample");
		product.setAvailable(true);
		product.setCategory(cat);
		product.setDescription("sample");
		product.setPrice(100L);

		Mockito.when(productService.findById(1L)).thenReturn(product);
		Mockito.when(categoryService.findById(1L)).thenReturn(cat);

		String redirct = controller.editProduct(1, model);

		assertEquals("productsList", redirct);

	}

	@Test
	public void testRemoveProduct() throws Exception {

		Product product = new Product();
		product.setId(1L);

		Mockito.when(productService.findById(1L)).thenReturn(product);

		String redirect = controller.removeProduct(1);
		assertEquals("redirect:" + "/product", redirect);

	}

	@Test
	public void testListProducts() throws Exception {
		MockitoAnnotations.initMocks(this);

		Category category = new Category();
		List<Category> catList = new ArrayList<Category>();
		catList.add(category);
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product());

		Mockito.when(categoryService.findAll()).thenReturn(catList);
		Mockito.when(productService.findAll()).thenReturn(productList);

		String redirct = controller.listProducts(model);
		assertEquals("productsList", redirct);

	}

	@Test
	public void testGetCategories() throws Exception {
		MockitoAnnotations.initMocks(this);

		Category category = new Category();
		category.setId(1L);
		category.setName("Category 1");
		List<Category> catList = new ArrayList<Category>();
		catList.add(category);

		Mockito.when(categoryService.findAll()).thenReturn(catList);

		String redirct = controller.getCategories(1L);
		assertEquals("{\"1\":\"Category 1\"}", redirct);

	}
}
