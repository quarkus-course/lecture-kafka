package tech.donau;

import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class PriceProducer {

    private Random random = new Random();

    @Outgoing("price")
    public Flowable<Price> producePrice() {
        return Flowable.interval(5, TimeUnit.SECONDS)
                .map(it -> {
                    final Price price = new Price();
                    price.setName("BTC");
                    price.setPrice((long) random.nextInt(6000));
                    return price;
                });
    }
}
