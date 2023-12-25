package Application.APIS.Products;

import Application.Database.DataRepository;
import Application.APIS.Products.Model.Product;
import org.springframework.stereotype.Repository;


@Repository
public class ProductRepository extends DataRepository<Product , Integer> {
    public ProductRepository() {
        super(Product.class);
    }

}
