package Application.Utilities.Deserializers;

import Application.APIS.Orders.Model.IOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import java.io.IOException;

//public class OrderDeserializer extends JsonSerializer<IOrder> {
//    @Override
//    public void serialize(IOrder iOrder, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//        jsonGenerator.writeStartObject();
//        jsonGenerator.writeStringField("id", String.valueOf(iOrder.getId()));
//        jsonGenerator.writeStringField("date", String.valueOf(iOrder.getDate()));
//        jsonGenerator.writeStringField("status", iOrder.getStatus());
//        jsonGenerator.writeStringField("userId", String.valueOf(iOrder.getUserId()));
//        jsonGenerator.writeEndObject();
//    }
//}
