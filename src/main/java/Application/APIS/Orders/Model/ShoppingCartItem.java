package Application.APIS.Orders.Model;

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
}
