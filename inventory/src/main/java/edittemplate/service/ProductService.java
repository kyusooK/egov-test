package edittemplate.service;

import edittemplate.domain.*;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts() throws Exception;
    Optional<Product> getProductById(Long id) throws Exception;
    Product createProduct(Product product) throws Exception;
    Product updateProduct(Product product) throws Exception;
    void deleteProduct(Long id) throws Exception;
}
