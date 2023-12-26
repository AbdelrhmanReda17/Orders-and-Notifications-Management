package Application.Utilities.Serializers;

import Application.APIS.Orders.Model.ShoppingCartItem;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;

import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ShoppingCartItemSerializer extends JsonSerializer<ShoppingCartItem> {
    @Override
    public void serialize(ShoppingCartItem shoppingCartItem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("productId", String.valueOf(shoppingCartItem.getProductId()));
        jsonGenerator.writeNumberField("quantity", shoppingCartItem.getQuantity());
        jsonGenerator.writeEndObject();
    }
}