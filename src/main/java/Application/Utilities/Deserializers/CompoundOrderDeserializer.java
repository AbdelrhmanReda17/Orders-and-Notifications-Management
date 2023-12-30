package Application.Utilities.Deserializers;

import Application.APIS.Orders.Model.CompoundOrder;
import Application.APIS.Orders.Model.IOrder;
import com.fasterxml.jackson.databind.JsonNode;


public class CompoundOrderDeserializer extends IOrderDeserializer {
    public IOrder deserialize(JsonNode node){
        return new CompoundOrder(
                node.get("price").asDouble(),
                node.get("userId").asInt(),
                deserializeProducts(node.get("products")),
                deserializeOrders(node.get("orderList"))
        );
    }

}
