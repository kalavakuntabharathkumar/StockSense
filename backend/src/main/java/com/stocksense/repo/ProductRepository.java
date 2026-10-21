package com.stocksense.repo;
import com.stocksense.model.Product;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
public interface ProductRepository extends JpaRepository<Product,Long>{Optional<Product> findBySku(String sku);List<Product> findByQuantityLessThanEqual(int quantity);}
