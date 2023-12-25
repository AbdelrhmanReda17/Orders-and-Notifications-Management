package Application.APIS.Orders.Model;

public class ShoppingCartItem {
    private int productId;
    private int quantity;

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
