package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired

    public ProductService(ProductRepository productRepository){
        this.productRepository =productRepository;
    }

    /**
     *  save a product
     * @param product the entity is saved
     *
     * @return the persisted entity
     */


    public Product SaveProduct(Product product){
        return productRepository.save(product);
    }

   public List<Product> getProduct(){
        return productRepository.findAll();
   }
   /*
   * Get one product by ID
   * @param id the ID one entity
   * @return entity product
   * */

   public Optional<Product> getProduct(long id){
        return productRepository.findById(id);
   }


    /**
     * Update a product.
     *
     * @param id the ID of the entity
     * @param updatedProduct the updated entity
     * @return the updated entity
     */

    public Product updateProduct(long id, Product updatedProduct){
        Optional<Product> existing = productRepository.findById(id);
        if (existing.isPresent()){
            Product product = existing.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            return productRepository.save(product);
        }else {
            throw new RuntimeException("Product not found");
        }

    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }


    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProduct(long id) {
        return getProduct();
    }

    public Optional<Product> getProductById(Long id) {
        return getProductById(id);
    }
}
