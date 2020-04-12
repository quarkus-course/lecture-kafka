package tech.donau.conf;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;
import tech.donau.Price;

public class PriceDeserializer extends JsonbDeserializer<Price> {

    public PriceDeserializer() {
        super(Price.class);
    }
}
