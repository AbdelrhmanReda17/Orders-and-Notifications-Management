package Application.Utilities.Deserializers;

import Application.APIS.Orders.Model.IOrder;
import Application.Utilities.Deserializers.Factory.DeserializerFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import java.io.IOException;


public class OrderDeserializer extends JsonDeserializer<IOrder> {
    @Override
    public IOrder deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return DeserializerFactory.getDeserializer(node.has("orderList")).deserialize(node);
    }
}

