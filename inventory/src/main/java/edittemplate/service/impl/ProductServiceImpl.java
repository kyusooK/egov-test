package edittemplate.service.impl;

import edittemplate.domain.Product;
import edittemplate.domain.ProductRepository;
import edittemplate.service.ProductService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("productService")
@Transactional
public class ProductServiceImpl
    extends EgovAbstractServiceImpl
    implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        ProductServiceImpl.class
    );

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() throws Exception {
        // Get all products
        return StreamSupport
            .stream(productRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> getProductById(Long id) throws Exception {
        // Get a product by ID
        return productRepository.findById(id);
    }

    @Override
    public Product createProduct(Product product) throws Exception {
        // Create a new product
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) throws Exception {
        // Update an existing product via ProductService
        if (productRepository.existsById(product.getId())) {
            return productRepository.save(product);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        // Delete a product
        productRepository.deleteById(id);
    }
}
