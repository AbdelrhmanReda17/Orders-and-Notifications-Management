package Application.APIS.Products.Controller;

import Application.APIS.Products.Model.Product;
import Application.APIS.Products.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> getProducts() {
        try{
            return ResponseEntity.ok(productService.getProducts());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable("id")  int id) {
        try {
            return ResponseEntity.ok(productService.getProduct(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{category}")
    public ResponseEntity<Object> getProductsByCategory(@PathVariable("category") String category) {
        try {
            return ResponseEntity.ok(productService.getProductsByCategory(category));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        try {
             productService.addProduct(product);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
        return ResponseEntity.ok("Product added successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
        try{
            productService.deleteProduct(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Product deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        try {
            productService.updateProduct(id, product);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Product updated successfully");
    }
}
