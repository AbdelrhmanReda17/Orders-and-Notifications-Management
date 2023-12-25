package Application.APIS.Orders.Model;

import Application.Utilities.Deserializers.ShoppingCartItemDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ShoppingCartItemDeserializer.class)
public class ShoppingCartItem {
    private final int productId;
    private final int quantity;

    public ShoppingCartItem(int quantity, int productId) {
        this.quantity = quantity;
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}

