package Application.Utilities.Deserializers;

import Application.APIS.Orders.Model.CompoundOrder;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Orders.Model.SimpleOrder;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class CompoundOrderDeserializer extends Deserializer {
    public IOrder deserialize(JsonNode node){
        return new CompoundOrder(
                node.get("id").asInt(),
                node.get("price").asDouble(),
                node.get("userId").asInt(),
                deserializeProducts(node.get("products")),
                deserializeOrders(node.get("orderList"))
        );
    }

}