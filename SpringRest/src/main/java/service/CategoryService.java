package service;

import entity.Product;
import entity.ProductsCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.IProductCategoryRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class CategoryService {
    private final IProductCategoryRepository productCategoryRepository;

   public List<Product> getAllCategories(){
       return productCategoryRepository.findAll();
   }
   public ProductsCategory getCategoryById(Long id){
       return productCategoryRepository
               .findById(id).orElseThrow(()->
       new RuntimeException("Category not found")).getCategory();
   }
}
