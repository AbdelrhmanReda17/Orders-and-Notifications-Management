package Application.Managers.ProductManager;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.OrderState;
import Application.APIS.Orders.Model.ShoppingCartItem;
import Application.APIS.Products.Model.Product;
import Application.APIS.Products.ProductRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class ProductManager {
    static ProductRepository productRepository = new ProductRepository();

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
}

