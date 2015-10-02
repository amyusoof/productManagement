package com.rakuten.productMgmt.web.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rakuten.productMgmt.entities.Category;
import com.rakuten.productMgmt.entities.Product;
import com.rakuten.productMgmt.model.ProductModel;
import com.rakuten.productMgmt.services.CategoryService;
import com.rakuten.productMgmt.services.ProductService;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	private String responseMsg = "";

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String listProducts(Model model) {

		logger.debug(" Enter in listProducts method ");
		try {
			ProductModel productModel = new ProductModel();
			productModel.setCategoriesList(categoryService.findAll());
			model.addAttribute("product", productModel);
			model.addAttribute("listProducts", this.productService.findAll());
			if (responseMsg != null && !responseMsg.isEmpty()) {
				model.addAttribute("responseMsg", responseMsg);
				responseMsg = "";
			}
		} catch (Exception e) {
			logger.error("This is Error message", e);
		}
		return "productsList";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") ProductModel p) {

		logger.debug(" Enter in addProduct  method ");
		Product productEntity = setProduct(p);
		if (p.getId() == 0) {
			responseMsg = "Product added Successfully";
			this.productService.create(productEntity);
		} else {
			responseMsg = "Product updated Successfully";
			this.productService.update(productEntity);
		}

		return "redirect:/product";

	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public @ResponseBody String getCategories(
			@RequestParam("departmentId") long departmentId) {

		String jsonresponse = "";
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			logger.debug(" Enter in getCategories method ");

			Map<Long, String> categoriesMap = new HashMap<Long, String>();
			List<Category> categoriesList = categoryService.findAll();
			for (Category category : categoriesList) {
				categoriesMap.put(category.getId(), category.getName());
			}

			jsonresponse = objectMapper.writeValueAsString(categoriesMap);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			logger.error(" Error in getCategories", e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			logger.error(" Error in getCategories", e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(" Error in getCategories", e);
			e.printStackTrace();
		}

		return jsonresponse;
	}

	@RequestMapping("/remove/{id}")
	public String removeProduct(@PathVariable("id") int id) {

		logger.debug(" Enter in removeProduct method ");
		productService.deleteProduct(Long.valueOf(id));
		responseMsg = "Product Deleted Successfully";
		return "redirect:/product";
	}

	@RequestMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {

		logger.debug(" Enter in editProduct method ");
		ProductModel productModel = new ProductModel();
		if (this.productService.findById(Long.valueOf(id)) != null) {
			productModel = getProductModel(this.productService.findById(Long
					.valueOf(id)));
		} else {

			productModel.setCategoriesList(categoryService.findAll());
		}

		model.addAttribute("product", productModel);
		model.addAttribute("listProducts", this.productService.findAll());
		return "productsList";
	}

	private ProductModel getProductModel(Product product) {
		ProductModel productModel = new ProductModel();
		productModel.setId(product.getId());
		productModel.setAvailable(product.getAvailable());
		productModel.setDesc(product.getDescription());
		productModel.setName(product.getName());
		productModel.setPrice(product.getPrice());
		productModel.setCategoryId(product.getCategory().getId());
		productModel.setCategoriesList(categoryService.findAll());

		return productModel;

	}

	public Product setProduct(ProductModel productModel) {
		Product product = new Product();
		if (productModel.getId() > 0) {

			product.setId(productModel.getId());
		}

		product.setAvailable(productModel.getAvailable());
		product.setCategory(this.categoryService.findById(productModel
				.getCategoryId()));
		product.setPrice(productModel.getPrice());
		product.setDescription(productModel.getDesc());
		product.setName(productModel.getName());
		return product;

	}

}
