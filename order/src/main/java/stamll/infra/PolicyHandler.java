package stamll.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stamll.config.kafka.KafkaProcessor;
import stamll.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCompleted'"
    )
    public void wheneverDeliveryCompleted_UpdateState(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        DeliveryCompleted event = deliveryCompleted;
        System.out.println(
            "\n\n##### listener UpdateState : " + deliveryCompleted + "\n\n"
        );

        // Sample Logic //
        Order.updateState(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ShippingReturned'"
    )
    public void wheneverShippingReturned_UpdateState(
        @Payload ShippingReturned shippingReturned
    ) {
        ShippingReturned event = shippingReturned;
        System.out.println(
            "\n\n##### listener UpdateState : " + shippingReturned + "\n\n"
        );

        // Sample Logic //
        Order.updateState(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
