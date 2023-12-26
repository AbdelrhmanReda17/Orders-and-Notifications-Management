package Application.APIS.Orders.Model;

import Application.Utilities.Serializers.ShoppingCartItemSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ShoppingCartItemSerializer.class)
public class ShoppingCartItem {
    private int productId;
    private int quantity;
    public ShoppingCartItem() {}

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

