package Application.Utilities.Deserializers.Factory;

import Application.Utilities.Deserializers.*;

public class DeserializerFactory {
    public static Deserializer getDeserializer(boolean isCompound) {
        if (isCompound) {
            return new CompoundOrderDeserializer();
        }
        return new SimpleOrderDeserializer();
    }
}
