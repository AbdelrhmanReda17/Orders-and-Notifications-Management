package Application.Utilities.Deserializers;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.ShoppingCartItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public abstract class IOrderDeserializer {
    public abstract IOrder deserialize(JsonNode node) throws IOException;
    public static List<ShoppingCartItem> deserializeProducts(JsonNode products) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(products, new TypeReference<>() {
        });
    }

    public  List<IOrder> deserializeOrders(JsonNode orders) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(orders, new TypeReference<>() {
        });
    }
}
