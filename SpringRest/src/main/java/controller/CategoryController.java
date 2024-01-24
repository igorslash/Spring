package controller;


import entity.ProductsCategory;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CategoryService;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories/all")
    public ResponseEntity<List<ProductsCategory>> getAllCategories(){
        ProductsCategory productsCategory =
                (ProductsCategory) categoryService.getAllCategories();
        return ok(Collections.singletonList(productsCategory));
    }
}
