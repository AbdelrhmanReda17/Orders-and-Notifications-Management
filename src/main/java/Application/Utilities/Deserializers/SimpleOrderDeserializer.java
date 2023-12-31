package Application.Utilities.Deserializers;

import Application.APIS.Orders.Model.SimpleOrder;
import com.fasterxml.jackson.databind.JsonNode;


public class SimpleOrderDeserializer extends IOrderDeserializer {
    public SimpleOrder deserialize(JsonNode node) {
        return new SimpleOrder(
                node.get("price").asDouble(),
                node.get("userId").asInt(),
                deserializeProducts(node.get("products"))
        );
    }

}
