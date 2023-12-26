package Application.Utilities.Deserializers;

import Application.APIS.Orders.Model.SimpleOrder;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class SimpleOrderDeserializer extends Deserializer{
    public SimpleOrder deserialize(JsonNode node) throws IOException {
        return new SimpleOrder(
                node.get("id").asInt(),
                node.get("price").asDouble(),
                node.get("userId").asInt(),
                deserializeProducts(node.get("products"))
        );
    }

}
