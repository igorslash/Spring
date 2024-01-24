package service;

import dto.ProductsDto;
import entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.IProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final IProductRepository iproductRepository;
    private final CategoryService categoryService;

    public Product createProduct(ProductsDto dto){
        return iproductRepository.save(Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .category(categoryService
                        .getCategoryById(dto.getCategoryId()))
                .build());
    }
    public Product readByCategoryId(Long id){
        return iproductRepository.findAllByCategoryId(id);

    }
    public List<Product> readAll(){
        return iproductRepository.findAll();
    }
    public Product updateProduct(Product product){
        return iproductRepository.save(product);
    }
    public void deleteProduct(Long id){
        iproductRepository.deleteById(id);
    }
}
