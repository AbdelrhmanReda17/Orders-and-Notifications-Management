package Application.APIS.Products.Service;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Orders.Model.ShoppingCartItem;
import Application.APIS.Products.Model.Product;
import Application.APIS.Products.ProductRepository;
import Application.Utilities.Database.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    private static DataRepository<Product, Integer> productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        ProductService.productRepository = productRepository;
    }

    public static void ValidateProduct(IOrder newOrder) {
        int productsCount = 0;
        for(Product product : (getProducts(newOrder.getProducts()))){
            if(product.getQuantity() < 1){
                throw new IllegalStateException("Product " + product.getName() + " is out of stock");
            }
            if(product.getQuantity() < newOrder.getProducts().get(productsCount).getQuantity()){
                throw new IllegalStateException("Can't Place the Order , Product " + product.getName() + " has only " + product.getQuantity() + " left");
            }
            productsCount++;
        }
    }
    public static List<Product> getProducts(List<ShoppingCartItem> ShoppingCartItems){
        List<Product> products = new LinkedList<>();
        for(ShoppingCartItem product : ShoppingCartItems){
            products.add(productRepository.findById(product.getProductId()));
        }
        return products;
    }
    public static void UpdateProducts(IOrder newOrder ,List<Product> products, OrderState status){
        for(int i = 0 ; i < newOrder.getProducts().size() ; i++){
            Product product1 = products.get(i);
            if (Objects.equals(status, OrderState.Cancelled)) {
                product1.setQuantity(product1.getQuantity() + newOrder.getProducts().get(i).getQuantity());
            } else {
                product1.setQuantity(product1.getQuantity() - newOrder.getProducts().get(i).getQuantity());
            }
            products.set(i , product1);
            productRepository.update(product1);
        }
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

    public List<Product> getProductsByCategory(String category) {
        try {
            return ((ProductRepository) productRepository).findByCategory(category);
        } catch (Exception e) {
            throw new IllegalStateException("Empty category or category does not exist");
        }
    }
}
