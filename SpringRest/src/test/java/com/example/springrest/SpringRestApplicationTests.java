package com.example.springrest;

import controller.ProductsController;
import dto.ProductsDto;
import entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import service.ProductService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpringRestApplicationTests {
    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductsController productController;

    @Test
    void testGetProducts() {
        // Arrange
        ProductsDto productsDto = new ProductsDto();
        Product product = new Product();
        when(productService.createProduct(productsDto))
                .thenReturn(product);

        // Act
        ResponseEntity<Product> response = productController
                .getProducts(productsDto);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    void testReadAll() {
        // Arrange
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productService.readAll()).thenReturn(products);

        // Act
        ResponseEntity<Iterable<Product>>
                response = productController.readAll();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(products, response.getBody());
    }

}
