package repository;

import entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductCategoryRepository
        extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Long id);
}
