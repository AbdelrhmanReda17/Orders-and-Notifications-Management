package Application.Utilities.Deserializers;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.ShoppingCartItem;
import Application.APIS.Orders.Model.SimpleOrder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public abstract class Deserializer {
    public abstract IOrder deserialize(JsonNode node) throws IOException;
    public static List<ShoppingCartItem> deserializeProducts(JsonNode products) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(products, new TypeReference<List<ShoppingCartItem>>() {
        });
    }

    public  List<IOrder> deserializeOrders(JsonNode orders) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(orders, new TypeReference<List<IOrder>>() {
        });
    }
}
