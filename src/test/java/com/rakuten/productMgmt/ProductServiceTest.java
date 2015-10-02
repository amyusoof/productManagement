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

import com.rakuten.productMgmt.entities.Product;
import com.rakuten.productMgmt.repositories.ProductRepository;
import com.rakuten.productMgmt.services.ProductService;

@RunWith(PowerMockRunner.class)
public class ProductServiceTest extends TestCase {

	@Mock
	private ProductRepository productRepositoryMock;

	@InjectMocks
	private ProductService productService;

	@Test
	public void testFindAll() throws Exception {
		MockitoAnnotations.initMocks(this);

		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product());

		Mockito.when(productRepositoryMock.findAll()).thenReturn(productList);

		List<Product> listProduct = productService.findAll();
		Assert.assertNotNull(listProduct);

	}

	@Test
	public void testCreate() throws Exception {
		MockitoAnnotations.initMocks(this);

		Product product = new Product();
		product.setId(1L);
		product.setName("sample");
		product.setAvailable(true);
		product.setDescription("sample");
		product.setPrice(100L);

		Mockito.when(productRepositoryMock.save(product)).thenReturn(product);

		Product productResult = productService.create(product);
		Assert.assertNotNull(productResult);
		Assert.assertEquals("sample", productResult.getName());

	}

	@Test
	public void testFindById() throws Exception {
		MockitoAnnotations.initMocks(this);

		Product product = new Product();
		product.setId(1L);
		product.setName("sample");
		product.setAvailable(true);
		product.setDescription("sample");
		product.setPrice(100L);

		Mockito.when(productRepositoryMock.findOne(1L)).thenReturn(product);

		Product productResult = productService.findById(1L);
		Assert.assertNotNull(productResult);
		Assert.assertEquals("sample", productResult.getName());

	}

	@Test
	public void testUpdate() throws Exception {
		MockitoAnnotations.initMocks(this);

		Product product = new Product();
		product.setId(1L);
		product.setName("sample");
		product.setAvailable(true);
		product.setDescription("sample");
		product.setPrice(100L);

		Mockito.when(productRepositoryMock.save(product)).thenReturn(product);

		Product productResult = productService.update(product);
		Assert.assertNotNull(productResult);
		Assert.assertEquals("sample", productResult.getName());

	}

	@Test
	public void testDelete() throws Exception {
		MockitoAnnotations.initMocks(this);

		Product product = new Product();
		product.setId(1L);
		product.setName("sample");
		product.setAvailable(true);
		product.setDescription("sample");
		product.setPrice(100L);

		Mockito.doNothing().when(productRepositoryMock).delete(product);

		productService.deleteProduct(1L);

		Mockito.verify(productRepositoryMock, Mockito.atLeastOnce()).delete(1L);
		Mockito.verify(productRepositoryMock, Mockito.never()).delete(2L);

	}

}
