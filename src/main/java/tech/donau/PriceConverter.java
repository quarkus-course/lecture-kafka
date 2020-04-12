package tech.donau;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PriceConverter {

    @Incoming("prices")
    @Outgoing("converted-prices")
    @Broadcast
    public Price convert(Price price) {
        price.setPrice(price.getPrice() * 2);
        return price;
    }

}
