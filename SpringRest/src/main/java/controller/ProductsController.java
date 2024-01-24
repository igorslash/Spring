package controller;

import dto.ProductsDto;
import entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

@RestController
@AllArgsConstructor
public class ProductsController {
    private ProductService productService;
    @PostMapping("/products")
    public ResponseEntity<Product> getProducts(
            @RequestBody ProductsDto productsDto) {
        Product product = productService.createProduct(productsDto);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/products/readAll")
    public ResponseEntity<Iterable<Product>> readAll() {
        return mappingResponseListProducts(productService.readAll());
    }
    @GetMapping("/categories/{id}")
    public ResponseEntity<Product> readCategoryById(@PathVariable Long id) {
        return mappingResponseProduct(productService.readByCategoryId(id));
    }

    @PutMapping("/products/update")
    public ResponseEntity<Product> updateProduct(
            @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
            }
    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<Product> deleteProductbyId(
            @PathVariable String id) {
        productService.deleteProduct(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<Product> mappingResponseProduct(Product product) {
        return new ResponseEntity<>(product, HttpStatus.OK);

    }
    public ResponseEntity<Iterable<Product>> mappingResponseListProducts
            (Iterable<Product> products) {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
