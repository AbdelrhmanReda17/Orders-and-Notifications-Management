package Application.APIS.Products;

import Application.APIS.Database.DataRepository;
import Application.APIS.Database.DatabaseFactory;
import Application.APIS.Products.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductRepository extends DataRepository<Product , String> {
    public ProductRepository() {
        super(Product.class);
    }

}
