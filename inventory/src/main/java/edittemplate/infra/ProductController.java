package edittemplate.infra;

import edittemplate.domain.*;
import edittemplate.service.*;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/products")
public class ProductController {

    @Resource(name = "productService")
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() throws Exception {
        // Get all products via ProductService
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable Long id)
        throws Exception {
        // Get a product by ID via ProductService
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product)
        throws Exception {
        // Create a new product via ProductService
        return productService.createProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(
        @PathVariable Long id,
        @RequestBody Product product
    ) throws Exception {
        // Update an existing product via ProductService
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) throws Exception {
        // Delete a product via ProductService
        productService.deleteProduct(id);
    }
}
