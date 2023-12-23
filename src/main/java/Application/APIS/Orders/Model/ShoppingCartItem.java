package Application.APIS.Orders.Model;

import Application.APIS.Orders.ShoppingCartItemSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ShoppingCartItemSerializer.class)
public class ShoppingCartItem {
    private String productId;
    private int quantity;

    public ShoppingCartItem(int quantity, String productId) {
        this.quantity = quantity;
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
