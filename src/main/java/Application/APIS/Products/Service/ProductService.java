package Application.APIS.Products.Service;

import Application.APIS.Products.Model.Product;
import Application.APIS.Products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Could not get products");
        }
    }
    public void deleteProduct(int id) {
        if(!productRepository.existsById(id)) {
            throw new IllegalStateException("Product with id " + id + " does not exist");
        }
        productRepository.deleteById(id);
    }

    public void updateProduct(int id, Product newProduct) {
        try{
            Product existingProduct = productRepository.findById(id);
            existingProduct.copy(newProduct);
            productRepository.update(existingProduct);
        } catch (Exception e) {
            throw new IllegalStateException("Product with id " + id + " does not exist");
        }
    }

    public void addProduct(Product newProduct) {
        try {
            productRepository.save(newProduct);
        } catch (Exception e) {
            throw new IllegalStateException("Product with id " + newProduct.getId() + " already exists");
        }
    }

    public Product getProduct(int id) {
        try {
            return productRepository.findById(id);
        } catch (Exception e) {
            throw new IllegalStateException("Product with id " + id + " does not exist");
        }
    }

}
