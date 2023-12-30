package Application.APIS.Products;

import Application.Utilities.Database.DataRepository;
import Application.APIS.Products.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductRepository extends DataRepository<Product , Integer> {
    public ProductRepository() {
        super(Product.class);
    }

    public List<Product> findByCategory(String category) {
        return data.stream().filter(product -> product.getCategory().equals(category)).toList();
    }

}
