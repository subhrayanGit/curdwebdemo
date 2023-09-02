package com.product.crudwebdemo;

import com.product.crudwebdemo.contoller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class CrudWebDemoApplicationTests {

	@Autowired
	private ProductController productController;

	@Test
	void contextLoads() {
		assertNotNull(productController);
	}

}

